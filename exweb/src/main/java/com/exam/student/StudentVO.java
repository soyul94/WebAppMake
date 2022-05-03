package com.exam.student;

public class StudentVO {
	
	private String stu_no;
	private String stu_name;
	private int stu_score;
	
	public StudentVO(String stu_no, String stu_name, int stu_score) {
		this.stu_no = stu_no;
		this.stu_name = stu_name;
		this.stu_score = stu_score;
	}

	public StudentVO() {
	}

	public String getStu_no() {
		return stu_no;
	}

	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public int getStu_score() {
		return stu_score;
	}

	public void setStu_score(int stu_score) {
		this.stu_score = stu_score;
	}

	@Override
	public String toString() {
		return "- stu_no=" + stu_no + ", stu_name=" + stu_name + ", stu_score=" + stu_score;
	}
	
	
	
}
