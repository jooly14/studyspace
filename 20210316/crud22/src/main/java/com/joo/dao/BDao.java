package com.joo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	@Value("#{sql['dummy.getAll']}")
	private String getAll;
	
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
