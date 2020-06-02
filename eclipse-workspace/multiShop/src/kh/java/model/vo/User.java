package kh.java.model.vo;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 11111111111L;
	private String userName;
	private String userNumb;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String userNumb) {
		super();
		this.userName = userName;
		this.userNumb = userNumb;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNumb() {
		return userNumb;
	}
	public void setUserNumb(String userNumb) {
		this.userNumb = userNumb;
	}
	@Override
	public String toString() {
		return getUserName()+"\t"+getUserNumb();
	}
	
}
