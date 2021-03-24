package com.joo.g2controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CDao {
	@Autowired
	private JdbcTemplate jdbcTmp;
	
	/*private String insert = "insert into dummy values(null,?,?,?)";
	private String getCnt = "select count(*) from dummy";
	private String getData = "select * from dummy where num = ?";
	private String getAll = "select * from dummy order by num desc limit ?,?";
	private String delete = "delete from dummy where num = ?";
	private String update = "update dummy set content = ? where num = ?";*/
	@Value("#{sql['dummy.insert']}")
	private String insert;
	@Value("#{sql['dummy.getCnt']}")
	private String getCnt;
	@Value("#{sql['dummy.getData']}")
	private String getData;
	@Value("#{sql['dummy.getAll']}")
	private String getAll;
	@Value("#{sql['dummy.delete']}")
	private String delete;
	@Value("#{sql['dummy.update']}")
	private String update;
	int result = 0;
	public int insert(CDto dto) {
		result = jdbcTmp.update(insert, dto.getId(), dto.getPw(),dto.getContent(),dto.getSfile(),dto.getOfile());
		return result;
	}
	
	public int delete(int num) {
		result = jdbcTmp.update(delete, num);
		return result;
	}
	
	public int getCnt() {
		result = jdbcTmp.queryForInt(getCnt);
		return result;
	}
	public int update(String content, int num) {
		result = jdbcTmp.update(update, content, num);
		return result;
	}
	public CDto getData(int num) {
		return (CDto)jdbcTmp.queryForObject(getData,new Object[] {num},new CDaoMapper());
	}
	public List<CDto> getAll(int page, int pagesize) {
		return (List<CDto>)jdbcTmp.query(getAll,new Object[] {(page-1)*pagesize,pagesize},new CDaoMapper());
	}
	class CDaoMapper implements RowMapper<CDto>{

		@Override
		public CDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CDto dto = new CDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			return dto;
		}
		
	}
}
