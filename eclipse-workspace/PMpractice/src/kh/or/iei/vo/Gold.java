package kh.or.iei.vo;

public class Gold extends Grade {

	public Gold() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Gold(String grade, String name, int point) {
		super(grade, name, point);
	}

	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return getPoint()*0.5;
	}

}
