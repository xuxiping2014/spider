package com.xinyunlian.spider.lst.pages;

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
 * @create 2017-10-30 11:10
 **/

public class DivLogin extends BasePage{

    public DivLogin() {

        super("登录div");
    }

    /**
     * 等待加载页面
     */
    public void loadingWatting(WebDriver driver) {
        (new WebDriverWait(driver, 60)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(LstEnum.LOGIN_SUBUMIT_BUTTON.getCssSelector())));
    }
}
