package kr.or.iei.point;

public class Vvip extends Grade{
	public Vvip() {

	}
	public Vvip(String grade, String name, int point) {
		super(grade,name,point);
	}
	
	@Override
	public double getBonus() {
		return 0.1*getPoint();
	}
}
