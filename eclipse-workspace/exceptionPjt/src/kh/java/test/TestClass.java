package kh.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestClass {
	Scanner sc= new Scanner(System.in);
	public void test1() {
		System.out.println("나눗셈 프로그램");
		System.out.print("첫 번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 수 입력 : ");
		int num2 = sc.nextInt();
		try {			
			int result = num1/num2; ///에러발생시 그 코드진행을 멈추고 바로 catch로 빠쳐나감
			System.out.println("결과 : "+result);
		}catch (Exception e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		}
	}
	public void menuPrint() {
		System.out.println("골라봐");
		System.out.println("1. 정지엽 지각");
		System.out.println("2. 언제 오는거죠?");
		System.out.println("3. 안와도... 크흠");
		System.out.print("입력 : ");
	}
	public void test2(int choice) {
		switch(choice) {
			case 1 : 
				System.out.println("정지엽 지각");
				break;
			case 2: 
				System.out.println("언제오는 거죠?");
				break;
			case 3:
				System.out.println("안와도 .. 크흠");
				break;
			default :
				System.out.println("1~3사이 값을 입력해주세요");
				break;
		}
	}
	public void start() {
		int choice = 0;
		menuPrint();
		try {
		choice = sc.nextInt();
		test2(choice);
		}catch (Exception e){
			System.out.println("숫자만 가능합니다.");
		}finally{
			System.out.println("프로그램이 종료됩니다");
		}
	}
	
	public void test3() throws FileNotFoundException{
			FileInputStream fis = new FileInputStream("Test.txt");
	}
	public void test4() throws FileNotFoundException {
		test3();
	}
	public void div(int num1, int num2) {
		if(num2 ==0) {
			throw new ExceptionTest2("0000으로 나누기 불가");
//			try {
//				throw new ExceptionTest1("0으로 나눌 수 없습니다.");
//			} catch (ExceptionTest1 e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println(num1/num2);
		
	}

}
