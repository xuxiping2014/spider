package com.xinyunlian.spider.jd;

import com.google.gson.*;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.enums.JDEnum;
import com.xinyunlian.spider.jd.dto.JdExcelRetEntity;
import com.xinyunlian.spider.jd.dto.LabelInfoDto;
import com.xinyunlian.spider.jd.dto.RetDto;
import com.xinyunlian.spider.jd.dto.WareInfoDto;
import com.xinyunlian.spider.jd.pages.PageCreep;
import com.xinyunlian.spider.sys.SystemConfig;
import com.xinyunlian.spider.utils.ExportExcelUtils;
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
 * @create 2017-10-31 12:09
 **/

public class CreepData {

    boolean isBegin = true;

    private WebDriver driver;

    private int pageIndex=1;

    private int currentCount=0;

    private int totalPageCount=0;


    private final int pageSize=10;


    private String categoryName="";

    private String urlTemplete = "";

    private List<WareInfoDto> mDst = null;

    private Gson gson=null;

    private String actionCode;
    public CreepData(WebDriver driver,String cateName,String urlTemplete,String actionCode)
    {
        this.actionCode =actionCode;
        this.driver = driver;
        this.categoryName = cateName;
        this.urlTemplete = urlTemplete;
        mDst = new ArrayList<WareInfoDto>();
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
            WebElement mDataContain = driver.findElement(By.xpath(JDEnum.CREEPER_DATA_FLAG.getCssSelector()));
            if (mDataContain != null) {
                String mData = mDataContain.getText();
                String jsonStr = mData.substring(mData.indexOf("{"),(mData.lastIndexOf("}")+1));
                dto=gson.fromJson(jsonStr, RetDto.class);
                BaseCreepAction.log("解析成功");
            } else {
                BaseCreepAction.log("数据获取失败");
                return  false;
            }
            if(dto!=null&&(dto.getData().getWareInfoList()==null
                    ||dto.getData().getWareInfoList().size()==0))
            {
                BaseCreepAction.log("数据取完了");
                return false;
            }
            else if(dto!=null&&dto.getData().getWareInfoList()!=null
                    ||dto.getData().getWareInfoList().size()>0)
            {
                Iterator<WareInfoDto> it =dto.getData().getWareInfoList().iterator();
                while(it.hasNext())
                {
                    mDst.add(it.next());
                }
            }
            if(isBegin)
            {
                totalPageCount =dto!=null?dto.getData().getPageCount():0;
                isBegin =false;
            }
            currentCount+=(dto!=null?(dto.getData().getWareInfoList()!=null?dto.getData().getWareInfoList().size():0):0);
            BaseCreepAction.log("载入数据["+pageIndex+"/"+totalPageCount+"页] "+currentCount+"条...");
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
        List<JdExcelRetEntity> rows =  transObject();
        //生成文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Random rand = new Random();
        String fileName= sdf.format(new Date())+"_"+categoryName+"_"+rand.nextInt(1000)+".xls";
        ExportExcelUtils.excelExport(rows,mHeaderMap,this.categoryName, SystemConfig.FF_DOWNLOAD_PATH+actionCode+"\\"+ fileName);
    }

    private List<JdExcelRetEntity> transObject()
    {
        List<JdExcelRetEntity> lstExcel = new ArrayList<JdExcelRetEntity>();
        if(mDst!=null)
        {
            try {
                for (WareInfoDto ret : mDst) {
                    JdExcelRetEntity e = new JdExcelRetEntity();
                    e.setFullGifts(ret.isFullGifts()?"是":"否");
                    e.setGifts(ret.isGifts()?"是":"否");
                    e.setImageUrl("http:"+ret.getImageUrl());
                    e.setIsSuit(ret.isSuit()?"是":"否");
                    e.setJdPrice(ret.getJdPrice());
                    e.setLowPurchaseCount(ret.getLowPurchaseCount()+ret.getSaleUnit());
                    e.setMarketPrice(ret.getMarketPrice());
                    e.setName(ret.getName());
                    e.setPackageSize(ret.getPackageSize());
                    e.setPrice(ret.getPrice());
                    if(ret.getSeckillPromotion()!=null)
                    {
                        String a = ret.getSeckillPromotion().getSaleNum();
                        String b =ret.getSeckillPromotion().getTotalNum();
                    }
                    e.setPromotion(ret.getSeckillPromotion()!=null?"是":"否");
                    e.setPromotionDes(ret.getSeckillPromotion()!=null?ret.getSeckillPromotion().getTitle()+ret.getSeckillPromotion().getDescription():"");
                    e.setPromotionNum(ret.getSeckillPromotion()!=null?((ret.getSeckillPromotion().getSaleNum()==null?"0":ret.getSeckillPromotion().getSaleNum())+"/"+(ret.getSeckillPromotion().getTotalNum()==null?"0":ret.getSeckillPromotion().getTotalNum())):"");
                    e.setPromotionStatus(ret.getSeckillPromotion()!=null?ret.getSeckillPromotion().getAvailableDesc():"");
                    e.setSaleUnit(ret.getSaleUnit());
                    e.setSkuId(ret.getSkuId());
                    e.setLabelInfo(getLabelContent(ret.getLabelList()));
                    e.setPromotionDate(ret.getSeckillPromotion()!=null?foramtteDateToString(ret.getSeckillPromotion().getBeginTime())+"-"+foramtteDateToString(ret.getSeckillPromotion().getEndTime()):"");
                    lstExcel.add(e);
                }
            }catch (Exception ex)
            {
                BaseCreepAction.log("转换数据有异常："+ex.getMessage());
            }
        }
        return lstExcel;
    }
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String foramtteDateToString(Date dt)
    {
        if(dt==null)
            return "/";
        else
        {
           return  sdf.format(dt);
        }
    }

    private String getLabelContent(List<LabelInfoDto> lst)
    {
        StringBuilder sb = new StringBuilder();
        if(lst!=null)
        {
            for (LabelInfoDto model :lst)
            {
                sb.append(model.getText());
            }
        }
        return sb.toString();
    }


    private Map<String, String> mHeaderMap = new LinkedHashMap<String, String>();

    private void initExcelhead()
    {
        mHeaderMap.put("skuId","sku");
        mHeaderMap.put("name","品名");
        mHeaderMap.put("price","市场售价");
        mHeaderMap.put("jdPrice","京东售价");
        mHeaderMap.put("marketPrice","建议零售价");
        mHeaderMap.put("lowPurchaseCount","起售数量");
        mHeaderMap.put("saleUnit","销售规格");
        mHeaderMap.put("packageSize","箱规");
        mHeaderMap.put("labelInfo","备注属性");
        mHeaderMap.put("gifts","有赠品");
        mHeaderMap.put("fullGifts","满赠");
        mHeaderMap.put("isSuit","优惠套装");
        mHeaderMap.put("promotion","促销");
        mHeaderMap.put("promotionDate","促销时间");
        mHeaderMap.put("promotionDes","促销信息");
        mHeaderMap.put("promotionStatus","促销状态");
        mHeaderMap.put("promotionNum","已售总数/促销总数");
        mHeaderMap.put("imageUrl","图片地址");
    }
}
