package com.xinyunlian.spider.jd.pages;

import com.xinyunlian.spider.enums.JDEnum;
import com.xinyunlian.spider.enums.LstEnum;
import com.xinyunlian.spider.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-31 10:24
 **/

public class PageLogin extends BasePage {
    public PageLogin()
    {
        super("京东登录界面");
    }

    public void loadingWatting(WebDriver driver){
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector(JDEnum.LOGIN_PAGE_SUBMIT_BTN.getCssSelector()))!=null;
            }
        });
    }


}
