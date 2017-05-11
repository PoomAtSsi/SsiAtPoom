package org.poom.sap.member.model.vo;

import java.sql.Date;

public class Member {
	private String userid;
	private String userpwd;
	private String username;
	private String email;
	private String gender;
	private String phone;
	private String address;
	private String hobby;
	private Date birth;
	
	public Member(){}

	public Member(String userid, String userpwd, String username, String email,
			String gender, String phone,
			String address, String hobby, Date birth) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.birth = birth;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", email=" + email
				+ ", gender=" + gender + ", phone=" + phone + ", address=" + address + ", hobby=" + hobby + ", birth="
				+ birth + "]";
	}

	
}
