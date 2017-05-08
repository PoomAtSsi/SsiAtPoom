package com.kh.sample.notice.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable{
	private int NOTICE_NO;
	private String NOTICE_TITLE;
	private String NOTICE_WRITER;
	private Date NOTICE_DATE;
	private String NOTICE_CONTENT;
	private int NOTICE_VIEWS;
	
	public Notice(){}
	
	public Notice(int NOTICE_NO, String NOTICE_TITLE, String NOTICE_WRITER,
			Date NOTICE_DATE, String NOTICE_CONTENT, int NOTICE_VIEWS) {
		super();
		this.NOTICE_NO = NOTICE_NO;
		this.NOTICE_TITLE = NOTICE_TITLE;
		this.NOTICE_WRITER = NOTICE_WRITER;
		this.NOTICE_DATE = NOTICE_DATE;
		this.NOTICE_CONTENT = NOTICE_CONTENT;
		this.setNOTICE_VIEWS(NOTICE_VIEWS);
	}

	public int getNOTICE_NO() {
		return NOTICE_NO;
	}

	public void setNOTICE_NO(int nOTICE_NO) {
		NOTICE_NO = nOTICE_NO;
	}

	public String getNOTICE_TITLE() {
		return NOTICE_TITLE;
	}

	public void setNOTICE_TITLE(String nOTICE_TITLE) {
		NOTICE_TITLE = nOTICE_TITLE;
	}

	public String getNOTICE_WRITER() {
		return NOTICE_WRITER;
	}

	public void setNOTICE_WRITER(String nOTICE_WRITER) {
		NOTICE_WRITER = nOTICE_WRITER;
	}

	public java.sql.Date getNOTICE_DATE() {
		return NOTICE_DATE;
	}

	public void setNOTICE_DATE(java.sql.Date nOTICE_DATE) {
		NOTICE_DATE = nOTICE_DATE;
	}

	public String getNOTICE_CONTENT() {
		return NOTICE_CONTENT;
	}

	public void setNOTICE_CONTENT(String nOTICE_CONTENT) {
		NOTICE_CONTENT = nOTICE_CONTENT;
	}
	
	public int getNOTICE_VIEWS() {
		return NOTICE_VIEWS;
	}
	
	public void setNOTICE_VIEWS(int nOTICE_VIEWS) {
		NOTICE_VIEWS = nOTICE_VIEWS;
	}

	@Override
	public String toString() {
		return "Notice [NOTICE_NO=" + NOTICE_NO + ", NOTICE_TITLE=" + NOTICE_TITLE + ", NOTICE_WRITER=" + NOTICE_WRITER
				+ ", NOTICE_DATE=" + NOTICE_DATE + ", NOTICE_CONTENT=" + NOTICE_CONTENT + ", NOTICE_VIEWS="
				+ NOTICE_VIEWS + "]";
	}	
	
	
	/*	
 	public Notice(String noticeTitle, String noticeWriter, String noticeContent) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
	}
 	*/

	/*
	public Notice(int noticeNo, String noticeTitle, String noticeWriter, Date noticeDate, String noticeContent, int hit) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
		this.hit = hit;
	}*/

	
	
}
