package com.joo.dto;

public class BDto {
	private int idx;
	private String title;
	private String writer;
	private String regdate;
	private String content;
	private int hit;
	public BDto() {
		// TODO Auto-generated constructor stub
	}
	public BDto(int idx, String title, String writer, String regdate, String content, int hit) {
		this.idx = idx;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.content = content;
		this.hit = hit;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
