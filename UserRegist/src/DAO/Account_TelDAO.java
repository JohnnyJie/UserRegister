package DAO;

import java.sql.*;
import java.util.ArrayList;

import Object.Account;
import Object.Tel_Account;



public class Account_TelDAO {


public ArrayList<Tel_Account> getAccount_TelList() {
	ArrayList<Tel_Account> list = new ArrayList<Tel_Account>();
	list.clear();
	
	String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	String DBURL = "jdbc:odbc:" + "software";
	Connection conn = null;
	Statement stmt = null;
	String sql = null;

	ResultSet r = null;

	try {
		Class.forName(DBDRIVER);
	} catch (Exception e) {
		System.out.println("数据库驱动程序加载失败！！！");
		return list;
	}

	try {
		conn = DriverManager.getConnection(DBURL);
	} catch (Exception e) {
		System.out.println("数据库连接失败！！");

		return list;
	}

	try {
		stmt = conn.createStatement();
		sql = "SELECT * FROM Account_Tel";
		r = stmt.executeQuery(sql);
		while (r.next()) {
			list.add(new Tel_Account(r.getString("phone"),r.getString("username")));
		}

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("操作数据库失败！");
		return list;
	}

	try {
		stmt.close();
		conn.close();
	} catch (Exception e) {
		System.out.println("username");
		return list;
	}
	return list;
}


public String getTelByAccount(String nm) {
		String tel=null;
		// 定义数据库驱动程序
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// 定义数据库连接地址
		String DBURL = "jdbc:odbc:" + "software";
		// 定义数据库连接对象，属于java.sql包中的接口
		Connection conn = null;
		// 定义Statement对象，用于操作数据库
		Statement stmt = null;
		// 定义一字符串变量，用于保存SQL语句
		String sql = null;

		ResultSet r = null;

		// 1、加载驱动程序
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("数据库驱动程序加载失败！！！");
			return null;
		}

		// 2、连接数据库
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("数据库连接失败！！！");

			return null;
		}

		// 3、操作数据库
		// 通过Connection对象实例化Statement对象
		try {
			stmt = conn.createStatement();
			// 为sql变量赋值
			// 插入语句
			sql = "SELECT * FROM Account_Tel WHERE username = \'"
					+ nm+"\'";
			r = stmt.executeQuery(sql);
			while (r.next()) {
				tel= r.getString("phone");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作数据库失败！！！");
			return null;
		}

		// 4、关闭数据库
		try {
			// 关闭操作
			stmt.close();
			// 关闭连接
			conn.close();
		} catch (Exception e) {
			System.out.println("数据库关闭失败！！！");
			return null;
		}
		return tel;
	}


public String getAccountByTel(String tel) {
		
		String username=null;
		// 定义数据库驱动程序
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// 定义数据库连接地址
		String DBURL = "jdbc:odbc:" + "software";
		// 定义数据库连接对象，属于java.sql包中的接口
		Connection conn = null;
		// 定义Statement对象，用于操作数据库
		Statement stmt = null;
		// 定义一字符串变量，用于保存SQL语句
		String sql = null;

		ResultSet r = null;

		// 1、加载驱动程序
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("数据库驱动程序加载失败！！！");
			return null;
		}

		// 2、连接数据库
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("数据库连接失败！！！");

			return null;
		}

		// 3、操作数据库
		// 通过Connection对象实例化Statement对象
		try {
			stmt = conn.createStatement();
			// 为sql变量赋值
			// 插入语句
			sql = "SELECT * FROM Account_Tel WHERE phone = /'"
					+ tel+"/'";
			r = stmt.executeQuery(sql);
			while (r.next()) {
				username= r.getString("username");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("操作数据库失败！！！");
			return null;
		}

		// 4、关闭数据库
		try {
			// 关闭操作
			stmt.close();
			// 关闭连接
			conn.close();
		} catch (Exception e) {
			System.out.println("数据库关闭失败！！！");
			return null;
		}
		return username;
	}

public void createTelAccount(Tel_Account a) {
	// 定义数据库驱动程序
	String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
	// 定义数据库连接地址
	String DBURL = "jdbc:odbc:" + "software";
	// 定义数据库连接对象，属于java.sql包中的接口
	Connection conn = null;
	// 定义Statement对象，用于操作数据库
	Statement stmt = null;
	// 定义一字符串变量，用于保存SQL语句
	String sql_insert = null;

	ResultSet r = null;

	// 1、加载驱动程序
	try {
		Class.forName(DBDRIVER);
	} catch (Exception e) {
		System.out.println("数据库驱动程序加载失败！！！");
		return;
	}

	// 2、连接数据库
	try {
		conn = DriverManager.getConnection(DBURL);
	} catch (Exception e) {
		System.out.println("数据库连接失败！！！");

		return;
	}

	// 3、操作数据库
	// 通过Connection对象实例化Statement对象
	try {
		stmt = conn.createStatement();
		// 为sql变量赋值
		// 插入语句

		sql_insert = "INSERT into Account_Tel(username,phone) values(?,?);";
		PreparedStatement ppst = conn.prepareStatement(sql_insert);
		ppst.setString(1, a.getUsername());
		ppst.setString(2, a.getTel());
		
		ppst.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("操作数据库失败！！！");
		return;
	}

	// 4、关闭数据库
	try {
		// 关闭操作
		stmt.close();
		// 关闭连接
		conn.close();
	} catch (Exception e) {
		System.out.println("数据库关闭失败！！！");
		return;
	}
	return;
}

}
