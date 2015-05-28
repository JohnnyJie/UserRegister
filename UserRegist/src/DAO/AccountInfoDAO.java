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
		// �������ݿ���������
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// �������ݿ����ӵ�ַ
		String DBURL = "jdbc:odbc:" + "software";
		// �������ݿ����Ӷ�������java.sql���еĽӿ�
		Connection conn = null;
		// ����Statement�������ڲ������ݿ�
		Statement stmt = null;
		// ����һ�ַ������������ڱ���SQL���
		String sql = null;

		ResultSet r = null;

		// 1��������������
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("���ݿ������������ʧ�ܣ�����");
			return null;
		}

		// 2���������ݿ�
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ�ܣ�����");

			return null;
		}

		// 3���������ݿ�
		// ͨ��Connection����ʵ����Statement����
		try {
			stmt = conn.createStatement();
			// Ϊsql������ֵ
			// �������
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
			System.out.println("�������ݿ�ʧ�ܣ�����");
			return null;
		}

		// 4���ر����ݿ�
		try {
			// �رղ���
			stmt.close();
			// �ر�����
			conn.close();
		} catch (Exception e) {
			System.out.println("���ݿ�ر�ʧ�ܣ�����");
			return null;
		}
		return a;
	}

	public void createAccount(Account a) {
		// �������ݿ���������
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// �������ݿ����ӵ�ַ
		String DBURL = "jdbc:odbc:" + "software";
		// �������ݿ����Ӷ�������java.sql���еĽӿ�
		Connection conn = null;
		// ����Statement�������ڲ������ݿ�
		Statement stmt = null;
		// ����һ�ַ������������ڱ���SQL���
		String sql_insert = null;

		ResultSet r = null;

		// 1��������������
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("���ݿ������������ʧ�ܣ�����");
			return;
		}

		// 2���������ݿ�
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ�ܣ�����");

			return;
		}

		// 3���������ݿ�
		// ͨ��Connection����ʵ����Statement����
		try {
			stmt = conn.createStatement();
			// Ϊsql������ֵ
			// �������

			sql_insert = "INSERT into AccountInfoTable(username,key) values(?,?);";
			PreparedStatement ppst = conn.prepareStatement(sql_insert);
			ppst.setString(1, a.getUsername());
			ppst.setString(2, a.getKey());
			
			ppst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�����");
			return;
		}

		// 4���ر����ݿ�
		try {
			// �رղ���
			stmt.close();
			// �ر�����
			conn.close();
		} catch (Exception e) {
			System.out.println("���ݿ�ر�ʧ�ܣ�����");
			return;
		}
		return;
	}

	public void deleteAccountByName(String nm) {
		// �������ݿ���������
		String DBDRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
		// �������ݿ����ӵ�ַ
		String DBURL = "jdbc:odbc:" + "software";
		// �������ݿ����Ӷ�������java.sql���еĽӿ�
		Connection conn = null;
		// ����Statement�������ڲ������ݿ�
		Statement stmt = null;
		// ����һ�ַ������������ڱ���SQL���
		String sql_del = null;

		ResultSet r = null;

		// 1��������������
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			System.out.println("���ݿ������������ʧ�ܣ�����");
			return;
		}

		// 2���������ݿ�
		try {
			conn = DriverManager.getConnection(DBURL);
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ�ܣ�����");

			return;
		}

		// 3���������ݿ�
		// ͨ��Connection����ʵ����Statement����
		try {
			stmt = conn.createStatement();
			// Ϊsql������ֵ
			// �������
			sql_del = "DELETE * FROM AccountInfoTable WHERE username = "
					+ String.valueOf(nm);
			stmt.execute(sql_del);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�����");
			return;
		}

		// 4���ر����ݿ�
		try {
			// �رղ���
			stmt.close();
			// �ر�����
			conn.close();
		} catch (Exception e) {
			System.out.println("���ݿ�ر�ʧ�ܣ�����");
			return;
		}
		return;
	}
}

