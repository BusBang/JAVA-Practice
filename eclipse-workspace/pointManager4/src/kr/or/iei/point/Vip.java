package kr.or.iei.point;

public class Vip extends Grade{
	public Vip() {

	}
	public Vip(String grade, String name, int point) {
		super(grade, name, point);
	}
	
	@Override
	public double getBonus() {
		return 0.05*getPoint();
	}

}
