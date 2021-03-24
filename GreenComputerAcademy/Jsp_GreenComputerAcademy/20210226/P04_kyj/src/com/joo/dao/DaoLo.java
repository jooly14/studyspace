package com.joo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import com.joo.dto.DtoLo;

public class DaoLo {
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	int result = 0;
	public int insertUser(DtoLo dto){
		getConnection();
		try {
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
	public Vector<DtoLo> getList(){
		getConnection();
		Vector<DtoLo> v = new Vector<>();
		try {
			String sql = "select * from user";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()){
				String idx = rs.getString(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				String email = rs.getString(5);
				String tel = rs.getString(6);
				String addr = rs.getString(7);
				String birth = rs.getString(8);
				String gender = rs.getString(9);
				String nation = rs.getString(10);
				String[] interest = new String[3];
				interest[0] = rs.getString(11);
				interest[1] = rs.getString(12);
				interest[2] = rs.getString(13);
				String findpw1 = rs.getString(14);
				String findpw2 = rs.getString(15);
				String findpw3 = rs.getString(16);
				String findas1 = rs.getString(17);
				String findas2 = rs.getString(18);
				String findas3 = rs.getString(19);
				String regdate = rs.getString(20);
				DtoLo dto = new DtoLo(id, pw, name, email, tel, addr, birth, gender, nation, interest, findpw1, findpw2, findpw3, findas1, findas2, findas3, idx, regdate);
				v.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			freeConnection();
		}
		return v;
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
