package com.tjl.test;

import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.view.View;

public class ViewTest {
	
	//测试单元,测试登录视图
	@Test
	public void indexViewTest() throws Exception{
		User user = View.indexView();
		System.out.println(user);
	}
	
	//测试单元,测试登录视图
	@Test
	public void managerMenuViewTest() throws Exception{
		int item = View.managerMenuView();
		System.out.println("item = " + item);
	}
	
	//测试单元,添加学生信息视图
	@Test
	public void addMenuViewTest() throws Exception{
		User user = View.addMenuView();
		System.out.println(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
