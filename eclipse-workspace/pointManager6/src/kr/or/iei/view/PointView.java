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
		System.out.println("<<<<포인트 관리 프로그램 v3.0>>>>");
		System.out.println();
		System.out.println("========== 메인 메뉴 ==========");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 정보 출력 (전체)");
		System.out.println("3. 회원 정보 출력 (1인)");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 탈퇴");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >> ");
		return sc.nextInt();
	}

	public Grade insertUser() {
		System.out.println("------ 회원 가입 ------");
		System.out.print("등급을 입력해주세요 [Silver/Gold/Vip] :");
		String grade = sc.next().toUpperCase();
		System.out.print("이름을 입력해주세요 : ");
		String name = sc.next();
		System.out.print("포인트를 입력해주세요 : ");
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
		System.out.println("------ 전체 회원 출력 ------");
		System.out.println("등급\t이름\t포인트\t보너스");
		Set <String> nameKeys = hm.keySet();
		for(String start : nameKeys) {
			System.out.println(hm.get(start));
		}
	}
	
	public String inputName() {
		System.out.print("이름을 입력해주세요 : ");
		String inputName = sc.next();
		return inputName;
	}
	
	public void ViewOneUser(Grade searchUser) {
		System.out.println("등급\t이름\t포인트\t추가포인트");
		System.out.println(searchUser);
	}

	public Grade modiUser() {
		System.out.print("새 등급 입력 : ");
		String newGrade = sc.next().toUpperCase();
		System.out.print("새 이름 입력 : ");
		String newName = sc.next();
		System.out.print("새 포인트 입력 : ");
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
