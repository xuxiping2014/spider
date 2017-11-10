package com.xinyunlian.spider.utils;

import java.io.*;
import java.util.Properties;

/**
 * ${DESCRIPTION}
 *
 * @author xxp
 * @create 2017-10-31 15:43
 **/

public class PropertyUtils {

    public static Properties InitProperties(String path)
    {
        Properties properties = new Properties();
        InputStream input = null;
        try {
            input = new BufferedInputStream(new FileInputStream(path));//加载Java项目根路径下的配置文件
            properties.load(input);// 加载属性文件
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
