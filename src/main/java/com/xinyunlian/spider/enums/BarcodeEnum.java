package com.xinyunlian.spider.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BarcodeEnum {

    SEARCH_PAGE_FLAG("button#gdsBtn"),
    SEARCH_PAGE_TEXT_KEYWORD("input#keyword"),
    SEARCH_PAGE_VALIDATE_FRAME("iframe#captcha_widget"),
    SEARCH_PAGE_VALIDATE_FLAG("span.captcha-widget-text"),
    SEARCH_PAGE_GOODS_INFO("dl.p-info"),
    SEARCH_PAGE_SUPPLIER_INFO ("dl.p-supplier"),
    SEARCH_PAGE_SEARCH_BTN("button#gdsBtn"),
    SEARCH_PAGE_INFO_DD("dd");




    private String cssSelector;


    public String getCssSelector() {
        return cssSelector;
    }

    public void setCssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }
}
