package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Grade;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;
import kr.or.iei.point.Vvip;

public class PointMgr {
	
	Grade [] members = new Grade[40];
	int index;
	Scanner sc = new Scanner(System.in);
	public PointMgr() {
		
	}
	
//	char grade;
	
	
	public void main() {
		while(true) {
			System.out.println();
			System.out.println("<<<<����Ʈ ���� ���α׷� v1.6>>>>");
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
			System.out.println("ȸ�� ��� �Է� [Silver/Gold/Vip/Vvip]");
			System.out.print("��� �Է� >>");
			String inputGrade = sc.next().toUpperCase();
			System.out.print("����Ʈ���� �Է� >> ");
			int inputPoint = sc.nextInt();
			switch(inputGrade) {
			case "SILVER" :
				members[index++] = new Silver(inputGrade, inputName, inputPoint);
				break;
			case "GOLD" :
				members[index++] = new Gold(inputGrade, inputName, inputPoint); 
				break;
			case "VIP" :
				members[index++] = new Vip(inputGrade, inputName, inputPoint);
				break;
			case "VVIP" :
				members[index++] = new Vvip(inputGrade, inputName, inputPoint);
				break;
			}
		}else {
			System.out.println("�ߺ��� �̸��� �ֽ��ϴ�. ���ο� �̸��� �Է����ּ���.");
			return;
		}	
	}
	//�ߺ� �˻�, ȸ�� �˻�
	public int duplicate(String name) {
		for(int i=0;i<index;i++) {
			if(members[i].getName().equals(name)) {
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
			System.out.println(members[i].getGrade()+"\t"+members[i].getName()+"\t"+
								members[i].getPoint()+"\t"+members[i].getBonus()+"\t");
		}
	}

	public void viewOne() {
		System.out.println("======== 1�� ȸ�� ���� ��� ==========");
		System.out.println("�̸��� �Է����ּ��� : ");
		System.out.print("�̸� �Է� >> ");
		String inputName = sc.next();
		int searchNumb = duplicate(inputName);
		if(searchNumb!=-1) {
				System.out.println(members[searchNumb].getGrade()+"\t"+members[searchNumb].getName()+"\t"+
									members[searchNumb].getPoint()+"\t"+members[searchNumb].getBonus()+"\t");			
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
			System.out.print("���ο� �̸� �Է� : ");
			String inputNewName = sc.next();
			System.out.println("���ο� ��� �Է� [silver/gold/vip/vvip]");
			System.out.print("���ο� ��� �Է� : ");
			String inputGrade = sc.next().toUpperCase();
			System.out.print("���ο� ����Ʈ �Է� : ");
			int inputPoint = sc.nextInt();
			switch(inputGrade) {
			case "SILVER" :
				members[searchNumb] = new Silver(inputGrade, inputNewName, inputPoint);
				break;
			case "GOLD" :
				members[searchNumb] = new Gold(inputGrade, inputNewName, inputPoint);
				break;
			case "VIP" :
				members[searchNumb] = new Vip(inputGrade, inputNewName, inputPoint);
				break;
			case "VVIP" :
				members[searchNumb] = new Vvip(inputGrade, inputNewName, inputPoint);
			}			
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
			for(int i = searchNumb;i<index-1;i++) {
				members[i] = members[i+1];
			}
			members[index-1] =null;
			index--;
		}
	}
}
