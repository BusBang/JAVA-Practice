package kr.or.iei.func;
import java.util.Scanner;
public class Example {
	public void exam1() {
		int num1;
		num1 = 100;
		char ch1 = '1';
		long lNum = 10000L;
		float fNum = 3.14f;
		final double PI = 3.14;
		System.out.println(num1);
		System.out.println("���� ��� : "+(num1+num1));
		System.out.println("���� ��� : "+(ch1+ch1));
		System.out.println("long ���"+lNum);
		System.out.println("float ���"+fNum);
		System.out.println(PI);
		num1 =200;
		System.out.println(num1);
		System.out.println("���� ��� : "+(num1+num1));
//		/* ctrl + /
//		����� �ٲ� �� ���� ������ �߻��Ѵ�
//		PI = 2.24;
//		System.out.println(PI);
//		*/		
	}
	
	public void exam2() {
		//���� 4�� ����
		//�̸������� ���� -> String
		String name = "����ȣ";
		//���� -> int
		int age = 27;
		//�ּ� -> String
		String address = "�������� ����";
		//����(��/��) -> char
		char sex = '��';	
		//�� ���� ���� �� ���� ���� �Է� �� ���
		System.out.println("�̸� :"+name);
		System.out.println("���� :"+age);
		System.out.println("�ּ� :"+address);
		System.out.println("���� :"+sex);
	}
	
	public void testMethod() {
		int num = 2147483647;
		int result = num + 1;
		System.out.println(result);
	}
	
	public void testMethod2() {
		int num = 2147483647;
		long result = (long)num + 1;
		System.out.println(result);
	}
	
	
	public void exam4() {
		int num=10;
		System.out.println("������ ���� num�ȿ� ����ִ� ���� "+num+"�Դϴ�.");
		System.out.printf("������ ���� num�ȿ� ����ִ� ���� %d�Դϴ�.\n",num);
	}
	
	public void exam5() {
		int num1=10;
		int num2=20;
		//System.out.println�� System.out.printf��
		//10+20=30 �Դϴ�. ���
		System.out.println(num1+"+"+num2+"="+(num1+num2)+"�Դϴ�.");
		System.out.printf("%d+%d=%d�Դϴ�.\n", num1,num2,num1+num2);
		
		double d =1.126123123123;
		System.out.println(d);
		System.out.printf("%.2f",d);
		//�Ҽ��� 2��° �ڸ����� ǥ�� (�ݿø�)
		
	}
	//����ǥ�� �����⸦ ��� �� �� ������? --> �̽������� ���ڸ� Ȱ���ؼ� 	
	
	public void testMethod3() {
		int one = 100;
		long two = 999900000000L;
		float three = 486.520f;
		double four = 5697.890123;
		char five = 'A';
		String six = "Hello JAVA";
		boolean seven = true;
		
		System.out.println(one);
		System.out.println(two);
		System.out.println(three);
		System.out.println(four);
		System.out.println(five);
		System.out.println(six);
		System.out.println(seven);	
	}
	
	public void testMethod4() {
		String nameHead = "�̸�";
		String ageHead = "����";
		String genderHead = "����";
		String addressHead = "�ּ�";
		String numberHead = "��ȭ��ȣ";
		String emailHead = "�̸���";
		
		String name1 = "����ȣ";
		int age1 = 27;
		char gender1 = '��';
		String address1 = "�����";
		String number1 = "010-2522-8575";
		String email1 = "bang8255@naver.com";
		
		String name2 = "������";
		int age2 = 26;
		char gender2 = '��';
		String address2 = "�����";
		String number2 = "010-9901-8058";
		String email2 = "dighfkql@naver.com";
		
		String name3 = "�ڼ���";
		int age3 = 25;
		char gender3 = '��';
		String address3 = "�����";
		String number3 = "010-5063-****";
		String email3 = "pspp2@naver.com";
		
		System.out.printf("%s\t%s\t%s\t%s\t%s\t\t%s\n",nameHead,ageHead,genderHead,addressHead,numberHead,emailHead);
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\n",name1,age1,gender1,address1,number1,email1);
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\n",name2,age2,gender2,address2,number2,email2);
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s\n",name3,age3,gender3,address3,number3,email3);
	}
	
