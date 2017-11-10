package com.xinyunlian.spider.jd;

import com.xinyunlian.spider.account.LstAccount;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.enums.JDEnum;
import com.xinyunlian.spider.jd.pages.PageLogin;
import com.xinyunlian.spider.jd.pages.PageMain;
import com.xinyunlian.spider.sys.SystemConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-27 20:18
 **/

public class JDAction extends BaseCreepAction {

    private LstAccount account;

    public JDAction(String pageUrl, String actionCode) {
        super(pageUrl, actionCode);
    }

    public boolean checkLoginStatus() {
        //等待十分钟，等待用户登录
        (new PageMain()).loadingWatting(driver,60*10);


        return true;
    }




    public void login(LstAccount account) {
        try
        {
            this.account =account;
            log("开始登录");
            log("地区："+account.getArea()+"  帐号："+account.getUserName()+"  密码："+account.getPassword());
            sleep(2,5);
            login();
        }
        catch (Exception e)
        {

        }
    }

    private boolean login()
    {
        log("页面加载中...");
        (new PageMain()).loadingWatting(driver);
        log("页面加载完毕");
        sleep(3,2);
        log("查找登录按钮");
        WebElement loginBtn = findWebElement(JDEnum.MAIN_PAGE_LOGIN_LINKED_BUTTON.getCssSelector());
        if(loginBtn==null)
        {
            log("未找到登录按钮，退出");
            return false;
        }
        log("跳转到登录界面");
        loginBtn.click();
        (new PageLogin()).loadingWatting(driver);
        sleep(3,2);
        log("开始自动登录");
        try {
            log("选择帐号登录");
            WebElement accountLoginBtn = findWebElement(JDEnum.LOGIN_PAGE_ACCOUNT_LOGIN_BTN.getCssSelector());
            accountLoginBtn.click();
            sleep(5);
            log("输入帐号；"+account.getUserName());
            WebElement txtUsername = findWebElement(JDEnum.LOGIN_PAGE_USERNAME_INPUT.getCssSelector());
            txtUsername.clear();
            txtUsername.sendKeys(account.getUserName());
            sleep(3,3);
            log("输入密码："+account.getPassword());
            WebElement txtPassword =findWebElement(JDEnum.LOGIN_PAGE_PASSWORD_INPUT.getCssSelector());
            txtPassword.clear();
            sleep(1,2);
            txtPassword.sendKeys(account.getPassword());
            log("登录帐号");
            sleep(3,3);
            WebElement btnSubmit = findWebElement(JDEnum.LOGIN_PAGE_LOGIN_SUBMIT_BTN.getCssSelector());
            btnSubmit.click();
        }catch (Exception ex)
        {
            log("自动登录失败，请手动登录！");
            return false;
        }

        log("登录完成");
        return true;
    }



    public void creepData() {
        sleep(3,3);
        log("开始抓去数据...");
        sleep(3,3);
        Creep(driver,"饮料和水",SystemConfig.FF_JD_CREEP_URL_DRINK);
        sleep(3,3);
        Creep(driver,"速食粮油",SystemConfig.FF_JD_CREEP_URL_FASTFOOD);
        sleep(3,3);
        Creep(driver,"乳制品",SystemConfig.FF_JD_CREEP_URL_MILK);
        sleep(3,3);
        Creep(driver,"中外酒类",SystemConfig.FF_JD_CREEP_URL_WINE);
    }

    private void Creep(WebDriver driver, String cateName, String urlTemplete)
    {
        try {
            CreepData mCd = new CreepData(driver, cateName, urlTemplete,actionCode);
            mCd.run();
            log("导出ecxcel数据...");
            mCd.exportExcel();
            log("导出ecxcel数据完毕");
        }catch (Exception ex)
        {
            log("Creep["+cateName+"]异常！");
        }
    }
}
