package test.run;
import java.util.Scanner;


public class Run {

	public static void main(String[] args) {
		/*
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("10�� �Է��غ����� :");
		int inputNumber = sc1.nextInt();
		if(inputNumber==10) {
			System.out.println("���߾��!!");
		}

		
		//���� ���� ���α׷�		
		System.out.println("======== ���� ���� ���α׷� ========");
		System.out.print("������ ������ �Է��ϼ��� :");
		int inputNumber1 = sc1.nextInt();
		if(inputNumber1>0) {
			System.out.printf("����� �Է��� �� %d��(��) ����Դϴ�.", inputNumber1);
		}
		if(inputNumber1==0) {
			System.out.printf("����� �Է��� �� %d��(��) %d�Դϴ�.", inputNumber1, inputNumber1);
		}
		if(inputNumber1<0) {
			System.out.printf("����� �Է��� �� %d��(��) �����Դϴ�.", inputNumber1);
		}			

		//�μ� �� ���α׷�
		System.out.println("======== �μ� �� ���α׷� ========");
		System.out.print("ù ��° ������ �Է��ϼ��� :");
		int num11 = sc1.nextInt();
		System.out.print("�� ��° ������ �Է��ϼ��� :");
		int num22 = sc1.nextInt();
		if(num11<num22) {
			System.out.println(num11+"<"+num22);
			System.out.println("�� ��° ���� �� Ů�ϴ�.");
		}
		if(num11==num22) {
			System.out.println(num11+"="+num22);
			System.out.println("�� ���� �����ϴ�.");
		}
		if(num11>num22) {
			System.out.println(num11+">"+num22);
			System.out.println("ù ��° ���� �� Ů�ϴ�.");
		}
		
		//�������α׷�
		System.out.println("======== ���� ���α׷� ========");
		System.out.print("�����ڸ� �Է��ϼ��� (+,-,*,/) :");
		char sign = sc1.nextLine().charAt(0);
		System.out.print("ù ��° ������ �Է��ϼ��� :");
		int num1 = sc1.nextInt();
		System.out.print("�� ��° ������ �Է��ϼ��� :");
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
		System.out.print("������ �Է��ϼ��� :");
		int number = sc1.nextInt();
		//if else�� �̿��ϱ�
		if(number%2==0) {
			System.out.println("¦���Դϴ�.");
		}else {
			System.out.println("Ȧ���Դϴ�.");
		}
		//�� ���� ���ϴ� ������ ��ħ
		
		//if�� �̿��ϱ�
		if(number%2==0) {
			System.out.println("¦���Դϴ�.");
		}
		if(number%2!=0) {
			System.out.println("Ȧ���Դϴ�.");
		}
		//�� �� ���ϴ� ������ ��ħ
	
	
		//���̰��� ���α׷�
		System.out.println("======== ���̰��� ���α׷� ========");
		System.out.print("�����Ͻ� �� �ο��� ����Դϱ�?");
		int people = sc1.nextInt();
		System.out.print("��� ����Դϱ�? (1�δ� 15000��) :");
		int adult = sc1.nextInt();
		System.out.print("���̴� ����Դϱ�? (1�δ� 5000��) :");
		int child = sc1.nextInt();
		if(people==adult+child) {
			System.out.printf("�����Ͻ� �� �ݾ��� %d�� �Դϴ�.",15000*adult+5000*child);
		}else {
			System.out.print("�ο����� ���� �ʽ��ϴ�.");
		}
		
		
		
		//���� ���α׷�
		System.out.println("======== ���� ���α׷� ========");
		System.out.print("<<ù ��° ����>>\n����� ����� �����ϱ��(1.apple, 2.��Ƽ�� �⽺)? :");
		int que1 = sc1.nextInt();
		int answer = 0;
		if(que1 == 1) {
			System.out.println("����!!!");
			answer++;
		}else {
			System.out.println("��!!");
		}
		System.out.print("<<�� ��° ����>>\n�ٳ����� ��� ������ ���� ������ (1.���, 2.����)? :");
		int que2 = sc1.nextInt();
		if(que2 == 2) {
			System.out.println("����!!!");
			answer++;
		}else {
			System.out.println("��!!");
		}
		System.out.printf("�� %d������ �������ϴ�.",answer);				

		
		//�ɸ��׽�Ʈ ���α׷�
		System.out.println("========== �ɸ��׽�Ʈ ==========");
		System.out.print("����� ���� �����Ͻʴϱ�? (1.yes, 2.no) :");
		int que1 = sc1.nextInt();
		if(que1 == 1) {
			System.out.print("����� ��踦 �ǿ�ϱ�? (1.yes, 2.no) :");
			int que2 = sc1.nextInt();
			if(que2 == 1) {
				System.out.print("���� �ǰ��� ���� �ʽ��ϴ�.");
			}else {
				System.out.print("���� ���� ���� �ʽ��ϴ�.");				
			}
		}else {
			System.out.print("����� �̼�ģ���� �ֽ��ϱ�? (1.yes, 2.no) :");
			int que2 = sc1.nextInt();
			if(que2 == 1) {
				System.out.println("��..��");
			}else {
				System.out.println("������ �Ф�");
			}
		}
		
		System.out.print("1~3 ���� ���� �Է��ϼ��� :");
		int numb = sc1.nextInt();
		if(numb == 1) {
			System.out.println("One");
		}else if(numb == 2) {
			System.out.println("Two");
		}else if(numb == 3) {
			System.out.println("Three");
		}else {
			System.out.println("�߸� �Է��߽��ϴ�.");
		}
		
		
		//��ҹ��� ��ȯ ���α׷�
		System.out.println("======== ��ҹ��� ��ȯ ���α׷� ========");
		System.out.print("�����Է� :");
		char letter = sc1.next().charAt(0);
		System.out.println("======== ��� ========");
		if((int)letter>=65 && (int)letter<=90) {
			System.out.println("�빮�ڸ� �Է��ϼ̽��ϴ�.");
			System.out.printf("�ҹ��ڷ� ��ȯ :%c",(char)letter^32);
		}else if((int)letter>=97 && (int)letter<=122) {
			System.out.println("�ҹ��ڸ� �Է��ϼ̽��ϴ�.");
			System.out.printf("�빮�ڷ� ��ȯ :%c",(char)letter^32);
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �����ڸ� �Է����ּ���.");
		}
		
		//��� ��� ���α׷�
		System.out.print("�����Է� :");
		int number = sc1.nextInt();
		System.out.println("===== ��� =====");
		if(number==0) {
			System.out.printf("[%d]��(��) 3�� ����� 4�� ����� �ƴմϴ�.",number);						
		}else if(number%3==0 && number%4==0) {
			System.out.printf("[%d]��(��) 3�� ����鼭 4�� ����Դϴ�.",number);
		}else if(number%3==0) {
			System.out.printf("[%d]��(��) 3�� ����Դϴ�.",number);			
		}else if(number%4==0) {
			System.out.printf("[%d]��(��) 4�� ����Դϴ�.",number);						
		}else {
			System.out.printf("[%d]��(��) 3�� ����� 4�� ����� �ƴմϴ�.",number);						
		}
		
		
		//switch��
		System.out.print("1~3 ������ �� �Է� : ");
		int num = sc1.nextInt();
		switch(num) {
		case 1 : System.out.println("1�� �Է�");
		break;
		case 2 : System.out.println("2�� �Է�");
		break;
		case 3 : System.out.println("3�� �Է�");
		break;
		default : System.out.println("�߸��Է�");
		}
		*/
		/*
		
		//�� �Է��ϸ� �ش� ��¥�� �� ���� ���
		System.out.print("�ϼ��� �˰� ���� ���� �Է��ϼ��� :");
		int month = sc1.nextInt();
		switch(month) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 :
			System.out.printf("%d������ 31�ϱ��� �ֽ��ϴ�.",month);
			break;
		case 2 :
			System.out.printf("%d������ 29�ϱ��� �ֽ��ϴ�.",month);
			break;
		case 4 :
		case 6 :
		case 9 :
		case 11 :
			System.out.printf("%d������ 30�ϱ��� �ֽ��ϴ�.",month);
			break;
		default : System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
		
		
		//���б� ���� �ý���
		System.out.println("���б� ���� �ý����Դϴ�");
		System.out.print("������ �Է��ϼ��� (A,B,C,D,F) :");
		char score = sc1.next().charAt(0);
		switch(score) {
		case 'A' :
			System.out.println("�����ϼ̽��ϴ�. ���б��� 100% �����ص帮�ڽ��ϴ�.");
			break;
		case 'B' :
			System.out.println("�����ϼ̽��ϴ�. ���б��� 50% �����ص帮�ڽ��ϴ�.");
			break;
		case 'C' :
			System.out.println("���б��� �ٶ�ø� �� �� ������ ���ּ���.");
			break;
		case 'D' :
			System.out.println("ũ��,");
			break;
		case 'F' :
			System.out.println("�� �� �� �� �� �� ��");
			break;
		default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		
		
		//Switch�� �̿��� ����
		System.out.println("========== ���� ���α׷� ==========");
		System.out.print("�����ڸ� �Է��ϼ��� (+,-,*,/):");
		char sign = sc1.next().charAt(0);
		System.out.print("ù ��° ������ �Է��ϼ��� :");
		int num1 = sc1.nextInt();
		System.out.print("�� ��° ������ �Է��ϼ��� :");
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
		default : 		System.out.println("�ٽ� �Է��ϼ���");
		}
		*/
		
		/////////////////////////////////////////////////////////
		
		//������ ���� ��� ���� ���α׷�
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("���� �Է� :");
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
			System.out.printf("%d�� ==> %c ���",score,grade);
		}else {
			System.out.println("�߸��� �Է� (0~100���� �Է�)");
		}
	}

}

