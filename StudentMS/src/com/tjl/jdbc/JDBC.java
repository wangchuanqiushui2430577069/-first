package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
		
		//����MySQL����
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("�������سɹ�!");
		//�������ݿ�,������Ӷ���
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/data","root","123456");
			System.out.println("���ݿ����ӳɹ�");
			//����ִ�л���
			Statement statement = connection.createStatement();
			//ִ��SQL��䣬�õ������
			ResultSet result = statement.executeQuery("SELECT * FROM firstmysql");//SQL�Ĳ�ѯ���
			while(result.next()) {
				System.out.print(result.getInt("id") + "     ");
				System.out.print(result.getString("uname") + "     ");
				System.out.println(result.getString("upass"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��������ʧ��!");
			System.out.println("���ݿ�����ʧ��");
		}
		
	}

}
