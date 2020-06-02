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
//		System.out.println(c); //10이 나올 것 같지만 d를 정의하면서 10-1+2가 되어서 9가 나옴. 연산의 기준은 무엇일까?
//		System.out.println(d); //11이 아닌 12가 나온다. print d를 하고 감소가 진행되기 때문에.
//		
//		int e = 10;
//		int f = 10;
//		int g;
//		g = (e++) + (++f) + e;
//		System.out.println(e); //11
//		System.out.println(f); //11
//		System.out.println(g); //10 + 11 + 11=32
		
		//배재호 컴활 합격 기원//
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("1과목 점수 입력 :");
		double class1 = sc1.nextInt();
		System.out.print("2과목 점수 입력 :");
		double class2 = sc1.nextInt();
		
		int sum = (int)(class1+class2);
		double avg = (double)(sum)/2;
		
		boolean condition1 = class1>=60 && class2 >=60;
		boolean condition2 = avg>=70;
		String result = condition1 == true && condition2 ==true?"합격":"불합격";
		
		System.out.printf("합계 : %d\n", sum);
		System.out.printf("합계 : %.2f\n", avg);
		System.out.println(result);
	
		
	
	
		
		
		
		
	}	

}
