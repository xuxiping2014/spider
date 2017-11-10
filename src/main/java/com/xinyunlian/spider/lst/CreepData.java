package com.xinyunlian.spider.lst;

import com.google.gson.*;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.enums.LstEnum;
import com.xinyunlian.spider.jd.dto.JdExcelRetEntity;
import com.xinyunlian.spider.lst.dto.LstExcelRetEntity;
import com.xinyunlian.spider.lst.dto.RetDataDto;
import com.xinyunlian.spider.lst.dto.RetDto;
import com.xinyunlian.spider.lst.dto.TagsListDto;
import com.xinyunlian.spider.lst.pages.PageCreep;
import com.xinyunlian.spider.sys.SystemConfig;
import com.xinyunlian.spider.utils.ExportExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-30 18:05
 **/

public class CreepData {

    boolean isBegin = true;

    private WebDriver driver;

    private int pageIndex=1;

    private int currentCount=0;

    private int totalCount=0;

    private final int pageSize=10;

    private String categoryName="";

    private String urlTemplete = "";

    private List<RetDataDto> mDst = null;

    private Gson gson =null;

    private String actionCode;

    public CreepData(WebDriver driver,String cateName,String urlTemplete,String actionCode)
    {
        this.actionCode=actionCode;
        this.driver = driver;
        this.categoryName = cateName;
        this.urlTemplete = urlTemplete;
        mDst = new ArrayList<RetDataDto>();
        initExcelhead();
        initGson();
    }

    private void initGson()
    {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        gson = builder.create();
    }
    public void run()
    {
        while(creepping())
        {
            BaseCreepAction.sleep(3,3);
        }
    }


    public boolean  creepping()
    {
        RetDto dto = null;
        try {
            if(isBegin)
                BaseCreepAction.log("分类：" + categoryName + " 开始....");
            driver.get(String.format(urlTemplete, pageIndex));
            BaseCreepAction.log("等待数据...");
            (new PageCreep()).loadingWatting(driver);
            BaseCreepAction.log("数据返回");
            BaseCreepAction.log("解析数据");
            WebElement mDataContain = driver.findElement(By.xpath(LstEnum.CREEPER_DATA_FLAG.getCssSelector()));
            if (mDataContain != null) {
                String mData = mDataContain.getText();
                String jsonStr = mData.substring(mData.indexOf("{"),(mData.lastIndexOf("}")+1));
                gson = new Gson();
                dto=gson.fromJson(jsonStr,RetDto.class);
                BaseCreepAction.log("解析成功");
            } else {
                BaseCreepAction.log("数据获取失败");
                return  false;
            }
            if(dto!=null&&(dto.getData().getOfferList()==null
                    ||dto.getData().getOfferList().size()==0))
            {
                BaseCreepAction.log("数据取完了");
                return false;
            }
            else if(dto!=null&&dto.getData().getOfferList()!=null
                    ||dto.getData().getOfferList().size()>0)
            {
                Iterator<RetDataDto> it =dto.getData().getOfferList().iterator();
                while(it.hasNext())
                {
                    mDst.add(it.next());
                }
            }
            if(isBegin)
            {
                totalCount =dto!=null?dto.getData().getTotalCount():0;
                isBegin =false;
            }
            currentCount+=(dto!=null?(dto.getData().getOfferList()!=null?dto.getData().getOfferList().size():0):0);
            BaseCreepAction.log("载入数据["+currentCount+"/"+totalCount+"]...");
        }catch (Exception e)
        {
            BaseCreepAction.log("抓去失败："+e.getMessage());
            return false;
        }
        pageIndex++;
        return true;
    }

    public void exportExcel()
    {
        List<LstExcelRetEntity> rows =  transObject();
        //生成文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Random rand = new Random();
        String fileName= sdf.format(new Date())+"_"+categoryName+"_"+rand.nextInt(1000)+".xls";
        ExportExcelUtils.excelExport(rows,mHeaderMap,this.categoryName, SystemConfig.FF_DOWNLOAD_PATH+actionCode+"\\"+ fileName);
    }

    private List<LstExcelRetEntity> transObject()
    {
       List<LstExcelRetEntity> lstExcel = new ArrayList<LstExcelRetEntity>();
       if(mDst!=null)
       {
           try {
               for (RetDataDto ret : mDst) {
                   LstExcelRetEntity e = new LstExcelRetEntity();
                   e.setId(ret.getId());
                   e.setBaseUnit(ret.getRetailVO().getBaseUnit());
                   e.setDealMoney((ret.getTradeQuantity().getGmvValue() != null ? ret.getTradeQuantity().getGmvValue().get("integer") : "0") + "元");
                   e.setMinSaleNum(ret.getTradeQuantity().getQuantityBegin() + ret.getTradeQuantity().getUnit());
                   e.setName(ret.getInformation().getSubject());
                   e.setPrice(ret.getRetailVO().getRetailPrice());
                   e.setSellOut(ret.getRetailVO().isSellout() ? "售罄" : "在售");
                   e.setSaleUnit(ret.getRetailVO().getNewSellUnit());
                   e.setStock(ret.getRetailVO().getAmountOnSale() + ret.getTradeQuantity().getUnit());
                   e.setUnit(ret.getTradeQuantity().getUnit());
                   e.setPromotionPrice(ret.getRetailVO().getPromotionPrice());
                   e.setPromotion((StringUtils.isNotEmpty(ret.getRetailVO().getPromotionPrice())&&!ret.getRetailVO().getPromotionPrice().equals("0.0") )? "促销" : "未促销");
                   e.setTag(getTags(ret.getRetailVO().getTagsList()));
                   lstExcel.add(e);
               }
           }catch (Exception ex)
           {
               BaseCreepAction.log("转换数据有异常："+ex.getMessage());
           }
       }
       return lstExcel;
    }

    private Map<String, String> mHeaderMap = new LinkedHashMap<String, String>();

    private void initExcelhead()
    {
        mHeaderMap.put("id","商品编号");
        mHeaderMap.put("name","品名");
        mHeaderMap.put("stock","库存");
        mHeaderMap.put("price","价格");
        mHeaderMap.put("saleUnit","销售规格");
        mHeaderMap.put("unit","销售单位");
        mHeaderMap.put("baseUnit","基础单位");
        mHeaderMap.put("minSaleNum","最小起订量");
        mHeaderMap.put("tag","备注属性");
        mHeaderMap.put("promotion","促销");
        mHeaderMap.put("promotionPrice","促销价格");
        mHeaderMap.put("dealMoney","成交金额");
        mHeaderMap.put("sellOut","售罄");
    }

    private String getTags(List<TagsListDto> lst)
    {
        StringBuilder sb = new StringBuilder();
        if(lst!=null)
        {
            for (TagsListDto model :lst)
            {
                sb.append(model.getTagName());
            }
        }
        return sb.toString();
    }
}
