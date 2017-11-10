package com.xinyunlian.spider.enums;

import lombok.AllArgsConstructor;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-29 10:02
 **/
@AllArgsConstructor
public enum LstEnum {

    //直接登录界面
    DIRECT_LOGIN_PAGE("DIV.formarea"),
    //密码登录a标签
    DIRECT_LOGIN_PAGE_PASSWORDCHOSE("a.forget-pwd.J_Quick2Static"),
    DIRECT_LOGIN_PAGE_USERNAME_INPUT("input.login-text.J_UserName"),
    DIRECT_LOGIN_PAGE_PASSWORD_INPUT("input#TPL_password_1"),
    DIRECT_LOGIN_PAGE_SUBMIT_BTN("button#J_SubmitStatic"),

    //首页页面标志，红包连接
    MAIN_PAGE_FLAG("a.link.red-packet"),
    //首页跳转到登录界面link
    MAIN_PAGE_LINKED_BUTTON("a.link.login"),
    MAIN_PAGE_SETTING_LOCALTION_DIV("div.next-overlay-wrapper.next-dialog-wrapper.opened"),
    //偶尔会有设置店铺地址框弹出
    MAIN_PAGE_SETTING_LOCALTION_DIV_CANCEL_BUTTON("button.next-btn.next-btn-normal.next-btn-medium"),



    //登录iframe的id
    LOGIN_LOINGBOX_IFRAME(".loginBox"),
    //用户名
    LOGIN_USERNAME_INPUT("input.login-text.J_UserName"),
    //密码
    LOGIN_PASSWORD_INPUT("input#TPL_password_1"),
    //登录按钮
    LOGIN_SUBUMIT_BUTTON("button#J_SubmitStatic"),
    //登录页面加载标志
    LOGIN_PAGE_FLAG(".loginBox"),

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
