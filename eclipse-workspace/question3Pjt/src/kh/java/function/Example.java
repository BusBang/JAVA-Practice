package kh.java.function;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner q3 = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 입력 :");
		int inputFirst = q3.nextInt();
		
		System.out.print("두 번째 정수 입력 :");
		int inputSecond = q3.nextInt();
		
		System.out.println("=========== 결과 ===========");
		System.out.println("더하기 결과 :" +(inputFirst+inputSecond));
		System.out.println("빼기 결과 :" +(inputFirst-inputSecond));
		System.out.println("곱하기 결과 :" +(inputFirst*inputSecond));
		System.out.println("나누기 몫 :" +(inputFirst/inputSecond));
		System.out.println("나누기 나머지 :" +(inputFirst%inputSecond));
		
		
	}

	public void exam2() {
		Scanner q4 = new Scanner(System.in);
		
		System.out.print("가로 길이 입력 :");
		double num1 = q4.nextDouble();		
		System.out.print("세로 길이 입력 :");
		double num2 = q4.nextDouble();	
		System.out.println("=========== 결과 ===========");
		System.out.println("면적 :"+(num1*num2));
		System.out.println("둘레 :"+2*(num1+num2));
	}
	public void exam3() {
		Scanner q5 = new Scanner(System.in);
		
		System.out.print("영어단어 입력 :");
		String voca = q5.nextLine();
		//변수.charAt(index) --> String 형식 변수의 문자를 한 글자씩 가져올 수 있다.
		System.out.println("첫 번째 문자 :"+voca.charAt(0));
		System.out.println("두 번째 문자 :"+voca.charAt(1));
		System.out.println("세 번째 문자 :"+voca.charAt(2));
		
	}
	
	
}
