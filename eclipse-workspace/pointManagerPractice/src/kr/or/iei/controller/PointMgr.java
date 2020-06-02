package kr.or.iei.controller;

import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;

public class PointMgr {
	
	Vip [] vips = new Vip [10];
	int vIndex;
	Gold [] golds = new Gold [10];
	int gIndex;
	Silver [] silvers = new Silver [10];
	int sIndex;
	Scanner sc = new Scanner(System.in);
	
	
	public void main() {
		while(true) {
			System.out.println("");
			System.out.println("========= ����Ʈ ���� ���α׷� v0.8 =========");
			System.out.println("1. ȸ�� ����");
			System.out.println("2. ȸ�� ��� (��ü)");
			System.out.println("3. ȸ�� ��� (1��)");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ���� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� >> ");
			int selMain = sc.nextInt();
			switch(selMain) {
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
				modify();
				break;
			case 5 :
				delete();
				break;
			case 0 :
				System.out.println("���α׷��� �����մϴ�");
				return;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			
		}		
	}
	public void enroll() {
		System.out.println();
		System.out.println("========== ȸ�� ���� ==========");
		System.out.println("�ߺ� �˻縦 ���� �̸��� �Է����ּ���");
		System.out.print("�̸� �Է� >> ");
		String inputName = sc.next();
		int searchNumber = duplicate(inputName);
		if(searchNumber==-1) {
			System.out.println("��� [silver / gold / vip]");
			System.out.print("��� �Է� >>");
			String inputGrade = sc.next().toUpperCase();
			System.out.print("����Ʈ �Է� >>");
			int inputPoint = sc.nextInt();
			switch(inputGrade) {
			case "SILVER" :
				silvers [sIndex] = new Silver(inputGrade, inputName, inputPoint);
				sIndex++;
				break;
			case "GOLD" :
				golds [gIndex] = new Gold(inputGrade, inputName, inputPoint);
				gIndex++;

				break;
			case "VIP" :
				vips [vIndex] = new Vip(inputGrade, inputName, inputPoint);
				vIndex++;

				break;
				default : System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}else {
			System.out.println("�ش� �̸��� �ߺ��Դϴ�.");
		}
	}
	public void viewAll() {
		System.out.println();
		System.out.println("======== ȸ�� ��� (��ü) ========");
		System.out.println("======== ȸ�� ��ü ���� ��� ==========");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�����Ʈ");
		for(int i=0;i<sIndex;i++) {
			System.out.println(silvers[i].getGrade()+"\t"+silvers[i].getName()+"\t"
								+silvers[i].getPoint()+"\t"+silvers[i].getBonus());
		}
		for(int i=0;i<gIndex;i++) {
			System.out.println(golds[i].getGrade()+"\t"+golds[i].getName()+"\t"
								+golds[i].getPoint()+"\t"+golds[i].getBonus());
		}
		for(int i=0;i<vIndex;i++) {
			System.out.println(vips[i].getGrade()+"\t"+vips[i].getName()+"\t"
								+vips[i].getPoint()+"\t"+vips[i].getBonus());
		}
	}
	public void viewOne() {
		System.out.println();
		System.out.println("======== ȸ�� ��� (1��) ========");
		System.out.println("�˻��� �̸� �Է� : ");
		String inputName = sc.next();
		int searchNumber = duplicate(inputName);
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�����Ʈ");
		if(searchNumber!=-1) {
			if(searchNumber/100==1) { //VIP 1�� ���
				searchNumber-=100;
				System.out.println(vips[searchNumber].getGrade()+"\t"+vips[searchNumber].getName()+"\t"
						+vips[searchNumber].getPoint()+"\t"+vips[searchNumber].getBonus());
			}else if(searchNumber/10==1) { //GOLD 1�� ���
				searchNumber-=10;
				System.out.println(golds[searchNumber].getGrade()+"\t"+golds[searchNumber].getName()+"\t"
						+golds[searchNumber].getPoint()+"\t"+golds[searchNumber].getBonus());
			}else if (searchNumber/10==0) { //SILVER 1�� ���
				System.out.println(silvers[searchNumber].getGrade()+"\t"+silvers[searchNumber].getName()+"\t"
						+silvers[searchNumber].getPoint()+"\t"+silvers[searchNumber].getBonus());
			
			}
		}
	}
	
	public void modify() {
		System.out.println();
		System.out.println("======== ȸ�� ���� ���� ========");
		System.out.print("�˻��� �̸� �Է� : ");
		String inputName = sc.next();
		int searchNumber = duplicate(inputName);
		if(searchNumber!=-1) {
			System.out.println("���ο� �̸� �Է� ");
			String inputNewName = sc.next();
			System.out.println("��� [silver / gold / vip]");
			System.out.print("������ ��� �Է� >>");
			String inputGrade = sc.next().toUpperCase();
			System.out.print("������ ����Ʈ �Է� >>");
			int inputPoint = sc.nextInt();
			
			if(searchNumber/100==1) { //VIP�� ���,
				System.out.println("vip������");
				searchNumber-=100;
				if(inputGrade=="VIP") {
					System.out.println("vip���� vip");
					vips [searchNumber] = new Vip(inputGrade, inputNewName, inputPoint);
				}else if(inputGrade=="SILVER") {
					System.out.println("vip���� silver������");
					silvers [sIndex] = new Silver(inputGrade, inputName, inputPoint);
					sIndex++;
					for(int i=searchNumber; i<vIndex-1;i++) {
						vips[i] = vips[i+1];
					}
					vips[--vIndex] = null;
				}else if(inputGrade=="GOLD"){
					golds [gIndex] = new Gold(inputGrade, inputName, inputPoint);
					gIndex++;
					for(int i=searchNumber; i<vIndex-1;i++) {
						vips[i] = vips[i+1];
					}
					vips[--vIndex] = null;
				}
			}
			}else if(searchNumber/10==1) { //GOLD 1�� ���
				searchNumber-=10;
				if(inputGrade=="GOLD") {
					golds [searchNumber] = new Gold(inputGrade, inputName, inputPoint);
				}else {
					if(inputGrade=="SILVER") {
						silvers [sIndex] = new Silver(inputGrade, inputName, inputPoint);
						sIndex++;
						for(int i=searchNumber; i<gIndex-1;i++) {
							golds[i] = golds[i+1];
						}
						golds[--gIndex] = null;
					}else if(inputGrade=="VIP"){
						vips [gIndex] = new Vip(inputGrade, inputName, inputPoint);
						vIndex++;
						for(int i=searchNumber; i<gIndex-1;i++) {
							golds[i] = golds[i+1];
						}
						golds[--gIndex] = null;

					}
				}
			}else if (searchNumber/10==0) { //SILVER 1�� ���
				if(inputGrade=="SILVER") {
					silvers [searchNumber] = new Silver(inputGrade, inputName, inputPoint);
				}else {
					if(inputGrade=="VIP") {
						vips [vIndex] = new Vip(inputGrade, inputName, inputPoint);
						vIndex++;
						System.out.println("�ǹ�->vip");
						for(int i=searchNumber; i<sIndex-1;i++) {
							silvers[i] = silvers[i+1];
						}
						silvers[--sIndex] = null;
					}else if(inputGrade=="GOLD"){
						golds [gIndex] = new Gold(inputGrade, inputName, inputPoint);
						gIndex++;
						for(int i=searchNumber; i<sIndex-1;i++) {
							silvers[i] = silvers[i+1];
						}
						silvers[--sIndex] = null;

					}
				}
			}
		}
	}
	public void delete() {
		System.out.println();
		System.out.println("======== ȸ�� Ż�� ========");
		System.out.print("������ �̸� �Է� : ");
		String inputName = sc.next();
		int searchNumber = duplicate(inputName);
		if(searchNumber!=-1) {
			if(searchNumber/100==1) {//VIP ����
				searchNumber-=100;
				for(int i=searchNumber; i<vIndex-1;i++) {
					vips[i] = vips[i+1];
				}
				vips[vIndex] = null;
				vIndex--;
			}else if(searchNumber/10==1) {
				searchNumber-=10;
				for(int i=searchNumber; i<gIndex-1;i++) {
					golds[i] = golds[i+1];
				}
				golds[gIndex] = null;
				gIndex--;
			}else if(searchNumber/10==0) {
				for(int i=searchNumber; i<sIndex-1;i++) {
					silvers[i] = silvers[i+1];
				}
				silvers[sIndex] = null;
				sIndex--;	
			}
		}
		System.out.println("ss");
	}
	public int duplicate(String inputName) {
		for(int i=0;i<sIndex;i++) {
			if(silvers[i].getName().equals(inputName)) {
				return i;
				
			}
		}
		for(int i=0;i<gIndex;i++) {
			if(golds[i].getName().equals(inputName)) {
				return i+10;
				
			}
		}
		for(int i=0;i<vIndex;i++) {
			if(vips[i].getName().equals(inputName)) {
				return i+100;
			}
		}
		System.out.println("�ش� �̸��� ��ܿ� �����ϴ�.");
		return -1;
	}
	
	

}
