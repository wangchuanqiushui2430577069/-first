package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
		
		//加载MySQL驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("驱动加载成功!");
		//连接数据库,获得连接对象
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/data","root","123456");
			System.out.println("数据库连接成功");
			//创建执行环境
			Statement statement = connection.createStatement();
			//执行SQL语句，得到结果集
			ResultSet result = statement.executeQuery("SELECT * FROM firstmysql");//SQL的查询语句
			while(result.next()) {
				System.out.print(result.getInt("id") + "     ");
				System.out.print(result.getString("uname") + "     ");
				System.out.println(result.getString("upass"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动加载失败!");
			System.out.println("数据库连接失败");
		}
		
	}

}
