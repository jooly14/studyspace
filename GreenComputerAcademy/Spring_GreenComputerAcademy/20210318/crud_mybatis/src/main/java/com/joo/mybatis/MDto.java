package com.joo.mybatis;

public class MDto {
	private int idx;
	private String id;
	private String pw;
	private String content;
	public MDto() {
		// TODO Auto-generated constructor stub
	}
	public MDto(int idx, String id, String pw, String content) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
		this.content = content;
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
	
	
}
