package com.joo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.joo.dto.DtoLo;

public class DaoLo {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	int result = 0;
	
	public int insertUser(DtoLo dto){
		getConnection();
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "insert into user values(null,?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?,?,?,?,"
					+ "?,?,?,CURDATE())";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getId());
			stmt.setString(2, dto.getPw());
			stmt.setString(3, dto.getName());
			stmt.setString(4, dto.getEmail());
			stmt.setString(5, dto.getTel());
			stmt.setString(6, dto.getAddr());
			/*try {
				stmt.setDate(7, new Date(format.parse(dto.getBirth()).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			stmt.setString(7, dto.getBirth());
			stmt.setString(8, dto.getGender());
			stmt.setString(9, dto.getNation());
			stmt.setString(10, null);
			stmt.setString(11, null);
			stmt.setString(12, null);
			for(int i=0; i<dto.getInterest().length;i++){
				stmt.setString(10+i, dto.getInterest()[i]);
			}
			stmt.setString(13, dto.getFindpw1());
			stmt.setString(14, dto.getFindpw2());
			stmt.setString(15, dto.getFindpw3());
			stmt.setString(16, dto.getFindas1());
			stmt.setString(17, dto.getFindas2());
			stmt.setString(18, dto.getFindas3());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			freeConnection();
		}
		return result;
	}
	public int idChk(String id){
		getConnection();
		
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "select count(*) from user where id = ?";
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
	public int chkLogin(String id,String pw){
		getConnection();
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "select count(*) from user where id = ? and pw = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pw);
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
}
