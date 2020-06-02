package kh.java.run;

import kh.java.test.Animal;
import kh.java.test.Tiger;

public class Start {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.crying();
		
		Tiger t = new Tiger();
		t.crying(); //상속했기 때문에 크라잉도 갖고 있음
		t.hunting();
		
		Animal at = new Tiger(); //상속받았기 때문에 다형성으로 이런 것도 가능함
		//부모타입은 자식타입을 받아줄 수 있음
		//부모가 좁은 의미. 자식이 부모 큰 의미(포함하고 있기 때문에)
		at.crying();
//		at.hunting(); //헌팅은 왜 불가능? -저장은 애니멀 타입으로 했기 때문에.
//		Upcasting : 자식이 부모타입으로 선언되어있기 때문에. -> 형변환을 해줘야한다.
		((Tiger)at).hunting();
		//애니멀타입인 at을 타이거타입으로 바꿔준 다음에 헌팅을 해줌
		
		


	}

}
