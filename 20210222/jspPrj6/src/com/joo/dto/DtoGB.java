package com.joo.dto;

import java.sql.Date;

public class DtoGB {
	private int idx;
	private String id;
	private String pw;
	private String content;
	private Date regdate;
	public DtoGB() {
		// TODO Auto-generated constructor stub
	}
	public DtoGB(int idx, String id, String pw, String content, Date regdate) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.content = content;
		this.regdate = regdate;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
