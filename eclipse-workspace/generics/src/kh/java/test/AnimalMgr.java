package kh.java.test;

public class AnimalMgr {
	private Object data; //데이터 타입을 오브젝트로 생성함. 다형성을 이용함
	
	public AnimalMgr() {
		
	}
	public AnimalMgr(Object data) {
		this.data=data;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data=data;
	}

}
