package com.xinyunlian.spider.base;

import com.xinyunlian.spider.YlfinSpiderMain;
import com.xinyunlian.spider.account.LstAccount;
import com.xinyunlian.spider.sys.SystemConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author xxp
 * @create 2017-10-27 20:08
 **/
@Data
public abstract class BaseCreepAction {

    private static Logger logger =  Logger.getLogger(YlfinSpiderMain.class);

    /**
     * 主窗口id
     */
    protected String mainWindowId;
    /**
     * 从窗口id
     */
    protected String mFellowWindowId;

    /**
     * 窗口id列表
     */
    protected Set<String> mWindowsIds;

    /**
     * 初始化加载地址
     */
    protected String pageUrl;

    protected WebDriver driver;

    protected FirefoxOptions profile;

    protected String actionCode;

    public BaseCreepAction(String pageUrl,String actionCode)
    {
        log("启动爬虫");
        this.pageUrl = pageUrl;
        this.actionCode=actionCode;
        log("初始化...");
        init();
        log("初始化完成");
        log("打开浏览器...");
        openBronse();
        log("打开浏览器成功");

    }

    private void init()
    {
        try {
            // ===== 如果火狐浏览器没有默认安装在C盘，需要自己确定其路径 原始安装路径
            System.setProperty("webdriver.firefox.bin", SystemConfig.FF_EXE_PATH);
            System.setProperty("webdriver.gecko.driver",SystemConfig.FF_DRIVER_PATH);

            File file = new File(SystemConfig.FF_DOWNLOAD_PATH+actionCode+"\\" );
            if (!file.exists()) {
                file.mkdirs();
            }
            // 配置响应下载参数
            profile = new FirefoxOptions();
            profile.addPreference("browser.download.dir", SystemConfig.FF_DOWNLOAD_PATH);// 下载路径
            profile.addPreference("browser.download.defaultFolder", SystemConfig.FF_DRIVER_PATH + "\\" + actionCode);
            profile.addPreference("browser.download.folderList", 2);// 2为保存在指定路径，0代表默认路径
            profile.addPreference("browser.download.useDownloadDir", true);
            profile.addPreference("browser.download.manager.showWhenStarting", false);// 是否显示开始
            // 禁止弹出保存框，value是文件格式，如zip文件
            profile.addPreference("browser.helperApps.neverAsk.saveToDisk",
                    "application/vnd.ms-excel,image/jpeg,application/zip,text/plain,text/csv,text/comma-separated-values,application/octet-stream,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            // 关于类型：可以参考http://www.w3school.com.cn/media/media_mimeref.asp
            profile.addPreference("browser.helperApps.alwaysAsk.force", false);
            // 设置脚本无响应提示时间 =0 : 不提示
            profile.addPreference("dom.max_script_run_time", 0);
            // 禁止firefox 检查组件兼容性
            profile.addPreference("extensions.checkCompatibility.temporaryThemeOverride_minAppVersion", false);
        }catch (Exception ex)
        {
            log("初始化失败！");
            log(ex.getMessage());
        }
    }

    /**
     * 打开浏览器
     */
    public void openBronse()
    {
        try {
            driver = new FirefoxDriver(profile);  // 定义驱动对象为 FirefoxDriver 对象
            driver.get(pageUrl);  // 打开的网址
            driver.manage().window().maximize();
            mainWindowId = driver.getWindowHandle();
        }catch (Exception ex)
        {
            log("打开浏览器失败！");
            log(ex.getMessage());
        }
    }

    /**
     * 检测登录状态
     * @return
     */
    public abstract boolean checkLoginStatus();

    /**
     * 关闭一个窗口
     * @param id
     */
    public void closeWindow(String id)
    {
        driver.switchTo().window(id);
        driver.close();
    }

    /**
     * 赋值子窗口id
     */
    public void getFellowWindowsId()
    {
        mWindowsIds = driver.getWindowHandles();
        mFellowWindowId = null;
        Iterator<String> it = mWindowsIds.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if(!mainWindowId.equals(next))
            {
                mFellowWindowId = next;
            }
        }
    }
    /**
     * 创建新标签
     * @return
     */
    public boolean createNewWindow(String title,String url)
    {
        return createNewWindow(title,url,true);
    }
    public boolean createNewWindow(String title,String url,boolean switchTo)
    {
        try {
            mWindowsIds = driver.getWindowHandles();
            //关闭多余窗口，只保留一个主窗口
            log("正在清除多余窗口....");
            if(StringUtils.isNotEmpty(mFellowWindowId))
                closeWindow(mFellowWindowId);
            log("已经清除多余窗口");
            log("新建tab页["+title+"]  url="+url);
            JavascriptExecutor oJavaScriptExecutor = (JavascriptExecutor)driver;
            oJavaScriptExecutor.executeScript("window.open('" + url + "')");
            log("新建tab页成功");
            getFellowWindowsId();
            if(switchTo)
                driver.switchTo().window(mFellowWindowId);
            sleep(3);
            return true;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            log("新建tab失败,原因："+ex.getMessage());
            return false;
        }
    }


