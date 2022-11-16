package com.example.bean;

import java.util.Date;

public class BoardVO {
	private int seq;
	private String category;
	private String title;
	private String writer;
	private String content;
	private String fileName;
	private Date editdate;
	private Date regdate;
	private int cnt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCategory() { return category; }
	public void setCategory(String category) {
		this.category = category;
	}

	public String getFileName() { return fileName; }
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public void setEditdate(Date editdate) {
		this.editdate = editdate;
	}

	public Date getEditdate() {
		return editdate;
	}

	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
