package com.xinyunlian.spider.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BaiduEnum {

    MAIN_PAGE_FLAG("i.graph-camera-icon"),

    MAIN_PAGE_NAME_DIV("div.graph-title");


    private String cssSelector;


    public String getCssSelector() {
        return cssSelector;
    }

    public void setCssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }
}
