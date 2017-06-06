package org.poom.sap.message.model.vo;

import java.sql.Date;

public class Message {
	private int m_num;
	private String m_sender;
	private String m_receiver;
	private Date m_time;
	private String m_contents;
	private int m_count;
	
	//로그인 된 회원기준으로 메세지 값 불러오기 위해 만듦
	private String onUser;
	
	public String getOnUser() {
		return onUser;
	}

	public void setOnUser(String onUser) {
		this.onUser = onUser;
	}

	public int getM_num() {
		return m_num;
	}

	public void setM_num(int m_num) {
		this.m_num = m_num;
	}

	public String getM_sender() {
		return m_sender;
	}

	public void setM_sender(String m_sender) {
		this.m_sender = m_sender;
	}

	public String getM_receiver() {
		return m_receiver;
	}

	public void setM_receiver(String m_receiver) {
		this.m_receiver = m_receiver;
	}

	public Date getM_time() {
		return m_time;
	}

	public void setM_time(Date m_time) {
		this.m_time = m_time;
	}

	public String getM_contents() {
		return m_contents;
	}

	public void setM_contents(String m_contents) {
		this.m_contents = m_contents;
	}

	public int getM_count() {
		return m_count;
	}

	public void setM_count(int m_count) {
		this.m_count = m_count;
	}

	
	
}
