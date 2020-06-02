package kh.java.practice;

import java.util.Scanner;

public class Sample {
	
	Scanner sc = new Scanner(System.in);
	
	public void sample1() {
		System.out.print("문자 입력 : ");
		char inputChar = sc.next().charAt(0);
		System.out.println((int)inputChar);
	}
	public void sample2() {
		System.out.print("국어 점수 입력 : ");
		double kor = sc.nextDouble();
		System.out.print("수학 점수 입력 : ");
		double math = sc.nextDouble();
		System.out.print("영어 점수 입력 : ");
		double eng = sc.nextDouble();
		System.out.println("=========결과=========");
		System.out.println("총점 : "+(int)(kor+math+eng));
		System.out.println("평균 : "+(int)((kor+math+eng)/3));
	}

}
