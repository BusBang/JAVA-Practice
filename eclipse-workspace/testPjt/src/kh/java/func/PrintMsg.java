package kh.java.func;

public class PrintMsg/*기능제공클래스는 main이 없다*/ {
	public void printHello() {
		System.out.println("Hello");
	}
	public void printHi() {
		System.out.println("Hi");
	}
	public void test() {
		System.out.println(1+1); //정수 2
		System.out.println(1.1+1.1); //실수 2.2
		System.out.println('1'+'1'); //문자 11이 아닌 98이 나옴 왜? 
		//(아스키코드에서 1은 49. 그러므로 49+49=98. 유니코드 앞 부분이 아스키 코드표와 같기 때문에 아스키코드만 봐도 됨. 문자를 숫자로 바꿨지만 다시 문자로 바꿔주진 않음)
		System.out.println("1"+" 1"); //문자열 1 1 (문자열을 더하면 그냥 붙여버린다. 공백을 넣으면 공백도 글자로 인식해서 나옴
		
		System.out.println(1+1.1); //실수 2.1 (정수+실수=실수)
		System.out.println(1+'1'); //정수 50 (정수+문자=정수)
		System.out.println(1.1+'1'); //실수 2.1 (실수+문자=실수. 1번과 동일
		System.out.println("HI"+1); //문자열HI1 (더하기의 경우, 문자열이 우선 순위가 높아서 다른 데이터를 문자열로 변환하여 문자열+문자열 연산)
	}

	
	

}

//기능제공클래스는 어떻게 실행할가?
//import를 한다! (같은 패키지 안에 있으면 임포트를 안 해줘도 됨. 같은 패키지 = 같은 폴더

