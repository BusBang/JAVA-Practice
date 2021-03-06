package kh.java.wrap;

import java.util.Scanner;

public class Calculator implements Calc {
	
	@Override
	public void start() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자를 입력해주세요. ");
		String num1 = sc.next();
		System.out.print("연산자를 입력해주세요. ");
		char sign = sc.next().charAt(0);
		System.out.print("두 번째 숫자를 입력해주세요. ");
		String num2 = sc.next();

		switch(sign) {
		case '+':
			Integer resultAdd = add(num1,num2);
			System.out.println("결과 : "+resultAdd);
			break;
		case '-':
			Integer resultSub = sub(num1,num2);
			System.out.println("결과 : "+resultSub);
			break;
		case '*' :
			Integer resultMulti = multi(num1,num2);
			System.out.println("결과 : "+resultMulti);

			break;
		case '/' :
			Double resultDiv = div(num1,num2);
			System.out.println("결과 : "+resultDiv);
			break;
			default : System.out.println("잘못 입력하셨습니다. ");
		}
		
	}

	@Override
	public int add(String num1, String num2) {
		return Integer.parseInt(num1)+Integer.parseInt(num2);
	}

	@Override
	public int sub(String num1, String num2) {
		return Integer.parseInt(num1)-Integer.parseInt(num2);
	}

	@Override
	public int multi(String num1, String num2) {
		return Integer.parseInt(num1)*Integer.parseInt(num2);
	}

	@Override
	public double div(String num1, String num2) {
		return Double.parseDouble(num1)/Double.parseDouble(num2);
	}

}
