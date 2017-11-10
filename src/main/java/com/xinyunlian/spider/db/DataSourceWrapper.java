package com.xinyunlian.spider.db;

import lombok.Getter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

public class DataSourceWrapper {

    private static Logger logger = Logger.getLogger(DataSourceWrapper.class);

    @Getter
    private SqlSessionFactory sqlSessionFactory;

    @Getter
    private SqlSession session;

    public DataSourceWrapper() {
        try {
            initDataBase();
        }catch (Exception ex)
        {
            logger.error("初始化DataSourceWrapper异常："+ex.getMessage());
        }
    }
    /**
     * 初始化数据库
     */
    public void initDataBase() throws Exception {
        try {
            logger.info("初始化数据库...");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("database/mybatis-plus.xml"), "userDefine");
            session = sqlSessionFactory.openSession(true);
            DataSource ds = session.getConfiguration().getEnvironment().getDataSource();
        }catch (IOException ex)
        {
            logger.error("初始化数据库IO异常",ex);
            throw ex;
        }
        catch (Exception ex)
        {
            logger.error("初始化数据库异常",ex);
            throw ex;
        }
    }

    public SqlSession beginTransfrom(Object...mappers)
    {
        SqlSession session = sqlSessionFactory.openSession(false);
        for (Object c:mappers) {
           c= session.getMapper(c.getClass());
        }
        return session;
    }

    /**
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public<T> T getMapperInstance(Class<T> clazz)
    {
        try {
            logger.info("获取数据Mapper:"+clazz.getSimpleName());
            return session.getMapper(clazz);
        }catch (Exception ex)
        {
            logger.error("获取数据Mapper异常",ex);
            throw ex;
        }
    }


}
