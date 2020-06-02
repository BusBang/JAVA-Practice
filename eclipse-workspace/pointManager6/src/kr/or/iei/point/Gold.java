package kr.or.iei.point;

public class Gold extends Grade{
	public Gold() {
		
	}
	public Gold(String grade, String name, int point) {
		super(grade, name, point);

	}
	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return 0.05*getPoint();
	}

}
