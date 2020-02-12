package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

//MVC�е�Model
public class UserDao_Imp implements UserDao {
	
	private static final String SQL_USER_LOGIN = "SELECT type FROM user WHERE uname=? AND upass=?";
	private static final String SQL_USER_INSERT = "INSERT INTO user VALUES(id,?,?,2)";
	private static final String SQL_USER_DELETE = "DELETE FROM user WHERE uname=?";
	private static final String SQL_USER_UPDATA = "UPDATE user SET upass =? WHERE uname =?";
	private static final String SQL_USER_SELECT = "SELECT * FROM user WHERE uname =?";

	
	//��¼
	@Override
	public int login(User user) {
     //�������ݿ⣬�������Ӷ���connection
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			//����Ԥ���뻷�� 
			preparedStatement = connection.prepareStatement(SQL_USER_LOGIN);
			//����SQL����еĲ���
			preparedStatement.setString(1, user.getUname()); //����һ���ʺ���ָ����
			preparedStatement.setString(2, user.getUpass());
			//ִ�����
		    result = preparedStatement.executeQuery();
			if(result.next())
				return result.getInt("type");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//�ͷ���Դ
			JDBCUtils.close(connection, preparedStatement, result); //��̬
		}
		return -1;
	}

	//���
	@Override
	public boolean insert(User user) {
		//�������ݿ⣬�������Ӷ���connection
			Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = null;
			int flag;
			try {
				//����Ԥ���뻷�� 
				preparedStatement = connection.prepareStatement(SQL_USER_INSERT);
				//����SQL����еĲ���
				preparedStatement.setString(1, user.getUname()); //����һ���ʺ���ָ����
				preparedStatement.setString(2, user.getUpass());
				//ִ�����
				flag = preparedStatement.executeUpdate();
				if(flag > 0)
					return true;				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.close(connection, preparedStatement, null); //��̬
			}
		return false;
	}

	//ɾ��
	@Override
	public boolean delete(String uname) {
		//�������ݿ⣬�������Ӷ���connection
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int flag;
		try {
			//����Ԥ���뻷�� 
			preparedStatement = connection.prepareStatement(SQL_USER_DELETE);
			//����SQL����еĲ���
			preparedStatement.setString(1, uname); //����һ���ʺ���ָ����
			//ִ�����
			flag = preparedStatement.executeUpdate();
			if(flag > 0)
				return true;				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection, preparedStatement, null); //��̬
		}
		
		return false;
	}

	//�޸�
	@Override
	public boolean updata(User user) {
		//�������ݿ⣬�������Ӷ���connection
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int flag;
		try {
			//����Ԥ���뻷�� 
			preparedStatement = connection.prepareStatement(SQL_USER_UPDATA);
			//����SQL����еĲ���
			preparedStatement.setString(1, user.getUpass()); //����һ���ʺ���ָ����
			preparedStatement.setString(2, user.getUname());
			//ִ�����
			flag = preparedStatement.executeUpdate();
			if(flag > 0)
				return true;				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection, preparedStatement, null); //��̬
		}
	return false;
	}

	//��ѯ
	@Override
	public User select(String uname) {
		//�������ݿ⣬�������Ӷ���connection
				Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet result;
				try {
					//����Ԥ���뻷�� 
					preparedStatement = connection.prepareStatement(SQL_USER_SELECT);
					//����SQL����еĲ���
					preparedStatement.setString(1, uname); //����һ���ʺ���ָ����
					//ִ�����
					result = preparedStatement.executeQuery();
					if(result.next())
						return new User(result.getInt("id"),result.getString("uname"),
								result.getString("upass"),result.getInt("type"));				
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtils.close(connection, preparedStatement, null); //��̬
				}
				
		return null;
	}

}
