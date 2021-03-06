package kh.java.member.vo;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberPw;
	private String MemberName;
	private String gender;
	private int age;
	private String phone;
	private String hobby;
	private Date enrollDate;
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String memberId, String memberPw, String memberName, String gender, int age, String phone,
			String hobby, Date enrollDate) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		MemberName = memberName;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}
	@Override
	public String toString() {
		return memberId + "\t" + memberPw + "\t" + MemberName + "\t" + gender + "\t" + age + "\t" + phone + "\t" + hobby + "\t" + enrollDate;
	}
	public String getMemberName() {
		return MemberName;
	}
	public void setMemberName(String memberName) {
		MemberName = memberName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
}
