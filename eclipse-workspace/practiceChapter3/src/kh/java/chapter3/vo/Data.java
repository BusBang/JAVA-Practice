package kh.java.chapter3.vo;

import java.util.Scanner;

public class Data {
	Scanner sc = new Scanner(System.in);
	public void example1() {
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		System.out.print("�ּ� �Է� : ");
		String addr = sc.next();
		System.out.print("Ű �Է� : ");
		double height = sc.nextDouble();
		System.out.print("������ �Է� : ");
		double weight = sc.nextDouble();
		System.out.print("���� �Է� : ");
		char sex = sc.next().charAt(0);
		System.out.println("�̸� : "+name);
		System.out.println("���� : "+age);
		System.out.println("�ּ� : "+addr);
		System.out.println("Ű : "+(int)height);
		System.out.printf("������ : %.1f\t",weight);
		System.out.println("����: "+sex);
	}
	public void example2() {
		System.out.print("���� ���� : ");
		int kor = sc.nextInt();
		System.out.print("���� ���� : ");
		int math = sc.nextInt();
		System.out.print("���� ���� : ");
		int eng = sc.nextInt();
		System.out.printf("��� ������ ������ %d���̰� ����� %.2f�� �Դϴ�!",kor+math+eng,(double)((kor+math+eng)/3));
	}

}
