package com.joo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.joo.dto.MDto;

@Repository
public class MDao {
	@Autowired
	JdbcTemplate jdbcTmp;
	
	@Value("#{sql['spmember.login']}")
	private String login;
	@Value("#{sql['spmember.signup']}")
	private String signup;
	@Value("#{sql['spmember.idchk']}")
	private String idchk;
	@Value("#{sql['spmember.deleteId']}")
	private String deleteId;
	
	public int deleteId(String id,String pw) {
		return jdbcTmp.update(deleteId,id,pw);
	}
	
	public int idchk(String id) {
		return jdbcTmp.queryForObject(idchk, new Object[] {id},Integer.class); 
	}
	public void signup(MDto dto) {
		jdbcTmp.update(signup,dto.getId(),dto.getPw(),dto.getName());
	}
	public int login(MDto dto) {
		return jdbcTmp.queryForObject(login,new Object[] {dto.getId(),dto.getPw()},Integer.class);
	}
}
