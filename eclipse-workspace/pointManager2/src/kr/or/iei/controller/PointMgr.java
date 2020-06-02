package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;

public class PointMgr {
	
	Scanner sc = new Scanner(System.in);
	Silver [] silvers = new Silver[10];
	int sIndex;
	
	Gold [] golds=new Gold [10];
	int gIndex;

	Vip [] vips=new Vip[10];
	int vIndex;
	
//	char grade;
	
	
	public void main() {
		while(true) {
			System.out.println();
			System.out.println("<<<<����Ʈ ���� ���α׷� v1.2>>>>");
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
			System.out.println("ȸ�� ��� �Է� [Silver/Gold/Vip]");
			System.out.print("��� �Է� >>");
			String inputGrade = sc.next().toUpperCase();
			System.out.print("����Ʈ���� �Է� >> ");
			int inputPoint = sc.nextInt();
			switch(inputGrade) {
			case "SILVER" :
				Silver sil = new Silver(inputGrade, inputName, inputPoint);
				silvers[sIndex] =sil;
				sIndex++;				
				break;
			case "GOLD" :
				Gold gol = new Gold(inputGrade, inputName, inputPoint);
				golds[gIndex] =gol;
				gIndex++;				
				break;
			case "VIP" :
				Vip vi = new Vip(inputGrade, inputName, inputPoint);
				vips[vIndex] =vi;
				vIndex++;
				break;
			}
		}else {
			System.out.println("�ߺ��� �̸��� �ֽ��ϴ�. ���ο� �̸��� �Է����ּ���.");
			return;
		}	
	}
	//�ߺ� �˻�, ȸ�� �˻�
	public int duplicate(String name) {
		for(int i=0;i<sIndex;i++) {
			if(silvers[i].getName().equals(name)) {
//				grade = 'S';
				return i;
			}
		}
		
		for(int i=0;i<gIndex;i++) {
			if(golds[i].getName().equals(name)) {
//				grade = 'G';
				return i+10;
			}
		}
		for(int i=0;i<vIndex;i++) {
			if(vips[i].getName().equals(name)) {
//				grade = 'V';
				return i+100;
			}
		}
		return -1;
	}
	//��� ȸ�� ���� ���
	public void viewAll() {
		System.out.println("======== ȸ�� ��ü ���� ��� ==========");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�����Ʈ");
		//�ǹ� ���
		for(int i=0;i<sIndex;i++) {
			System.out.println(silvers[i].getGrade()+"\t"+silvers[i].getName()+"\t"+
								silvers[i].getPoint()+"\t"+silvers[i].getBonus()+"\t");
		}
		for(int i=0;i<gIndex;i++) {
			System.out.println(golds[i].getGrade()+"\t"+golds[i].getName()+"\t"+
								golds[i].getPoint()+"\t"+golds[i].getBonus()+"\t");
		}
		for(int i=0;i<vIndex;i++) {
			System.out.println(vips[i].getGrade()+"\t"+vips[i].getName()+"\t"+
								vips[i].getPoint()+"\t"+vips[i].getBonus()+"\t");
		}
	}

