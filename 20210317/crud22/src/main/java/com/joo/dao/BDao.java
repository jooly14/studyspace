package com.joo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.joo.dto.BDto;

@Repository
public class BDao {
	@Autowired
	private JdbcTemplate jdbcTmp;
	@Value("#{sql['spboard.getAll']}")
	private String getAll;
	@Value("#{sql['spboard.insert']}")
	private String insert;
	@Value("#{sql['spboard.getData']}")
	private String getData;
	@Value("#{sql['spboard.getCnt']}")
	private String getCnt;
	@Value("#{sql['spboard.updateHit']}")
	private String updateHit;
	@Value("#{sql['spboard.update']}")
	private String update;
	@Value("#{sql['spboard.delete']}")
	private String delete;
	
	public void delete(int idx) {
		jdbcTmp.update(delete,idx);
	}
	
	public void update(BDto dto) {
		jdbcTmp.update(update,dto.getTitle(),dto.getContent(),dto.getIdx());
	}
	
	public void updateHit(int idx) {
		jdbcTmp.update(updateHit,idx);
	}
	
	public int getCnt() {
		return jdbcTmp.queryForObject(getCnt, Integer.class);
	}
	
	public BDto getData(int idx) {
		return (BDto) jdbcTmp.queryForObject(getData, new Object[] {idx}, new daoMapper());
	}
	public void insert(BDto dto) {
		jdbcTmp.update(insert,dto.getTitle() , dto.getWriter(),dto.getContent());
	}
	public ArrayList<BDto> getAll(int page, int pagesize){
		return (ArrayList<BDto>) jdbcTmp.query(getAll, new Object[] {(page-1)*pagesize,pagesize}, new daoMapper());
	}
	class daoMapper implements RowMapper<BDto> {

		@Override
		public BDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BDto dto = new BDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			return dto;
		}

	}
}
