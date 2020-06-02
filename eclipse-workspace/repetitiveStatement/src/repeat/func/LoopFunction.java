package repeat.func;
import java.util.Scanner;

public class LoopFunction {
	public void Loop1() {
		for(int i=5; i>=1; i--) {
			System.out.println(i+"번째 실행중");
		}
	}
	public void LoopExam1() {
		for(int i=1; i<=5; i++) {
			System.out.println("안녕하세요");
		}
	}
	public void LoopExam2() {
		//입력한 횟수만큼 안녕하세요 출력
		Scanner sc1 = new Scanner(System.in);
		System.out.print("몇 번 출력하시겠습니까? :");
		int num = sc1.nextInt();
		for(int i=1; i<=num; i++) {
			System.out.println("안녕하세요");
		}
	}
	public void LoopExam3() {
		//구구단 2단 출력
		System.out.println("2단 입니다.");
		for(int i=1;i<=9;i++) {
			System.out.printf("2*%d=%d\n",i,2*i);
		}
	}
	public void LoopExam4() {
		//입력한 숫자에 맞는 구구단 출력
		Scanner sc4 = new Scanner(System.in);
		System.out.print("몇단을 출력하시겠습니까? ");
		int num = sc4.nextInt();
		System.out.printf("%d단 입니다.\n",num);
		for(int i=1;i<=9;i++) {
			System.out.printf("%d*%d=%d\n",num,i,num*i);
		}
	}
	public void LoopExam5() {
		//반복문으로 5번 반복해 그 합을 출력하는 프로그램
		Scanner sc5 = new Scanner(System.in);
		
		int i;
		int sum=0;
		for(i=1;i<=5;i++) {
			System.out.print("정수 값을 입력하시오 :");
			int num =sc5.nextInt();
			sum = sum + num;
		}
		System.out.printf("입력한 %d개의 정수의 합 :%d",i-1,sum);
	}
	public void LoopExam6() {
		//정수 두 개를 입력받고 두 수 사이의 모든 수의 합을 구하는 프로그램
		Scanner sc6 = new Scanner(System.in);
		System.out.print("첫 번째 수 입력 : ");
		int num1 = sc6.nextInt();
		System.out.print("두 번째 수 입력 : ");
		int num2 = sc6.nextInt();
		int sum = 0;
		for(int i=num1;i<=num2;i++) {
			sum = sum + i;
		}
		System.out.printf("%d ~ %d의 정수의 합 : %d",num1,num2,sum);
	}
	public void LoopExam7() {
		//수를 입력 받고 1부터 입력 받은 숫자의 짝수들의 합을 구하는 프로그램
		Scanner sc7 = new Scanner(System.in);
		System.out.print("숫자 입력 :");
		int num = sc7.nextInt();
		int even;
		int sum = 0;
		for(int i=1;i<=num;i++) {
			if(i%2==0) {
				even = i;
				sum += even;
			}
		}System.out.printf("짝수들의 합은 :%d",sum);
	}
	public void Loop2() {
		int i=1;
		while(i<=5) {
			System.out.println(i+"번째 반복해서 수행 중");
			i++;
		}
	}
	public void WhileExam1() {
		int i=1;
		while(i<=5) {
			System.out.println("안녕하세요");
			i++;
		}
	}
	public void WhileExam2() {
		Scanner sc2 = new Scanner(System.in); 
		System.out.print("몇 번 출력하시겠습니까?");
		int repeat = sc2.nextInt();
		int i = 1;
		while(i<=repeat) {
			System.out.println("안녕하세요");
			i++;
		}
	}
	public void WhileExam3() {
		System.out.println("2단입니다");
		int i = 1;
		while(i<=9) {
			System.out.printf("2*%d=%d\n",i,2*i);
			i++;
		}
	}
	public void WhileExam4() {
		Scanner sc4 = new Scanner(System.in);
		System.out.print("몇 단을 출력하시겠습니까?");
		int num = sc4.nextInt();
		System.out.printf("%d단입니다.\n",num);
		int i=1;
		while(i<=9) {
			System.out.printf("%d*%d=%d\n",num,i,num*i);
			i++;
		}
	}
	public void WhileExam5() {
		//반복문 5번 반복, 입력받은 숫자들의 합
		Scanner sc5 = new Scanner(System.in);
		int i = 1;
		int sum = 0;
		while(i<=5) {
			System.out.print("정수값을 입력하시오 :");
			int num = sc5.nextInt();
			sum += num;
			i++;
		}
		System.out.printf("입력한 %d개의 정수의 합 :%d",i-1,sum);
	}
	public void WhileExam6() {
		//정수 두 개를 입력받고 두 수 사이의 모든 수의 합을 구하는 프로그램
		Scanner sc6 = new Scanner(System.in);
		System.out.print("첫 번째 수 입력 :");
		int num1 = sc6.nextInt();
		System.out.print("두 번째 수 입력 :");
		int num2 = sc6.nextInt();
		int sum = 0;
		int i = num1;
		while(i<=num2) {
			sum += i;
			i++;
		}
		System.out.printf("%d ~ %d의 정수의 합 : %d",num1,num2,sum);
	}
	public void WhileExam7() {
		//1부터 입력받은 숫자까지의 모든 짝수의 합
		Scanner sc7 = new Scanner(System.in);
		System.out.print("숫자 입력 :");
		int input = sc7.nextInt();
		int start = 1;
		int sum = 0;
		while(start<=input) {
			if(start%2==0) {
				sum += start;
			}
			start++;
		}
		System.out.printf("짝수들의 합은 :%d",sum);
	}
	public void DoWhile() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력");
		int num = sc.nextInt();
		do {
			System.out.println(num%10);
			num /= 10;
		}while(num>0);
	}
	public void forTest() {
		for(int i=1;i<=5;i++) {
			for(int j=1; j<=3;j++) {
				System.out.println("i="+i+"/j="+j);
			}
		}
	}
	public void infLoopTest() {
		//무한 반복문 사용 예
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("한번더[y/n]?");
			char ch = sc.next().charAt(0);
			if (ch=='n') {
				break; //반복문을 빠져나가는 방법
			}else {
				System.out.println("반복");
			}
		}
		System.out.println("끝");
	}
	public void breakTest() {
		//break 예시.
		for(int i=1; i<=10;i++) {
			System.out.println(i+"출력");
			if(i==5) {
				break; //i가 5가 되는 순간 break가 동작, test1은 동작하지 않고 for문을 빠져나가게 됨. 그러므로 test1은 4번만 출력
			}
			System.out.println("test1");
		}
		System.out.println("test2");
	}
	public void continueTest() {
		//continue 예시.
		for(int i=1; i<=10;i++) {
			System.out.println(i+"출력");
			if(i==5) {
				continue; //i가 5가 되는 순간 continue를 만난 순간, 바로 for를 다음 순서에서 시작함. 그러므로 5출력때 test1이 출력되지 않음.
			}
			System.out.println("test1");
		}
		System.out.println("test2");
	}
	public void con2() {
		//continue 예시2.
		for(int i=1; i<=10;i++) {
			System.out.println(i+"출력");
			if(i%2==0) {
				continue; //i가 짝수일 때 마다 continue 동작, 그러므로 test1은 홀수때만 출력
			}
			System.out.println("test1");
		}
		System.out.println("test2");
	}
	
	

}
