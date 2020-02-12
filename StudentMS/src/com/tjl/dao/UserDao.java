package com.tjl.dao;

import com.tjl.bean.User;

public interface UserDao {
	
	//验证登录的方法
	// -1登录失败  1 管理员登陆  2学生登陆 
	int login(User user);
	
	//添加学生信息，成功返回true,否则返回false
	boolean insert(User user);
	
	//删除学生信息，成功返回true,否则返回false
	boolean delete(String uname);
	
	//修改学生信息，成功返回true,否则返回false
	boolean updata(User user);
	
	//查询学生信息，返回该学生对象
	User select(String uname);
	
	
}
