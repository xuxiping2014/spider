package com.xinyunlian.spider.mutiply;

import com.google.gson.*;
import com.xinyunlian.spider.account.LstAccount;
import com.xinyunlian.spider.ancc.ANCC;
import com.xinyunlian.spider.ancc.AuthException;
import com.xinyunlian.spider.ancc.accnAction;
import com.xinyunlian.spider.ancc.dto.AttributeDto;
import com.xinyunlian.spider.ancc.dto.DetailDto;
import com.xinyunlian.spider.ancc.dto.ImageDto;
import com.xinyunlian.spider.ancc.dto.RetDto;
import com.xinyunlian.spider.ancc.inter.GoodsAttrModelMapper;
import com.xinyunlian.spider.ancc.inter.GoodsImageModelMapper;
import com.xinyunlian.spider.ancc.inter.GoodsModelMapper;
import com.xinyunlian.spider.ancc.model.GoodsAttrModel;
import com.xinyunlian.spider.ancc.model.GoodsImageModel;
import com.xinyunlian.spider.ancc.model.GoodsModel;
import com.xinyunlian.spider.ancc.model.GoodsModelExample;
import com.xinyunlian.spider.baidu.pages.PageMain;
import com.xinyunlian.spider.barcode.dto.GoodsInfoDto;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.db.DataSourceWrapper;
import com.xinyunlian.spider.enums.BaiduEnum;
import com.xinyunlian.spider.mutiply.dto.ExcelInputDto;
import com.xinyunlian.spider.sys.SystemConfig;
import com.xinyunlian.spider.utils.ExportExcelUtils;
import com.xinyunlian.spider.utils.ReadExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;

public class MutiplyAction extends BaseCreepAction {

    List<ExcelInputDto> goodsInfoLst;
    private Logger log = Logger.getLogger(accnAction.class);
    private DataSourceWrapper wrapper;
    private ANCC ancc ;
    private Gson gson;
    private GoodsAttrModelMapper attrMapper=null;
    private GoodsImageModelMapper imageMapper = null;
    private GoodsModelMapper goodsMapper = null;

    private List<GoodsModel> retLst = null;

    public MutiplyAction(String pageUrl, String actionCode) {
        super(pageUrl, actionCode);
        log("载入百度查询界面...");
        (new PageMain()).loadingWatting(driver);
        log("载入完毕");
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
        retLst = new ArrayList<GoodsModel>();
    }

