package kh.java.collection;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.collection.vo.Student;

public class StudentMgr {
	Scanner sc = new Scanner(System.in);
	ArrayList<Student> students = new ArrayList<Student>();
	
	public class studentMGR {
		
	}
	
	public void main() {
		while(true) {
			System.out.println("\n ======== �л� ���� ���α׷� =========");
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
				printOntStudent();			
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
	private void deleteStudent() {
		System.out.println("\n===== �л� ���� ���� =====");
		System.out.print("������ �л� �̸� �Է� : ");
		String name = sc.next();
		int searchIndex = sc.nextInt();
		if(searchIndex == -1) {
			System.out.println("�л� ������ �����ϴ�.");
		}else {
			students.remove(searchIndex);
		}
	}
	private void printAllStudent() {
		if(students.isEmpty()) {
			System.out.println("����� �л� ������ �����ϴ�. ");
		}else {
			System.out.println("\n===== �л� ���� ��� 1�� =====");
			System.out.println("�̸�\t����\t�ּ�");
			//�迭�̳� �÷��ǰ� ���� �������� ���θ� ���� �ϳ��� ���� ��. for its�� ?
			for(Student s : students) {
				System.out.println(s);
			}
//			for(int i=0; i<students.size();i++) {
//				System.out.println(students.get(i));
//			}
		}
	}
	private void modifyStudent() {
		System.out.println("\n======= �л� ���� ���� =======");
		System.out.print("������ �л� �̸� �Է� : ");
		String name = sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex ==-1) {
			System.out.println("�������� �ʴ� �л��Դϴ�. ");
		}else {
			System.out.print("�� �̸� �Է� : ");
			String newName = sc.next();
			System.out.print("�� ���� �Է� : ");
			int newAge = sc.nextInt();
			System.out.print("�� �ּ� �Է� : ");
			String newAddr = sc.next();
			students.get(searchIndex).setName(newName);
			students.get(searchIndex).setAge(newAge);
			students.get(searchIndex).setAddr(newAddr);	
		}
		
	}
	public void insertStudent() {
		System.out.println("\n======= �л� ���� �Է� =======");
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		System.out.print("�ּ� �Է� : ");
		String addr = sc.next();
		Student s = new Student(name, age, addr);
		students.add(s);		
	}
	public void printOntStudent() {
		System.out.println("\n===== �л� ���� ��� 1�� =====");
		System.out.print("��ȸ�� �л� �̸� �Է� : ");
		String name =sc.next();
		int searchIndex = searchStudent(name);
		if(searchIndex ==-1) {
			System.out.println("�������� �ʴ� �л��Դϴ�. ");
		}else {
			System.out.println("�̸�\t����\t�ּ�");
			System.out.println(students.get(searchIndex));
		}
	}
	public int searchStudent(String name) {
		for(int i=0;i<students.size(); i++) {
			if(students.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	

}
