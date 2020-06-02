package kr.or.iei.vo;

//데이터가 되는 클래스
public class Student {
	// 이름 나이 주소
	private String name;
	private int age;
	private String addr;
	
	@Override
	public String toString() {
		String str = name+"\t"+age+"\t"+addr;
		return str;
	}

	// 기본 생성자 - 클래스명과 동일한 메소드 생성, 내용은 비워둠
	public Student() {

	}

	// 매개변수 생성자 - 클래스명과 동일하며, 지역변수를 바꿔줄 수 있게 this구문을 써줌
	public Student(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	// Getter
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddr() {
		return addr;
	}

	// Setter
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
