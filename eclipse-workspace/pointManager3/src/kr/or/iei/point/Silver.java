package kr.or.iei.point;

public class Silver extends Grade{
	//�⺻������
	public Silver() {

	}
	
	//�Ű����� �ִ� ������
	public Silver(String grade, String name, int point) {
		super(grade, name, point);
	}

	@Override
	public double getBonus() {
		return 0.02*getPoint();
	}
	
}
