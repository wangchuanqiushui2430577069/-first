package cn.itcast.eshop.common.util;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCUtil {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态语句块,调用类时自动执行
    static {
        //tils.class 获取对象
        //getClassLoader() 类加载器
        //getSystemResourceAsStream("db.properties") 加载资源文件放到输入流中

        InputStream is = JDBCUtil.class.getClassLoader().getSystemResourceAsStream("jdbc.properties");

        //创建Properties对象
        Properties p = new Properties();

        //加载流文件
        try {
            p.load(is);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            //加载MYSQL驱动
            Class.forName(driver);
            System.out.println("加载成功！");
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    //获取连接对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
            //System.out.println("数据库连接成功!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放资源的方法
    public static void close(Connection conn, Statement statement, ResultSet result) {

        try {
            if(result != null) {
                result.close();
                result = null;
            }
            if(statement != null) {
                statement.close();
                statement = null;
            }
            if(conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

}