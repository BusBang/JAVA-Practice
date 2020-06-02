package kr.or.iei.point;

public abstract class Grade { //클래스에서의 추상화. 상속용으로 만들어진 클래스. 아예 독립적인 객체화가 불가능
	private String grade;
	private String name;
	private int point;
	
	public Grade() {
		
	}
	
	public Grade(String grade, String name, int point) {
		this.grade=grade;
		this.name=name;
		this.point=point;
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
	public abstract double getBonus(); //추상화
	
	public void setGrade(String grade) {
		this.grade=grade;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPoint(int point) {
		this.point=point;
	}
}
