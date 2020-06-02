package kr.or.iei.point;

public class Silver {
	
	private String grade;
	private String name;
	private int point; //보너스 포인트에 종속되는 값으로서 변수를 만들지 않아도 된다.
	//또한, 보너스 포인트의 경우, 직접 입력하지 않고 계산만 해주면 된다.
	
	//기본생성자
	public Silver() {
		
	}
	
	//매개변수 있는 생성자
	public Silver(String grade, String name, int point) {
		this.grade = grade;
		this.name = name;
		this.point = point;
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
		return 0.02*point;
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

}
