package example.java;
import java.util.Scanner;

public class ExampleVariable {
	public void exam1() {
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("�̸� �Է� :");
		String name = sc1.next();
		
		System.out.print("���� �Է� :");
		int age = sc1.nextInt();
		
		sc1.nextLine();
		System.out.print("�ּ� �Է� :");
		String address = sc1.nextLine();
		
		System.out.print("Ű �Է� :");
		double height = sc1.nextDouble();
		
		System.out.print("������ �Է� :");
		double weight = sc1.nextDouble();
		
		System.out.print("���� �Է� :");
		char sex = sc1.next().charAt(0);
		
		System.out.printf("�̸�:%s, ����:%d, �ּ�:%s, Ű:%d, ������:%.1f, ����:%c",
							name,age,address,(int)height,weight,sex);	
	}
	
	public void exam2() {
		System.out.println("�̸�\t����\t����\t����\t��ȭ��ȣ\t\t�̸���");
		String name = "����ȣ";
		int age = 27;
		char sex = '��';
		String address = "�����";
		String phone = "010-2522-8575";
		String mail = "bang8255@naver.com";
		System.out.printf("%s\t%d\t%c\t%s\t%s\t%s",name, age, sex, address, phone, mail);
		
	}

}
