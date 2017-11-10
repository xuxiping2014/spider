package com.xinyunlian.spider.baidu.pages;

import com.xinyunlian.spider.enums.BaiduEnum;
import com.xinyunlian.spider.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMain extends BasePage{
    public PageMain() {
        super("百度页面");
    }

    @Override
    public void loadingWatting(WebDriver driver) {
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BaiduEnum.MAIN_PAGE_FLAG.getCssSelector())));
    }

    public void loadingWatting(WebDriver driver,int timeOutInSeconds) {
        (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(BaiduEnum.MAIN_PAGE_FLAG.getCssSelector())));
    }
}
