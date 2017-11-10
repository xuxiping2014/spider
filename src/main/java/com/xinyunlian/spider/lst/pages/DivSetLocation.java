package com.xinyunlian.spider.lst.pages;

import com.xinyunlian.spider.enums.LstEnum;
import com.xinyunlian.spider.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-30 13:19
 **/

public class DivSetLocation extends BasePage {
    public DivSetLocation()
    {
        super("设置地区位置div");
    }

    public void loadingWatting(WebDriver driver) {
        try {
            (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(LstEnum.MAIN_PAGE_SETTING_LOCALTION_DIV.getCssSelector())));
        }catch (Exception ex)
        {

        }
    }
}
