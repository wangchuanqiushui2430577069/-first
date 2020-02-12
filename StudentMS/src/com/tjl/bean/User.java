package com.tjl.bean;

public class User {
	
	//用户信息
	private int id;        //用户ID
	private String uname;  //用户名
	private String upass;  //用户密码
	private int type;      //1.管理员 2.学生
	
	
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
	
	
	//修改器
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
	
	//访问器
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
