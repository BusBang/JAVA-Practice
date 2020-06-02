package kr.or.iei.point;

public class Vip extends Grade{
	public Vip () {
		
	}

	public Vip(String grade, String name, int point) {
		super(grade, name, point);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return 0.1*getPoint();
	}


}
