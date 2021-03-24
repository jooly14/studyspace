package com.joo.g2controller;

public class CDto {
	private int num;
	private String id;
	private String pw;
	private String content;
	private String sfile;
	private String ofile;
	
	public CDto() {
	}


	public CDto(int num, String id, String pw, String content) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.content = content;
	}
	public CDto(String id, String pw, String content) {
		this.id = id;
		this.pw = pw;
		this.content = content;
	}
	
	public CDto(String id, String pw, String content, String sfile, String ofile) {
		this.id = id;
		this.pw = pw;
		this.content = content;
		this.sfile = sfile;
		this.ofile = ofile;
	}
	public CDto(int num, String id, String pw, String content, String sfile, String ofile) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.content = content;
		this.sfile = sfile;
		this.ofile = ofile;
	}

	public String getSfile() {
		return sfile;
	}

	public void setSfile(String sfile) {
		this.sfile = sfile;
	}

	public String getOfile() {
		return ofile;
	}

	public void setOfile(String ofile) {
		this.ofile = ofile;
	}
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
