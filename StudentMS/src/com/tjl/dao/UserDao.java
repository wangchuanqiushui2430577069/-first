package com.tjl.dao;

import com.tjl.bean.User;

public interface UserDao {
	
	//��֤��¼�ķ���
	// -1��¼ʧ��  1 ����Ա��½  2ѧ����½ 
	int login(User user);
	
	//���ѧ����Ϣ���ɹ�����true,���򷵻�false
	boolean insert(User user);
	
	//ɾ��ѧ����Ϣ���ɹ�����true,���򷵻�false
	boolean delete(String uname);
	
	//�޸�ѧ����Ϣ���ɹ�����true,���򷵻�false
	boolean updata(User user);
	
	//��ѯѧ����Ϣ�����ظ�ѧ������
	User select(String uname);
	
	
}
