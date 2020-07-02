package com.edo.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edo.beans.Student;

public class DAL {
	public static String sqlx = "";

	public static String testQueryByID(String ID) {
		ResultSet rs = null;
		String result = "";
		sqlx = "SELECT * FROM edo_students where ID = '" + ID + "'";
		try {
			rs = DB.executeQuery(sqlx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				result = result + "ID:" + rs.getString("ID") + "  Name:" + rs.getString("StuName") + "</br>";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<Student> StuList() {
		ResultSet rs = null;
		List<Student> list=new ArrayList<Student>();
		sqlx = "SELECT * FROM edo_students";
		try {
			rs = DB.executeQuery(sqlx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				Student stu=new Student();
				stu.setAge(rs.getInt("StuAge"));
				stu.setId(  rs.getInt("ID"));
				stu.setStuName(rs.getString("StuName"));
				stu.setStuSex(rs.getString("StuSex"));
				stu.setCdate(rs.getDate("CDate"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static int Add(String stuName, int stuAge, String Sex) {
		// SQL语句  
		String sql = "INSERT INTO `edo_students` (StuName,StuAge,StuSex) VALUES ( '" + stuName + "', " + stuAge + ", '"
				+ Sex + "');";

		int ret = 0;
		try {
			ret = DB.Update(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}
	public static int Delete(int Id) {
		// SQL语句  
		String sql = "delete from `edo_students` where ID="+Id+";";

		int ret = 0;
		try {
			ret = DB.Update(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return ret;
	}
	
}
