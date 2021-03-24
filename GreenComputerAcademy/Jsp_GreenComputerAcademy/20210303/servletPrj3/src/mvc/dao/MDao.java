package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import mvc.dto.MDto;

public class MDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int result;
	DBConnectionMgr pool = DBConnectionMgr.getInstance();
	int totalcnt;
	public Vector selectAll(String page,int pagesize){
		Vector v = new Vector<>();
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		try {
			String sql = "select SQL_CALC_FOUND_ROWS * from user2 order by idx desc limit ?,?";
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (Integer.parseInt(page)-1)*pagesize);
			pstmt.setInt(2, pagesize);
			rs = pstmt.executeQuery();
			while(rs.next()){
				int idx = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				MDto dto = new MDto(idx, id, pw, name);
				v.add(dto);
			}
			String sql2 = "select FOUND_ROWS()";
			pstmt2 = conn.prepareStatement(sql2);
			rs2 = pstmt2.executeQuery();
			if(rs2.next()){
				totalcnt = rs2.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
			pool.freeConnection(conn, pstmt2, rs2);
		}
		return v;
	}
	public int getTotalcnt(){
		return totalcnt;
	}
	public int delete(String idx){
		try {
			String sql = "delete from user2 where idx=?";
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(idx));
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}
		
		return result;
	}
	public int insert(MDto dto){
		try {
			String sql = "insert into user2 values(null,?,?,?)";
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt);
		}
		
		return result;
	}
	
	public int idChk(String id){
		try {
			String sql = "select count(*) from user2 where id = ?";
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		
		return result;
	}
	public int signin(MDto dto){
		try {
			String sql = "select count(*) from user2 where id = ? and pw = ?";
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		
		return result;
	}
	public MDto selectOne(String id2){
		MDto dto = null;
		try {
			String sql = "select * from user2 where id = ?";
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id2);
			rs = pstmt.executeQuery();
			if(rs.next()){
				int idx = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				dto = new MDto(idx, id, pw, name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		
		return dto;
	}
	public int moduser(MDto dto , String oldpw){
		try {
			String sql = "update user2 set pw=?, name=? where idx=? and pw=?";
			conn = pool.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getIdx());
			pstmt.setString(4, oldpw);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(conn, pstmt, rs);
		}
		return result;
	}
	
}
