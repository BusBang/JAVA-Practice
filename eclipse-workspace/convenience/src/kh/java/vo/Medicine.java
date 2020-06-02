package kh.java.vo;

public class Medicine extends Goods{
	private String expired;
	
	public Medicine() {
		
	}
	public Medicine(String name, int price, int stock, boolean adult, String expired) {
		super(name,price,stock,adult);
		this.expired=expired;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpored(String expired) {
		this.expired=expired;
	}
}
