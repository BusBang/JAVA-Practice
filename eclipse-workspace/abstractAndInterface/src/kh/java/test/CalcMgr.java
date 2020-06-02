package kh.java.test;

import java.util.Scanner;

public class CalcMgr {
	Scanner sc = new Scanner(System.in);
	public void main() {
		System.out.println("첫 번째 수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두 번째 수 입력 : ");
		int num2 = sc.nextInt();
		Calc c = new Calc();
		int sum = c.sum(num1, num2);
		System.out.println(sum);
	}

}
