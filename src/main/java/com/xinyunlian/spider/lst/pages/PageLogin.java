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
 * @create 2017-10-29 20:33
 **/

public class PageLogin extends BasePage {
    public PageLogin() {
        super("登录界面");
    }

    /**
     * 等待加载页面
     */
    public void loadingWatting(WebDriver driver) {
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector(LstEnum.LOGIN_PAGE_FLAG.getCssSelector())) != null;
            }
        });
    }
}
