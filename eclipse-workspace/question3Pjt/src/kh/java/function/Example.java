package kh.java.function;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner q3 = new Scanner(System.in);
		
		System.out.print("ù ��° ���� �Է� :");
		int inputFirst = q3.nextInt();
		
		System.out.print("�� ��° ���� �Է� :");
		int inputSecond = q3.nextInt();
		
		System.out.println("=========== ��� ===========");
		System.out.println("���ϱ� ��� :" +(inputFirst+inputSecond));
		System.out.println("���� ��� :" +(inputFirst-inputSecond));
		System.out.println("���ϱ� ��� :" +(inputFirst*inputSecond));
		System.out.println("������ �� :" +(inputFirst/inputSecond));
		System.out.println("������ ������ :" +(inputFirst%inputSecond));
		
		
	}

	public void exam2() {
		Scanner q4 = new Scanner(System.in);
		
		System.out.print("���� ���� �Է� :");
		double num1 = q4.nextDouble();		
		System.out.print("���� ���� �Է� :");
		double num2 = q4.nextDouble();	
		System.out.println("=========== ��� ===========");
		System.out.println("���� :"+(num1*num2));
		System.out.println("�ѷ� :"+2*(num1+num2));
	}
	public void exam3() {
		Scanner q5 = new Scanner(System.in);
		
		System.out.print("����ܾ� �Է� :");
		String voca = q5.nextLine();
		//����.charAt(index) --> String ���� ������ ���ڸ� �� ���ھ� ������ �� �ִ�.
		System.out.println("ù ��° ���� :"+voca.charAt(0));
		System.out.println("�� ��° ���� :"+voca.charAt(1));
		System.out.println("�� ��° ���� :"+voca.charAt(2));
		
	}
	
	
}
