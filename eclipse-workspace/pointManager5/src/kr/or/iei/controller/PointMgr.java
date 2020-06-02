package kr.or.iei.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Grade;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;
import kr.or.iei.point.Vvip;

public class PointMgr {
	Scanner sc = new Scanner(System.in);
	HashMap<String, Grade> hm = new HashMap<String, Grade>();

	public void pointMgr() {
		
	}

	public void main() {
		while(true) {
			System.out.println();
			System.out.println("<<<<����Ʈ ���� ���α׷� v2.0>>>>");
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
				enrollUser();
				break;
			case 2 : 
				viewAllUser();
				break;
			case 3 :
				viewOneUser();
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

	private void delUser() {
		System.out.println("----<ȸ�� ����>----");
		System.out.print("������ ����� �̸��� �Է����ּ��� : ");
		String name = sc.next();
		if(hm.containsKey(name)) {
			hm.remove(name);
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		}else {
			System.out.println("�׷� �̸��� �����ϴ�.");
		}
	}

	private void modiUser() {
		System.out.println("----<ȸ�� ���� ����>----");
		System.out.print("������ ����� �̸��� �Է����ּ��� : ");
		String name = sc.next();
		if(hm.containsKey(name)) {
			System.out.println("<���ο� ���� �Է�>");
			System.out.print("���ο� ����� �Է����ּ��� : ");
			String newGrade = sc.next().toUpperCase();
			System.out.print("���ο� �̸��� �Է����ּ��� : ");
			String newName = sc.next();
			System.out.print("���ο� ����Ʈ�� �Է����ּ��� : ");
			int newPoint = sc.nextInt();
			hm.remove(name);
			hm.put(newName, generateObje(newGrade, newName, newPoint));
		}else {
			System.out.println("�׷� �̸��� �����ϴ�.");
		}
	}
	
	public Grade generateObje(String grade, String name, int point) {
		Grade g = null;
		switch(grade) {
		case "SILVER" :
			g = new Silver(grade,name,point);		
			break;
		case "GOLD" :
			g = new Gold(grade,name,point);
			break;
		case "VIP" :
			g = new Vip(grade,name,point);
			break;
		case "VVIP" :
			g = new Vvip(grade,name,point);
			break;
			default : System.out.println("�߸� �Է��ϼ̽��ϴ�. ");
		}
		return g;
	}

	private void viewOneUser() {
		System.out.println("----<ȸ�� 1�� ���>----");
		System.out.print("ã�� ����� �̸��� �Է����ּ��� : ");
		String name = sc.next();
		if(hm.containsKey(name)) {
			System.out.println(hm.get(name));
		}else {
			System.out.println("�׷� �̸��� �����ϴ�. ");
		}				
	}

	private void viewAllUser() {
		if(hm.isEmpty()) {
			System.out.println("<�˸�> ��ϵ� ȸ���� �����ϴ�.");
		}else {
			System.out.println("----<��ü ȸ�� ���>----");
			System.out.println("[���]\t[�̸�]\t[����Ʈ]\t[���ʽ�����Ʈ]");
			Set <String> nameKeys = hm.keySet();
			for(String start : nameKeys) {
				System.out.println(hm.get(start));
			}
		}
	}

	private void enrollUser() {
		while(true) {			
			System.out.println("-----<ȸ�� ���>-----");
			System.out.println("ȸ�� ������ �Է����ּ���. ");
			System.out.println("��� : [Silver / Gold / Vip / Vvip]");
			System.out.print("����� �Է����ּ��� : ");
			String grade = sc.next().toUpperCase();
			System.out.print("�̸��� �Է����ּ��� : ");
			String name = sc.next();
			if(searchUser(name).equals("No")) {
				System.out.print("����Ʈ�� �Է����ּ��� : ");
				int point = sc.nextInt();
				hm.put(name, generateObje(grade, name, point));
				return;
			}else {
				System.out.println("�̹� �̸��� �ֽ��ϴ�.");
			}
		}		
	}
	public String searchUser(String name) {
		Set<String> nameKey = hm.keySet();
		for(String start : nameKey) {
			if(hm.containsKey(name)) {
				return start; 
			}
		}
		return "No";
	}
}
