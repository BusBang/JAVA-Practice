package kr.or.iei.point;

public class Gold extends Grade{
	//grade ����, name ����, point ���� --> private ������ ������ �� ����. super�� �̿��ؾ���.
	//getter, setter ��� �Ϸ�
	public Gold() {

	}
	public Gold(String grade, String name, int point) {
		//�Ű����� ���� ��������
		super(grade,name,point); 
		// super�� ù�ٿ����� ȣ���� ����
		//this.grade = grade;
		//this.name = name;
		//this.point = point;
	}
	@Override //�������̵�? �θ��� �޼ҵ带 �ڽ��� �������ؼ� ����ϴ� ��. (�θ� ���� �޼ҵ带 �Է� �� ������ �˷���)
	public double getBonus() { //���� �̸��� ���� �޼ҵ忡 �Ű������� ��� �����ε��� �� �Ǿ��ϴµ� ? --> �������̵�
		return 0.05*getPoint(); //getPoint��� �޼ҵ带 ������.
	}
	

}