    /**
     * 读取excel文件
     */
    public void readExcelFile()
    {
        log("数据初始化中...");
        try {
            ReadExcelUtils reader = new ReadExcelUtils();
            log.info("读取原始数据文件[" + SystemConfig.FF_BARCODE_INPUT_PATH + SystemConfig.FF_BARCODE_FILENAME + "]...");
            goodsInfoLst = reader.readExcel(ExcelInputDto.class, SystemConfig.FF_BARCODE_INPUT_PATH + SystemConfig.FF_BARCODE_FILENAME);
            if(goodsInfoLst==null||goodsInfoLst.size()==0)
            {
                log("读取文件条数="+0+"条");
            }
            else {
                log("读取文件条数="+goodsInfoLst.size()+"条");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkLoginStatus() {
        return true;
    }


    @Override
    public void login(LstAccount account) {


    }

    @Override
    public void creepData() {
        log("开始获取详细数据...");
        if(goodsInfoLst==null)
            return;
        for(int i=0;i<goodsInfoLst.size();i++)
        {
            BaseCreepAction.sleepInMillis(200);
            ExcelInputDto model = goodsInfoLst.get(i);
            model.setBarcode(model.getBarcode().startsWith("0")?model.getBarcode().substring(1):model.getBarcode());
            GoodsModel goodsModel = null;

            log("["+i+"][BARCODE="+model.getBarcode()+"]检测数据是否已经存在数据库中...");
            goodsModel = getGoodsInfoByBarcode(model.getBarcode());
            if(goodsModel!=null)
            {
                if(goodsModel.getType()==null)
                {
                    goodsModel.setType(model.getIsTobacco());
                    updateGoodsInfo(goodsModel);
                }
                retLst.add(goodsModel);
                log("["+i+"][BARCODE="+model.getBarcode()+"]数据已经存在，跳过到下一条记录。");
                continue;
            }
            log("["+i+"][BARCODE="+model.getBarcode()+"]数据库未查询到，开始进行ANCC接口查询...");

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
            if(dto==null||dto.getD()==null||dto.getD().getItemName().equals("***(企业未公开详细信息!)")
                    ||dto.getD().getItemName().equals("无") || StringUtils.isBlank(dto.getD().getItemName())) {
                if (dto == null || dto.getD() == null) {
                    log("[" + i + "][BARCODE=" + model.getBarcode() + "]ACNN接口查询未查询到");
                } else{
                    log("[" + i + "][BARCODE=" + model.getBarcode() + "]ACNN接口查询信息不全");
                }
                log("[" + i + "][BARCODE=" + model.getBarcode() + "]通过百度接口进行查询...");
                //开始通过百度查询
                try {
                    log("[" + i + "][BARCODE=" + model.getBarcode() + "]载入商品信息界面");
                    driver.get(String.format(SystemConfig.FF_BAIDU_BARCODE_URL, model.getBarcode()));
                    WebElement nameDiv = null;
                    try {
                        (new PageMain()).loadingWatting(driver);
                        nameDiv = findWebElement(BaiduEnum.MAIN_PAGE_NAME_DIV.getCssSelector());
                    } catch (Exception ex) {
                        /**
                         * 条码被错当成了快递单号而进行了处理
                         */
                        if (java.net.URLDecoder.decode(driver.getCurrentUrl(), "utf-8").contains("快递单号")) {
                            nameDiv = null;
                            log("[" + i + "][BARCODE="+model.getBarcode()+"]被识别成为了快递单号");
                        }
                        else
                        {
                            throw ex;
                        }
                    }
                    if (nameDiv != null) {
                        log("[" + i + "][BARCODE="+model.getBarcode()+"]查询到信息"+ nameDiv.getText());
                        if(dto==null)
                        {
                            dto = new RetDto();
                            dto.setD(new DetailDto());
                        }
                        dto.getD().setItemName(nameDiv.getText());
                    } else {
                        goodsModel = new GoodsModel();
                        goodsModel.setProductCode(model.getBarcode());
                        goodsModel.setStatus("3");
                        retLst.add(goodsModel);
                        log("[" + i + "][BARCODE="+model.getBarcode()+"]没有查询到该商品");
                        //infoDto.setItemName(null);
                    }
                    sleep(5, 2);
                }catch (Exception ex)
                {
                    log("第[" + i + "]条商品信息查询异常，跳过到下一条记录...");
                    ex.printStackTrace();
                }
            }else
            {
                log("["+i+"]检测到数据[BARCODE="+model.getBarcode()+"]"+dto.getD().getItemName());
                retLst.add(goodsModel);
            }
            saveData(model, dto, i + 1);
        }
    }

    public boolean saveData(ExcelInputDto goods,RetDto dto,int index)
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
            if(dto==null||dto.getD()==null)
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

    /**
     * 爬取数据
     * @param model
     * @return
     */
    private RetDto creepping(ExcelInputDto model,int index) throws AuthException {
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

    private GoodsModel getGoodsInfoByBarcode(String barcode)
    {
        goodsMapper = wrapper.getMapperInstance(GoodsModelMapper.class);
        GoodsModelExample queryModel = new GoodsModelExample();
        queryModel.setDistinct(false);
        GoodsModelExample.Criteria criteria = queryModel.createCriteria();
        criteria.andProductCodeEqualTo(barcode);
        List<GoodsModel> models =  goodsMapper.selectByExample(queryModel);
        return models.size()>0?models.get(0):null;
    }

    private void updateGoodsInfo(GoodsModel model)
    {
        goodsMapper = wrapper.getMapperInstance(GoodsModelMapper.class);
        goodsMapper.updateByPrimaryKey(model);
    }

    private Map<String, String> mHeaderMap = new LinkedHashMap<String, String>();

    private void initExcelhead()
    {
        mHeaderMap.put("barcode","条码");
        mHeaderMap.put("name","品名");
        mHeaderMap.put("spec","规格");
        mHeaderMap.put("isTobacco","类型");
        mHeaderMap.put("price","售价");
        mHeaderMap.put("brand","商标");
        mHeaderMap.put("factory","厂家");
        mHeaderMap.put("error","异常信息");
        mHeaderMap.put("errorCode","异常编码");
    }

    public void exportExcel()
    {
        log("开始导出数据...");
        List<GoodsInfoDto> lst = transformDto();
        initExcelhead();
        //生成文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Random rand = new Random();
        String fileName= sdf.format(new Date())+"_"+rand.nextInt(1000)+".xls";
        ExportExcelUtils.excelExport(lst,mHeaderMap,"店铺商品", SystemConfig.FF_BARCODE_OUTPUT_PATH+ fileName);
        log("导出文件位置："+SystemConfig.FF_BARCODE_OUTPUT_PATH+ fileName);
    }

    private  List<GoodsInfoDto> transformDto()
    {
        List<GoodsInfoDto> lst = new ArrayList<>();
        if(retLst!=null)
            for(int i=0;i<retLst.size();i++)
            {
                GoodsModel model = retLst.get(i);
                GoodsInfoDto dto = new GoodsInfoDto();
                dto.setBarcode(model.getProductCode());
                dto.setFactory(model.getFirmName());
                dto.setBrand(model.getBrandName());
                dto.setSpec(model.getItemSpecification());
                dto.setName(model.getItemName());
                dto.setIsTobacco(model.getType());
                for(int k=0;k<goodsInfoLst.size();k++)
                {
                    if(goodsInfoLst.get(k).getBarcode().equals(model.getProductCode()))
                    {
                        dto.setPrice(goodsInfoLst.get(k).getPrice());
                        break;
                    }
                }
                if(model.getType()!=null)
                {
                    if(model.getStatus().equals("1"))
                    {
                        dto.setErrorCode("");
                        dto.setError("");
                    }
                    else
                    {
                        dto.setError(model.getStatus());
                    }
                }
                lst.add(dto);
            }
        return lst;
    }
}
