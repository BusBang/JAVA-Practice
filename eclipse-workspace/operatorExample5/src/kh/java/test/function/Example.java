package kh.java.test.function;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("���� ���� �Է� :");
		double kor = sc1.nextInt();
		System.out.print("���� ���� �Է� :");
		double eng = sc1.nextInt();
		System.out.print("���� ���� �Է� :");
		double mat = sc1.nextInt();
		
		int sum = (int)(kor+eng+mat);
		double avg = (double)(sum)/3;
		//double avg = sum/(double)3;
		
		boolean condition1 = kor>=40 && eng >=40 && mat >= 40;
		boolean condition2 = avg>=60;
		String result = condition1 == true && condition2 ==true?"�հ�":"���հ�";
		// �ٸ� �� 1)
		// String result = (kor>=40 && eng>=40 && mat >=40) && avg >= 60 ? "�հ�":"���հ�";
		//
		// �ٸ��� 2)
		// System.out.println((kor>=40 && eng>=40 && mat >=40) && avg >= 60 ? "�հ�":"���հ�");
		System.out.printf("�հ� : %d\n", sum);
		System.out.printf("�հ� : %.2f\n", avg);
		System.out.println(result);
		System.out.println((kor>=40 && eng>=40 && mat >=40) && avg >= 60 ? "�հ�":"���հ�");
	}
	public void exam2() {
		Scanner sc2 = new Scanner(System.in);
		
		System.out.print("���� �Է� :");
		int num = sc2.nextInt();
		
		String result = (num%2) == 1?"Ȧ��!":"¦��!";
		
		System.out.println(result);
		
	}
	

}
