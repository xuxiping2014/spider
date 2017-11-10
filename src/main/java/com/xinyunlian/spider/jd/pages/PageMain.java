package com.xinyunlian.spider.jd.pages;

import com.xinyunlian.spider.enums.JDEnum;
import com.xinyunlian.spider.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-31 10:25
 **/

public class PageMain extends BasePage {
    public PageMain()
    {
        super("京东主界面");
    }
    public void loadingWatting(WebDriver driver,int timeOutInSeconds){
        (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector(JDEnum.MAIN_PAGE_FLAG.getCssSelector()))!=null;
            }
        });
    }

    /**
     * 等待加载页面
     */
    public void loadingWatting(WebDriver driver)
    {
        loadingWatting(driver,60);

    }
}
