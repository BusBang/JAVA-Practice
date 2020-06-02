package kh.java.vo;

public class Goods {
	//가격, 재고, 상품이름, 성인인증필요 유무
	private String name;
	private int price;
	private int stock;
	private boolean adult;	
	
	//기본 생성자, 매개변수생성자, getter, setter
	public Goods() {
		
	}
	public Goods(String name, int price, int stock, boolean adult) {
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.adult = adult;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public boolean getAdult() {
		return adult;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	public void setStock(int stock) {
		this.stock=stock;
	}
	public void setAdult(boolean adult) {
		this.adult=adult;
	}
}
