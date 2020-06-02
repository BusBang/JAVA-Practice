package kh.or.iei.student;

import java.util.Scanner;

public class StudentFunc {

	Scanner sc = new Scanner(System.in);
	String [] name = new String [100];
	int [] age = new int [100];
	String [] address = new String [100] ;
	int index;
	
	public void main(){
	
		while(true) {
			System.out.println("====== �л� ���� ���α׷� v1.0 ======");
			System.out.println("1. �л����");
			System.out.println("2. �л� ���� ��ȸ(��ü)");
			System.out.println("3. �л� ���� ��ȸ(1��)");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� >> ");
			int selMain = sc.nextInt();
			
			switch(selMain) {
			case 1 : //�л� ���
				enroll();
				break;
			case 2 : //�л� ���� ��ȸ ��ü
				viewAllStudent();
				break;
			case 3 : //�л� ���� ��ȸ 1��
				viewStudent();
				break;
			case 4 : //�л� ���� ����
				modify();
				break;
			case 5 : //�л� ���� �� ��
				delete();
				break;
			case 0 : //���α׷�����
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�.  �ٽ� �Է����ּ���.");
			}
		}
		
	}
	public void enroll() {
		System.out.println();
		System.out.println("====== �л� ���� ��� ======");
		System.out.print("�̸� : ");
		name[index] = sc.next();
		System.out.print("���� : ");
		age[index] = sc.nextInt();
		System.out.print("�ּ� : ");
		sc.nextLine();
		address[index] = sc.nextLine();
		index++;
	}
	public void viewAllStudent() {
		System.out.println();
		System.out.println("==== �л� ���� ��ȸ (��ü) ====");
		System.out.println("�̸�\t����\t�ּ�");
		for(int i=0;i<index;i++) {
			System.out.println(name[i]+"\t"+age[i]+"\t"+address[i]);
		}
		System.out.println();
	}
	public void delete() {
		System.out.println();
		System.out.println("====== �л� ���� ���� ======");
		int searchIndex = search();
		if(searchIndex!=1) {
			for(int i=searchIndex; i<index-1; i++) {
				name[i]=name[i+1];
				age[i]=age[i+1];
				address[i]=address[i+1];
			}
		name[searchIndex]=null;
		age[searchIndex]=0;
		address[searchIndex]=null;
		index--;
		}
	}

	public void modify() {
		System.out.println();
		System.out.println("====== �л� ���� ���� ======");
		int searchIndex = search();
		if(searchIndex != -1) {
			System.out.print("�̸� ���Է� : ");
			name[searchIndex] = sc.next();
			System.out.print("���� ���Է� : ");	
			age[searchIndex] = sc.nextInt();
			System.out.print("�ּ� ���Է� : ");
			sc.nextLine();
			address[searchIndex] = sc.nextLine();
			System.out.println("���Է� �Ϸ��Ͽ����ϴ�.");
		}	
	}
	
	public void viewStudent() {
		System.out.println();
		System.out.println("==== �л� ���� ��ȸ (1��) ====");
		int searchIndex = search();
		if(searchIndex != -1) {
			System.out.println(name[searchIndex]+"\t"+age[searchIndex]+"\t"+address[searchIndex]);		
		}
		System.out.println();
	}
	
	public int search() {
		System.out.print("�˻� �̸� �Է� : ");
		String inputName = sc.next();
		for(int i=0;i<index;i++) {
			if(name[i].equals(inputName)) {
				return i;
			}
		}
		System.out.println("�л� ������ �����ϴ�.");
		return -1;
		
	}

}
