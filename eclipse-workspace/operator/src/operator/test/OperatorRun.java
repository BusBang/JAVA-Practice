package operator.test;
import java.util.Scanner;

public class OperatorRun {

	public static void main(String[] args) {
//		int a = 10;
//		int b = 10;
//		System.out.println(a);
//		System.out.println(a++);
//		System.out.println(a);
//		
//		System.out.println(b);
//		System.out.println(++b);
//		System.out.println(b);
//		
//		int c = 10;
//		int d = (c--)+2;
//		System.out.println(c); //10�� ���� �� ������ d�� �����ϸ鼭 10-1+2�� �Ǿ 9�� ����. ������ ������ �����ϱ�?
//		System.out.println(d); //11�� �ƴ� 12�� ���´�. print d�� �ϰ� ���Ұ� ����Ǳ� ������.
//		
//		int e = 10;
//		int f = 10;
//		int g;
//		g = (e++) + (++f) + e;
//		System.out.println(e); //11
//		System.out.println(f); //11
//		System.out.println(g); //10 + 11 + 11=32
		
		//����ȣ ��Ȱ �հ� ���//
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("1���� ���� �Է� :");
		double class1 = sc1.nextInt();
		System.out.print("2���� ���� �Է� :");
		double class2 = sc1.nextInt();
		
		int sum = (int)(class1+class2);
		double avg = (double)(sum)/2;
		
		boolean condition1 = class1>=60 && class2 >=60;
		boolean condition2 = avg>=70;
		String result = condition1 == true && condition2 ==true?"�հ�":"���հ�";
		
		System.out.printf("�հ� : %d\n", sum);
		System.out.printf("�հ� : %.2f\n", avg);
		System.out.println(result);
	
		
	
	
		
		
		
		
	}	

}
