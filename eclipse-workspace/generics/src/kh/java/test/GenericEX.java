package kh.java.test;

public class GenericEX<T> {
	private T data;
	//������, getter, setter
	public GenericEX() {
		
	}
	public GenericEX(T data) {
		this.data=data;
	}
	public T GetData() {
		return data;
	}
	public void setData(T data) {
		this.data=data;
	}
	
	

}
