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
 * @create 2017-10-29 20:05
 **/

public class PageMain extends BasePage {

    public PageMain() {
        super( "主页面");
    }

    public void loadingWatting(WebDriver driver,int timeOutInSeconds)
    {
        (new WebDriverWait(driver, timeOutInSeconds)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.cssSelector(LstEnum.MAIN_PAGE_FLAG.getCssSelector()))!=null;
            }
        });

        //        boolean b = false;
//        int i=0;
//        while(!b)
//        {
//            if(i>60)
//            {
//                log("页面加载失败["+page.getPageName()+"]！");
//                break;
//            }
//            sleep(1);
//            b = (null!=findWebElement(page.getPageFlag()));
//            ++i;
//            log("页面加载中["+page.getPageName()+"]["+i+"]...");
//        }
    }
    /**
     * 等待加载页面
     */
    public void loadingWatting(WebDriver driver)
    {
        loadingWatting(driver,60);

    }
}
