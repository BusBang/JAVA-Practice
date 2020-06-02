package kh.java.model.vo;

import java.io.Serializable;

public class Goods implements Serializable{
	private static final long serialVersionUID = 11111111111L;
	private String goodsName;
	private int goodsPrice;
		
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
	public Goods(String goodsName, int goodsPrice) {
		super();
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
	}
	public Goods() {
		super();
		
	}
	@Override
	public String toString() {
		return getGoodsName()+"\t"+getGoodsPrice();
	}

}
