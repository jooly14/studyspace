package com.joo.crudfile;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class FDao {
	@Autowired
	private JdbcTemplate jdbcTmp;
	
	@Value("#{sql['filedummy.getAll']}")
	private String getAll;
	@Value("#{sql['filedummy.insert']}")
	private String insert;
	
	public List<FDto> getAll(){
		return jdbcTmp.query(getAll, new FDaoMapper());
	}
	public void insert(FDto dto){
		jdbcTmp.update(insert,dto.getFilename(),dto.getName());
	}
	
	class FDaoMapper implements RowMapper<FDto>{
		@Override
		public FDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			FDto dto = new FDto(rs.getInt(1), rs.getString(2), rs.getString(3));
			return dto;
		}
		
	}
}
