package kh.java.chapter3.vo;

import java.util.Scanner;

public class Data {
	Scanner sc = new Scanner(System.in);
	public void example1() {
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("주소 입력 : ");
		String addr = sc.next();
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		System.out.print("몸무게 입력 : ");
		double weight = sc.nextDouble();
		System.out.print("성별 입력 : ");
		char sex = sc.next().charAt(0);
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("주소 : "+addr);
		System.out.println("키 : "+(int)height);
		System.out.printf("몸무게 : %.1f\t",weight);
		System.out.println("성별: "+sex);
	}
	public void example2() {
		System.out.print("국어 점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
		System.out.print("영어 점수 : ");
		int eng = sc.nextInt();
		System.out.printf("당신 성적의 총합은 %d점이고 평균은 %.2f점 입니다!",kor+math+eng,(double)((kor+math+eng)/3));
	}

}
