package kh.java.test;

public class Test1 implements Cloneable {
	//public class Test1 implements Cloneable
	//지금부터 Test1이라는 애는 복제가 가능한 거야. 라고 말해주는 것
	
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
	public Object clone() { //부모클래스인 Object의 클론타입을 복사하는 것을 선언해주는것
		// super 상위클래스의 생성자를 부르는 것
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
