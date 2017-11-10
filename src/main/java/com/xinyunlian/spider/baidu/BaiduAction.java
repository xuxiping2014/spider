package com.xinyunlian.spider.baidu;

import com.xinyunlian.spider.account.LstAccount;
import com.xinyunlian.spider.ancc.inter.GoodsModelMapper;
import com.xinyunlian.spider.ancc.model.GoodsModel;
import com.xinyunlian.spider.ancc.model.GoodsModelExample;
import com.xinyunlian.spider.baidu.pages.PageMain;
import com.xinyunlian.spider.barcode.dto.GoodsInfoDto;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.db.DataSourceWrapper;
import com.xinyunlian.spider.enums.BaiduEnum;
import com.xinyunlian.spider.sys.SystemConfig;
import com.xinyunlian.spider.utils.ExportExcelUtils;
import com.xinyunlian.spider.utils.ReadExcelUtils;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.*;

public class BaiduAction extends BaseCreepAction {

    private DataSourceWrapper wrapper;
    List<GoodsModel> goodsInfoLst;
    private GoodsModelMapper goodsMapper = null;
    public BaiduAction(String pageUrl, String actionCode) {
        super(pageUrl, actionCode);
        this.wrapper = new DataSourceWrapper();
        goodsMapper = wrapper.getMapperInstance(GoodsModelMapper.class);
    }



    @Override
    public boolean checkLoginStatus() {
        return true;
    }

    @Override
    public void login(LstAccount account) {
        log("载入百度查询界面...");
        (new PageMain()).loadingWatting(driver);
        if(goodsInfoLst==null)
        {
            try {
                //查询数据
                GoodsModelExample queryModel = new GoodsModelExample();
                GoodsModelExample.Criteria query1=  queryModel.createCriteria();
                query1.andStatusEqualTo("2");
                GoodsModelExample.Criteria query2=  queryModel.createCriteria();
                query2.andStatusEqualTo("3");
                queryModel.or(query2);
                goodsInfoLst = goodsMapper.selectByExample(queryModel);
                log("查询到未完善数据["+goodsInfoLst.size()+"]条");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        log("开始爬数据");
    }


    @Override
    public void creepData() {
        for (int i=0;i< goodsInfoLst.size();i++) {
            try {
                log("第[" + i + "]条商品信息发现异常，开始抓取数据...");
                log("载入商品信息界面");
                GoodsModel infoDto = goodsInfoLst.get(i);
                driver.get(String.format(SystemConfig.FF_BAIDU_BARCODE_URL, infoDto.getProductCode()));
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
                        log("条码["+infoDto.getProductCode()+"]被识别成为了快递单号");
                    }
                    else
                    {
                        throw ex;
                    }
                }
                if (nameDiv != null) {
                    log("查询到信息:" + nameDiv.getText());
                    infoDto.setItemName(nameDiv.getText());
                    infoDto.setStatus("1");
                    goodsMapper.updateByPrimaryKey(infoDto);
                    log("更新数据库数据信息");
                } else {
                    log("没有查询到该商品[" + infoDto.getProductCode() + "]信息");
                    //infoDto.setItemName(null);
                }


                sleep(5, 2);
            }catch (Exception ex)
            {
                log("第[" + i + "]条商品信息查询异常，跳过到下一条记录...");
            }
        }



    }
}
