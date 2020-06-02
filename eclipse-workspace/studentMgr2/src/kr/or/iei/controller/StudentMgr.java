package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.vo.Student;

public class StudentMgr {
	//�̸��迭, ���̹迭, �ּҹ迭, ��ĳ��, �ε���
	Student[] students = new Student[10];
	Scanner sc = new Scanner(System.in);
	int index;
	
	public void main() {
		while(true) {
			System.out.println("===== �л� ���� ���α׷� v1.1 =====");
			System.out.println("1. �л� ���� �Է�");
			System.out.println("2. �л� ���� ��� (��ü)");
			System.out.println("3. �л� ���� ��� (1��)");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� >> ");
			int sel = sc.nextInt();
			switch(sel) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudent();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				modifyStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default :
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}	
		}	
	}
	
	public void insertStudent() {
		System.out.println("\n===== �л� ���� �Է� =====");
		System.out.print("�л� �̸� �Է� : ");
		String name = sc.next();
		System.out.print("�л� ���� �Է� : ");
		int age = sc.nextInt();
		System.out.print("�л� �ּ� �Է� : ");
		String addr = sc.next();
		/*
		//�⺻ �����ڸ� �̿��� stu��� ������ �����, stu�� �̸��� �ּҿ� null�� �� ����, ���̴� 0�� ������ ����
		
		Student stu = new Student();
		stu.setName(name);
		stu.setAge(age);
		stu.setAddr(addr);
		*/
		//�Ű����� �����ڸ� �̿��� StudentŬ������ �����ص� Student�Ű� Ŭ������ stu������ �־��ִ� ��
		Student stu = new Student(name,age,addr);
		
		students[index] = stu;
		index++;
	}
	
	public void printAllStudent() {
		System.out.println();
		System.out.println("===== �л� ��ü ���� ��� =====");
		System.out.println("�̸�\t����\t�ּ�");
		for(int i=0; i<index;i++) {
//			System.out.println(students[i].getName()+"\t"+students[i].getAge()+"\t"+students[i].getAddr());
			System.out.println(students[i]);
		}	
	}
	
	public void printOneStudent() {
		System.out.println();
		System.out.println("===== �л� 1�� ���� ��� =====");
		System.out.print("�˻��� �̸��� �Է����ּ��� : ");
		String inputName = sc.next();
		int searchIndex = searchStudent(inputName);
		if(searchIndex!= -1) {
			System.out.println(students[searchIndex].getName()+"\t"+students[searchIndex].getAge()+"\t"+students[searchIndex].getAddr());
			System.out.println();
		}
	}
	
	public int searchStudent(String name) {
		for(int i=0;i<index;i++) {
			if(students[i].getName().equals(name)) {
				return i;
			}
		}
		System.out.println("�̸��� ã�� �� �����ϴ�");
		return -1;
	}
	
	public void modifyStudent() {
		System.out.println();
		System.out.println("===== �л� ���� ���� =====");
		System.out.print("�˻��� �̸��� �Է����ּ��� : ");
		String inputName = sc.next();
		int searchIndex = searchStudent(inputName);
		if(searchIndex!= -1) {
			System.out.println("�л� �̸� �Է� : ");
			String modiName = sc.next();
			System.out.println("�л� ���� �Է� : ");
			int modiAge = sc.nextInt();
			System.out.println("�л� �ּ� �Է� : ");
			String modiAddr = sc.next();
			students[searchIndex].setName(modiName);
			students[searchIndex].setAge(modiAge);
			students[searchIndex].setAddr(modiAddr);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");	
			System.out.println();	
		}

	}
	public void deleteStudent() {
		System.out.println("===== �л� ���� ���� =====");
		System.out.print("������ �л� �̸� �Է� : ");
		String inputName = sc.next();
		int searchIndex = searchStudent(inputName);
		if(searchIndex!= -1) {
			for(int i=0; i<index-1; i++) {
				students[i] = students[i+1];
			}
			students[index-1] = null;
			index--;
		}
		
	}
}
	
	
	
	

