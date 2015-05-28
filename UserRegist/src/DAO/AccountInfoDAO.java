package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Object.Account;



public class AccountInfoDAO {

public Account getAccountByName(String name) {
		
		String key=null;
		Account a;
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
			sql = "SELECT * FROM AccountInfoTable WHERE username = \'"
					+ name+"\'";
			r = stmt.executeQuery(sql);
			while (r.next()) {
				key= r.getString("key");
				
			}System.out.println("Ai:"+key);
			if(key==null){
				a=null;
			}else{
				a=new Account(name,key);
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
		return a;
	}

	public void createAccount(Account a) {
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

			sql_insert = "INSERT into AccountInfoTable(username,key) values(?,?);";
			PreparedStatement ppst = conn.prepareStatement(sql_insert);
			ppst.setString(1, a.getUsername());
			ppst.setString(2, a.getKey());
			
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

	public void deleteAccountByName(String nm) {
		// 定义数据库驱动程序
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// 定义数据库连接地址
		String DBURL = "jdbc:odbc:" + "software";
		// 定义数据库连接对象，属于java.sql包中的接口
		Connection conn = null;
		// 定义Statement对象，用于操作数据库
		Statement stmt = null;
		// 定义一字符串变量，用于保存SQL语句
		String sql_del = null;

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
			sql_del = "DELETE * FROM AccountInfoTable WHERE username = "
					+ String.valueOf(nm);
			stmt.execute(sql_del);

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

