package kh.java.function;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("ù ��° ���� �Է� :");
		int num1 = sc1.nextInt();
		System.out.print("�� ��° ���� �Է� :");
		int num2 = sc1.nextInt();
		
		System.out.println("========== ��� ==========");
		System.out.println("���ϱ� ��� :"+(num1+num2));
		System.out.println("���� ��� :"+(num1-num2));
		System.out.println("���ϱ� ��� :"+(num1*num2));
		System.out.println("������ �� :"+(num1/num2));
		System.out.println("������ ������ :"+(num1%num2));
	}
	
	public void exam2() {
		Scanner sc2 = new Scanner(System.in);
		System.out.print("���� ���� �Է� :");
		double wide = sc2.nextDouble();
		System.out.print("���� ���� �Է� :");
		double depth = sc2.nextDouble();
		
		System.out.println("========== ��� ==========");
		System.out.println("���� :"+(wide*depth));
		System.out.println("�ѷ� :"+2*(wide+depth));
	}
	
	public void exam3() {
		Scanner sc3 = new Scanner(System.in);
		System.out.print("����ܾ� �Է� :");
		String voca = sc3.nextLine();

		System.out.printf("ù ��° ���� :%c\n",voca.charAt(0));
		System.out.printf("�� ��° ���� :%c\n",voca.charAt(1));
		System.out.printf("�� ��° ���� :%c\n",voca.charAt(2));
		
	}

}
