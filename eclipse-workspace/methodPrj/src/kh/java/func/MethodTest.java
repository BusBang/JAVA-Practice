package kh.java.func;
import java.util.Scanner;

public class MethodTest {
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù ��° �� �Է� : ");
		int num1 = sc.nextInt(); //10
		System.out.println("�� ��° �� �Է� : ");
		int num2 = sc.nextInt(); //20
//		int sum = num1+num2;		//���ϱ⸦ 100�� �����ϸ� �ڵ� 100���� ����
		
		System.out.print("�����ڸ� �Է��ϼ���[+,-,*,/] :");
	
		char oper = sc.next().charAt(0);
		switch (oper) {
		case '+' :
			int sumMethod= sum(num1,num2);
			System.out.println("�� ���� ���� : "+sumMethod);
			break;
		case '-' :
			int subMethod = sub(num1,num2);
			System.out.println("�� ���� ���� : "+subMethod);
			break;
		case '*' :
			int mulMethod = multi(num1,num2);
			System.out.println("�� ���� ���� : "+mulMethod);
			break;
		case '/' :
			double divMethod = div(num1,num2);
			System.out.printf("�� ���� ���� ���� : %.2f\n",divMethod);
			break;
		}
		/*
		System.out.println("�� ���� ���� : "+sumMethod);
		//�ҽ��ڵ� �߰� �ۼ���,
		//100�� ¥�� �ڵ� ����
		//�޼ҵ带 �̿��ϸ� ���ϰ� ���� �� ����
		sum(num1,num2);
		//�ҽ��ڵ� �߰� �ۼ�
		System.out.println("�� ���� ���� : "+sub);
		System.out.println("�� ���� ���� : "+mulMethod);
		System.out.printf("�� ���� ������� : %.2f",divMethod);
		*/
	}
	
	public int sum(int su1, int su2) {
		//int su1 = 10;
		//int su2 = 20; �� �ִٰ� �����ϴ� ����
		System.out.println("���� 2���� ���ϴ� �޼ҵ��Դϴ�.");
		int result =su1+su2; // 1�ٷ� ������ 100�� ¥����
		return result; //�޼ҵ带 ������ ���� ��ȯ. �ٵ� ���� ��� �Է�?
	}
	//�޼ҵ� �����ε� :
	//�� �� �ڸ� ������ �̸��� ���Ƶ� �Ű������� Ÿ��, ������ ������ ���ش�.
	public int sum(int su11, int su22, int su33) {
		System.out.println("���� 3���� ���ϴ� �޼ҵ��Դϴ�.");
		int result = su11+su22+su33;
		return result;
	}
	
	public int sub(int su1, int su2) {
		int result =su1-su2;
		return result;
	}
	public int multi(int su11, int su12) {
//		int result =su11*su12;
//		return result;
		return su11*su12;
		
	}
	public double div(int divNum1, int divNum2) {
		double result = (double)divNum1/divNum2;
		return result;
	}
	

	

}
