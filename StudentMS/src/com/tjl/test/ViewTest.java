package com.tjl.test;

import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.view.View;

public class ViewTest {
	
	//���Ե�Ԫ,���Ե�¼��ͼ
	@Test
	public void indexViewTest() throws Exception{
		User user = View.indexView();
		System.out.println(user);
	}
	
	//���Ե�Ԫ,���Ե�¼��ͼ
	@Test
	public void managerMenuViewTest() throws Exception{
		int item = View.managerMenuView();
		System.out.println("item = " + item);
	}
	
	//���Ե�Ԫ,���ѧ����Ϣ��ͼ
	@Test
	public void addMenuViewTest() throws Exception{
		User user = View.addMenuView();
		System.out.println(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
