package kr.or.iei.view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Grade;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;

public class PointView {
	Scanner sc = new Scanner(System.in);

	public int mainMenu() {
		System.out.println();
		System.out.println("<<<<����Ʈ ���� ���α׷� v3.0>>>>");
		System.out.println();
		System.out.println("========== ���� �޴� ==========");
		System.out.println("1. ȸ�� ����");
		System.out.println("2. ȸ�� ���� ��� (��ü)");
		System.out.println("3. ȸ�� ���� ��� (1��)");
		System.out.println("4. ȸ�� ���� ����");
		System.out.println("5. ȸ�� Ż��");
		System.out.println("0. ���α׷� ����");
		System.out.print("���� >> ");
		return sc.nextInt();
	}

	public Grade insertUser() {
		System.out.println("------ ȸ�� ���� ------");
		System.out.print("����� �Է����ּ��� [Silver/Gold/Vip] :");
		String grade = sc.next().toUpperCase();
		System.out.print("�̸��� �Է����ּ��� : ");
		String name = sc.next();
		System.out.print("����Ʈ�� �Է����ּ��� : ");
		int point = sc.nextInt();
		switch(grade) {
		case "SILVER" :
			Silver sUser = new Silver(grade, name, point);
			return sUser;
		case "GOLD" :
			Gold gUser = new Gold(grade, name, point);
			return gUser;
		case "VIP" :
			Vip vUser = new Vip(grade, name, point);
			return vUser;
		}
		return null;
	}
	
	public void printMsg(String message) {
		System.out.println(message);
	}

	public void viewAllUser(HashMap <String, Grade> hm) {
		System.out.println("------ ��ü ȸ�� ��� ------");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�");
		Set <String> nameKeys = hm.keySet();
		for(String start : nameKeys) {
			System.out.println(hm.get(start));
		}
	}
	
	public String inputName() {
		System.out.print("�̸��� �Է����ּ��� : ");
		String inputName = sc.next();
		return inputName;
	}
	
	public void ViewOneUser(Grade searchUser) {
		System.out.println("���\t�̸�\t����Ʈ\t�߰�����Ʈ");
		System.out.println(searchUser);
	}

	public Grade modiUser() {
		System.out.print("�� ��� �Է� : ");
		String newGrade = sc.next().toUpperCase();
		System.out.print("�� �̸� �Է� : ");
		String newName = sc.next();
		System.out.print("�� ����Ʈ �Է� : ");
		int newPoint = sc.nextInt();
		switch(newGrade) {
		case "SILVER" :
			Silver sUser = new Silver(newGrade, newName, newPoint);
			return sUser;
		case "GOLD" :
			Gold gUser = new Gold(newGrade, newName, newPoint);
			return gUser;
		case "VIP" :
			Vip vUser = new Vip(newGrade, newName, newPoint);
			return vUser;	
		}
		return null;
	}
}
