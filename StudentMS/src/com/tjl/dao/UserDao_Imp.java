package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;

//MVC中的Model
public class UserDao_Imp implements UserDao {
	
	private static final String SQL_USER_LOGIN = "SELECT type FROM user WHERE uname=? AND upass=?";
	private static final String SQL_USER_INSERT = "INSERT INTO user VALUES(id,?,?,2)";
	private static final String SQL_USER_DELETE = "DELETE FROM user WHERE uname=?";
	private static final String SQL_USER_UPDATA = "UPDATE user SET upass =? WHERE uname =?";
	private static final String SQL_USER_SELECT = "SELECT * FROM user WHERE uname =?";

	
	//登录
	@Override
	public int login(User user) {
     //连接数据库，创建连接对象connection
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			//创建预编译环境 
			preparedStatement = connection.prepareStatement(SQL_USER_LOGIN);
			//设置SQL语句中的参数
			preparedStatement.setString(1, user.getUname()); //传递一个问号所指参数
			preparedStatement.setString(2, user.getUpass());
			//执行语句
		    result = preparedStatement.executeQuery();
			if(result.next())
				return result.getInt("type");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//释放资源
			JDBCUtils.close(connection, preparedStatement, result); //多态
		}
		return -1;
	}

	//添加
	@Override
	public boolean insert(User user) {
		//连接数据库，创建连接对象connection
			Connection connection = JDBCUtils.getConnection();
			PreparedStatement preparedStatement = null;
			int flag;
			try {
				//创建预编译环境 
				preparedStatement = connection.prepareStatement(SQL_USER_INSERT);
				//设置SQL语句中的参数
				preparedStatement.setString(1, user.getUname()); //传递一个问号所指参数
				preparedStatement.setString(2, user.getUpass());
				//执行语句
				flag = preparedStatement.executeUpdate();
				if(flag > 0)
					return true;				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtils.close(connection, preparedStatement, null); //多态
			}
		return false;
	}

	//删除
	@Override
	public boolean delete(String uname) {
		//连接数据库，创建连接对象connection
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int flag;
		try {
			//创建预编译环境 
			preparedStatement = connection.prepareStatement(SQL_USER_DELETE);
			//设置SQL语句中的参数
			preparedStatement.setString(1, uname); //传递一个问号所指参数
			//执行语句
			flag = preparedStatement.executeUpdate();
			if(flag > 0)
				return true;				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection, preparedStatement, null); //多态
		}
		
		return false;
	}

	//修改
	@Override
	public boolean updata(User user) {
		//连接数据库，创建连接对象connection
		Connection connection = JDBCUtils.getConnection();
		PreparedStatement preparedStatement = null;
		int flag;
		try {
			//创建预编译环境 
			preparedStatement = connection.prepareStatement(SQL_USER_UPDATA);
			//设置SQL语句中的参数
			preparedStatement.setString(1, user.getUpass()); //传递一个问号所指参数
			preparedStatement.setString(2, user.getUname());
			//执行语句
			flag = preparedStatement.executeUpdate();
			if(flag > 0)
				return true;				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(connection, preparedStatement, null); //多态
		}
	return false;
	}

	//查询
	@Override
	public User select(String uname) {
		//连接数据库，创建连接对象connection
				Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet result;
				try {
					//创建预编译环境 
					preparedStatement = connection.prepareStatement(SQL_USER_SELECT);
					//设置SQL语句中的参数
					preparedStatement.setString(1, uname); //传递一个问号所指参数
					//执行语句
					result = preparedStatement.executeQuery();
					if(result.next())
						return new User(result.getInt("id"),result.getString("uname"),
								result.getString("upass"),result.getInt("type"));				
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					JDBCUtils.close(connection, preparedStatement, null); //多态
				}
				
		return null;
	}

}
