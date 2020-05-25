package member.model.vo;

import java.sql.Date;

public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	private String memberName;
	private int companyNo;
	private String phone;
	private Date enrollDate;
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getCompanyNo() {
		return companyNo;
	}
	public void setCompanyNo(int companyNo) {
		this.companyNo = companyNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(int memberNo, String memberId, String memberPw, String memberName, int companyNo, String phone,
			Date enrollDate) {
		super();
		this.memberNo = memberNo;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.companyNo = companyNo;
		this.phone = phone;
		this.enrollDate = enrollDate;
	}
	

}
