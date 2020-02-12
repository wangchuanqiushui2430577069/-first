package com.tjl.bean;

public class User {
	
	//�û���Ϣ
	private int id;        //�û�ID
	private String uname;  //�û���
	private String upass;  //�û�����
	private int type;      //1.����Ա 2.ѧ��
	
	
	public User(String uname, String upass) {
		this.uname = uname;
		this.upass = upass;
	}
	public User(String uname, String upass, int type) {
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}
	public User(int id, String uname, String upass, int type) {
		this.id = id;
		this.uname = uname;
		this.upass = upass;
		this.type = type;
	}
	
	
	//�޸���
	public void setId(int id) {
		this.id = id;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	//������
	public int getId() {
		return id;
	}
	public String getUname() {
		return uname;
	}
	public String getUpass() {
		return upass;
	}
	public int getType() {
		return type;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", upass=" + upass + ", type=" + type + "]";
	}
	public User() {
		
	}
	
	
	
	
}
