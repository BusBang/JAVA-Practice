package kh.java.test.function;
import java.util.Scanner;

public class Example {
	public void exam1() {
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("국어 점수 입력 :");
		double kor = sc1.nextInt();
		System.out.print("영어 점수 입력 :");
		double eng = sc1.nextInt();
		System.out.print("수학 점수 입력 :");
		double mat = sc1.nextInt();
		
		int sum = (int)(kor+eng+mat);
		double avg = (double)(sum)/3;
		//double avg = sum/(double)3;
		
		boolean condition1 = kor>=40 && eng >=40 && mat >= 40;
		boolean condition2 = avg>=60;
		String result = condition1 == true && condition2 ==true?"합격":"불합격";
		// 다른 답 1)
		// String result = (kor>=40 && eng>=40 && mat >=40) && avg >= 60 ? "합격":"불합격";
		//
		// 다른답 2)
		// System.out.println((kor>=40 && eng>=40 && mat >=40) && avg >= 60 ? "합격":"불합격");
		System.out.printf("합계 : %d\n", sum);
		System.out.printf("합계 : %.2f\n", avg);
		System.out.println(result);
		System.out.println((kor>=40 && eng>=40 && mat >=40) && avg >= 60 ? "합격":"불합격");
	}
	public void exam2() {
		Scanner sc2 = new Scanner(System.in);
		
		System.out.print("정수 입력 :");
		int num = sc2.nextInt();
		
		String result = (num%2) == 1?"홀수!":"짝수!";
		
		System.out.println(result);
		
	}
	

}