	public void viewOne() {
		System.out.println("======== 1�� ȸ�� ���� ��� ==========");
		System.out.println("�̸��� �Է����ּ��� : ");
		System.out.print("�̸� �Է� >> ");
		String inputName = sc.next();
		int searchNumb = duplicate(inputName);
		if(searchNumb!=-1) {
			if(searchNumb/100==1) { //VIP
				searchNumb-=100;
				System.out.println(vips[searchNumb].getGrade()+"\t"+vips[searchNumb].getName()+"\t"+
									vips[searchNumb].getPoint()+"\t"+vips[searchNumb].getBonus()+"\t");			
			}else if(searchNumb/10==1) {//GOLD
				searchNumb-=10;
				System.out.println(golds[searchNumb].getGrade()+"\t"+golds[searchNumb].getName()+"\t"+
									golds[searchNumb].getPoint()+"\t"+golds[searchNumb].getBonus()+"\t");							
			}else if(searchNumb/10==0) {//SILVER
				System.out.println(silvers[searchNumb].getGrade()+"\t"+silvers[searchNumb].getName()+"\t"+
									silvers[searchNumb].getPoint()+"\t"+silvers[searchNumb].getBonus()+"\t");											
			}
			/*
			//����� ������ ���� int grade�� ���� �����ϴ� ��� 
			if(grade==1) {
				System.out.println(silvers[searchNumb].getGrade()+"\t"+silvers[searchNumb].getName()+"\t"+
						silvers[searchNumb].getPoint()+"\t"+silvers[searchNumb].getBonus()+"\t");			
			}else if(grade==2) {
				System.out.println(golds[searchNumb].getGrade()+"\t"+golds[searchNumb].getName()+"\t"+
						golds[searchNumb].getPoint()+"\t"+golds[searchNumb].getBonus()+"\t");							
			}else if(grade==3) {
				System.out.println(vips[searchNumb].getGrade()+"\t"+vips[searchNumb].getName()+"\t"+
						vips[searchNumb].getPoint()+"\t"+vips[searchNumb].getBonus()+"\t");			
			}
			*/
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
		if(searchNumb==-1) {
			System.out.println("ã�� �̸��� �����ϴ�.");
			return;
		}
		System.out.print("���ο� �̸� �Է� : ");
		String inputNewName = sc.next();
		System.out.print("���ο� ��� �Է� : ");
		String inputGrade = sc.next();
		System.out.print("���ο� ����Ʈ �Է� : ");
		int inputPoint = sc.nextInt();
		if(searchNumb!=-1) {
			if(searchNumb/100==1) {//���� ����� vip�� ���
				searchNumb-=100;
				if(vips[searchNumb].getGrade().equals(inputGrade.toUpperCase())) {
					//��� ��ȭ�� ����
					vips[searchNumb].setName(inputNewName);
					vips[searchNumb].setPoint(inputPoint);
				}else {
					//��� ��ȭ�� �ִ� ���
					//vip �迭���� ����
					for(int i=searchNumb;i<vIndex;i++) {
						vips[i] = vips[i+1]; 
					}
					vips[--vIndex]=null;
					switch(inputGrade.toUpperCase()) {
					case "GOLD" :
						golds[gIndex] = new Gold(inputGrade, inputNewName, inputPoint);
						gIndex++;
						break;
					case "SILVER" :
						silvers[sIndex] = new Silver(inputGrade, inputNewName, inputPoint);
						sIndex++;
						break;
					}
				}
			}else if(searchNumb/10==1) {//���� ����� gold�� ���
				searchNumb-=10;
				if(golds[searchNumb].getGrade().equals(inputGrade.toUpperCase())) {
					//��� ��ȭ�� ����

					golds[searchNumb].setGrade(inputGrade);
					golds[searchNumb].setName(inputNewName);
					golds[searchNumb].setPoint(inputPoint);

				}else {
					//��� ��ȭ�� �ִ� ���
					//GOLD �迭���� ����
					for(int i=searchNumb;i<gIndex;i++) {
						golds[i] = golds[i+1]; 
					}
					golds[--gIndex]=null;
					switch(inputGrade.toUpperCase()) {
					case "VIP" :
						vips[vIndex] = new Vip(inputGrade, inputNewName, inputPoint);
						vIndex++;
						break;
					case "SILVER" :
						silvers[sIndex] = new Silver(inputGrade, inputNewName, inputPoint);
						sIndex++;
						break;
					}
				}
			}else if(searchNumb/10==0) {//���� ����� silver�� ���
				if(silvers[searchNumb].getGrade().equals(inputGrade.toUpperCase())) {
					//��� ��ȭ�� ����
					silvers[searchNumb] = new Silver(inputGrade, inputNewName,inputPoint);
				}else {
					//��� ��ȭ�� �ִ� ���
					//SILVER �迭���� ����
					for(int i=searchNumb;i<sIndex;i++) {
						silvers[i] = silvers[i+1]; 
					}
					silvers[--sIndex]=null;
					switch(inputGrade.toUpperCase()) {
					case "VIP" :
						vips[vIndex++] = new Vip(inputGrade, inputNewName, inputPoint);
						break;
					case "GOLD" :
						golds[gIndex++] = new Gold(inputGrade, inputNewName, inputPoint);
						break;
					}
				}
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
			if(searchNumb/100==1) { //VIP
				for(int i=searchNumb;i<vIndex-1;i++) {
					vips[i] = vips[i+1]; 
				}
				vips[--vIndex]=null;
			}else if(searchNumb/10==1) { //GOLD
				for(int i=searchNumb;i<gIndex-1;i++) {
					golds[i] = golds[i+1]; 
				}
				golds[--gIndex]=null;
			}else if(searchNumb/10==0) { //SILVER
				for(int i=searchNumb;i<sIndex-1;i++) {
					silvers[i] = silvers[i+1]; 
				}
				silvers[--sIndex]=null;
			}
		}
	}
}
