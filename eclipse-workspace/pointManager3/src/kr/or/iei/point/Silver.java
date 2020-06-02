package kr.or.iei.point;

public class Silver extends Grade{
	//기본생성자
	public Silver() {

	}
	
	//매개변수 있는 생성자
	public Silver(String grade, String name, int point) {
		super(grade, name, point);
	}

	@Override
	public double getBonus() {
		return 0.02*getPoint();
	}
	
}
