package kh.java.func;
import java.util.Scanner;

public class MethodTest {
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 수 입력 : ");
		int num1 = sc.nextInt(); //10
		System.out.println("두 번째 수 입력 : ");
		int num2 = sc.nextInt(); //20
//		int sum = num1+num2;		//더하기를 100번 실행하면 코드 100줄이 생김
		
		System.out.print("연산자를 입력하세요[+,-,*,/] :");
	
		char oper = sc.next().charAt(0);
		switch (oper) {
		case '+' :
			int sumMethod= sum(num1,num2);
			System.out.println("두 수의 합은 : "+sumMethod);
			break;
		case '-' :
			int subMethod = sub(num1,num2);
			System.out.println("두 수의 차는 : "+subMethod);
			break;
		case '*' :
			int mulMethod = multi(num1,num2);
			System.out.println("두 수의 곱은 : "+mulMethod);
			break;
		case '/' :
			double divMethod = div(num1,num2);
			System.out.printf("두 수를 나눈 값은 : %.2f\n",divMethod);
			break;
		}
		/*
		System.out.println("두 수의 합은 : "+sumMethod);
		//소스코드 추가 작성시,
		//100줄 짜리 코드 생김
		//메소드를 이용하면 편하게 구할 수 있음
		sum(num1,num2);
		//소스코드 추가 작성
		System.out.println("두 수의 차는 : "+sub);
		System.out.println("두 수의 곱은 : "+mulMethod);
		System.out.printf("두 수의 나누기는 : %.2f",divMethod);
		*/
	}
	
	public int sum(int su1, int su2) {
		//int su1 = 10;
		//int su2 = 20; 이 있다고 생각하는 것임
		System.out.println("정수 2개를 더하는 메소드입니다.");
		int result =su1+su2; // 1줄로 쳤지만 100줄 짜리임
		return result; //메소드를 실행한 값을 반환. 근데 값은 어떻게 입력?
	}
	//메소드 오버로딩 :
	//위 두 자리 덧셈과 이름이 같아도 매개변수의 타입, 갯수로 구분을 해준다.
	public int sum(int su11, int su22, int su33) {
		System.out.println("정수 3개를 더하는 메소드입니다.");
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
