package kh.java.collection;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kh.java.collection.vo.Student;

public class StudentMgrMap {
	HashMap<String, Student> students = new HashMap<String, Student>();
	Scanner sc = new Scanner(System.in);
	
	public void main() {
		while(true) {
			System.out.println("\n ========�л� ���� ���α׷�=========");
			System.out.println("1. �л����");
			System.out.println("2. �л� ��ü ���");
			System.out.println("3. �л� 1�� ���� ���");
			System.out.println("4. ���� ����");
			System.out.println("5. ���� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� >>");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudent();
				break;
			case 3 :
				printOneStudent();			
				break;
			case 4:
				modifyStudent();
				break;
			case 5 :
				deleteStudent();
				break;
			case 0 :
				return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
		}
		
	}

	private void printOneStudent() {
		System.out.println("-------�л� 1�� ���-------");
		System.out.print("��ȸ�� �л� �̸� �Է� : ");
		String name = sc.next();
		if(students.containsKey(name)) {
			System.out.println("�̸�\t����\t�ּ�");
			System.out.println(students.get(name)); //toString�� �Ǿ��ֱ� ������ ����� ������ ��
		}else {
			System.out.println("�ش� �̸��� ���� �л��� �������� �ʽ��ϴ�. ");
		}
		
		
	}

	private void deleteStudent() {
		System.out.println("-------�л� 1�� ���-------");
		System.out.print("������ �л� �̸� �Է� : ");
		String name = sc.next();
		if(students.containsKey(name)) {
			System.out.println("������ �����Ͻðڽ��ϱ�? [y/n]");
			char choice = sc.next().charAt(0);
			if(choice=='y') {
				students.remove(name);
				System.out.println("�����Ͽ����ϴ�. ");
			}else {
				System.out.println("���� ����� ����մϴ�. ");
				return;
			}
			
		}else {
			System.out.println("���� �̸��Դϴ�. �ٽ� �Է����ּ���. ");
		}
	}

	private void modifyStudent() {
		System.out.println("-------�л� 1�� ���-------");
		System.out.print("������ �л� �̸� �Է� : ");
		String name = sc.next();
		if(students.containsKey(name)) {
			System.out.print("�� �̸� �Է� : ");
			String newName = sc.next();
			System.out.print("�� ���� �Է� : ");
			int newAge = sc.nextInt();
			System.out.print("�� �ּ� �Է� : ");
			String newAddr = sc.next();
			students.remove(name);
			students.put(name, new Student(newName, newAge, newAddr));
		}else {
			System.out.println("���� �̸��Դϴ�. �ٽ� �Է����ּ���.");
		}
	}

	private void printAllStudent() {
		System.out.println("-------�л� ��ü ���-------");
		System.out.println("�̸�\t����\t�ּ�");
		Set<String> studentKeys = students.keySet();
		for(String sk : studentKeys) {
			System.out.println(students.get(sk));
		}
	}

	private void insertStudent() {
		System.out.println("-------�л� ���� ���-------");
		String name = "";
		while(true) {
			System.out.print("�̸� �Է� : ");
			name = sc.next();
			if(students.containsKey(name)) {
				System.out.println("�ߺ��� �̸��Դϴ�. �ٽ� �Է����ּ���.");
			}else {
				break;
			}
		}
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		System.out.print("�ּ� �Է� : ");
		String addr = sc.next();
		Student ns = new Student(name, age, addr);
		students.put(name, ns);
	}

}
