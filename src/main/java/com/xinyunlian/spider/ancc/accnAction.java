package com.xinyunlian.spider.ancc;

import com.google.gson.*;
import com.xinyunlian.spider.account.LstAccount;
import com.xinyunlian.spider.ancc.converter.DateConverter;
import com.xinyunlian.spider.ancc.dto.AttributeDto;
import com.xinyunlian.spider.ancc.dto.ImageDto;
import com.xinyunlian.spider.ancc.dto.RetDto;
import com.xinyunlian.spider.ancc.inter.GoodsAttrModelMapper;
import com.xinyunlian.spider.ancc.inter.GoodsImageModelMapper;
import com.xinyunlian.spider.ancc.inter.GoodsModelMapper;
import com.xinyunlian.spider.ancc.model.GoodsAttrModel;
import com.xinyunlian.spider.ancc.model.GoodsImageModel;
import com.xinyunlian.spider.ancc.model.GoodsModel;
import com.xinyunlian.spider.ancc.model.GoodsModelExample;
import com.xinyunlian.spider.barcode.dto.GoodsInfoDto;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.db.DataSourceWrapper;
import com.xinyunlian.spider.sys.SystemConfig;
import com.xinyunlian.spider.utils.ReadExcelUtils;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class accnAction{
    private Logger log = Logger.getLogger(accnAction.class);
    private DataSourceWrapper wrapper;
    private ANCC ancc ;
    private Gson gson;
    private GoodsAttrModelMapper attrMapper=null;
    private GoodsImageModelMapper imageMapper = null;
    private GoodsModelMapper goodsMapper = null;
    public accnAction()
    {
        ancc = new ANCC();
        this.wrapper = new DataSourceWrapper();
        gson =new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                    @Override
                    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                            String str = json.getAsString();
                            if(StringUtils.isBlank(str))
                                return null;
                            else
                                return sdf.parse(str);
                        } catch (Exception e) {
                            return null;
                        }
                    }
                }).setDateFormat("dd/MM/yyyy hh:mm:ss").create();
    }

    private List<GoodsInfoDto> goodsInfoLst;

    public void CreepData()
    {
        log.info("数据初始化中...");
        try {
            ReadExcelUtils reader = new ReadExcelUtils();
            log.info("读取原始数据文件[" + SystemConfig.FF_BARCODE_INPUT_PATH + SystemConfig.FF_BARCODE_FILENAME + "]...");
            goodsInfoLst = reader.readExcel(GoodsInfoDto.class, SystemConfig.FF_BARCODE_INPUT_PATH + SystemConfig.FF_BARCODE_FILENAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(goodsInfoLst==null||goodsInfoLst.size()==0)
        {
            log.info("读取文件条数="+0);
            return;
        }
        else {
            log.info("读取文件条数="+goodsInfoLst.size());
        }
        log.info("开始获取详细数据...");
        for(int i=0;i<goodsInfoLst.size();i++)
        {
            BaseCreepAction.sleepInMillis(200);
            GoodsInfoDto model = goodsInfoLst.get(i);
            model.setBarcode(model.getBarcode().startsWith("0")?model.getBarcode().substring(1):model.getBarcode());
            try{
                if(isExsit(model.getBarcode()))
                {
                    log.info("["+i+"]数据[BARCODE="+model.getBarcode()+"]已经存在，跳过到下一条记录。");
                    continue;
                }
            }catch (Exception ex){

            }
            RetDto dto = null;
            try {
                dto = creepping(model, i + 1);
                BaseCreepAction.sleep(4,3);
            }
            catch (AuthException ex)
            {
                --i;
                log.error("休息一会...");
                BaseCreepAction.sleep(30,15);
                dto = null;
            }
            catch (Exception ex)
            {
                log.error("获取数据异常："+ex.getMessage());
                dto = null;
            }
            saveData(model, dto, i + 1);
        }
    }

    private Random random = new Random();
    /**
     * 爬取数据
     * @param model
     * @return
     */
    private RetDto creepping(GoodsInfoDto model,int index) throws AuthException {
        log.info("["+index+"]获取数据BARCODE=["+model.getBarcode()+"]...");
        String barcode = model.getBarcode();
        String json =null;
        try {
            json = ancc.loadJson(barcode);
            log.info("["+index+"]数据返回成功");
        }catch (AuthException ex)
        {
            log.error("["+index+"]权限Forbidden："+ex.getMessage());
            throw ex;
        }
        catch (Exception ex)
        {
            log.error("["+index+"]数据返回异常："+ex.getMessage());
            throw ex;
        }
        RetDto retDto=null;
        try {
            retDto = gson.fromJson(json, RetDto.class);
            log.info("["+index+"]解析数据成功");
        }catch (Exception ex)
        {
            log.error("["+index+"]解析数据异常："+ex.getMessage());
            return null;
        }
        return retDto;
    }
    private boolean isExsit(String barcode)
    {
        goodsMapper = wrapper.getMapperInstance(GoodsModelMapper.class);
        GoodsModelExample queryModel = new GoodsModelExample();
        queryModel.setDistinct(false);
        GoodsModelExample.Criteria criteria = queryModel.createCriteria();
        criteria.andProductCodeEqualTo(barcode);
        return goodsMapper.selectByExample(queryModel).size()>0;
    }

    public boolean saveData(GoodsInfoDto goods,RetDto dto,int index)
    {
        log.info("["+index+"]存储数据...");
        GoodsModel goodsModel = new GoodsModel();
        List<GoodsImageModel> imageLst = new ArrayList<>();
        List<GoodsAttrModel> attrLst = new ArrayList<>();
        try
        {
            log.info("[" + index + "]组织数据");
            goodsModel.setProductCode(goods.getBarcode());
            goodsModel.setShopId("");
            goodsModel.setCreateDate(new Date());
            goodsModel.setType(goods.getIsTobacco());
            if(dto==null)
            {
                goodsModel.setStatus("3");
            }
            else {
                //商品
                goodsModel.setAlermCount(dto.getD().getAlermCount());
                goodsModel.setBatch(dto.getD().getBatch());
                goodsModel.setBrandName(dto.getD().getBrandName());
                goodsModel.setDiffyearsmonthsdays(dto.getD().getDiffYearsMonthsDays());
                goodsModel.setFirmAddress(dto.getD().getFirmAddress());
                goodsModel.setFirmContactman(dto.getD().getFirmContactMan());
                goodsModel.setFirmContactphone(dto.getD().getFirmContactPhone());
                goodsModel.setFirmLoginDate(dto.getD().getFirmLoginDate());
                goodsModel.setFirmLogoutDate(dto.getD().getFirmLogoutDate());
                goodsModel.setFirmLogoutDate1(dto.getD().getFirmLogoutDate1());
                goodsModel.setFirmName(dto.getD().getFirmName());
                goodsModel.setFirmStatus(dto.getD().getFirmStatus());
                goodsModel.setFirmValidDate(dto.getD().getFirmValidDate());
                goodsModel.setHonestCount(dto.getD().getHonestCount());
                goodsModel.setId(null);
                goodsModel.setItemClasscode(dto.getD().getItemClassCode());
                goodsModel.setItemDepth(dto.getD().getItemDepth());
                goodsModel.setItemDescription(dto.getD().getItemDescription());
                goodsModel.setItemGrossweight(dto.getD().getItemGrossWeight());
                goodsModel.setItemHeight(dto.getD().getItemHeight());
                goodsModel.setItemName(dto.getD().getItemName());
                goodsModel.setItemNetcontent(dto.getD().getItemNetContent());
                goodsModel.setItemNetweight(dto.getD().getItemNetWeight());
                goodsModel.setItemPackagingmaterialCode(dto.getD().getItemPackagingMaterialCode());
                goodsModel.setItemPackagingTypecode(dto.getD().getItemPackagingTypeCode());
                goodsModel.setItemShortdescription(dto.getD().getItemShortDescription());
                goodsModel.setItemSpecification(dto.getD().getItemSpecification());
                goodsModel.setItemWidth(dto.getD().getItemWidth());
                goodsModel.setKeeponRecord(dto.getD().getKeepOnRecord());
                goodsModel.setProductEx(dto.getD().getProductEx());
                goodsModel.setProductfangwei(dto.getD().getProductFangWei());
                //goodsModel.setQs(dto.getD().getQS());
                goodsModel.setQualificationCount(dto.getD().getQualificationCount());
                goodsModel.setRecallCount(dto.getD().getRecallCount());
                goodsModel.setStatus((goodsModel.getItemName().equals("***(企业未公开详细信息!)")||goodsModel.getItemName().equals("无") || StringUtils.isBlank(goodsModel.getItemName())) ? "2" : "1");
                //图片
                if (dto.getD().getImage() != null && dto.getD().getImage().size() > 0) {
                    for (ImageDto entity : dto.getD().getImage()) {
                        GoodsImageModel model = new GoodsImageModel();
                        model.setId(null);
                        model.setImageDescription(entity.getImageDescription());
                        model.setImageUrl(entity.getImageurl());
                        model.setProductCode(goods.getBarcode());
                        imageLst.add(model);
                    }
                }

                //属性
                if (dto.getD().getArrayOfKeyValue() != null && dto.getD().getArrayOfKeyValue().getKeyValue() != null
                        && dto.getD().getArrayOfKeyValue().getKeyValue().size() > 0) {
                    for (AttributeDto entity : dto.getD().getArrayOfKeyValue().getKeyValue()) {
                        GoodsAttrModel model = new GoodsAttrModel();
                        model.setId(null);
                        model.setAttName(entity.getAttName());
                        model.setAttValue(entity.getAttValue());
                        model.setProductCode(goods.getBarcode());
                        attrLst.add(model);
                    }
                }
            }
        }
        catch (Exception ex)
        {
            log.error("["+index+"]转model异常",ex);
        }
        SqlSession session = null;
        try {
            //存数据库
            //初始化
            session = wrapper.getSqlSessionFactory().openSession(false);
            attrMapper = session.getMapper(GoodsAttrModelMapper.class);
            imageMapper = session.getMapper(GoodsImageModelMapper.class);
            goodsMapper = session.getMapper(GoodsModelMapper.class);

            log.info("["+index+"]开始插入数据：商品1条，图片["+imageLst.size()+"]条，属性["+attrLst.size()+"]条。");
            goodsMapper.insert(goodsModel);
            for (GoodsImageModel model:imageLst) {
                imageMapper.insert(model);
            }
            for(GoodsAttrModel model:attrLst)
            {
                attrMapper.insert(model);
            }
            session.commit();
            log.info("["+index+"]插入成功");
        }catch (Exception ex)
        {
            session.rollback();
            log.error("["+index+"]插入数据异常",ex);
            return false;
        }
        finally {
            if(session!=null)
                session.close();
        }
        return true;
    }
}
