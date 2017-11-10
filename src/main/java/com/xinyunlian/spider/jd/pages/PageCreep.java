package com.xinyunlian.spider.jd.pages;

import com.xinyunlian.spider.enums.JDEnum;
import com.xinyunlian.spider.enums.LstEnum;
import com.xinyunlian.spider.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-31 12:16
 **/

public class PageCreep extends BasePage {
    public PageCreep()
    {
        super("京东爬数据界面");
    }
    public void loadingWatting(WebDriver driver) {
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector(JDEnum.CREEPER_PAGE_FLAG.getCssSelector())) != null;
            }
        });
    }
}
