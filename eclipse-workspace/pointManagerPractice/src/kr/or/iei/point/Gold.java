package kr.or.iei.point;

public class Gold extends Silver{
	
	public Gold() {

	}
	public Gold(String grade, String name, int point) {
		super(grade, name, point);
	}
	
	@Override
	public double getBonus() {
		return 0.05*getPoint();
	}

}
