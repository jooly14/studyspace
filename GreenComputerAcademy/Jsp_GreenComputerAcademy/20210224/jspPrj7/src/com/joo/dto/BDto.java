package com.joo.dto;

public class BDto {
	private int idx;
	private String title;
	private String id;
	private String content;
	private String regdate;
	private int hit;
	private int good;
	private int bad;
	private String ip;
	public BDto() {
		// TODO Auto-generated constructor stub
	}
	public BDto(int idx, String title, String id, String content, String regdate, int hit, int good, int bad,
			String ip) {
		this.idx = idx;
		this.title = title;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.good = good;
		this.bad = bad;
		this.ip = ip;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
