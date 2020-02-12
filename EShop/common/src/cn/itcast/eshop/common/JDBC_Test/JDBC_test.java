package cn.itcast.eshop.common.JDBC_Test;


import cn.itcast.eshop.common.util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class JDBC_test {

    /** 配置的 jdbc.propertices 文件放在 对应模块的 Src 下面     */

    private static final String JDBC_UTIL_SELECT = "SELECT * FROM scorelist";

    public static void main(String[] args) {
        Connection connection = JDBCUtil.getConnection();
        Statement statement = null;
        ResultSet result;
        try {
            //创建预编译环境
            statement = connection.createStatement();
            //执行语句
            result = statement.executeQuery(JDBC_UTIL_SELECT);
            while(result.next())
                System.out.println("number: " + result.getInt("number") + " name:  " +
                result.getString("name") + "      pass: " + result.getString("pass") +
                " id: " + result.getInt("id") + "    math: " + result.getInt("math") +
                " computer: " + result.getInt("computer") + " sport: " + result.getInt("sport"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, null); //多态
        }
    }
}