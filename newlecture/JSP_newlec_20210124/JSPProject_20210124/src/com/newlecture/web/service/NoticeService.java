package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class NoticeService {
	public int removeNoticeAll(int[] ids) {
		int result = 0;
		String params = "";
		for(int i=0;i<ids.length;i++) {
			params += ids[i] ;
			if(i< ids.length-1) {
				params += ",";
			}
		}
		String sql = "DELETE FROM NEWLEC.NOTICE WHERE ID IN("+params+")";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"newlec","tiger");
			Statement st = con.createStatement();
			result = st.executeUpdate(sql);

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int pubNoticeAll(int[] oids, int[] cids) {
		List<String> oidsList = new ArrayList<>(); 
		List<String> cidsList = new ArrayList<>(); 
		
		for(int i=0;i<oids.length;i++) {
			oidsList.add(String.valueOf(oids[i]));
		}
		for(int i=0;i<cids.length;i++) {
			cidsList.add(String.valueOf(cids[i]));
		}	
		
		return pubNoticeAll(oidsList,cidsList);
	}
	public int pubNoticeAll(List<String> oids, List<String> cids) {
		String oidsCSV = "";
		String cidsCSV = "";
		
		oidsCSV = String.join(",",oids);
		cidsCSV = String.join(",",cids);
		
		return pubNoticeAll(oidsCSV,cidsCSV);
	}
	public int pubNoticeAll(String oidsCSV, String cidsCSV) {
		int result = 0;
//		String params = "";
//		for(int i=0;i<ids.size();i++) {
//			params += ids.get(i) ;
//			if(i< ids.size()-1) {
//				params += ",";
//			}
//		}
		String sqlOpen = String.format("UPDATE NEWLEC.NOTICE SET PUB=1 WHERE ID IN(%s)", oidsCSV);
		String sqlClose = String.format("UPDATE NEWLEC.NOTICE SET PUB=0 WHERE ID IN(%s)", cidsCSV);
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"newlec","tiger");
			Statement st1 = con.createStatement();
			Statement st2 = con.createStatement();
			result += st1.executeUpdate(sqlOpen);
			result += st2.executeUpdate(sqlClose);

			st1.close();
			st2.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int insertNotice(Notice notice) {
		int result = 0;
		String sql = "INSERT INTO NEWLEC.NOTICE(TITLE, CONTENT, WRITER_ID, PUB, FILES) VALUES(?,?,?,?,?)";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"newlec","tiger");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getWriter_id());
			st.setBoolean(4, notice.getPub());
			st.setString(5, notice.getFiles()!=null?notice.getFiles():"");
			result = st.executeUpdate();

			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public int deleteNotice(int id) {
		
		return 0;
	}
	public int updateNotice(Notice notice) {
		
		return 0;
	}
	public List<Notice> getNoticeNewestList() {
		
		return null;
	}
	
	public List<NoticeView> getNoticeList() {
		
		
		return getNoticeList("title","",1);
	}
	public List<NoticeView> getNoticeList(int page) {
		
		return getNoticeList("title","",page);
	}
	public List<NoticeView> getNoticeList(String field, String query, int page) {
		List<NoticeView> list = new ArrayList<NoticeView>();
		String sql = "SELECT * FROM ( " + 
				" SELECT ROW_NUMBER() OVER (ORDER BY REGDATE DESC) NUM, " + 
				" NEWLEC.NOTICE_VIEW2.* FROM NEWLEC.NOTICE_VIEW2 WHERE "+field+" LIKE ?" + 
				" ) WHERE NUM BETWEEN ? AND ?";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"newlec","tiger");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			ResultSet rs = st.executeQuery();

			while(rs.next()){
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writer_id = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				int cmtCount = rs.getInt("CMT_COUNT");
				boolean pub = rs.getBoolean("PUB");
				NoticeView notice = new NoticeView(id, title, regdate, writer_id, hit, files, cmtCount, pub);
				list.add(notice);
			}


			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
	public List<NoticeView> getNoticePubList(String field, String query, int page) {
		List<NoticeView> list = new ArrayList<NoticeView>();
		String sql = "SELECT * FROM ( " + 
				" SELECT ROW_NUMBER() OVER (ORDER BY REGDATE DESC) NUM, " + 
				" NEWLEC.NOTICE_VIEW2.* FROM NEWLEC.NOTICE_VIEW2 WHERE "+field+" LIKE ?" + 
				" ) WHERE PUB=1 AND NUM BETWEEN ? AND ?";
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"newlec","tiger");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			st.setInt(2, 1+(page-1)*10);
			st.setInt(3, page*10);
			ResultSet rs = st.executeQuery();

			while(rs.next()){
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writer_id = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				int cmtCount = rs.getInt("CMT_COUNT");
				boolean pub = rs.getBoolean("PUB");
				NoticeView notice = new NoticeView(id, title, regdate, writer_id, hit, files, cmtCount, pub);
				list.add(notice);
			}


			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	public int getNoticeCount() {
		return getNoticeCount("title","");
	}
	public int getNoticeCount(String field, String query){
		int count = 0;
		String sql = "SELECT COUNT(ID) COUNT FROM ( " + 
				" SELECT ROW_NUMBER() OVER (ORDER BY REGDATE DESC) NUM, " + 
				" NEWLEC.NOTICE.* FROM NEWLEC.NOTICE WHERE "+field+" LIKE ?" + 
				" )";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"newlec","tiger");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%"+query+"%");
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
			

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	public Notice getNotice(int id){
		Notice n = null;
		String sql = "SELECT * FROM NEWLEC.NOTICE WHERE ID=?";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"newlec","tiger");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writer_id = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				boolean pub = rs.getBoolean("PUB");
				
				n = new Notice(id, title, regdate, writer_id, hit, files, content ,pub);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return n;
	}
	public Notice getNextNotice(int id){
		String sql = "SELECT * FROM NEWLEC.NOTICE WHERE ID = (SELECT ID FROM(SELECT ID FROM NEWLEC.NOTICE WHERE REGDATE > (SELECT REGDATE FROM NEWLEC.NOTICE WHERE ID=?) ORDER BY REGDATE ASC) WHERE ROWNUM=1)";
		
		Notice n = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"newlec","tiger");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writer_id = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				boolean pub = rs.getBoolean("PUB");
				
				n = new Notice(id, title, regdate, writer_id, hit, files, content,pub);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return n;
	}
	public Notice getPrevNotice(int id){
		String sql = "SELECT * FROM NEWLEC.NOTICE WHERE ID= (SELECT ID FROM(SELECT ID FROM NEWLEC.NOTICE WHERE REGDATE < (SELECT REGDATE FROM NEWLEC.NOTICE WHERE ID=?) ORDER BY REGDATE DESC) WHERE ROWNUM=1)";
		
		Notice n = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"newlec","tiger");
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				String title = rs.getString("TITLE");
				Date regdate = rs.getDate("REGDATE");
				String writer_id = rs.getString("WRITER_ID");
				int hit = rs.getInt("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");
				boolean pub = rs.getBoolean("PUB");
				
				n = new Notice(id, title, regdate, writer_id, hit, files, content,pub);
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return n;
	}
	
	
}
