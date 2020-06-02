package kh.java.function;

import java.util.Scanner;

public class Example {
	Scanner sc= new Scanner(System.in);
	public void exam1() {
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.println("========결과========");
		System.out.println("더하기 결과 : "+(num1+num2));
		System.out.println("빼기 결과 : "+(num1-num2));
		System.out.println("나누기 결과 : "+(num1/num2));
		System.out.println("나머지 결과 : "+(num1%num2));
	}
	public void exam2() {

		System.out.print("가로 입력 : ");
		double wide = sc.nextDouble();
		System.out.print("세로 입력 : ");
		double depth = sc.nextDouble();
		System.out.println("=====결과=====");
		System.out.println("면적 : "+(wide*depth));
		System.out.println("둘레 : "+(2*(wide+depth)));


	}

}
