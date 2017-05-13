package org.poom.sap.notice.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable{
	private int NOTICE_NO;
	private String NOTICE_NICKNAME;
	private String NOTICE_TITLE;
	private String NOTICE_CONTENTS;
	private String NOTICE_FILE;
	private Date NOTICE_DATE;
	
	public Notice(){}
	
	public Notice(int NOTICE_NO, String NOTICE_NICKNAME, String NOTICE_TITLE,
			String NOTICE_CONTENTS, String NOTICE_FILE, Date NOTICE_DATE) {
		super();
		this.NOTICE_NO = NOTICE_NO;
		this.NOTICE_NICKNAME = NOTICE_NICKNAME;
		this.NOTICE_TITLE = NOTICE_TITLE;
		this.NOTICE_CONTENTS = NOTICE_CONTENTS;
		this.NOTICE_FILE = NOTICE_FILE;
		this.NOTICE_DATE = NOTICE_DATE;
	}

	public int getNOTICE_NO() {
		return NOTICE_NO;
	}

	public void setNOTICE_NO(int nOTICE_NO) {
		NOTICE_NO = nOTICE_NO;
	}

	public String getNOTICE_NICKNAME() {
		return NOTICE_NICKNAME;
	}

	public void setNOTICE_NICKNAME(String nOTICE_NICKNAME) {
		NOTICE_NICKNAME = nOTICE_NICKNAME;
	}

	public String getNOTICE_TITLE() {
		return NOTICE_TITLE;
	}

	public void setNOTICE_TITLE(String nOTICE_TITLE) {
		NOTICE_TITLE = nOTICE_TITLE;
	}

	public String getNOTICE_CONTENTS() {
		return NOTICE_CONTENTS;
	}

	public void setNOTICE_CONTENTS(String nOTICE_CONTENTS) {
		NOTICE_CONTENTS = nOTICE_CONTENTS;
	}

	public String getNOTICE_FILE() {
		return NOTICE_FILE;
	}

	public void setNOTICE_FILE(String nOTICE_FILE) {
		NOTICE_FILE = nOTICE_FILE;
	}

	public Date getNOTICE_DATE() {
		return NOTICE_DATE;
	}

	public void setNOTICE_DATE(Date nOTICE_DATE) {
		NOTICE_DATE = nOTICE_DATE;
	}

	@Override
	public String toString() {
		return "Notice [NOTICE_NO=" + NOTICE_NO + ", NOTICE_NICKNAME=" + NOTICE_NICKNAME + ", NOTICE_TITLE="
				+ NOTICE_TITLE + ", NOTICE_CONTENTS=" + NOTICE_CONTENTS + ", NOTICE_FILE=" + NOTICE_FILE
				+ ", NOTICE_DATE=" + NOTICE_DATE + "]";
	}

}
