package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Silver;

public class PointMgr {
	
	Scanner sc = new Scanner(System.in);
	Silver [] silvers = new Silver[30];
	int index;
	
	public void main() {
		while(true) {
			System.out.println();
			System.out.println("<<<<����Ʈ ���� ���α׷� v1.0>>>>");
			System.out.println();
			System.out.println("========== ���� �޴� ==========");
			System.out.println("1. ȸ�� ����");
			System.out.println("2. ȸ�� ���� ��� (��ü)");
			System.out.println("3. ȸ�� ���� ��� (1��)");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� Ż��");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� >> ");
			int selectMain = sc.nextInt();
			switch(selectMain) {
			case 1 :
				enroll();
				break;
				
			case 2 : 
				viewAll();
				break;
			case 3 :
				viewOne();
				break;
			case 4 : 
				modiUser();
				break;
			case 5 : 
				delUser();
				break;
			case 0 : 
				System.out.println("���α׷��� �����մϴ�");
				return;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}
	
	public void enroll() {
		System.out.println("======== ȸ������ ========");		
		System.out.println("<�˸�> �ߺ� �˻縦 ���� �̸��� �Է����ּ���. ");
		System.out.print("�̸� �Է� >> ");
		String inputName = sc.next();
		int dupliNumber = duplicate(inputName);
		if(dupliNumber==-1) {
			System.out.println("<�˸�> �ߺ��� �̸��� �ƴմϴ�.");
			System.out.print("��� �Է� >> ");
			String inputGrade = sc.next();
			System.out.print("����Ʈ���� �Է� >> ");
			int inputPoint = sc.nextInt();
			
			silvers[index] =new Silver(inputGrade, inputName, inputPoint);
			index++;
		}else {
			System.out.println("�ߺ��� �̸��� �ֽ��ϴ�. ���ο� �̸��� �Է����ּ���.");
			return;
		}
		
	}
	//�ߺ� �˻�, ȸ�� �˻�
	public int duplicate(String name) {
		for(int i=0;i<index;i++) {
			if(silvers[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	//��� ȸ�� ���� ���
	public void viewAll() {
		System.out.println("======== ȸ�� ��ü ���� ��� ==========");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�����Ʈ");
		for(int i=0;i<index;i++) {
			System.out.println(silvers[i].getGrade()+"\t"+silvers[i].getName()+"\t"+
								silvers[i].getPoint()+"\t"+silvers[i].getBonus()+"\t");
		}
	}

	public void viewOne() {
		System.out.println("======== 1�� ȸ�� ���� ��� ==========");
		System.out.println("�̸��� �Է����ּ��� : ");
		System.out.print("�̸� �Է� >> ");
		String inputName = sc.next();
		int searchNumb = duplicate(inputName);
		if(searchNumb!=-1) {
			System.out.println(silvers[searchNumb].getGrade()+"\t"+silvers[searchNumb].getName()+"\t"+
					silvers[searchNumb].getPoint()+"\t"+silvers[searchNumb].getBonus()+"\t");			
		}else {
			System.out.println("ã�� �̸��� �����ϴ�.");
		}
	}
	
	public void modiUser() {
		System.out.println("======== ȸ�� ���� ���� ========");
		System.out.println("�̸��� �Է����ּ��� : ");
		System.out.print("�̸� �Է� >> ");
		String inputName = sc.next();
		int searchNumb = duplicate(inputName);
		if(searchNumb!=-1) {
			System.out.print("�̸� �Է� : ");
			String inputNewName = sc.next();
			System.out.print("��� �Է� : ");
			String inputGrade = sc.next();
			System.out.print("����Ʈ �Է� : ");
			int inputPoint = sc.nextInt();
			silvers[searchNumb].setGrade(inputGrade);
			silvers[searchNumb].setName(inputNewName);
			silvers[searchNumb].setPoint(inputPoint);
		}else {
			System.out.println("ã�� �̸��� �����ϴ�.");
		}
	}
	public void delUser() {
		System.out.println("======== ȸ�� ���� ���� ========");
		System.out.println("�̸��� �Է����ּ��� : ");
		System.out.print("�̸� �Է� >> ");
		String inputName = sc.next();
		int searchNumb = duplicate(inputName);
		if(searchNumb!=-1) {
			for(int i=searchNumb;i<index-1;i++) {
				silvers[i] = silvers[i+1]; 
			}
			silvers[index-1]=null;
			index--;
		}
	}
}
