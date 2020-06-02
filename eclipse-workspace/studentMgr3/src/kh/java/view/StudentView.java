package kh.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.model.vo.Student;

public class StudentView {
	Scanner sc = new Scanner(System.in);
	public int mainMenu() { //�信�� ������ �޾Ƽ� ��Ʈ�ѷ��� �ǵ����ٰ���.
		System.out.println("----- �л� ���� ���α׷� -----");
		System.out.println("1. �л� ���");
		System.out.println("2. �л� ��ü ���");
		System.out.println("3. �л� 1�� ���");
		System.out.println("4. �л� ���� ����");
		System.out.println("5. �л� ���� ����");
		System.out.println("0. ���α׷� ����");
		System.out.print("���� >> ");
		int select = sc.nextInt();
		return select;
	}
	public Student insertStudent() {
		System.out.println("----- �л� ���� �Է� -----");
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		System.out.print("�ּ� �Է� : ");
		String addr = sc.next();
		Student insertS = new Student(name, age, addr); //���� Ÿ���� 1������ �����ϴ�. ���������� ��Ʈ�ѷ��� ������ ���� StudentŸ������ �����Ѵ�. �� �������� vo.Student�� �ʿ��ϴ�
		return insertS;

	}
	public void viewAllStudent(ArrayList<Student> stud) { //��ü ����� ���� for���� ����ϱ� ���� ��Ʈ�ѷ��� Student�� �޾ƾ��Ѵ�.
		System.out.println("----- �л� ��ü ��� -----");
		System.out.println("�̸�\t����\t�ּ�"); 
		for(Student start : stud) {
			System.out.println(start);
		}
	}
	public String inputName() {
		System.out.print("�л� �̸� �Է� : ");
		String name = sc.next();
		return name;
	}
	public void viewOnStudent(Student s) {
		System.out.println("�̸�\t����\t�ּ�");
		System.out.println(s);		
	}
	public void printMsg(String msg) {
		System.out.println(msg);
		
	}
	public Student modifyStudent() {
		System.out.print("�� �̸� �Է� : ");
		String newName = sc.next();
		System.out.print("�� ���� �Է� : ");
		int newAge = sc.nextInt();
		System.out.print("�� �ּ� �Է� : ");
		String newAddr = sc.next();
		Student modifys = new Student(newName, newAge, newAddr);
		return modifys;
	}


	
}
