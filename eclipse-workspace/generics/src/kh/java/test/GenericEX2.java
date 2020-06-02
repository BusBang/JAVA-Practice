package kh.java.test;

public class GenericEX2<G, T> {
	private G data1;
	private T data2;
	public GenericEX2() {
		
	}
	public GenericEX2(G data1, T data2) {
		this.data1=data1;
		this.data2=data2;
	}
	public G GetData1() {
		return data1;
	}

	public T GetData2() {
		return data2;
	}
	public void setData1(G data) {
		this.data1=data;
	}
	public void setData2(T data) {
		this.data2=data;
	}
	

}
