package kh.java.practice;

import java.util.Scanner;

public class Sample {
	
	Scanner sc = new Scanner(System.in);
	
	public void sample1() {
		System.out.print("���� �Է� : ");
		char inputChar = sc.next().charAt(0);
		System.out.println((int)inputChar);
	}
	public void sample2() {
		System.out.print("���� ���� �Է� : ");
		double kor = sc.nextDouble();
		System.out.print("���� ���� �Է� : ");
		double math = sc.nextDouble();
		System.out.print("���� ���� �Է� : ");
		double eng = sc.nextDouble();
		System.out.println("=========���=========");
		System.out.println("���� : "+(int)(kor+math+eng));
		System.out.println("��� : "+(int)((kor+math+eng)/3));
	}

}
