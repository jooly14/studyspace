package com.joo.dto;

import java.sql.Date;

public class DtoLo {
	private String idx;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String tel;
	private String addr;
	private String birth;
	private String gender;
	private String nation;
	private String[] interest;
	private String findpw1;
	private String findpw2;
	private String findpw3;
	private String findas1;
	private String findas2;
	private String findas3;
	private String regdate;
	public DtoLo() {
		// TODO Auto-generated constructor stub
	}
	
	public DtoLo(String id, String pw, String name, String email, String tel, String addr, String birth, String gender,
			String nation, String[] interest, String findpw1, String findpw2, String findpw3, String findas1,
			String findas2, String findas3,String idx, String regdate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.addr = addr;
		this.birth = birth;
		this.gender = gender;
		this.nation = nation;
		this.interest = interest;
		this.findpw1 = findpw1;
		this.findpw2 = findpw2;
		this.findpw3 = findpw3;
		this.findas1 = findas1;
		this.findas2 = findas2;
		this.findas3 = findas3;
		this.idx = idx;
		this.regdate = regdate;
	}
	
	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	public String getFindpw1() {
		return findpw1;
	}
	public void setFindpw1(String findpw1) {
		this.findpw1 = findpw1;
	}
	public String getFindpw2() {
		return findpw2;
	}
	public void setFindpw2(String findpw2) {
		this.findpw2 = findpw2;
	}
	public String getFindpw3() {
		return findpw3;
	}
	public void setFindpw3(String findpw3) {
		this.findpw3 = findpw3;
	}
	public String getFindas1() {
		return findas1;
	}
	public void setFindas1(String findas1) {
		this.findas1 = findas1;
	}
	public String getFindas2() {
		return findas2;
	}
	public void setFindas2(String findas2) {
		this.findas2 = findas2;
	}
	public String getFindas3() {
		return findas3;
	}
	public void setFindas3(String findas3) {
		this.findas3 = findas3;
	}
	
	
}
