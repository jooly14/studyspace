package com.joo.dto;

public class DtoTest {
	private int idx;
	private String id;
	private int pw;
	public DtoTest() {
	}
	public DtoTest(int idx, String id, int pw) {
		this.idx = idx;
		this.id = id;
		this.pw = pw;
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
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	
}
