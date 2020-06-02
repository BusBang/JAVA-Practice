package kh.java.function;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 입력 :");
		int num1 = sc1.nextInt();
		System.out.print("두 번째 정수 입력 :");
		int num2 = sc1.nextInt();
		
		System.out.println("========== 결과 ==========");
		System.out.println("더하기 결과 :"+(num1+num2));
		System.out.println("빼기 결과 :"+(num1-num2));
		System.out.println("곱하기 결과 :"+(num1*num2));
		System.out.println("나누기 몫 :"+(num1/num2));
		System.out.println("나누기 나머지 :"+(num1%num2));
	}
	
	public void exam2() {
		Scanner sc2 = new Scanner(System.in);
		System.out.print("가로 길이 입력 :");
		double wide = sc2.nextDouble();
		System.out.print("세로 길이 입력 :");
		double depth = sc2.nextDouble();
		
		System.out.println("========== 결과 ==========");
		System.out.println("면적 :"+(wide*depth));
		System.out.println("둘레 :"+2*(wide+depth));
	}
	
	public void exam3() {
		Scanner sc3 = new Scanner(System.in);
		System.out.print("영어단어 입력 :");
		String voca = sc3.nextLine();

		System.out.printf("첫 번째 문자 :%c\n",voca.charAt(0));
		System.out.printf("두 번째 문자 :%c\n",voca.charAt(1));
		System.out.printf("세 번째 문자 :%c\n",voca.charAt(2));
		
	}

}
