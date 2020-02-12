package com.tjl.controller;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.view.View;

public class Control {

	public static void main(String[] args) {
		//给用户展示登录界面
		while(true) {
			
			User user = View.indexView();
			UserDao_Imp imp = new UserDao_Imp();
			int type = imp.login(user);  //登录
			switch(type){
			case -1: 
				System.out.println("输入有误，请重新输入");
				break;
			case 1: 
				System.out.println("登录管理员成功");
				managerServer();
				break;
			case 2:
				System.out.println("学生登录成功");
				studentServer(user);
				break;
			default:
				break;
			}
			
		}
	}

	//学生操作
	private static void studentServer(User user) {

		while(true) {
			int order = View.studentMenuView();
			switch(order) {
			case 0: //退出
				System.out.println("已退出学生管理系统！");
				System.exit(-1);
				break;
			case 1: //显示学生信息
				View.printUser(user);				
				break;
		 }
		}
		
		
	}

	//管理员操作
	private static void managerServer() {
		UserDao_Imp imp = new UserDao_Imp();
		
		while(true) {
			//展示管理员菜单视图
			int order = View.managerMenuView();
			boolean flag;
			String uname = null;
			User user = null;
			switch(order) {
			case 0: //退出
				System.out.println("已退出学生管理系统！");
				System.exit(-1);
				break;
			case 1: //添加学生信息
				user = View.addMenuView();
				flag = imp.insert(user);
				if(flag)
					System.out.println("添加学生信息成功!");
				else
					System.out.println("添加学生信息失败!");
				break;
			case 2: //删除学生信息
			    uname = View.deleteMenuView();
				flag = imp.delete(uname);
				if(flag)
					System.out.println("删除学生信息成功!");
				else
					System.out.println("删除学生信息失败!");
				break;
			case 3: //修改学生信息
				user = View.updataMenuView();
				flag = imp.updata(user);
				if(flag)
					System.out.println("修改学生信息成功!");
				else
					System.out.println("修改学生信息失败!");
				break;
			case 4: //查询学生信息
				uname = View.selectMenuView();
				user = imp.select(uname);
				View.printUser(user);
				System.out.println("");
				break;
			default:
				break;
			}
		}
		
	}

}
