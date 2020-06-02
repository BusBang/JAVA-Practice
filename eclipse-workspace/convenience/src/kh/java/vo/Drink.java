package kh.java.vo;

public class Drink extends Goods{
	private int amount;
	private int kcal;
	
	public Drink() {
		
	}
	public Drink(String name, int price, int stock, boolean adult, int amount, int kcal) {
		super(name,price,stock,adult);
		this.amount=amount;
		this.kcal = kcal;
	}
	public int getAmount() {
		return amount;
	}
	public int getKcal() {
		return kcal;
	}
	public void setAmount(int amount) {
		this.amount=amount;
	}
	public void setKcal(int kcal) {
		this.kcal=kcal;
	}
	
	@Override
	public String toString() {
		String str = getName()+"\t"+getPrice()+"\t"+getStock()+"\t"+(getAdult()?"O":"X")+"\t"+getAmount()+"\t"+getKcal();
		return str;
	}
	

}
