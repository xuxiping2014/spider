package com.xinyunlian.spider.pages;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.WebDriver;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-29 20:03
 **/
@Data
@AllArgsConstructor
public abstract class BasePage {
    private String pageName;

    /**
     * 等待加载页面
     */
    public abstract void loadingWatting(WebDriver driver) ;

}
