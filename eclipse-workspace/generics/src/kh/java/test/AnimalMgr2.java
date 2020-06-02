package kh.java.test;

public class AnimalMgr2<T extends Animal> { //제네릭을 이용하자. //애니멀을 포함하거나 애니멀을 상속한 친구들만 사용할 수 있음 (Tiger만 상속했기 때문에 Bear는 안 됨)
	private T data;
	public AnimalMgr2() {
		
	}
	public AnimalMgr2(T data) {
		this.data=data;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data=data;
	}
}
