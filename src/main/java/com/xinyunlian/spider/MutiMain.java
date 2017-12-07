package com.xinyunlian.spider;

import com.xinyunlian.spider.ancc.accnAction;
import com.xinyunlian.spider.base.BaseCreepAction;
import com.xinyunlian.spider.mutiply.MutiplyAction;
import com.xinyunlian.spider.sys.SystemConfig;
import com.xinyunlian.spider.utils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;

public class MutiMain
{
    public  static void main(String[] args)
    {
        initLog4j();
        if(!initProperties())
        {
            BaseCreepAction.log("程序结束....");
        }
        else {
            MutiplyAction action = new MutiplyAction(SystemConfig.FF_BAIDU_BARCODE_URL,"mutiply");
            action.readExcelFile();
            action.creepData();
            action.creepData();
            action.exportExcel();
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
        Properties userPoperties =  PropertyUtils.InitProperties(getOutJarPath("user.properties"));
        SystemConfig.FF_EXE_PATH = userPoperties.getProperty("ff_exe_path");
        SystemConfig.FF_DRIVER_PATH = userPoperties.getProperty("ff_driver_path");
        SystemConfig.FF_DOWNLOAD_PATH=System.getProperty("user.dir")+"\\file\\download\\";
        SystemConfig.FF_BARCODE_INPUT_PATH = System.getProperty("user.dir")+"\\file\\input\\";
        SystemConfig.FF_BARCODE_OUTPUT_PATH = System.getProperty("user.dir")+"\\file\\output\\";
        checkFile(SystemConfig.FF_BARCODE_INPUT_PATH ,true);
        checkFile(SystemConfig.FF_BARCODE_OUTPUT_PATH ,true);
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

        Properties sysPoperties =  PropertyUtils.InitProperties(getOutJarPath("barcode.properties"));
        //连接参数
        SystemConfig.FF_BARCODE_URL =  sysPoperties.getProperty("ff_barcode_url");
        SystemConfig.FF_BARCODE_FILENAME =sysPoperties.getProperty("filename");
        SystemConfig.FF_BAIDU_BARCODE_URL = sysPoperties.getProperty("ff_baidu_barcode_url");

        if(StringUtils.isBlank(SystemConfig.FF_BARCODE_URL))
        {
            BaseCreepAction.log("连接缺失参数，请查看配置文件...");
            return false;
        }
        BaseCreepAction.log("初始化系统参数结束");
        return true;
    }



    //获取配置文件路径
    private static String getOutJarPath(String sourcePath)
    {
        if(!isDeBug())
            return System.getProperty("user.dir")+"\\"+sourcePath;
        else
            return YlfinSpiderMain.class.getClassLoader().getResource("").getPath()+sourcePath;
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
