package com.hwua.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class C3P0Utils {

        private static DataSource  ds=
            new  ComboPooledDataSource();

    public static DataSource getDs(){

        return ds;
    }


}
