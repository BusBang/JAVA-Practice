package kh.java.model.vo;

import java.io.Serializable;

public class Buylist implements Serializable{
	private static final long serialVersionUID = 11111111111L;
	private String userName;
	private String goodsName;
	private	int goodsPrice;
	public Buylist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buylist(String userName, String goodsName, int goodsPrice) {
		super();
		this.userName = userName;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	@Override
	public String toString() {
		return getUserName()+"\t"+getGoodsName()+"\t"+getGoodsPrice();
	}
	
	

}
