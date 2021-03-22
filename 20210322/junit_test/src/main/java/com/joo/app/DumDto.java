package com.joo.app;

public class DumDto {
	private int idx;
	private String pw;
	private String content;
	public DumDto() {
		// TODO Auto-generated constructor stub
	}
	public DumDto(int idx, String pw, String content) {
		this.idx = idx;
		this.pw = pw;
		this.content = content;
	}
	/*
	public DumDto(int idx) {
		this.idx = idx;
	}
	public DumDto(String pw) {
		this.content = content;
	}
	public DumDto(String pw, String content) {
		this.pw = pw;
		this.content = content;
	}
	
	*/
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
