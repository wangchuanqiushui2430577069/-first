package com.tjl.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {  //��װ�ɹ���
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	//��̬����,������ʱ�Զ�ִ��
	static {
		//JDBCUtils.class ��ȡ����
		//getClassLoader() �������
		//getSystemResourceAsStream("db.properties") ������Դ�ļ��ŵ���������
		
		InputStream is = JDBCUtils.class.getClassLoader().getSystemResourceAsStream("db.properties");
		
		//����Properties����
		Properties p = new Properties();
		
		//�������ļ�
		try {
			p.load(is);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
		//����MYSQL����
			Class.forName(driver);
			System.out.println("���سɹ���");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
	
	//��ȡ���Ӷ���
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
			//System.out.println("���ݿ����ӳɹ�!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//�ͷ���Դ�ķ���
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
