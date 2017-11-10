package com.xinyunlian.spider.enums;

import lombok.AllArgsConstructor;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-29 11:28
 **/
@AllArgsConstructor
public enum JDEnum {
    LOGIN_PAGE_SUBMIT_BTN("A.btn.J_ping"),
    LOGIN_PAGE_ACCOUNT_LOGIN_BTN("span#account_login_txt"),
    LOGIN_PAGE_USERNAME_INPUT("input.acc-input.username.txt-input.J_ping"),
    LOGIN_PAGE_PASSWORD_INPUT("input.acc-input.password.txt-input.J_ping"),
    LOGIN_PAGE_LOGIN_SUBMIT_BTN("a#loginBtn"),

    MAIN_PAGE_LOGIN_LINKED_BUTTON("div.login-icon"),

    MAIN_PAGE_FLAG("i.icon-home_normal_selected"),


    //爬取数据界面
    CREEPER_PAGE_FLAG("body"),
    CREEPER_DATA_FLAG("//pre");


    private String cssSelector;


    public String getCssSelector() {
        return cssSelector;
    }

    public void setCssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }
}
