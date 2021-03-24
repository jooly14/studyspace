package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.app.entity.Notice;

public class NoticeService {
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "newlec";
	private String upw = "tiger";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	@SuppressWarnings("finally")
	public List<Notice> getList(int page,String field, String query){
		List<Notice> list = new ArrayList<>();
		
		int start = 1 + 10*(page-1);
		int end = page*10;
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			String sql = "SELECT * FROM NEWLEC.NOTICE_VIEW WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
			con = DriverManager.getConnection(url,uid,upw);
			st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, start);
			st.setInt(3, end);
			rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regDate = rs.getDate("REGDATE");
				String content = rs.getString("CONTENT");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				Notice notice = new Notice(id, title, writerId, regDate, content, hit, files);
				list.add(notice);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				return list;
			}
		}
	}
	@SuppressWarnings("finally")
	public int insert(Notice notice) {
		String title = notice.getTitle();
		String writerId = notice.getWriterId();
		String content = notice.getContent();
		String files = notice.getFiles();
		Connection con = null;
		PreparedStatement st = null;
		int result  = -1;
		try {
			Class.forName(driver);
			String sql = "INSERT INTO NEWLEC.NOTICE(title,writer_id,content,files) VALUES(?,?,?,?)";
			con = DriverManager.getConnection(url,uid,upw);
			st = con.prepareStatement(sql);
			
			st.setString(1, title);
			st.setString(2, writerId);
			st.setString(3, content);
			st.setString(4, files);
			
			result = st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				return result;
			}
			
		}
		
	}
	@SuppressWarnings("finally")
	public int update(Notice notice) {
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();
		int id = notice.getId();
		Connection con = null;
		PreparedStatement st = null;
		int result = -1;
		try {
			Class.forName(driver);
			String sql = "UPDATE NEWLEC.NOTICE SET title=?,content=?,files=?,id=?";
			con = DriverManager.getConnection(url,uid,upw);
			st = con.prepareStatement(sql);
			
			st.setString(1, title);
			st.setString(2, content);
			st.setString(3, files);
			st.setInt(4, id);
			
			result = st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				return result;
			}
		}
		
		
		
	}
	@SuppressWarnings("finally")
	public int delete(int id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int result = -1;
		try {
			Class.forName(driver);
			String sql = "DELETE NEWLEC.NOTICE WHERE ID=?";
			con = DriverManager.getConnection(url,uid,upw);
			st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			
			result = st.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				return result;
			}
		}
		
		
	}
	@SuppressWarnings("finally")
	public int getCount() {
		int count = 0;
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			String sql = "SELECT count(ID) COUNT FROM NEWLEC.NOTICE";
			con = DriverManager.getConnection(url,uid,upw);
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				return count;
			}
		}
		
	}
	
}
