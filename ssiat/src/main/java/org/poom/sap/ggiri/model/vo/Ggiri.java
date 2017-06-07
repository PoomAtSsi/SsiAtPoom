package org.poom.sap.ggiri.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Ggiri implements Serializable{
	private int cat_no;
	private int g_no;
	private String g_title;
	private String g_nickname;
	private int category;
	private String g_detail;
	private String g_career;
	private String g_file;
	private String g_location;
	private Date g_dday;
	private int g_minppl;
	private int g_maxppl;
	private int g_countppl;
	private int g_fee;
	private int g_like;
	private int g_visibility;
	private double g_lx;
	private double g_ly;
	
	//join
	private int g_j_no;
	private String g_j_nickname;
	
	//like
	private int g_l_no;
	private String g_l_nickname;
	
	
	public Ggiri(){}
	
	public Ggiri(int g_j_no, String g_j_nickname,int g_l_no, String g_l_nickname) {
		super();
		this.g_j_no = g_j_no;
		this.g_j_nickname = g_j_nickname;
		this.g_l_no = g_l_no;
		this.g_l_nickname = g_l_nickname;
	}
	

	public int getG_l_no() {
		return g_l_no;
	}

	public void setG_l_no(int g_l_no) {
		this.g_l_no = g_l_no;
	}

	public String getG_l_nickname() {
		return g_l_nickname;
	}

	public void setG_l_nickname(String g_l_nickname) {
		this.g_l_nickname = g_l_nickname;
	}

	public int getCat_no(){
		return cat_no;
	}
	
	public void setCat_no(int cat_no){
		this.cat_no = cat_no;
	}

	public int getG_no() {
		return g_no;
	}

	public void setG_no(int g_no) {
		this.g_no = g_no;
	}

	public String getG_title() {
		return g_title;
	}

	public void setG_title(String g_title) {
		this.g_title = g_title;
	}

	public String getG_nickname() {
		return g_nickname;
	}

	public void setG_nickname(String g_nickname) {
		this.g_nickname = g_nickname;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getG_detail() {
		return g_detail;
	}

	public void setG_detail(String g_detail) {
		this.g_detail = g_detail;
	}

	public String getG_career() {
		return g_career;
	}

	public void setG_career(String g_career) {
		this.g_career = g_career;
	}

	public String getG_file() {
		return g_file;
	}

	public void setG_file(String g_file) {
		this.g_file = g_file;
	}

	public String getG_location() {
		return g_location;
	}

	public void setG_location(String g_location) {
		this.g_location = g_location;
	}

	public Date getG_dday() {
		return g_dday;
	}

	public void setG_dday(Date g_dday) {
		this.g_dday = g_dday;
	}

	public int getG_minppl() {
		return g_minppl;
	}

	public void setG_minppl(int g_minppl) {
		this.g_minppl = g_minppl;
	}

	public int getG_maxppl() {
		return g_maxppl;
	}

	public void setG_maxppl(int g_maxppl) {
		this.g_maxppl = g_maxppl;
	}

	public int getG_countppl() {
		return g_countppl;
	}

	public void setG_countppl(int g_countppl) {
		this.g_countppl = g_countppl;
	}

	public int getG_fee() {
		return g_fee;
	}

	public void setG_fee(int g_fee) {
		this.g_fee = g_fee;
	}

	public int getG_like() {
		return g_like;
	}

	public void setG_like(int g_like) {
		this.g_like = g_like;
	}

	public int getG_visibility() {
		return g_visibility;
	}

	public void setG_visibility(int g_visibility) {
		this.g_visibility = g_visibility;
	}

	public double getG_lx() {
		return g_lx;
	}

	public void setG_lx(double g_lx) {
		this.g_lx = g_lx;
	}

	public double getG_ly() {
		return g_ly;
	}

	public void setG_ly(double g_ly) {
		this.g_ly = g_ly;
	}

	public int getG_j_no() {
		return g_j_no;
	}

	public void setG_j_no(int g_j_no) {
		this.g_j_no = g_j_no;
	}

	public String getG_j_nickname() {
		return g_j_nickname;
	}

	public void setG_j_nickname(String g_j_nickname) {
		this.g_j_nickname = g_j_nickname;
	}

	public Ggiri(int cat_no,int g_no, String g_title, String g_nickname, int category, String g_detail, String g_career,
			String g_file, String g_location, Date g_dday, int g_minppl, int g_maxppl, int g_countppl, int g_fee,
			int g_like, int g_visibility, double g_lx, double g_ly) {
		super();
		this.cat_no = cat_no;
		this.g_no = g_no;
		this.g_title = g_title;
		this.g_nickname = g_nickname;
		this.category = category;
		this.g_detail = g_detail;
		this.g_career = g_career;
		this.g_file = g_file;
		this.g_location = g_location;
		this.g_dday = g_dday;
		this.g_minppl = g_minppl;
		this.g_maxppl = g_maxppl;
		this.g_countppl = g_countppl;
		this.g_fee = g_fee;
		this.g_like = g_like;
		this.g_visibility = g_visibility;
		this.g_lx = g_lx;
		this.g_ly = g_ly;
	}

	@Override
	public String toString() {
		return "Ggiri [g_no=" + g_no + ", g_title=" + g_title + ", g_nickname=" + g_nickname + ", category="
				+ category + ", g_detail=" + g_detail + ", g_career=" + g_career + ", g_file=" + g_file
				+ ", g_location=" + g_location + ", g_dday=" + g_dday + ", g_minppl=" + g_minppl + ", g_maxppl="
				+ g_maxppl + ", g_countppl=" + g_countppl + ", g_fee=" + g_fee + ", g_like=" + g_like
				+ ", g_visibility=" + g_visibility + ", g_lx=" + g_lx + ", g_ly=" + g_ly + ", g_j_no=" + g_j_no
				+ ", g_j_nickname=" + g_j_nickname + "g_l_nickname" +"="+ g_l_nickname+","+g_l_no;
	}

}
