package kh.java.practice;
import java.util.Scanner;

public class Sample {
	public void sample1() {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("���� �Է� :");
		char letter = sc1.nextLine().charAt(0);
		
		System.out.printf("%c�� �����ڵ� �� : %d",letter,(int)letter);
	}
	
	public void sample2() {
		Scanner sc2 = new Scanner(System.in);
		System.out.print("���� ���� �Է� :");
		int score1 = sc2.nextInt();
		System.out.print("���� ���� �Է� :");
		int score2 = sc2.nextInt();
		System.out.print("���� ���� �Է� :");
		int score3 = sc2.nextInt();
		
		System.out.println("========== ��� ==========");
		System.out.printf("���� :%d\n",score1+score2+score3);
		System.out.printf("��� :%d\n",(score1+score2+score3)/3);

	
	
	}

}
