package com.tjl.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.tjl.bean.User;
import com.tjl.dao.UserDao_Imp;
import com.tjl.jdbc.JDBCUtils;

public class JDBCUtilTest {
	@Test
	public void jdbcConnectionTest() throws Exception{
		//”“º¸ run as µ„  JUtil Test ≤‚ ‘
		Connection connection = JDBCUtils.getConnection();
		Statement  statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM firstmysql");
		while(result.next()) {
			System.out.print(result.getInt("id") + "     ");
			System.out.print(result.getString("uname") + "     ");
			System.out.println(result.getString("upass"));
		}
	}
	
	//≤‚ ‘µ«¬º
	@Test
	public void loginTest() throws Exception{
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("¡ı”¿µœ","18201214");
		int type = userDao_Imp.login(user);
		System.out.println("type = " + type);	
	}
	
	//≤‚ ‘ÃÌº””√ªß
	@Test
	public void insertTest() throws Exception{
		UserDao_Imp userDao_Imp = new UserDao_Imp();
		User user = new User("∏∂—ÂÕ®","18201208");
		boolean flag = userDao_Imp.insert(user);
		System.out.println("flag = " + flag);
	}
	
	//≤‚ ‘…æ≥˝”√ªß
		@Test
		public void deleteTest() throws Exception{
			UserDao_Imp userDao_Imp = new UserDao_Imp();
			String uname = "aaa";
			boolean flag = userDao_Imp.delete(uname);
			System.out.println("flag = " + flag);
		}
		
	//≤‚ ‘–ﬁ∏ƒ”√ªß
		@Test
		public void updataTest() throws Exception{
			UserDao_Imp userDao_Imp = new UserDao_Imp();
			User user = new User("π˘ø°","18201210");
			boolean flag = userDao_Imp.updata(user);
			System.out.println("flag = " + flag);
		}
	
	//≤‚ ‘–ﬁ∏ƒ”√ªß
		@Test
		public void selectTest() throws Exception{
			UserDao_Imp userDao_Imp = new UserDao_Imp();
			String uname = "ø°";
			User user = userDao_Imp.select(uname);
			System.out.println("user = " + user);
		}

	
	
	
	
	
	
	
}
