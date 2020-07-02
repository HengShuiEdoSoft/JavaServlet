package com.edo.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.StatementImpl;

public class DB {
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://192.168.2.2:3306/javatest?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	static String user = "edoroot";
	static String password = "123456";
	static Connection aConnection;
	
	public static Connection connectDB(){
		try{
			Class.forName(driver);
			aConnection = DriverManager.getConnection(url,user,password);
			if(aConnection.isClosed())
			{
				System.out.print("Succeeded!");
			}
		}catch(ClassNotFoundException e){
			System.out.println(e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aConnection;
	}
	
	public static ResultSet executeQuery(String sqlx) throws SQLException{
		connectDB();
		ResultSet rs = null;
		StatementImpl stmt = (StatementImpl) aConnection.createStatement();
		try {
		 rs = ((java.sql.Statement) stmt).executeQuery(sqlx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	} 
	public static int Update(String sqlx) throws SQLException{
		connectDB();
		int rs = 0;
		StatementImpl stmt = (StatementImpl) aConnection.createStatement();
		try {
		 rs = ((java.sql.Statement) stmt).executeUpdate(sqlx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	} 
}
