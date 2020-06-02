package kh.java.run;
import kh.java.func.MethodTest;
import java.util.Scanner;
import kh.java.func.Exam;
import kh.java.func.BR;


public class Start {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BR br1 = new BR();
		br1.main();
		
//		//오버로딩 테스트. (void로 출력하기)
//		MethodTest sumTest = new MethodTest();
//		int result1 = sumTest.sum(10, 20); 
//		System.out.println(result1);
//		int result2 = sumTest.sum(10, 20, 30);
//		System.out.println(result2);

		/*
		Exam e = new Exam();
		int [] arr = {1,2,3,4,5};
		System.out.println(arr[2]); 
		e.testFunction(arr[2]);			//testFunction 메소드를 이용해 arr[2]를 받고 100을 넣어줌
		System.out.println(arr[2]);		//근데 산출 값은 3. (해당값만 넘긴것이라서 그런것)
		e.testFunction2(arr);			//주소를 넘긴다
		System.out.println(arr[2]);		//리턴 값은 100. (해당값이 아닌 주소 값이 변화된 것이라 바뀐 것). 참조형 데이터의 주소형을 수정하면 원본 데이터가 수정된다.
		//정확히 말하면 '보내는 것'이 아니고 '불러온 값을 수정한다'라고 말한다.
		*/
		
		
//		//e.changeChar();
//		//변수 e는 changeChar라는 메소드에서 온 것.
//		System.out.print("영문자 입력 : ");
//		char ch= sc.next().charAt(0);
//		System.out.println("====== 변환 ======");
//		char ch2 = e.changeChar(ch); //변수 e는 Exam클래스 속 changeChar메소드에서 왔으며 (ch를 매개변수로 받음)
//		//ch를 매개변수로 받아서 changeChar 메소드를 거친후 char ch2로 반환.
//		System.out.println(ch+"-->"+ch2);


//		MethodTest test1 = new MethodTest();
//		test1.main();
//		int result = test1.sum(10,20);
//		System.out.println(result);
		// TODO Auto-generated method stub

	}

}
