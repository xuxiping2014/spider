package com.xinyunlian.spider.barcode.pages;

import com.xinyunlian.spider.enums.BarcodeEnum;
import com.xinyunlian.spider.enums.JDEnum;
import com.xinyunlian.spider.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMain extends BasePage {
    public PageMain()
    {
        super("检索界面");
    }

    @Override
    public void loadingWatting(WebDriver driver) {
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector(BarcodeEnum.SEARCH_PAGE_TEXT_KEYWORD.getCssSelector()))!=null;
            }
        });
    }



}