    /**
     * 登出
     */
    //public abstract void loginOut();
    /**
     * 登录
     */
    public abstract void login(LstAccount account);

    /**
     * 设置分类
     */
    //public abstract void setCategroy();

    /**
     * 跳页
     * @return
     */
    //public abstract boolean toNextPage();

    /**
     * 爬数据
     */
    public abstract void creepData();







    /**************通用方法*******************/
    public static void log(String msg)
    {
        writeConsole(msg);
    }

    private static void writeConsole(String msg)
    {
        try {
            logger.info(msg);
        }catch (Exception e)
        {

        }
    }
    private static Random rand = new Random();
    /**
     * 休息，休息一下
     * @param seconds
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("----->sleep出错！ error:" + e.getMessage());
        }
    }
    public static void sleep(int seconds,int randSecond)  {
        try {
            Thread.sleep((seconds+rand.nextInt(randSecond)) * 1000);
        } catch (InterruptedException e) {
            System.out.println("----->sleep出错！ error:" + e.getMessage());
        }
    }

    public static void sleepInMillis(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("----->sleep出错！ error:" + e.getMessage());
        }
    }
    /**
     * 转到当前页面
     */
    protected void switchToCurrentWindows()
    {
        if(driver!=null)
        {
            //得到当前句柄
            String currentWindow = driver.getWindowHandle();
            //得到所有窗口的句柄
            Set<String> handles = driver.getWindowHandles();
            //排除当前窗口的句柄，则剩下是新窗口
            Iterator<String> it = handles.iterator();
            while(it.hasNext()){
                if(currentWindow == it.next())  continue;
                driver.switchTo().window(it.next());
            }
        }
    }

    /**
     * 找元素
     * @param cssSelector
     * @return
     */
    public WebElement findWebElement(String cssSelector)
    {
        if(null==driver)
        {
            log("异常[getWebElement]：驱动==null");
        }
        try
        {
            return driver.findElement(By.cssSelector(cssSelector));
        }
        catch (Exception ex)
        {
            log("异常[getWebElement] exception:"+ex.getMessage());

        }
        return null;
    }


    /**
     * 找元素
     * @param id
     * @return
     */
    public WebElement findWebElementById(String id)
    {
        if(null==driver)
        {
            log("异常[getWebElement]：驱动==null");
        }
        try
        {
            return driver.findElement(By.id(id));
        }
        catch (Exception ex)
        {
            log("异常[getWebElement] exception:"+ex.getMessage());

        }
        return null;
    }

    /**
     * 找元素
     * @param cssSelector
     * @return
     */
    public WebElement findWebElements(String cssSelector)
    {
        if(null==driver)
        {
            log("异常[getWebElemens]：驱动==null");
        }
        try
        {
            return driver.findElement(By.cssSelector(cssSelector));
        }
        catch (Exception ex)
        {
            log("异常[getWebElements] exception:"+ex.getMessage());

        }
        return null;
    }


}