package oper.exam.variable;
import java.util.Scanner;

public class Variable {
	public void exam1() {
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("ù ��° �� �Է� :");
		double num1 = sc1.nextDouble();
		System.out.print("�� ��° �� �Է� :");
		double num2 = sc1.nextDouble();
		
		System.out.println("========== ��� ==========");
		System.out.printf("�� ���� ���� �� : %d\n", (int)(num1+num2));
		System.out.printf("�� ���� �� �� : %d\n", (int)(num1-num2));
		System.out.printf("�� ���� ���� �� : %d\n", (int)(num1*num2));
		System.out.printf("�� ���� ���� �� : %.2f\n", num1/num2);
	}
	
	public void exam2() {
		int a = 40, b= 20;
		a += b;
		System.out.printf("a�� ��: %d, b�� ��: %d \n",a,b); //60 20
		a -= b;
		System.out.printf("a�� ��: %d, b�� ��: %d \n",a,b); //40 20
		a *= b;
		System.out.printf("a�� ��: %d, b�� ��: %d \n",a,b); //800 20
		a /= b;
		System.out.printf("a�� ��: %d, b�� ��: %d \n",a,b); //40 20
	}
	
	public void exam3() {
		int a=10, b=20, c=30, d=40;
		boolean result1, result2;
		result1 = ((a < 20 && b > 10) && (c == 20 || d == 40));
		//((true && true ) && (false || true)) => true&&true => true
		result2 = ((a == 10 && b != 2 * 10) || ( c== 30 && d != 40));
		//((true && false ) || (true && false)) => false||false => false
		System.out.printf("ù ��° ��� �� : %b \n", result1);
		System.out.printf("�� ��° ��� �� : %b \n", result2);

	}
	
	public void exam4() {
		Scanner sc4 = new Scanner(System.in);
		
		System.out.print("���̸� �Է��ϼ��� :");
		int age = sc4.nextInt();
				
		String result = age > 19?"�����Դϴ�. �������":"�̼����ڴ� ����Ұ��Դϴ�";
		System.out.println(result);		
		
	}
	
	

}
