package com.zkp.recshop.utils;
/**
 * 数据池连接操作
 * 提供数据库连接以及Apache需要的DataSource对象
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    private static DruidDataSource druidDataSource;

    static {
        try {
            InputStream is = DruidUtils.class.getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return druidDataSource;
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = druidDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
