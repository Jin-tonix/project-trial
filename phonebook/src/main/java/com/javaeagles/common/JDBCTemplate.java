package com.javaeagles.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {
    public static Connection getConnection() {
        Connection con = null;
        Properties prop = new Properties();

        try{
            prop.load(new FileReader("src/main/java/com/javaeagles/config/connection-info.properties"));

            String driver = prop.getProperty("Driver");
            String url = prop.getProperty("Url");

            Class.forName(driver);
            con = DriverManager.getConnection(url,prop);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return con;
    }
    public static void close(Connection con) {
        try {
            if (con != null && !con.isClosed());
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void close (PreparedStatement ps) {
        try{
            if (ps != null && !ps.isClosed()); {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close (ResultSet rs) {
        try{
            if(rs != null && !rs.isClosed());{

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
