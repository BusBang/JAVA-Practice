package kh.java.test;

public class Test1 implements Cloneable {
	//public class Test1 implements Cloneable
	//���ݺ��� Test1�̶�� �ִ� ������ ������ �ž�. ��� �����ִ� ��
	
	private int data;
	public Test1() {
		
	}
	public Test1(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	@Override
	public Object clone() { //�θ�Ŭ������ Object�� Ŭ��Ÿ���� �����ϴ� ���� �������ִ°�
		// super ����Ŭ������ �����ڸ� �θ��� ��
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
