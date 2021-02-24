package com.joo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.joo.dto.BDto;

public class BDao {
	private int pageSize = 10;
	private int totalPage = 0;
	private int totalCnt = 0;
	private int curPage = 0;
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	int result = 0;
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public Vector<BDto> getList(){
		getConnection();
		String sql = "select SQL_CALC_FOUND_ROWS * from board order by idx desc limit ?,?";
		Vector<BDto> v = new Vector<>();
		Statement stmt2 = null;
		ResultSet rs2 = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, (curPage-1)*10);
			stmt.setInt(2, pageSize);
			rs = stmt.executeQuery();
			while(rs.next()){
				int idx = rs.getInt(1);
				String title = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString("content");
				String regdate = rs.getString("regdate");
				int good = rs.getInt("good");
				int bad = rs.getInt("bad");
				String ip = rs.getString("ip");
				int hit = rs.getInt("hit");
				BDto dto = new BDto(idx, title, id, content, regdate, hit, good, bad, ip);
				v.add(dto);
			}
			String sql2 = "select FOUND_ROWS()";
			stmt2 = conn.createStatement();
			rs2 = stmt2.executeQuery(sql2);
			if(rs2.next()){
				totalCnt = rs2.getInt(1);
				totalPage = totalCnt/pageSize;
				if(totalCnt%pageSize!=0){
					totalPage++;
				}
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			freeConnection();
				try {
					if(rs2!=null) rs2.close();
					if(stmt2 != null)stmt2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return v;
	}
	public BDto read(String idx1){
		getConnection();
		String sql = "select * from board where idx = "+idx1;
		BDto dto = null;
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()){
				int idx = rs.getInt(1);
				String title = rs.getString(2);
				String id = rs.getString(3);
				String content = rs.getString("content");
				String regdate = rs.getString("regdate");
				int good = rs.getInt("good");
				int bad = rs.getInt("bad");
				String ip = rs.getString("ip");
				int hit = rs.getInt("hit");
				dto = new BDto(idx, title, id, content, regdate, hit, good, bad, ip);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	public int insert(String id, String title, String content, String ip){
		getConnection();
		String sql = "insert into board values(null,?,?,?,default,default,default,default,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,title);
			stmt.setString(2,id);
			stmt.setString(3, content);
			stmt.setString(4,ip);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
