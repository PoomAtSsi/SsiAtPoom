package org.poom.sap.notice.model.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Notice implements java.io.Serializable{
	private int notice_no;
	private String notice_nickname;
	private String notice_title;
	private String notice_contents;
	private MultipartFile notice_file;
	private Date notice_date;
	private int notice_visibility;
	private String notice_filepath;
	
	public Notice(){}
	
	public Notice(int notice_no, String notice_nickname, String notice_title,
			String notice_contents, MultipartFile notice_file, Date notice_date, int notice_visibility
			,String notice_filepath) {
		super();
		this.notice_no = notice_no;
		this.notice_nickname = notice_nickname;
		this.notice_title = notice_title;
		this.notice_contents = notice_contents;
		this.notice_file = notice_file;
		this.notice_date = notice_date;
		this.notice_visibility = notice_visibility;
		this.notice_filepath = notice_filepath;
	}


	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNotice_nickname() {
		return notice_nickname;
	}

	public void setNotice_nickname(String notice_nickname) {
		this.notice_nickname = notice_nickname;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_contents() {
		return notice_contents;
	}

	public void setNotice_contents(String notice_contents) {
		this.notice_contents = notice_contents;
	}

	public MultipartFile getNotice_file() {
		return notice_file;
	}

	public void setNotice_file(MultipartFile notice_file) {
		this.notice_file = notice_file;
	}

	public Date getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}

	public int getNotice_visibility() {
		return notice_visibility;
	}

	public void setNotice_visibility(int notice_visibility) {
		this.notice_visibility = notice_visibility;
	}
	
	public String getNotice_filepath() {
		return notice_filepath;
	}

	public void setNotice_filepath(String notice_filepath) {
		this.notice_filepath = notice_filepath;
	}

	@Override
	public String toString() {
		return "Notice [notice_no=" + notice_no + ", notice_nickname=" + notice_nickname + ", notice_title="
				+ notice_title + ", notice_contents=" + notice_contents + ", notice_file=" + notice_file
				+ ", notice_date=" + notice_date + ", notice_visibility=" + notice_visibility + ", notice_filepath="
				+ notice_filepath + "]";
	}

	
}
