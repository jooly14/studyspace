package com.joo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import com.joo.dto.DtoGB;


public class DaoGB {
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
	public Vector<DtoGB> getList(){
		getConnection();
		Vector<DtoGB> v = new Vector<>();
		String sql = "SELECT * FROM GUESTBOOK";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				/*String data = rs.getInt(1) +"/" +rs.getString(2)+ "/" + rs.getInt(3);
				v.add(data);*/
				int idx = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String content = rs.getString(4);
				Timestamp ts = rs.getTimestamp(5);
				Date regdate = new Date(ts.getTime());
				DtoGB dto = new DtoGB(idx, id, pw, content, regdate);
				v.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			freeConnection();
		}
		return v;
	}
	public int insertList(String id, String pw , String content){
		getConnection();
		int result = 0;
		String sql = "INSERT INTO GUESTBOOK VALUES(NULL,?,?,?,DEFAULT)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			stmt.setString(3, content);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			freeConnection();
		}
		return result;
	}
	public int updateList(String idx, String id, String content){
		getConnection();
		int result = 0;
		String sql = "UPDATE GUESTBOOK SET ID = ?, CONTENT = ?  WHERE IDX =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, content);
			stmt.setInt(3, Integer.parseInt(idx));
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			freeConnection();
		}
		return result;
	}
	public int chkBeforeDelete(String pw,String idx){
		getConnection();
		int result = 0;
		String sql = "SELECT PW FROM GUESTBOOK WHERE IDX = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(idx));
			rs = stmt.executeQuery();
			if(rs.next()){
				String pw2 = rs.getString(1);
				if(pw.equals(pw2)){
					result = 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			freeConnection();
		}
		return result;
	}
	public int deleteList(String idx){
		getConnection();
		int result = 0;
		String sql = "DELETE FROM GUESTBOOK WHERE IDX = ?";
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
	public DtoGB getData(String idx1){
		getConnection();
		String sql = "SELECT * FROM GUESTBOOK WHERE IDX = ?";
		DtoGB dto = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(idx1));
			rs = stmt.executeQuery();
			if(rs.next()){
				int idx = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String content = rs.getString(4);
				Timestamp ts = rs.getTimestamp(5);
				Date regdate = new Date(ts.getTime());
				dto = new DtoGB(idx, id, pw, content, regdate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			freeConnection();
		}
		return dto;
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
