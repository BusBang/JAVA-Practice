package kh.java.serial;

import java.io.Serializable;

public class User implements Serializable{ //직렬화가 가능하게 됨
	private static final long serialVersionUID = 11111111111L; //시리얼 버전 유아이디
	private String id;
	private String pw; //transient 제외하기
	private int age;
	private String addr; //추가하더라도 돌아감
	private Score Score; //transient를 하지 않으면 돌아가지 않는다. ArrayList는 됨

	
	public Score getScore() {
		return Score;
	}
	public void setScore(Score score) {
		Score = score;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public User() {
		super();
	}
	public User(String id, String pw, int age, Score score) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.Score = score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
