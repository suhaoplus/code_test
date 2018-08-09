package cn.xdl.util;

import java.sql.*;
import java.util.ResourceBundle;

public class DBCPUtil {
    private static final String url;
    private static final String user;
    private static final String pwd;
    static {
        ResourceBundle rb = ResourceBundle.getBundle("dbcp");
        url = rb.getString("url");
        user = rb.getString("user");
        pwd = rb.getString("password");
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(Connection conn, Statement stmt,ResultSet rs){
        try {
            if (conn != null){
                conn.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
