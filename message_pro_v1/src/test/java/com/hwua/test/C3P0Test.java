package com.hwua.test;

import com.hwua.util.C3P0Util;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Test {
    @Test
    public void testConnection() throws Exception{
        DataSource ds = C3P0Util.getDs();
        Connection connection = ds.getConnection();
    }
}
