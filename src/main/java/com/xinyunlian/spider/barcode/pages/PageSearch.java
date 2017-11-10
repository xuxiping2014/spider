package com.xinyunlian.spider.barcode.pages;

import com.xinyunlian.spider.enums.BarcodeEnum;
import com.xinyunlian.spider.enums.LstEnum;
import com.xinyunlian.spider.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSearch extends BasePage {
    public PageSearch()
    {
        super("检索界面");
    }

    @Override
    public void loadingWatting(WebDriver driver) {
        loadingWatting(driver,60);
    }

    public void loadingWatting(WebDriver driver,int timeOutISeconds) {
        (new WebDriverWait(driver, 60)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                try {
                    driver.switchTo().frame(driver.findElement(By.cssSelector(BarcodeEnum.SEARCH_PAGE_VALIDATE_FRAME.getCssSelector())));
                    WebElement validateDiv = driver.findElement(By.cssSelector(BarcodeEnum.SEARCH_PAGE_VALIDATE_FLAG.getCssSelector()));
                    if (validateDiv != null)
                        return !validateDiv.getText().startsWith("点击此处进行人机识别验证");
                    else
                        return true;
                }catch (Exception ex)
                {
                    return true;
                }
                finally {
                    driver.switchTo().defaultContent();
                }
            }
        });
    }
}
