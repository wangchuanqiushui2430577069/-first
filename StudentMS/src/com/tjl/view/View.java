package com.tjl.view;

import java.util.Scanner;
import com.tjl.bean.User;

public class View {
	
	private static Scanner input = new Scanner(System.in);
	
//首页视图
	public static User indexView() {
		
		System.out.println("***************************************************************");
		System.out.println("*********\t\t学生信息管理系统\t\t***************");
		System.out.println("*********\t\t请根据提示操作\t\t***************");
		System.out.println("*********\t\t请输入账号：\t\t***************");
		String uname = input.nextLine();
		System.out.println("*********\t\t请输入密码：\t\t***************");
		String upass = input.nextLine();
		System.out.println("***************************************************************");
	
		return new User(uname,upass);
	}
	
//管理员菜单视图
	public static int managerMenuView() {
		int item = 0;
		System.out.println("***************************************************************");
		System.out.println("*********\t欢迎管理员回来\t***************");
		System.out.println("*********\t请根据提示操作\t***************");
		System.out.println("*********\t0.退出\t***************");
		System.out.println("*********\t1.添加学生信息\t***************");
		System.out.println("*********\t2.删除学生信息\t***************");
		System.out.println("*********\t3.修改学生信息\t***************");
		System.out.println("*********\t4.查询学生信息\t***************");
		//获取用户输入信息
		String type = input.nextLine();
		//转换类型
		if(type.equals("0") || type.equals("1") || type.equals("2") 
				|| type.equals("3") || type.equals("4")) {
			item = Integer.parseInt(type);
		}else {   
			//用户的输入不在0-4之间
			System.out.println("输入错误，请重新输入");
			return managerMenuView();
		}
		System.out.println("***************************************************************");
		
		return item;
	}
	
	/*
	 * 添加学生视图
	 * 
	 */
	public static int studentMenuView() {
		int item = 0;
		System.out.println("***************************************************************");
		System.out.println("*********\t欢迎 学生 回来\t***************");
		System.out.println("*********\t请根据提示操作\t***************");
		System.out.println("*********\t0.退出\t***************");
		System.out.println("*********\t1.查询学生信息\t***************");
		//获取用户输入信息
		String type = input.nextLine();
		//转换类型
		if(type.equals("0") || type.equals("1")) {
			item = Integer.parseInt(type);
		}else {   
			//用户的输入不在0-1之间
			System.out.println("输入错误，请重新输入");
			return studentMenuView();
		}
		System.out.println("***************************************************************");
		
		return item;	
	}
	
	//添加学生信息
	public static User addMenuView() {
		System.out.println("***************************************************************");
		System.out.println("*********\t\t请根据提示操作\t\t***************");
		System.out.println("*********\t\t请输入添加的学生账号：\t\t***************");
		String uname = input.nextLine();
		System.out.println("*********\t\t请输入其密码：\t\t***************");
		String upass = input.nextLine();
		System.out.println("***************************************************************");
	
		return new User(uname,upass);
	}
	
	//删除学生信息
	public static String deleteMenuView() {
		System.out.println("***************************************************************");
		System.out.println("*********\t\t请根据提示操作\t\t***************");
		System.out.println("*********\t\t请输入要删除的学生账号：\t\t***************");
		String uname = input.nextLine();
		System.out.println("***************************************************************");
		return uname;
	}
	
	//修改学生信息
		public static User updataMenuView() {
			System.out.println("***************************************************************");
			System.out.println("*********\t\t请根据提示操作\t\t***************");
			System.out.println("*********\t\t请输入账号：\t\t***************");
			String uname = input.nextLine();
			System.out.println("*********\t\t请输入新的密码：\t\t***************");
			String upass = input.nextLine();
			System.out.println("***************************************************************");
		
			return new User(uname,upass);
		}
	
	//查询学生信息
		public static String selectMenuView() {
			System.out.println("***************************************************************");
			System.out.println("*********\t\t请根据提示操作\t\t***************");
			System.out.println("*********\t\t请输入要查询的学生账号：\t\t***************");
			String uname = input.nextLine();
			System.out.println("***************************************************************");
			return uname;
		}

		//输出学生信息
		public static void printUser(User user) {
			System.out.println("用户名为：" + user.getUname());
			System.out.println("用户名 ID 为：" + user.getId());
			System.out.println("用户名密码为：" + user.getUpass());
			if(user.getType() == 1)			
				System.out.println("用户名权限 ：" + "管理员");
			else
				System.out.println("用户名为：" + "学生");
		}
	
}
