package com.xinyunlian.spider.barcode;

import com.xinyunlian.spider.XylSpiderMain;
import com.xinyunlian.spider.account.LstAccount;
import com.xinyunlian.spider.barcode.dto.GoodsInfoDto;
import com.xinyunlian.spider.barcode.pages.PageMain;
import com.xinyunlian.spider.barcode.pages.PageSearch;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.enums.BarcodeEnum;
import com.xinyunlian.spider.lst.dto.LstExcelRetEntity;
import com.xinyunlian.spider.sys.SystemConfig;
import com.xinyunlian.spider.utils.ExportExcelUtils;
import com.xinyunlian.spider.utils.ReadExcelUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.*;

public class BarcodeAction extends BaseCreepAction {

    public BarcodeAction(String pageUrl, String actionCode) {
        super(pageUrl, actionCode);
    }

    @Override
    public boolean checkLoginStatus() {

        try {
            driver.switchTo().frame(findWebElement(BarcodeEnum.SEARCH_PAGE_VALIDATE_FRAME.getCssSelector()));
            WebElement validateDiv = findWebElement(BarcodeEnum.SEARCH_PAGE_VALIDATE_FLAG.getCssSelector());
            if (validateDiv != null)
                return !validateDiv.getText().startsWith("点击此处进行人机识别验证");
            else
                return true;
        }catch (Exception ex)
        {
            return false;
        }
        finally {
            driver.switchTo().defaultContent();
        }
    }

    @Override
    public void login(LstAccount account) {
        log("载入界面中...");
        (new PageMain()).loadingWatting(driver);
        log("已经载入界面");
        boolean vali = checkLoginStatus();
        log("检测界面验证状态:"+vali);
        if(!vali)
        {
            log("请进行手动验证...");
            (new  PageSearch()).loadingWatting(driver,5*10);
            log("验证通过");
        }
    }

    @Override
    public void creepData() {
        log("开始抓取数据...");
        log("读取原始文件："+ SystemConfig.FF_BARCODE_INPUT_PATH+ SystemConfig.FF_BARCODE_FILENAME);
        ReadExcelUtils reader = new ReadExcelUtils();
        List<GoodsInfoDto> lst=null;
        try {
             lst= reader.readExcel(GoodsInfoDto.class, SystemConfig.FF_BARCODE_INPUT_PATH+ SystemConfig.FF_BARCODE_FILENAME);
        }catch (Exception e)
        {
            log("读取失败："+e.getMessage());
        }
        log("读取数据:"+lst.size()+"条");
        for(int i=0;i<lst.size();i++)
        {
            try {
                creepping(lst.get(i), i);
                sleep(5, 2);
            }catch (Exception e)
            {
                if(e.getClass().equals(AuthException.class))
                {
                    log("权限被封,等待60秒...");
                    sleep(75);
                    log("重新载入界面...");
                    driver.get(pageUrl);
                    login(null);
                    sleep(5);
                    --i;
                }
            }
        }
        log("数据抓取完毕，导出excel文件...");
        String path = exportExcel(lst);
        log("导出excel完毕，路径："+path);

    }

    private void creeppingBaidu(List<GoodsInfoDto> lst)
    {
        log("对数据进行二次筛选");

    }

    private void creepping(GoodsInfoDto in,int index) throws AuthException {
        log("任务第["+index+"]条");
        if(isAuthForbidden())
        {
            throw new AuthException();
        }
        try {
            if (StringUtils.isNotBlank(in.getBarcode())) {
                WebElement input = findWebElement(BarcodeEnum.SEARCH_PAGE_TEXT_KEYWORD.getCssSelector());
                WebElement btn = findWebElement(BarcodeEnum.SEARCH_PAGE_SEARCH_BTN.getCssSelector());
                log("输入条码...");
                input.clear();
                input.sendKeys(in.getBarcode());

                log("点击查询按钮...");
                btn.click();
                    String STR_READY_STATE = "";
                JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
                log("等待结果...");
                while (!STR_READY_STATE.equals("complete")) {
                    sleepInMillis(100);
                    STR_READY_STATE = (String) jsDriver.executeScript("return document.readyState");
                }
                log("结果返回");
                List<WebElement> resultInfos = driver.findElements(By.cssSelector(BarcodeEnum.SEARCH_PAGE_GOODS_INFO.getCssSelector()));
                List<WebElement> supplierInfos = driver.findElements(By.cssSelector(BarcodeEnum.SEARCH_PAGE_SUPPLIER_INFO.getCssSelector()));
                WebElement resultInfo;
                WebElement supplierInfo;
                if (resultInfos == null || resultInfos.size() == 0) {
                    in.setError("无查询结果");
                    return;
                }
                if (resultInfos.size() > 1) {
                    in.setError("条码异常,查询到多个结果");
                }
                resultInfo = resultInfos.get(0);
                supplierInfo = supplierInfos.get(0);
                List<WebElement> Info = resultInfo.findElements(By.cssSelector(BarcodeEnum.SEARCH_PAGE_INFO_DD.getCssSelector()));
                List<WebElement> supplier = supplierInfo.findElements(By.cssSelector(BarcodeEnum.SEARCH_PAGE_INFO_DD.getCssSelector()));
                //in.setBarcode(Info.get(0).findElement(By.cssSelector("a")).getText());
                in.setName(Info.get(3).getText());
                in.setSpec(Info.get(4).getText());
                in.setBrand(supplier.get(0).getText());
                in.setFactory(supplier.get(1).findElement(By.cssSelector("a")).getText());
                log("当前条抓取成功");
            }
        }catch (Exception e)
        {
            log("抓取数据失败:"+e.getMessage());
        }
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

    public String exportExcel( List<GoodsInfoDto> lst)
    {
        initExcelhead();
        //生成文件名称
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Random rand = new Random();
        String fileName= sdf.format(new Date())+"_"+rand.nextInt(1000)+".xls";
        ExportExcelUtils.excelExport(lst,mHeaderMap,"店铺商品", SystemConfig.FF_BARCODE_OUTPUT_PATH+ fileName);
        return SystemConfig.FF_BARCODE_OUTPUT_PATH+ fileName;
    }

    private boolean isAuthForbidden()
    {
        WebElement head = findWebElement("div#header");
        if(head!=null)
        {
            return "服务器错误".equals(head.findElement(By.cssSelector("h1")).getText());
        }
        return false;

    }
}
