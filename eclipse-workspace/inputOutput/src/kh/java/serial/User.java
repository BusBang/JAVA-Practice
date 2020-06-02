package kh.java.serial;

import java.io.Serializable;

public class User implements Serializable{ //����ȭ�� �����ϰ� ��
	private static final long serialVersionUID = 11111111111L; //�ø��� ���� �����̵�
	private String id;
	private String pw; //transient �����ϱ�
	private int age;
	private String addr; //�߰��ϴ��� ���ư�
	private Score Score; //transient�� ���� ������ ���ư��� �ʴ´�. ArrayList�� ��

	
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
