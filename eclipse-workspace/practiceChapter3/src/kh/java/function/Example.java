package kh.java.function;

import java.util.Scanner;

public class Example {
	Scanner sc= new Scanner(System.in);
	public void exam1() {
		System.out.print("ù ��° ���� �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ���� �Է� : ");
		int num2 = sc.nextInt();
		System.out.println("========���========");
		System.out.println("���ϱ� ��� : "+(num1+num2));
		System.out.println("���� ��� : "+(num1-num2));
		System.out.println("������ ��� : "+(num1/num2));
		System.out.println("������ ��� : "+(num1%num2));
	}
	public void exam2() {

		System.out.print("���� �Է� : ");
		double wide = sc.nextDouble();
		System.out.print("���� �Է� : ");
		double depth = sc.nextDouble();
		System.out.println("=====���=====");
		System.out.println("���� : "+(wide*depth));
		System.out.println("�ѷ� : "+(2*(wide+depth)));


	}

}
