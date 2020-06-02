package kh.or.iei.vo;

public class Silver extends Grade{
	
	public Silver () {
		
	}
	
	public Silver (String grade, String name, int point) {
		super(grade, name, point);
	}
	
	@Override
	public double getBonus() {
		// TODO Auto-generated method stub
		return getPoint()*0.01;
	}
}
