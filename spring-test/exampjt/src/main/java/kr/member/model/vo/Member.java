package kr.member.model.vo;

public class Member {
	private int seq;
	private String id;
	private String name;
	private String regDate;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Member(int seq, String id, String name, String regDate) {
		super();
		this.seq = seq;
		this.id = id;
		this.name = name;
		this.regDate = regDate;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
