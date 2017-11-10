package com.xinyunlian.spider.lst;

import com.xinyunlian.spider.account.LstAccount;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.enums.LstEnum;
import com.xinyunlian.spider.lst.pages.*;
import com.xinyunlian.spider.sys.SystemConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author xxp
 * @create 2017-10-27 20:18
 **/

public class LstAction extends BaseCreepAction {

    private LstAccount account;

    public LstAction(String pageUrl, String actionCode) {
        super(pageUrl, actionCode);
    }

    public boolean checkLoginStatus() {
        log("检测登录状态：登录="+(findWebElement(LstEnum.MAIN_PAGE_LINKED_BUTTON.getCssSelector())==null));
        return findWebElement(LstEnum.MAIN_PAGE_LINKED_BUTTON.getCssSelector())==null;
    }


    public void login(LstAccount account) {
        try
        {
            this.account =account;
            log("开始登录");
            log("地区："+account.getArea()+"  帐号："+account.getUserName()+"  密码："+account.getPassword());
            sleep(2,5);
            mutiLogin();
        }
        catch (Exception e)
        {

        }
    }

    private void mutiLogin()
    {
        log("开始自动登录...");
        try {
            //登录方式一
            if (findWebElement(LstEnum.MAIN_PAGE_LINKED_BUTTON.getCssSelector()) != null) {
                log("登录方式一");
                log("检测设置区域div...");
                (new DivSetLocation()).loadingWatting(driver);
                if (findWebElement(LstEnum.MAIN_PAGE_SETTING_LOCALTION_DIV.getCssSelector()) != null) {
                    log("取消弹出设置地址div");
                    sleep(5, 5);
                    WebElement cancelBtn = findWebElement(LstEnum.MAIN_PAGE_SETTING_LOCALTION_DIV_CANCEL_BUTTON.getCssSelector());
                    cancelBtn.click();
                }
                sleep(5, 4);
                WebElement loginLinkBtn = findWebElement(LstEnum.MAIN_PAGE_LINKED_BUTTON.getCssSelector());
                loginLinkBtn.click();
                log("进入登录界面...");
                log("载入登录界面...");
                (new PageLogin()).loadingWatting(driver);
                log("载入完成");
                sleep(10, 15);
                log("切换到iframe");
                driver.switchTo().frame(findWebElement(LstEnum.LOGIN_LOINGBOX_IFRAME.getCssSelector()));
                (new DivLogin()).loadingWatting(driver);
                log("输入用户名：" + account.getUserName());
                WebElement loginUserNameTextBox = findWebElement(LstEnum.LOGIN_USERNAME_INPUT.getCssSelector());
                loginUserNameTextBox.clear();
                loginUserNameTextBox.sendKeys(account.getUserName());
                sleep(5, 2);
                log("输入密码：" + account.getPassword());
                WebElement loginPasswordTextBox = findWebElement(LstEnum.LOGIN_PASSWORD_INPUT.getCssSelector());
                loginPasswordTextBox.clear();
                loginPasswordTextBox.sendKeys(account.getPassword());
                log("账户登录");
                sleep(5, 2);
                WebElement submitBtn = findWebElement(LstEnum.LOGIN_SUBUMIT_BUTTON.getCssSelector());
                submitBtn.submit();
                sleep(5, 5);
            } else if (null != findWebElement(LstEnum.DIRECT_LOGIN_PAGE.getCssSelector())) {
                log("登录方式二");
                sleep(5, 5);
                log("选择密码登录");
                log("切换到登录frame");
                driver.switchTo().frame(0);
                log("登录div加载...");
                (new PageDirectLogin()).loadingWatting(driver);
                log("加载完毕");
                sleep(3);
                //密码登录点击
                WebElement mMmdy = findWebElement(LstEnum.DIRECT_LOGIN_PAGE_PASSWORDCHOSE.getCssSelector());
                mMmdy.click();
                sleep(5, 10);

                log("输入用户名：" + account.getUserName());
                WebElement loginUserNameTextBox = findWebElement(LstEnum.DIRECT_LOGIN_PAGE_USERNAME_INPUT.getCssSelector());
                loginUserNameTextBox.clear();
                loginUserNameTextBox.sendKeys(account.getUserName());
                sleep(5, 3);
                log("输入密码：" + account.getPassword());
                WebElement loginPasswordTextBox = findWebElement(LstEnum.DIRECT_LOGIN_PAGE_PASSWORD_INPUT.getCssSelector());
                loginPasswordTextBox.clear();
                loginPasswordTextBox.sendKeys(account.getPassword());
                log("账户登录");
                sleep(5, 3);
                WebElement submitBtn = findWebElement(LstEnum.DIRECT_LOGIN_PAGE_SUBMIT_BTN.getCssSelector());
                submitBtn.submit();
                sleep(5, 10);
            }
            log("切回主界面");
            driver.switchTo().defaultContent();
        }catch (Exception e)
        {
            log("自动登录异常:"+e.getMessage());
        }
        log("载入主界面...");
        //等待主界面加载登录 等待时间为10分钟
        (new PageMain()).loadingWatting(driver,60*10);
        log("载入完成");
        log("检测设置区域div...");
        (new DivSetLocation()).loadingWatting(driver);
        //取消弹出的设置地址div
        if(findWebElement(LstEnum.MAIN_PAGE_SETTING_LOCALTION_DIV.getCssSelector())!=null)
        {
            sleep(5,10);
            log("取消弹出设置地址div");
            WebElement cancelBtn = findWebElement(LstEnum.MAIN_PAGE_SETTING_LOCALTION_DIV_CANCEL_BUTTON.getCssSelector());
            cancelBtn.click();
        }
        sleep(2,2);
    }


    public void creepData() {
        sleep(3,3);
        log("开始抓取数据...");
        Creep(driver,"酒类",SystemConfig.FF_LST_CREEP_URL_WINE);
        sleep(3,3);
        Creep(driver,"饮料",SystemConfig.FF_LST_CREEP_URL_DRINK);
        sleep(3,3);
        Creep(driver,"乳制品",SystemConfig.FF_LST_CREEP_URL_MILK);
        sleep(3,3);
        Creep(driver,"水",SystemConfig.FF_LST_CREEP_URL_WATER);
        sleep(3,3);
        Creep(driver,"方便食品",SystemConfig.FF_LST_CREEP_URL_FASTFOOD);
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
