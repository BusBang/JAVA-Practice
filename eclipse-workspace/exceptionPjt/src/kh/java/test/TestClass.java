package kh.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestClass {
	Scanner sc= new Scanner(System.in);
	public void test1() {
		System.out.println("������ ���α׷�");
		System.out.print("ù ��° �� �Է� : ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° �� �Է� : ");
		int num2 = sc.nextInt();
		try {			
			int result = num1/num2; ///�����߻��� �� �ڵ������� ���߰� �ٷ� catch�� ���ĳ���
			System.out.println("��� : "+result);
		}catch (Exception e) {
			System.out.println("0���δ� ���� �� �����ϴ�.");
		}
	}
	public void menuPrint() {
		System.out.println("����");
		System.out.println("1. ������ ����");
		System.out.println("2. ���� ���°���?");
		System.out.println("3. �ȿ͵�... ũ��");
		System.out.print("�Է� : ");
	}
	public void test2(int choice) {
		switch(choice) {
			case 1 : 
				System.out.println("������ ����");
				break;
			case 2: 
				System.out.println("�������� ����?");
				break;
			case 3:
				System.out.println("�ȿ͵� .. ũ��");
				break;
			default :
				System.out.println("1~3���� ���� �Է����ּ���");
				break;
		}
	}
	public void start() {
		int choice = 0;
		menuPrint();
		try {
		choice = sc.nextInt();
		test2(choice);
		}catch (Exception e){
			System.out.println("���ڸ� �����մϴ�.");
		}finally{
			System.out.println("���α׷��� ����˴ϴ�");
		}
	}
	
	public void test3() throws FileNotFoundException{
			FileInputStream fis = new FileInputStream("Test.txt");
	}
	public void test4() throws FileNotFoundException {
		test3();
	}
	public void div(int num1, int num2) {
		if(num2 ==0) {
			throw new ExceptionTest2("0000���� ������ �Ұ�");
//			try {
//				throw new ExceptionTest1("0���� ���� �� �����ϴ�.");
//			} catch (ExceptionTest1 e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println(num1/num2);
		
	}

}
