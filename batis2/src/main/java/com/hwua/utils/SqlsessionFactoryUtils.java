package com.hwua.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlsessionFactoryUtils {

    private  static SqlSessionFactory sessionFactory=null;


    public static SqlSessionFactory getInstance() throws Exception{
        if(sessionFactory == null){
            synchronized (SqlsessionFactoryUtils.class){
                if(sessionFactory == null){
                     sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
                }
            }

        }
        return  sessionFactory;
    }
}
