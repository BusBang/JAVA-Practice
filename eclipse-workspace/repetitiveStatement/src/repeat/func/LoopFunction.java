package repeat.func;
import java.util.Scanner;

public class LoopFunction {
	public void Loop1() {
		for(int i=5; i>=1; i--) {
			System.out.println(i+"��° ������");
		}
	}
	public void LoopExam1() {
		for(int i=1; i<=5; i++) {
			System.out.println("�ȳ��ϼ���");
		}
	}
	public void LoopExam2() {
		//�Է��� Ƚ����ŭ �ȳ��ϼ��� ���
		Scanner sc1 = new Scanner(System.in);
		System.out.print("�� �� ����Ͻðڽ��ϱ�? :");
		int num = sc1.nextInt();
		for(int i=1; i<=num; i++) {
			System.out.println("�ȳ��ϼ���");
		}
	}
	public void LoopExam3() {
		//������ 2�� ���
		System.out.println("2�� �Դϴ�.");
		for(int i=1;i<=9;i++) {
			System.out.printf("2*%d=%d\n",i,2*i);
		}
	}
	public void LoopExam4() {
		//�Է��� ���ڿ� �´� ������ ���
		Scanner sc4 = new Scanner(System.in);
		System.out.print("����� ����Ͻðڽ��ϱ�? ");
		int num = sc4.nextInt();
		System.out.printf("%d�� �Դϴ�.\n",num);
		for(int i=1;i<=9;i++) {
			System.out.printf("%d*%d=%d\n",num,i,num*i);
		}
	}
	public void LoopExam5() {
		//�ݺ������� 5�� �ݺ��� �� ���� ����ϴ� ���α׷�
		Scanner sc5 = new Scanner(System.in);
		
		int i;
		int sum=0;
		for(i=1;i<=5;i++) {
			System.out.print("���� ���� �Է��Ͻÿ� :");
			int num =sc5.nextInt();
			sum = sum + num;
		}
		System.out.printf("�Է��� %d���� ������ �� :%d",i-1,sum);
	}
	public void LoopExam6() {
		//���� �� ���� �Է¹ް� �� �� ������ ��� ���� ���� ���ϴ� ���α׷�
		Scanner sc6 = new Scanner(System.in);
		System.out.print("ù ��° �� �Է� : ");
		int num1 = sc6.nextInt();
		System.out.print("�� ��° �� �Է� : ");
		int num2 = sc6.nextInt();
		int sum = 0;
		for(int i=num1;i<=num2;i++) {
			sum = sum + i;
		}
		System.out.printf("%d ~ %d�� ������ �� : %d",num1,num2,sum);
	}
	public void LoopExam7() {
		//���� �Է� �ް� 1���� �Է� ���� ������ ¦������ ���� ���ϴ� ���α׷�
		Scanner sc7 = new Scanner(System.in);
		System.out.print("���� �Է� :");
		int num = sc7.nextInt();
		int even;
		int sum = 0;
		for(int i=1;i<=num;i++) {
			if(i%2==0) {
				even = i;
				sum += even;
			}
		}System.out.printf("¦������ ���� :%d",sum);
	}
	public void Loop2() {
		int i=1;
		while(i<=5) {
			System.out.println(i+"��° �ݺ��ؼ� ���� ��");
			i++;
		}
	}
	public void WhileExam1() {
		int i=1;
		while(i<=5) {
			System.out.println("�ȳ��ϼ���");
			i++;
		}
	}
	public void WhileExam2() {
		Scanner sc2 = new Scanner(System.in); 
		System.out.print("�� �� ����Ͻðڽ��ϱ�?");
		int repeat = sc2.nextInt();
		int i = 1;
		while(i<=repeat) {
			System.out.println("�ȳ��ϼ���");
			i++;
		}
	}
	public void WhileExam3() {
		System.out.println("2���Դϴ�");
		int i = 1;
		while(i<=9) {
			System.out.printf("2*%d=%d\n",i,2*i);
			i++;
		}
	}
	public void WhileExam4() {
		Scanner sc4 = new Scanner(System.in);
		System.out.print("�� ���� ����Ͻðڽ��ϱ�?");
		int num = sc4.nextInt();
		System.out.printf("%d���Դϴ�.\n",num);
		int i=1;
		while(i<=9) {
			System.out.printf("%d*%d=%d\n",num,i,num*i);
			i++;
		}
	}
	public void WhileExam5() {
		//�ݺ��� 5�� �ݺ�, �Է¹��� ���ڵ��� ��
		Scanner sc5 = new Scanner(System.in);
		int i = 1;
		int sum = 0;
		while(i<=5) {
			System.out.print("�������� �Է��Ͻÿ� :");
			int num = sc5.nextInt();
			sum += num;
			i++;
		}
		System.out.printf("�Է��� %d���� ������ �� :%d",i-1,sum);
	}
	public void WhileExam6() {
		//���� �� ���� �Է¹ް� �� �� ������ ��� ���� ���� ���ϴ� ���α׷�
		Scanner sc6 = new Scanner(System.in);
		System.out.print("ù ��° �� �Է� :");
		int num1 = sc6.nextInt();
		System.out.print("�� ��° �� �Է� :");
		int num2 = sc6.nextInt();
		int sum = 0;
		int i = num1;
		while(i<=num2) {
			sum += i;
			i++;
		}
		System.out.printf("%d ~ %d�� ������ �� : %d",num1,num2,sum);
	}
	public void WhileExam7() {
		//1���� �Է¹��� ���ڱ����� ��� ¦���� ��
		Scanner sc7 = new Scanner(System.in);
		System.out.print("���� �Է� :");
		int input = sc7.nextInt();
		int start = 1;
		int sum = 0;
		while(start<=input) {
			if(start%2==0) {
				sum += start;
			}
			start++;
		}
		System.out.printf("¦������ ���� :%d",sum);
	}
	public void DoWhile() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է�");
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
		//���� �ݺ��� ��� ��
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("�ѹ���[y/n]?");
			char ch = sc.next().charAt(0);
			if (ch=='n') {
				break; //�ݺ����� ���������� ���
			}else {
				System.out.println("�ݺ�");
			}
		}
		System.out.println("��");
	}
	public void breakTest() {
		//break ����.
		for(int i=1; i<=10;i++) {
			System.out.println(i+"���");
			if(i==5) {
				break; //i�� 5�� �Ǵ� ���� break�� ����, test1�� �������� �ʰ� for���� ���������� ��. �׷��Ƿ� test1�� 4���� ���
			}
			System.out.println("test1");
		}
		System.out.println("test2");
	}
	public void continueTest() {
		//continue ����.
		for(int i=1; i<=10;i++) {
			System.out.println(i+"���");
			if(i==5) {
				continue; //i�� 5�� �Ǵ� ���� continue�� ���� ����, �ٷ� for�� ���� �������� ������. �׷��Ƿ� 5��¶� test1�� ��µ��� ����.
			}
			System.out.println("test1");
		}
		System.out.println("test2");
	}
	public void con2() {
		//continue ����2.
		for(int i=1; i<=10;i++) {
			System.out.println(i+"���");
			if(i%2==0) {
				continue; //i�� ¦���� �� ���� continue ����, �׷��Ƿ� test1�� Ȧ������ ���
			}
			System.out.println("test1");
		}
		System.out.println("test2");
	}
	
	

}
