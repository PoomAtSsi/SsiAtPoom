package org.poom.sap.member.model.vo;

import java.sql.Date;

public class Member {
	private String email;
	private String username;
	private String nickname;
	private String password;
	private String mobile;
	private Date regdate;
	private String profile;
	private String gender;
	private Date birth;
	private String introduce;
	private String career;
	private int email_agree;
	private int water;
	
	public Member(){}

	public Member(String email, String username, String nickname, String password,
			String mobile, Date regdate,
			String profile, String gender, Date birth,
			String introduce, String career, int email_agree, int water) {
		super();
		this.email = email;
		this.username = username;
		this.nickname = nickname;
		this.password = password;
		this.mobile = mobile;
		this.regdate = regdate;
		this.profile = profile;
		this.gender = gender;
		this.birth = birth;
		this.introduce = introduce;
		this.career = career;
		this.email_agree = email_agree;
		this.water = water;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public int getEmail_agree() {
		return email_agree;
	}

	public void setEmail_agree(int email_agree) {
		this.email_agree = email_agree;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", username=" + username + ", nickname=" + nickname + ", password=" + password
				+ ", mobile=" + mobile + ", regdate=" + regdate + ", profile=" + profile + ", gender=" + gender
				+ ", birth=" + birth + ", introduce=" + introduce + ", career=" + career + ", email_agree="
				+ email_agree + ", water=" + water + "]";
	}

	
}
