package com.joo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;

import com.joo.dto.DtoGB;


public class DaoGB {
	private int pageNumber = 0;
	private int pageSize = 5;
	private int totalPage = 0;
	private int cnt = 0;
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
	public int calcTotalPage(){
		totalPage = cnt/pageSize;
		if(cnt%pageSize>0){
			totalPage++;
		}
		return totalPage;
	}
	
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getCnt() {
		return cnt;
	}
	public Vector<DtoGB> getList(String sort, String find){
		getConnection();
		Vector<DtoGB> v = new Vector<>();
		String sql = "SELECT SQL_CALC_FOUND_ROWS * FROM GUESTBOOK";
		
		Statement stmt2 = null;
		ResultSet rs2 = null;
		if(sort==null||find==null||find.equals("")){
			
		}else if(sort.equals("name")){
			sql = sql + " where id= '"+find+"'";
		}else if(sort.equals("con")){
			sql = sql + " where content like '%"+find+"%'";
		}
		sql = sql+ " ORDER BY idx DESC limit "+pageNumber*pageSize+","+pageSize;
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
			
			stmt2 = conn.createStatement();
			rs2 = stmt2.executeQuery("SELECT FOUND_ROWS()");
			if(rs2.next()){
				cnt = rs2.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			freeConnection();
			try {
				if(stmt2!=null)stmt2.close();
				if(rs2!=null)rs2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	public int insertList(DtoGB gdto){
		getConnection();
		int result = 0;
		String sql = "INSERT INTO GUESTBOOK VALUES(NULL,?,?,?,DEFAULT)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, gdto.getId());
			stmt.setString(2, gdto.getPw());
			stmt.setString(3, gdto.getContent());
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
