package kh.java.practice;
import java.util.Scanner;

public class Sample {
	public void sample1() {
		Scanner sc1 = new Scanner(System.in);
		System.out.print("문자 입력 :");
		char letter = sc1.nextLine().charAt(0);
		
		System.out.printf("%c의 유니코드 값 : %d",letter,(int)letter);
	}
	
	public void sample2() {
		Scanner sc2 = new Scanner(System.in);
		System.out.print("국어 점수 입력 :");
		int score1 = sc2.nextInt();
		System.out.print("수학 점수 입력 :");
		int score2 = sc2.nextInt();
		System.out.print("영어 점수 입력 :");
		int score3 = sc2.nextInt();
		
		System.out.println("========== 결과 ==========");
		System.out.printf("총점 :%d\n",score1+score2+score3);
		System.out.printf("평균 :%d\n",(score1+score2+score3)/3);

	
	
	}

}
