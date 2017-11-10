package com.xinyunlian.spider.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.xinyunlian.spider.ancc.inter.GoodsImageModelMapper;
import com.xinyunlian.spider.ancc.model.GoodsImageModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;


public class test {

    private static final String NAME_SPACE = "com.xinyunlian.spider.ancc.model.ImageModel";

    public static GoodsImageModelMapper mapper;
    public static void main(String[] args)
    {

        SqlSessionFactory sqlSessionFactory;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("database/mybatis-plus.xml"),"userDefine");
            SqlSession session = sqlSessionFactory.openSession();
            System.out.println("class="+session.getConfiguration().getEnvironment().getDataSource().getClass().getName());
            DataSource ds = session.getConfiguration().getEnvironment().getDataSource();
            Object a=null;
            if(ds instanceof DruidDataSource){
                System.out.println("Yes");
                DruidDataSource ds2 = (DruidDataSource)ds;
                a=  ds2.getConnection().prepareStatement("select * from p_image where 1=1");
            }else{
                System.out.println("No");
            }
            mapper = session.getMapper(GoodsImageModelMapper.class);
            GoodsImageModel model = mapper.selectByPrimaryKey(0);
            System.out.println(model.getImageDescription());

            //List<GoodsImageModel> lst = session.selectOne("com.xinyunlian.spider.ancc.inter.GoodsImageModelMapper.selectByPrimaryKey",1);
            //List<GoodsImageModel> lst= session.selectList("select * from p_image where 1=1 ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
