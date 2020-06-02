package test.run;
import java.util.Scanner;


public class Run {

	public static void main(String[] args) {
		/*
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("10을 입력해보세요 :");
		int inputNumber = sc1.nextInt();
		if(inputNumber==10) {
			System.out.println("잘했어요!!");
		}

		
		//숫자 구별 프로그램		
		System.out.println("======== 숫자 구별 프로그램 ========");
		System.out.print("임의의 정수를 입력하세요 :");
		int inputNumber1 = sc1.nextInt();
		if(inputNumber1>0) {
			System.out.printf("당신이 입력한 수 %d은(는) 양수입니다.", inputNumber1);
		}
		if(inputNumber1==0) {
			System.out.printf("당신이 입력한 수 %d은(는) %d입니다.", inputNumber1, inputNumber1);
		}
		if(inputNumber1<0) {
			System.out.printf("당신이 입력한 수 %d은(는) 음수입니다.", inputNumber1);
		}			

		//두수 비교 프로그램
		System.out.println("======== 두수 비교 프로그램 ========");
		System.out.print("첫 번째 정수를 입력하세요 :");
		int num11 = sc1.nextInt();
		System.out.print("두 번째 정수를 입력하세요 :");
		int num22 = sc1.nextInt();
		if(num11<num22) {
			System.out.println(num11+"<"+num22);
			System.out.println("두 번째 수가 더 큽니다.");
		}
		if(num11==num22) {
			System.out.println(num11+"="+num22);
			System.out.println("두 수가 같습니다.");
		}
		if(num11>num22) {
			System.out.println(num11+">"+num22);
			System.out.println("첫 번째 수가 더 큽니다.");
		}
		
		//계산기프로그램
		System.out.println("======== 계산기 프로그램 ========");
		System.out.print("연산자를 입력하세요 (+,-,*,/) :");
		char sign = sc1.nextLine().charAt(0);
		System.out.print("첫 번째 정수를 입력하세요 :");
		int num1 = sc1.nextInt();
		System.out.print("두 번째 정수를 입력하세요 :");
		int num2 = sc1.nextInt();
		if(sign=='+') {
			System.out.printf("%d %c %d = %d",num1,sign,num2,num1+num2);
		}
		if(sign=='-') {
			System.out.printf("%d %c %d = %d",num1,sign,num2,num1-num2);
		}
		if(sign=='*') {
			System.out.printf("%d %c %d = %d",num1,sign,num2,num1*num2);
		}
		if(sign=='/') {
			System.out.printf("%d %c %d = %.6f",num1,sign,num2,(double)num1/num2);
		}
		
		
		//if else
		System.out.print("정수를 입력하세요 :");
		int number = sc1.nextInt();
		//if else를 이용하기
		if(number%2==0) {
			System.out.println("짝수입니다.");
		}else {
			System.out.println("홀수입니다.");
		}
		//한 번만 비교하는 과정을 거침
		
		//if만 이용하기
		if(number%2==0) {
			System.out.println("짝수입니다.");
		}
		if(number%2!=0) {
			System.out.println("홀수입니다.");
		}
		//두 번 비교하는 과정을 거침
	
	
		//놀이공원 프로그램
		System.out.println("======== 놀이공원 프로그램 ========");
		System.out.print("입장하실 총 인원은 몇명입니까?");
		int people = sc1.nextInt();
		System.out.print("어른은 몇명입니까? (1인당 15000원) :");
		int adult = sc1.nextInt();
		System.out.print("아이는 몇명입니까? (1인당 5000원) :");
		int child = sc1.nextInt();
		if(people==adult+child) {
			System.out.printf("지불하실 총 금액은 %d원 입니다.",15000*adult+5000*child);
		}else {
			System.out.print("인원수가 맞지 않습니다.");
		}
		
		
		
		//퀴즈 프로그램
		System.out.println("======== 퀴즈 프로그램 ========");
		System.out.print("<<첫 번째 퀴즈>>\n사과는 영어로 무엇일까요(1.apple, 2.스티브 잡스)? :");
		int que1 = sc1.nextInt();
		int answer = 0;
		if(que1 == 1) {
			System.out.println("정답!!!");
			answer++;
		}else {
			System.out.println("땡!!");
		}
		System.out.print("<<두 번째 퀴즈>>\n바나나는 길어 길으면 기차 기차는 (1.비싸, 2.빨라)? :");
		int que2 = sc1.nextInt();
		if(que2 == 2) {
			System.out.println("정답!!!");
			answer++;
		}else {
			System.out.println("땡!!");
		}
		System.out.printf("총 %d문제를 맞혔습니다.",answer);				

		
		//심리테스트 프로그램
		System.out.println("========== 심리테스트 ==========");
		System.out.print("당신은 술을 좋아하십니까? (1.yes, 2.no) :");
		int que1 = sc1.nextInt();
		if(que1 == 1) {
			System.out.print("당신은 담배를 피웁니까? (1.yes, 2.no) :");
			int que2 = sc1.nextInt();
			if(que2 == 1) {
				System.out.print("담배는 건강에 좋지 않습니다.");
			}else {
				System.out.print("술은 간에 좋지 않습니다.");				
			}
		}else {
			System.out.print("당신은 이성친구가 있습니까? (1.yes, 2.no) :");
			int que2 = sc1.nextInt();
			if(que2 == 1) {
				System.out.println("올..ㅋ");
			}else {
				System.out.println("힘내요 ㅠㅠ");
			}
		}
		
		System.out.print("1~3 사이 수를 입력하세요 :");
		int numb = sc1.nextInt();
		if(numb == 1) {
			System.out.println("One");
		}else if(numb == 2) {
			System.out.println("Two");
		}else if(numb == 3) {
			System.out.println("Three");
		}else {
			System.out.println("잘못 입력했습니다.");
		}
		
		
		//대소문자 변환 프로그램
		System.out.println("======== 대소문자 변환 프로그램 ========");
		System.out.print("문자입력 :");
		char letter = sc1.next().charAt(0);
		System.out.println("======== 결과 ========");
		if((int)letter>=65 && (int)letter<=90) {
			System.out.println("대문자를 입력하셨습니다.");
			System.out.printf("소문자로 변환 :%c",(char)letter^32);
		}else if((int)letter>=97 && (int)letter<=122) {
			System.out.println("소문자를 입력하셨습니다.");
			System.out.printf("대문자로 변환 :%c",(char)letter^32);
		}else {
			System.out.println("잘못 입력하셨습니다. 영문자를 입력해주세요.");
		}
		
		//배수 출력 프로그램
		System.out.print("정수입력 :");
		int number = sc1.nextInt();
		System.out.println("===== 결과 =====");
		if(number==0) {
			System.out.printf("[%d]은(는) 3의 배수도 4의 배수도 아닙니다.",number);						
		}else if(number%3==0 && number%4==0) {
			System.out.printf("[%d]은(는) 3의 배수면서 4의 배수입니다.",number);
		}else if(number%3==0) {
			System.out.printf("[%d]은(는) 3의 배수입니다.",number);			
		}else if(number%4==0) {
			System.out.printf("[%d]은(는) 4의 배수입니다.",number);						
		}else {
			System.out.printf("[%d]은(는) 3의 배수도 4의 배수도 아닙니다.",number);						
		}
		
		
		//switch문
		System.out.print("1~3 사이의 수 입력 : ");
		int num = sc1.nextInt();
		switch(num) {
		case 1 : System.out.println("1을 입력");
		break;
		case 2 : System.out.println("2를 입력");
		break;
		case 3 : System.out.println("3을 입력");
		break;
		default : System.out.println("잘못입력");
		}
		*/
		/*
		
		//달 입력하면 해당 날짜의 일 수를 출력
		System.out.print("일수를 알고 싶은 달을 입력하세요 :");
		int month = sc1.nextInt();
		switch(month) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 :
			System.out.printf("%d월달은 31일까지 있습니다.",month);
			break;
		case 2 :
			System.out.printf("%d월달은 29일까지 있습니다.",month);
			break;
		case 4 :
		case 6 :
		case 9 :
		case 11 :
			System.out.printf("%d월달은 30일까지 있습니다.",month);
			break;
		default : System.out.println("잘못입력하셨습니다.");
		}
		
		
		//장학금 지불 시스템
		System.out.println("장학금 지불 시스템입니다");
		System.out.print("학점을 입력하세요 (A,B,C,D,F) :");
		char score = sc1.next().charAt(0);
		switch(score) {
		case 'A' :
			System.out.println("수고하셨습니다. 장학금을 100% 지급해드리겠습니다.");
			break;
		case 'B' :
			System.out.println("수고하셨습니다. 장학금을 50% 지급해드리겠습니다.");
			break;
		case 'C' :
			System.out.println("장학금을 바라시면 좀 더 열심히 해주세요.");
			break;
		case 'D' :
			System.out.println("크흠,");
			break;
		case 'F' :
			System.out.println("학 사 경 고 입 니 다");
			break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
		
		
		//Switch를 이용한 계산기
		System.out.println("========== 계산기 프로그램 ==========");
		System.out.print("연산자를 입력하세요 (+,-,*,/):");
		char sign = sc1.next().charAt(0);
		System.out.print("첫 번째 정수를 입력하세요 :");
		int num1 = sc1.nextInt();
		System.out.print("두 번째 정수를 입력하세요 :");
		int num2 = sc1.nextInt();		
		switch(sign) {
		case '+' :
			System.out.printf("%d%c%d=%d",num1,sign,num2,num1+num2);
			break;
		case '-' :
			System.out.printf("%d%c%d=%d",num1,sign,num2,num1-num2);
			break;
		case '*' :
			System.out.printf("%d%c%d=%d",num1,sign,num2,num1*num2);
			break;
		case '/' :
			System.out.printf("%d%c%d=%.6f",num1,sign,num2,(double)num1/num2);
			break;
		default : 		System.out.println("다시 입력하세요");
		}
		*/
		
		/////////////////////////////////////////////////////////
		
		//점수에 따른 등급 산출 프로그램
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("점수 입력 :");
		int score = sc1.nextInt();
		char grade ='0';
		int seperate = score/10;
		
		if (score>=0 && score<=100) {
		switch(seperate) {
			case 0 :
			case 1 :
			case 2 :
			case 3 :
			case 4 :
			case 5 :
				grade = 'F';
				break;
			case 6 :
				grade = 'D';
				break;
			case 7 :
				grade = 'C';
			case 8 :
				grade = 'B';
			case 9 :
			case 10 :
				grade = 'A';
				break;
		}
			System.out.printf("%d점 ==> %c 등급",score,grade);
		}else {
			System.out.println("잘못된 입력 (0~100사이 입력)");
		}
	}

}

