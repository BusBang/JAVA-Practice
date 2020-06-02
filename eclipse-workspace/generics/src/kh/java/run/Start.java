package kh.java.run;

import kh.java.test.Animal;
import kh.java.test.AnimalMgr;
import kh.java.test.AnimalMgr2;
import kh.java.test.Bear;
//import kh.java.test.GenericEX;
import kh.java.test.Tiger;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		GenericEX<T> ge = new GenericEX<T>();
//		ge.setData("test");
		Tiger t1 = new Tiger(1000); // 1. hp 1000인 Tiger 객체의 주소가 t1임
		AnimalMgr am1 = new AnimalMgr(t1); // 2.AnimalMgr 생성자의 매개변수 타입은 Object. 다형성에 의해서 Tiger객체의 주소가 Object 타입 변수에 저장
		//AnimalMgr의 생성자에는 Object타입의 data를 매개변수로 넣어줘야함
		//14번 줄에서 t1에 1000이라는 데이터를 넣어줌
		//부모 타입으로 업 캐스팅 되어있는 상태
		AnimalMgr am2 = new AnimalMgr(new Bear(2000));
		//3. am1에 있는 data변수의 값을 가져오려고 하는데 ? 데이터 타입은? -> Object
		Object obj1 = am1.getData();
		Object obj2 = am2.getData();
		System.out.println(obj1); // 주소값만 출력 된다.		
		//GetData의 자료형은 Object. 주소는? -> Tiger 개체의 주소가 들어있음.
		//그 주소의 값을 불러오기 위해 (Tiger)로 묶어서 다운캐스팅해준다. --> 부모타입 Object에는 getHp()메소드가 존재하지 않기 때문에.
		//이런 부분의 복잡함을 해결해주는 것이 제네릭임
		((Tiger)am1.getData()).getHp(); //그래서 부모를 자식으로 바꿈 (다운캐스팅을 한 것)
		((Bear) am2.getData()).getHp();
		
		//제네릭 적용
		AnimalMgr2<Tiger> a1 = new AnimalMgr2<Tiger>(t); //a1에서 t라고 되어있는 것이 모두 Tiger 타입으로 바뀌는 것
		AnimalMgr2<Bear> a2 = new AnimalMgr2<Bear>(b); //a2에서 b라고 되어있는 것이 모두 Bear 타입으로 바뀌는 것
		
		a1.getData().getHp(); //다운캐스팅을 할 필요가 없음. 왜냐하면 getData타입은 Tiger타입이라서. 
		a2.getData().getHp(); //다운캐스팅을 할 필요가 없음. 왜냐하면 getData타입은 Bear타입이라서.
		
		AnimalMgr2<Animal> amm1 = new AnimalMgr2<Animal>(new Animal());
		AnimalMgr2<Tiger> amm2 = new AnimalMgr2<Tiger>(new Tiger());
		AnimalMgr2<Bear> amm3 = new AnimalMgr2<Bear>(new Bear()); //Bear의 경우 import도 했지만 사용 불가가 뜸. AnimalMgr2의 조건에 extends Animal이 걸려있기 때문.


	}

}
