package kr.or.iei.point;

public class Silver {
	
	private String grade;
	private String name;
	private int point;
	private double bonus;
	
	//기본생성자
	public Silver() {
		
	}
	
	//매개변수 있는 생성자
	public Silver(String grade, String name, int point) {
		this.grade = grade;
		this.name = name;
		this.point = point;
		this.bonus = point*0.02;
	}
	
	public String getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	public double getBonus() {
		return bonus;
	}
	public void setGrade(String grade) {
		this.grade=grade;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPoint(int point) {
		this.point=point;
	}
	public void setBonus(double bonus) {
		this.bonus=bonus;
	}	

}
