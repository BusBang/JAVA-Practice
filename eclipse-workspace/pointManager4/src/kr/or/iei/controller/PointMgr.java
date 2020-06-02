package kr.or.iei.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kr.or.iei.point.Gold;
import kr.or.iei.point.Grade;
import kr.or.iei.point.Silver;
import kr.or.iei.point.Vip;
import kr.or.iei.point.Vvip;

public class PointMgr {
	Scanner sc = new Scanner(System.in);
	ArrayList<Grade> ga = new ArrayList<Grade>();

	public void pointMgr() {
		
	}

	public void main() {
		while(true) {
			System.out.println();
			System.out.println("<<<<포인트 관리 프로그램 v2.0>>>>");
			System.out.println();
			System.out.println("========== 메인 메뉴 ==========");
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 정보 출력 (전체)");
			System.out.println("3. 회원 정보 출력 (1인)");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
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
				System.out.println("프로그램을 종료합니다");
				return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	private void delUser() {
		System.out.println("----<회원 삭제>----");
		System.out.print("삭제할 사람의 이름을 입력해주세요 : ");
		String name = sc.next();
		int search = searchUser(name);
		if(search!=-1) {
			ga.remove(search);
			System.out.println("삭제가 완료되었습니다.");
		}else {
			System.out.println("그런 이름은 없습니다.");
		}
	}

	private void modiUser() {
		System.out.println("----<회원 정보 수정>----");
		System.out.print("수정할 사람의 이름을 입력해주세요 : ");
		String name = sc.next();
		int search = searchUser(name);
		if(search!=-1) {
			System.out.println("<새로운 정보 입력>");
			System.out.print("새로운 등급을 입력해주세요 : ");
			String newGrade = sc.next().toUpperCase();
			System.out.print("새로운 이름을 입력해주세요 : ");
			String newName = sc.next();
			System.out.print("새로운 포인트를 입력해주세요 : ");
			int newPoint = sc.nextInt();
			ga.set(search, generateObje(newGrade, newName, newPoint));
		}else {
			System.out.println("그런 이름은 없습니다.");
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
			default : System.out.println("잘못 입력하셨습니다. ");
		}
		return g;
	}

	private void viewOneUser() {
		System.out.println("----<회원 1인 출력>----");
		System.out.print("찾을 사람의 이름을 입력해주세요 : ");
		String name = sc.next();
		int search = searchUser(name);
		if(search!=-1) {
			System.out.println(ga.get(search));
		}else {
			System.out.println("그런 이름은 없습니다. ");
		}
				
	}

	private void viewAllUser() {
		if(ga.isEmpty()) {
			System.out.println("<알림> 등록된 회원이 없습니다.");
		}else {
			System.out.println("----<전체 회원 출력>----");
			System.out.println("[등급]\t[이름]\t[포인트]\t[보너스포인트]");
			for(Grade aa : ga) {
				System.out.println(aa);			
			}	
		}
	}

	private void enrollUser() {
		while(true) {			
			System.out.println("-----<회원 등록>-----");
			System.out.println("회원 정보를 입력해주세요. ");
			System.out.println("등급 : [Silver / Gold / Vip / Vvip]");
			System.out.print("등급을 입력해주세요 : ");
			String grade = sc.next().toUpperCase();
			System.out.print("이름을 입력해주세요 : ");
			String name = sc.next();
			System.out.print("포인트를 입력해주세요 : ");
			int point = sc.nextInt();
			ga.add(generateObje(grade, name, point));
			return;
		}		
	}
	public int searchUser(String name) {
		for(int i=0; i<ga.size();i++) {
			if(ga.get(i).getName()==name) {
				return i;
			}
		}
		return -1;
			
	}
}
