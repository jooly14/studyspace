package com.npnc.board.dto;

import java.sql.Timestamp;
import java.util.Vector;

public class BDto {	//�Խñ� dto
	private int idx;	//�۹�ȣ
	private String title;	//������
	private String id;		//�ۼ��� ���̵�
	private String content;	//�۳���
	private Timestamp regdate;	//�ۼ��ð�
	private int hit;		//��ȸ��
	private String file;	//���ϰ��
	private int category;	
	private int good;		//���ƿ� ����
	private int bad;		//�Ⱦ�� ����
	private Vector<RDto> replys;	//��� �Խñ�
	private int replyCnt;
	
	public BDto() {}	//�⺻ ������
	public BDto(int idx, String title, String id, String content, Timestamp regdate, int hit, String file, int category,
			int good, int bad, Vector<RDto> replys, int replyCnt) {
		this.idx = idx;
		this.title = title;
		this.id = id;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
		this.file = file;
		this.category = category;
		this.good = good;
		this.bad = bad;
		this.replys = replys;
		this.replyCnt = replyCnt;
	}
	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
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
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
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
	public Vector<RDto> getReplys() {
		return replys;
	}
	public void setReplys(Vector<RDto> replys) {
		this.replys = replys;
	}
	
}
