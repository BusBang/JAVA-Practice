package kh.or.iei.student;

import java.util.Scanner;

public class StudentFunc {
	String [] names = new String [10];		//�л� �̸� ���� �迭
	int [] ages = new int [10];				//�л� ���� ���� �迭
	String [] addrs = new String [10];		//�л� �ּ� ���� �迭
	int index;								//�迭 �ε��� ������ ����
	Scanner sc= new Scanner(System.in);

	public void main() {
		while(true) {
			System.out.println("======== �л� ���� ���α׷� v1.0 ========");
			System.out.println("1. �л����");
			System.out.println("2. �л� ���� ��ȸ(��ü)");
			System.out.println("3. �л� ���� ��ȸ(1��");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� >> ");
			int selMain = sc.nextInt();
			switch(selMain) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudents();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				modifyStudent();
				break;
			case 5:
				break;
			case 0:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default :
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void insertStudent() {
		
		System.out.println();
		System.out.println("======�л� ���� �Է�======");
		System.out.print("�̸� �Է� : ");
		String insertName = sc.next();
		System.out.print("���� �Է� : ");
		int insertAge = sc.nextInt();
		System.out.print("�ּ� �Է� : ");
		sc.nextLine(); //���� ���� ���ſ� �ڵ�
		String insertAddr = sc.nextLine();
		
		names[index] = insertName;
		ages[index] = insertAge;
		addrs[index] = insertAddr;
		index++;
		
		System.out.println("�л� ���� ��� ���� !!");
	}
	public void deleteStudent() {
		System.out.println("\n===== �л� ���� ���� =====");
		int searchIndex = searchStudent("����");
		if(searchIndex != -1) {
			for(int i=searchIndex;i<index-1;i++) {
				names[i] = names[i+1];
				ages[i] = ages[i+1];
				addrs[i] = addrs[i+1];
			}
			names[index] = null;
			ages[index] = 0;
			addrs[index] = null;
			index--;
			
		}
		
	}
	public void printAllStudents() {
		System.out.println("\n ====== �л� ���� ��ü ��� ====== ");
		System.out.println("[�̸�]\t[����]\t[�ּ�] ");
		for(int i=0; i<index; i++) {
			System.out.println(names[i]+"\t"+ages[i]+"\t"+addrs[i]);
		}
	}
	
	public void printOneStudent() {
		System.out.println("\n ====== �л� ���� ��� ====== ");
		int searchIndex = searchStudent("��ȸ");
		
		if(searchIndex!=-1) {
			System.out.println("[�̸�]\t[����]\t[�ּ�] ");
			System.out.println(names[searchIndex]+"\t"+ages[searchIndex]+"\t"+addrs[searchIndex]);
		}
	}
	
	public void modifyStudent() {
		System.out.println("\n===== �л� ���� ���� =====");
		int searchIndex = searchStudent("����");
		
		if(searchIndex!=-1) {
			System.out.println("======�л� ���� �Է�======");
			System.out.print("�̸� �Է� : ");
			names[searchIndex] = sc.next();
			System.out.print("���� �Է� : ");
			ages[searchIndex] = sc.nextInt();
			System.out.print("�ּ� �Է� : ");
			sc.nextLine(); //���� ���� ���ſ� �ڵ�
			addrs[searchIndex] = sc.nextLine();
		}
	}
	public void insertStudentData(String inName, int inAge, String inAddr) {
		
	}
	public int searchStudent(String msg) {
		System.out.print(msg+"�� �л� �̸� �Է� : ");
		String name = sc.next();
		for(int i=0;i<index;i++) {
			if(names[i].equals(name)) {
				return i;
			}
		}
		System.out.println("�л� ������ �����ϴ�.");
		return -1;
	}

}
