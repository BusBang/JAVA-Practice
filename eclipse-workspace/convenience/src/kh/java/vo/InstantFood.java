package kh.java.vo;

public class InstantFood extends Goods {
	private String expired;
	private int kcal;
	
	public InstantFood() {
		
	}
	public InstantFood(String name, int price, int stock, boolean adult, String expired, int kcal) {
		super(name,price,stock,adult);
		this.expired=expired;
		this.kcal=kcal;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired=expired;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal=kcal;
	}
	
	
	@Override
	public String toString() {
		String str = getName()+"\t"+getPrice()+"\t"+getStock()+"\t"+(getAdult()?"O":"X")+"\t"+getExpired()+"\t"+getKcal();
		return str;
	}
}
