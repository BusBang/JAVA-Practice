package kh.java.run;

public class Testclass {
	int num;
	
	public void test() {
		int num1;
		System.out.println(num); 	// 전역 변수는 자동으로 초기화되기 때문에 바로 사용을 할 수 있다.
		System.out.println(num1);	// 지역 변수는 초기화가 안 되기 때문에 반드시 초기화를 거쳐줘야 사용 가능하다
	}

}
