package com.joo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class ADao {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	int result = 0;
	public void getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3307/jspdb?useUnicode=true&characterEncoding=UTF-8";
		String dbId = "root";
		String dbPw = "1234";
		try {
			conn = DriverManager.getConnection(url,dbId,dbPw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void freeConnection(){
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public int insert(String id, String pw, String name){
		getConnection();
		String sql = "insert into user2 values(null,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			stmt.setString(3, name);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection();
		}
		return result;
	}
	public int idChk(String id){
		getConnection();
		try {
			String sql = "select count(*) from user2 where id = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			freeConnection();
		}
		return result;
	}
}
