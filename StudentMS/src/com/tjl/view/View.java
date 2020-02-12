package com.tjl.view;

import java.util.Scanner;
import com.tjl.bean.User;

public class View {
	
	private static Scanner input = new Scanner(System.in);
	
//��ҳ��ͼ
	public static User indexView() {
		
		System.out.println("***************************************************************");
		System.out.println("*********\t\tѧ����Ϣ����ϵͳ\t\t***************");
		System.out.println("*********\t\t�������ʾ����\t\t***************");
		System.out.println("*********\t\t�������˺ţ�\t\t***************");
		String uname = input.nextLine();
		System.out.println("*********\t\t���������룺\t\t***************");
		String upass = input.nextLine();
		System.out.println("***************************************************************");
	
		return new User(uname,upass);
	}
	
//����Ա�˵���ͼ
	public static int managerMenuView() {
		int item = 0;
		System.out.println("***************************************************************");
		System.out.println("*********\t��ӭ����Ա����\t***************");
		System.out.println("*********\t�������ʾ����\t***************");
		System.out.println("*********\t0.�˳�\t***************");
		System.out.println("*********\t1.���ѧ����Ϣ\t***************");
		System.out.println("*********\t2.ɾ��ѧ����Ϣ\t***************");
		System.out.println("*********\t3.�޸�ѧ����Ϣ\t***************");
		System.out.println("*********\t4.��ѯѧ����Ϣ\t***************");
		//��ȡ�û�������Ϣ
		String type = input.nextLine();
		//ת������
		if(type.equals("0") || type.equals("1") || type.equals("2") 
				|| type.equals("3") || type.equals("4")) {
			item = Integer.parseInt(type);
		}else {   
			//�û������벻��0-4֮��
			System.out.println("�����������������");
			return managerMenuView();
		}
		System.out.println("***************************************************************");
		
		return item;
	}
	
	/*
	 * ���ѧ����ͼ
	 * 
	 */
	public static int studentMenuView() {
		int item = 0;
		System.out.println("***************************************************************");
		System.out.println("*********\t��ӭ ѧ�� ����\t***************");
		System.out.println("*********\t�������ʾ����\t***************");
		System.out.println("*********\t0.�˳�\t***************");
		System.out.println("*********\t1.��ѯѧ����Ϣ\t***************");
		//��ȡ�û�������Ϣ
		String type = input.nextLine();
		//ת������
		if(type.equals("0") || type.equals("1")) {
			item = Integer.parseInt(type);
		}else {   
			//�û������벻��0-1֮��
			System.out.println("�����������������");
			return studentMenuView();
		}
		System.out.println("***************************************************************");
		
		return item;	
	}
	
	//���ѧ����Ϣ
	public static User addMenuView() {
		System.out.println("***************************************************************");
		System.out.println("*********\t\t�������ʾ����\t\t***************");
		System.out.println("*********\t\t��������ӵ�ѧ���˺ţ�\t\t***************");
		String uname = input.nextLine();
		System.out.println("*********\t\t�����������룺\t\t***************");
		String upass = input.nextLine();
		System.out.println("***************************************************************");
	
		return new User(uname,upass);
	}
	
	//ɾ��ѧ����Ϣ
	public static String deleteMenuView() {
		System.out.println("***************************************************************");
		System.out.println("*********\t\t�������ʾ����\t\t***************");
		System.out.println("*********\t\t������Ҫɾ����ѧ���˺ţ�\t\t***************");
		String uname = input.nextLine();
		System.out.println("***************************************************************");
		return uname;
	}
	
	//�޸�ѧ����Ϣ
		public static User updataMenuView() {
			System.out.println("***************************************************************");
			System.out.println("*********\t\t�������ʾ����\t\t***************");
			System.out.println("*********\t\t�������˺ţ�\t\t***************");
			String uname = input.nextLine();
			System.out.println("*********\t\t�������µ����룺\t\t***************");
			String upass = input.nextLine();
			System.out.println("***************************************************************");
		
			return new User(uname,upass);
		}
	
	//��ѯѧ����Ϣ
		public static String selectMenuView() {
			System.out.println("***************************************************************");
			System.out.println("*********\t\t�������ʾ����\t\t***************");
			System.out.println("*********\t\t������Ҫ��ѯ��ѧ���˺ţ�\t\t***************");
			String uname = input.nextLine();
			System.out.println("***************************************************************");
			return uname;
		}

		//���ѧ����Ϣ
		public static void printUser(User user) {
			System.out.println("�û���Ϊ��" + user.getUname());
			System.out.println("�û��� ID Ϊ��" + user.getId());
			System.out.println("�û�������Ϊ��" + user.getUpass());
			if(user.getType() == 1)			
				System.out.println("�û���Ȩ�� ��" + "����Ա");
			else
				System.out.println("�û���Ϊ��" + "ѧ��");
		}
	
}
