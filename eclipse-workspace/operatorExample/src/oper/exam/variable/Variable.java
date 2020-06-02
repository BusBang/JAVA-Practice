package oper.exam.variable;
import java.util.Scanner;

public class Variable {
	public void exam1() {
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("첫 번째 수 입력 :");
		double num1 = sc1.nextDouble();
		System.out.print("두 번째 수 입력 :");
		double num2 = sc1.nextDouble();
		
		System.out.println("========== 결과 ==========");
		System.out.printf("두 수를 더한 수 : %d\n", (int)(num1+num2));
		System.out.printf("두 수를 뺀 수 : %d\n", (int)(num1-num2));
		System.out.printf("두 수를 곱한 수 : %d\n", (int)(num1*num2));
		System.out.printf("두 수를 나눈 수 : %.2f\n", num1/num2);
	}
	
	public void exam2() {
		int a = 40, b= 20;
		a += b;
		System.out.printf("a의 값: %d, b의 값: %d \n",a,b); //60 20
		a -= b;
		System.out.printf("a의 값: %d, b의 값: %d \n",a,b); //40 20
		a *= b;
		System.out.printf("a의 값: %d, b의 값: %d \n",a,b); //800 20
		a /= b;
		System.out.printf("a의 값: %d, b의 값: %d \n",a,b); //40 20
	}
	
	public void exam3() {
		int a=10, b=20, c=30, d=40;
		boolean result1, result2;
		result1 = ((a < 20 && b > 10) && (c == 20 || d == 40));
		//((true && true ) && (false || true)) => true&&true => true
		result2 = ((a == 10 && b != 2 * 10) || ( c== 30 && d != 40));
		//((true && false ) || (true && false)) => false||false => false
		System.out.printf("첫 번째 결과 값 : %b \n", result1);
		System.out.printf("두 번째 결과 값 : %b \n", result2);

	}
	
	public void exam4() {
		Scanner sc4 = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요 :");
		int age = sc4.nextInt();
				
		String result = age > 19?"성인입니다. 어서오세요":"미성년자는 입장불가입니다";
		System.out.println(result);		
		
	}
	
	

}