	public void scan() {
		Scanner sc = new Scanner(System.in);//����غ�
		//������ �Է¹޴� ���
		System.out.print("���� �Է� : ");
		int inputNumber; //���� ���� ����, �ֱ�
		inputNumber = sc.nextInt(); // ����ڰ� �Է��� �� �ֱ� / �Է´��. �ֿܼ� �Է� �� ���͸� ������ inputNumber�� system out�� �־���.
		//sc.nextInt(); --> �Է��� ��ٸ��� ���͸� ������ ��� �� �����. �׷��� ���� ���� ���� �� ��.
		//Console â�� ���ư��� �ִ����� Ȯ���� ����� ���ư����� Ȯ��
		System.out.println("����ڰ� �Է��� �� : "+inputNumber);
		
		//�Ǽ��� �Է¹޴� ���
		System.out.println("�Ǽ� �Է� : "); //println�� ��� ������ �Ʒ��ٿ��� ���� ����
		double dNumber = sc.nextDouble();
		System.out.println("����ڰ� �Է��� ��: "+dNumber);
		
		//���ڿ� �Է¹޴� ��� - �� ������ �������� �˰� �־�� ��
		System.out.println("ù ��° ���ڿ� �Է�: ");
		String str1 = sc.next();
		System.out.println("str1 : "+str1);
		sc.nextLine(); //�� �ڵ忡�� ������ ���Ͱ� �� �� �����ֱ� ������, sc.nextLine()���� ���͸� �Ծ���� ��
		//sc.nextLine()�� ���� ���� ���͸� ���ִ� �뵵�� �� �� �� �߰��� ����Ѵ�. ���� ���� ��
		//���۰� ���� ���� ó������ ����Ͽ��� ��, �Է� ���� ����ϸ� �ȴ�

		System.out.println("�� ��° ���ڿ� �Է�: ");
		String str2 = sc.nextLine();
		System.out.println("str2 : "+str2);
		//ù ��°�� ���, ���⸦ �ϸ� ©����.
		//sc.next();�� ���⸦ �������� ���ϱ� ������ ���Ⱑ ���� �͸� ����
		//�� ��°�� ���, ������� ������.
		//sc.nextLine(); ���⸦ �����ϴ� ��쿡 ����ϸ� ����
		
		//���� �Է� �޴� ���
		System.out.println("���� �Է� :");
		char ch = sc.next().charAt(0); //���ڸ� �д� ����� �������� �ʰ�, ���ڿ��� �޾ƿͼ� ù ��° ���ڸ� ������ ���. �� ��° ������ ��� 1�� �ٲٸ� ��
		System.out.println("�Է��� ���ڴ� :"+ch);
		//�� ���ư��� ���� ("str2 : "+str2.charAt(1)); �� �����ϰ� �Ǹ� �� ��° ���ڸ� ����.
		//������ ������ char�� ��ȯ�� ������ �� �� �ִ� ����.
	}
	
	public void question1() {
		Scanner q1 = new Scanner(System.in);

		System.out.print("���� �̸� :");
		String inputName = q1.nextLine();
		System.out.println("���� �̸� :"+inputName);
		
		System.out.print("���� ���� :");
		int inputAge = q1.nextInt();
		System.out.println("���� ���� :"+inputAge);
		
		q1.nextLine();
		System.out.print("���� �ּ� :");
		String address = q1.nextLine();
		System.out.println("���� �ּ� :"+address);
		
		System.out.print("���� Ű :");
		double inputHeight = q1.nextDouble();
		System.out.println("���� Ű :"+(int)inputHeight);

		System.out.print("���� ������ :");
		double weight = q1.nextDouble();
		System.out.println("���� ������ :"+weight);
		
		System.out.print("���� ���� :");
		char gender = q1.next().charAt(0);
		System.out.println("���� ���� :"+gender);
		System.out.printf("%s,%d,%s,%d,%.1f,%c",inputName,inputAge,address,(int)inputHeight,weight,gender);
	}
	public void question2() {
		Scanner q2 = new Scanner(System.in);
		
		System.out.print("�������� �Է� :");
		int kor = q2.nextInt();
		System.out.println("�������� �Է� :"+kor);
		
		System.out.print("�������� �Է� :");
		int mat = q2.nextInt();
		System.out.println("�������� �Է� :"+mat);
		
		System.out.print("�������� �Է� :");
		int eng = q2.nextInt();
		System.out.println("�������� �Է� :"+eng);
		
		System.out.printf("��� ������ �� ���� %d���̰� ����� %.2f�Դϴ�.",kor+mat+eng,(double)(kor+mat+eng)/3);
	}

}
