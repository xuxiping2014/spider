package com.xinyunlian.spider.lst.pages;

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
 * @create 2017-10-30 18:27
 **/

public class PageCreep extends BasePage {
    public PageCreep()
    {
        super("爬取数据页面");
    }
    @Override
    public void loadingWatting(WebDriver driver) {
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector(LstEnum.CREEPER_PAGE_FLAG.getCssSelector())) != null;
            }
        });
    }
}
