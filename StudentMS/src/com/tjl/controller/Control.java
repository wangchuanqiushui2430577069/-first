package com.tjl.controller;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.view.View;

public class Control {

	public static void main(String[] args) {
		//���û�չʾ��¼����
		while(true) {
			
			User user = View.indexView();
			UserDao_Imp imp = new UserDao_Imp();
			int type = imp.login(user);  //��¼
			switch(type){
			case -1: 
				System.out.println("������������������");
				break;
			case 1: 
				System.out.println("��¼����Ա�ɹ�");
				managerServer();
				break;
			case 2:
				System.out.println("ѧ����¼�ɹ�");
				studentServer(user);
				break;
			default:
				break;
			}
			
		}
	}

	//ѧ������
	private static void studentServer(User user) {

		while(true) {
			int order = View.studentMenuView();
			switch(order) {
			case 0: //�˳�
				System.out.println("���˳�ѧ������ϵͳ��");
				System.exit(-1);
				break;
			case 1: //��ʾѧ����Ϣ
				View.printUser(user);				
				break;
		 }
		}
		
		
	}

	//����Ա����
	private static void managerServer() {
		UserDao_Imp imp = new UserDao_Imp();
		
		while(true) {
			//չʾ����Ա�˵���ͼ
			int order = View.managerMenuView();
			boolean flag;
			String uname = null;
			User user = null;
			switch(order) {
			case 0: //�˳�
				System.out.println("���˳�ѧ������ϵͳ��");
				System.exit(-1);
				break;
			case 1: //���ѧ����Ϣ
				user = View.addMenuView();
				flag = imp.insert(user);
				if(flag)
					System.out.println("���ѧ����Ϣ�ɹ�!");
				else
					System.out.println("���ѧ����Ϣʧ��!");
				break;
			case 2: //ɾ��ѧ����Ϣ
			    uname = View.deleteMenuView();
				flag = imp.delete(uname);
				if(flag)
					System.out.println("ɾ��ѧ����Ϣ�ɹ�!");
				else
					System.out.println("ɾ��ѧ����Ϣʧ��!");
				break;
			case 3: //�޸�ѧ����Ϣ
				user = View.updataMenuView();
				flag = imp.updata(user);
				if(flag)
					System.out.println("�޸�ѧ����Ϣ�ɹ�!");
				else
					System.out.println("�޸�ѧ����Ϣʧ��!");
				break;
			case 4: //��ѯѧ����Ϣ
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
