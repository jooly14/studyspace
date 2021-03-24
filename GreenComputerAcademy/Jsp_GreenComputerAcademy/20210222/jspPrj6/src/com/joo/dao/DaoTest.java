package com.joo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.joo.dto.DtoTest;

public class DaoTest {
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
		String url = "jdbc:mysql://localhost:3307/jspdb";
		String dbId = "root";
		String dbPw = "1234";
		try {
			conn = DriverManager.getConnection(url,dbId,dbPw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int insertDao(String id, String pw){
		getConnection();
		String sql = "INSERT INTO DAOTEST VALUES(NULL,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, Integer.parseInt(pw));
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			freeConnection();
		}
		return result;
	}
	public int deleteDao(String idx){
		getConnection();
		String sql = "DELETE FROM DAOTEST WHERE IDX = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(idx));
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			freeConnection();
		}
		return result;
	}
	public int updateDao(String idx,String id,String pw){
		getConnection();
		String sql = "UPDATE DAOTEST SET ID=?,PW=? WHERE IDX=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setInt(2, Integer.parseInt(pw));
			stmt.setInt(3, Integer.parseInt(idx));
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			freeConnection();
		}
		return result;
	}
	public Vector<DtoTest> selectDao(){
		getConnection();
		Vector<DtoTest> v = new Vector<>();
		String sql = "SELECT * FROM DAOTEST";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				/*String data = rs.getInt(1) +"/" +rs.getString(2)+ "/" + rs.getInt(3);
				v.add(data);*/
				int idx = rs.getInt(1);
				String id = rs.getString(2);
				int pw = rs.getInt(3);
				DtoTest dto = new DtoTest(idx, id, pw);
				v.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			freeConnection();
		}
		return v;
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
}
