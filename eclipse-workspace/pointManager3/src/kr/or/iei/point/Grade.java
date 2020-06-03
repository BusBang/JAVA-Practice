package kr.or.iei.point;

public abstract class Grade { //Ŭ���������� �߻�ȭ. ��ӿ����� ������� Ŭ����. �ƿ� �������� ��üȭ�� �Ұ���
	private String grade;
	private String name;
	private int point;
	
	public Grade() {
		
	}
	
	public Grade(String grade, String name, int point) {
		this.grade=grade;
		this.name=name;
		this.point=point;
	}
	public String getGrade() {
		return grade;
	}
	public String getName() {
		return name;
	}
	public int getPoint() {
		return point;
	}
	public abstract double getBonus(); //�߻�ȭ
	
	public void setGrade(String grade) {
		this.grade=grade;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPoint(int point) {
		this.point=point;
	}
}