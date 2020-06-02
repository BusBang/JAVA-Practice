package kh.java.run;

import java.util.Timer;

import kh.java.test.Test1;

public class Start {

	public static void main(String[] args) {
		
		Test1 t1 = new Test1();
		System.out.println(t1); //t1에는 toString을 생략되어 있는 것이다.
		System.out.println(t1.toString());
		
		//Test1클래스의 clone()메소드의 리턴타입은 Object임.
		//다형성은 부모타입 레퍼런스 자식타입 객체를 저장
		Test1 t2 = (Test1)t1.clone(); //그냥 하면 Object에서 Test1에 넣으려 해서 오류가 발생함. (Test1). 다운캐스팅을 이용해 넣어준다.
		System.out.println(t1);
		System.out.println(t2);
		//clone 순서
		//1) Test1의 implements Cloneable을 해준다
		//2) public Object clone() {}을 만들어준다.
		//3) 복사할 변수 = (형변환)이전변수.clone();을 실행해준다.
		
		
		//kh.java.test. : 패키지 이름
		//Test1 : 클래스 이름
		//@ : 의미없음 (구분자)
		//7852e922 : 인스턴스 식별값
		
		//String 값 비교시 사용했던 equals
		String str1 = new String("Hello");
		String str2 = new String("Hello");
		if(str1.equals(str2)) {
			System.out.println("같습니다. ");
		}else {
			System.out.println("다릅니다. ");
		}
		//equlas를 안쓰면 다릅니다가 출력.
		//new String을 안 쓰고 "Hello"만 쓰면 같습니다가 출력

		


	}

}
