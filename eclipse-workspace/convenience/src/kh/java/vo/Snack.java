package kh.java.vo;

public class Snack extends Goods {
	private int kcal;
	private int weight;
	
	public Snack() {
		
	}
	public Snack(String name, int price, int stock, boolean adult, int kcal, int weight) {
		super(name,price,stock,adult);
		this.kcal=kcal;
		this.weight=weight;		
	}
	public int getKcal() {
		return kcal;
	}
	public int getWeight() {
		return weight;
	}
	public void setKcal(int kcal) {
		this.kcal=kcal;
	}
	public void setWeight(int weight) {
		this.weight=weight;
	}
}
