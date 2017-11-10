package com.xinyunlian.spider;

import com.xinyunlian.spider.account.LstAccount;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.jd.JDAction;
import com.xinyunlian.spider.lst.LstAction;
import com.xinyunlian.spider.sys.SystemConfig;
import com.xinyunlian.spider.utils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-31 14:56
 **/

public class YlfinSpiderMain {
    private static LstAccount account;
    public static void main(String[] args)
    {
        initLog4j();
        if(!initProperties())
        {
            BaseCreepAction.log("程序结束....");
        }
        else {
            BaseCreepAction action;
            if (SystemConfig.FF_ACCOUNT_TYPE.toLowerCase().equals("ali")) {
                action = new LstAction(SystemConfig.FF_ALI_URL, "ali");
            } else {
                action = new JDAction(SystemConfig.FF_JD_URL, "jd");
            }
            action.login(account);
            action.creepData();
            BaseCreepAction.log("抓取数据完毕！");
        }
        BaseCreepAction.log("请按任意键退出程序");
        Scanner scanner = new Scanner(System.in);
        scanner.next();
    }

    /**
     * 加载log4j配置
     */
    private static void initLog4j()
    {
        PropertyConfigurator.configure(YlfinSpiderMain.class.getResourceAsStream("/log4j.properties"));
    }
    /**
     * 初始化配置参数
     * @return
     */
    private static boolean initProperties()
    {
        BaseCreepAction.log("初始化系统数据...");
        Properties userPoperties =  PropertyUtils.InitProperties(getPath("user.properties"));
        SystemConfig.FF_EXE_PATH = userPoperties.getProperty("ff_exe_path");
        SystemConfig.FF_DRIVER_PATH = userPoperties.getProperty("ff_driver_path");
//        SystemConfig.FF_DOWNLOAD_PATH = userPoperties.getProperty("ff_download_path");
//        BaseCreepAction.log(SystemConfig.FF_DOWNLOAD_PATH);
        SystemConfig.FF_DOWNLOAD_PATH = getPath("download\\");
        checkFile(SystemConfig.FF_DOWNLOAD_PATH ,true);
        if(!checkFile(SystemConfig.FF_DRIVER_PATH,false))
        {
            BaseCreepAction.log("缺失参数[ff_driver_path]，请查看配置文件...");
            return false;
        }
        if(!checkFile(SystemConfig.FF_EXE_PATH,false))
        {
            BaseCreepAction.log("缺失参数[ff_exe_path]，请查看配置文件...");
            return false;
        }
        SystemConfig.FF_USERNAME = userPoperties.getProperty("ff_username");
        SystemConfig.FF_PASSWORD =  userPoperties.getProperty("ff_password");
        if(StringUtils.isEmpty(SystemConfig.FF_USERNAME))
        {
            BaseCreepAction.log("缺失参数[ff_username]，请查看配置文件...");
            return false;
        }
        if(StringUtils.isEmpty(SystemConfig.FF_PASSWORD))
        {
            BaseCreepAction.log("缺失参数[ff_password]，请查看配置文件...");
            return false;
        }
        SystemConfig.FF_ACCOUNT_TYPE = userPoperties.getProperty("ff_accountType");
        if(StringUtils.isEmpty(SystemConfig.FF_ACCOUNT_TYPE))
        {
            BaseCreepAction.log("缺失参数[ff_accountType]，请查看配置文件...");
            return false;
        }
        if(!SystemConfig.FF_ACCOUNT_TYPE.toLowerCase().equals("ali")&&!SystemConfig.FF_ACCOUNT_TYPE.toLowerCase().equals("jd"))
        {
            BaseCreepAction.log("参数[ff_accountType]不正确，请查看配置文件...");
            return false;
        }
        account = new LstAccount(SystemConfig.FF_USERNAME,SystemConfig.FF_PASSWORD,"");
        Properties sysPoperties =  PropertyUtils.InitProperties(getPath("config.properties"));
        //零售通连接参数
        SystemConfig.FF_ALI_URL = sysPoperties.getProperty("ali_url");
        SystemConfig.FF_LST_CREEP_URL_MILK =  sysPoperties.getProperty("lst_creeper_url_milk");
        SystemConfig.FF_LST_CREEP_URL_WINE =  sysPoperties.getProperty("lst_creeper_url_wine");
        SystemConfig.FF_LST_CREEP_URL_DRINK =  sysPoperties.getProperty("lst_creeper_url_drink");
        SystemConfig.FF_LST_CREEP_URL_FASTFOOD =  sysPoperties.getProperty("lst_creeper_url_fastfood");
        SystemConfig.FF_LST_CREEP_URL_WATER =  sysPoperties.getProperty("lst_creeper_url_water");
        //京东连接参数
        SystemConfig.FF_JD_URL= sysPoperties.getProperty("jd_url");
        SystemConfig.FF_JD_CREEP_URL_DRINK = sysPoperties.getProperty("jd_creeper_url_drink");
        SystemConfig.FF_JD_CREEP_URL_WINE = sysPoperties.getProperty("jd_creeper_url_wine");
        SystemConfig.FF_JD_CREEP_URL_MILK = sysPoperties.getProperty("jd_creeper_url_milk");
        SystemConfig.FF_JD_CREEP_URL_FASTFOOD = sysPoperties.getProperty("jd_creeper_url_fastfood");
        if(StringUtils.isBlank(SystemConfig.FF_LST_CREEP_URL_MILK)||StringUtils.isBlank(SystemConfig.FF_LST_CREEP_URL_WINE)||
                StringUtils.isBlank(SystemConfig.FF_ALI_URL)||StringUtils.isBlank(SystemConfig.FF_JD_URL)||
                StringUtils.isBlank(SystemConfig.FF_LST_CREEP_URL_DRINK)||StringUtils.isBlank(SystemConfig.FF_LST_CREEP_URL_FASTFOOD)||
                StringUtils.isBlank(SystemConfig.FF_LST_CREEP_URL_WATER)||StringUtils.isBlank(SystemConfig.FF_JD_CREEP_URL_DRINK)||
                StringUtils.isBlank(SystemConfig.FF_JD_CREEP_URL_WINE)||StringUtils.isBlank(SystemConfig.FF_JD_CREEP_URL_MILK)||
                StringUtils.isBlank(SystemConfig.FF_JD_CREEP_URL_FASTFOOD))
        {
            BaseCreepAction.log("连接缺失参数，请查看配置文件...");
            return false;
        }
        BaseCreepAction.log("初始化系统参数结束");
        return true;
    }



    //获取配置文件路径
    private static String getPath(String sourcePath)
    {
        if(!isDeBug())
            return System.getProperty("user.dir")+"\\"+sourcePath;
        else
            return YlfinSpiderMain.class.getClassLoader().getResource(sourcePath).getPath();
    }

    /**
     * debug模式路径从class开始，jar模式从jar包开始
     * @return
     */
    private static boolean isDeBug()
    {
        String key="sun.java.command";
        String val=System.getProperty(key);
        return !val.equals("spider_jar.jar");
    }
    /**
     * 检测文件是否存在
     * @param path
     * @return
     */
    private static boolean checkFile(String path,boolean create)
    {
        try {
            File file = new File(path);
            if(!create)
            {
                if (file.exists())
                    return true;
                else
                    return false;
            }else {
                if(!file.exists())
                {
                    file.mkdirs();
                }
            }
            return true;
        }catch (Exception ex)
        {
            return false;
        }
    }

}
