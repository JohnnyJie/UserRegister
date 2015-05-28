package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Object.Person;

public class PersonInfoDAO {

	public Person getPersonByPhone(String phone) {
		
		String name=null;
		String id=null;
		String email=null;
		String sex=null;
		Person p;
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
			sql = "SELECT * FROM PersonInfoTable WHERE phone = \'"
					+ phone+"\'";
			r = stmt.executeQuery(sql);
			while (r.next()) {
				name= r.getString("personName");
				id=r.getString("id");
				email=r.getString("email");
				sex=r.getString("sex");
			}
			if(name==null||id==null){
				p=null;
			}else{
				p=new Person(name,id,phone,sex,email);
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
		return p;
	}

	public void createPerson(Person p) {
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

			sql_insert = "INSERT into PersonInfoTable(phone,id,email,personname,sex) values(?,?,?,?,?);";
			PreparedStatement ppst = conn.prepareStatement(sql_insert);
			ppst.setString(1, p.getPhone());
			ppst.setString(2, p.getId());
			ppst.setString(3, p.getEmail());
			ppst.setString(4, p.getName());
			ppst.setString(5, p.getSex());
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

	public void deletePersonByPhone(String ph) {
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
			sql_del = "DELETE * FROM PersonInfoTable WHERE phone = "
					+ String.valueOf(ph);
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
