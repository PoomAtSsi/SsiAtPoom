package org.poom.sap.noriter.model.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Noriter implements java.io.Serializable{

	private int category;
	private int classNo;
	private String nickname;
	private String classTitle;
	private String detail;
	private MultipartFile video;
	private String career;
	private int water;
	private int like;
	private int count;
	private int hidden;
	private Date date;
	private int visibility;
	private String videopath;
	private String videoname;

	public Noriter(){};

	public Noriter(int category, int classNo, String nickname,
			String classTitle, String detail, MultipartFile video, String career,
			int water, int like, int count, int hidden, Date date,
			int visibility, String videopath, String videoname){
		super();
		this.category = category;
		this.classNo = classNo;
		this.nickname = nickname;
		this.classTitle = classTitle;
		this.detail = detail;
		this.video = video;
		this.career = career;
		this.water = water;
		this.like = like;
		this.count = count;
		this.hidden = hidden;
		this.date = date;
		this.visibility = visibility;
		this.videopath = videopath;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}


	public int getClassNo() {
		return classNo;
	}


	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getClassTitle() {
		return classTitle;
	}


	public void setClassTitle(String classTitle) {
		this.classTitle = classTitle;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public MultipartFile getVideo() {
		return video;
	}


	public void setVideo(MultipartFile video) {
		this.video = video;
	}


	public String getCareer() {
		return career;
	}


	public void setCareer(String career) {
		this.career = career;
	}


	public int getWater() {
		return water;
	}


	public void setWater(int water) {
		this.water = water;
	}


	public int getLike() {
		return like;
	}


	public void setLike(int like) {
		this.like = like;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public int getHidden() {
		return hidden;
	}


	public void setHidden(int hidden) {
		this.hidden = hidden;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public String getVideopath() {
		return videopath;
	}

	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}

	public String getVideoname() {
		return videoname;
	}

	public void setVideoname(String videoname) {
		this.videoname = videoname;
	}

	@Override
	public String toString() {
		return "Noriter [category=" + category + ", classNo=" + classNo + ", nickname=" + nickname + ", classTitle="
				+ classTitle + ", detail=" + detail + ", video=" + video + ", career=" + career + ", water=" + water
				+ ", like=" + like + ", count=" + count + ", hidden=" + hidden + ", date=" + date + ", visibility="
				+ visibility + ", videopath=" + videopath + ", videoname=" + videoname + "]";
	}

}
