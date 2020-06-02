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
			System.out.println("<<<<포인트 관리 프로그램 v1.6>>>>");
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
				System.out.println("프로그램을 종료합니다");
				return;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void enroll() {
		System.out.println("======== 회원가입 ========");		
		System.out.println("<알림> 중복 검사를 위한 이름을 입력해주세요. ");
		System.out.print("이름 입력 >> ");
		String inputName = sc.next();
		int dupliNumber = duplicate(inputName);
		if(dupliNumber==-1) {
			System.out.println("<알림> 중복된 이름이 아닙니다.");
			System.out.println("회원 등급 입력 [Silver/Gold/Vip/Vvip]");
			System.out.print("등급 입력 >>");
			String inputGrade = sc.next().toUpperCase();
			System.out.print("포인트점수 입력 >> ");
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
			System.out.println("중복된 이름이 있습니다. 새로운 이름을 입력해주세요.");
			return;
		}	
	}
	//중복 검사, 회원 검사
	public int duplicate(String name) {
		for(int i=0;i<index;i++) {
			if(members[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	//모든 회원 정보 출력
	public void viewAll() {
		System.out.println("======== 회원 전체 정보 출력 ==========");
		System.out.println("등급\t이름\t포인트\t보너스포인트");
		for(int i=0;i<index;i++) {
			System.out.println(members[i].getGrade()+"\t"+members[i].getName()+"\t"+
								members[i].getPoint()+"\t"+members[i].getBonus()+"\t");
		}
	}

	public void viewOne() {
		System.out.println("======== 1인 회원 정보 출력 ==========");
		System.out.println("이름을 입력해주세요 : ");
		System.out.print("이름 입력 >> ");
		String inputName = sc.next();
		int searchNumb = duplicate(inputName);
		if(searchNumb!=-1) {
				System.out.println(members[searchNumb].getGrade()+"\t"+members[searchNumb].getName()+"\t"+
									members[searchNumb].getPoint()+"\t"+members[searchNumb].getBonus()+"\t");			
		}else {
			System.out.println("찾는 이름이 없습니다.");
		}
	}
	
	public void modiUser() {
		System.out.println("======== 회원 정보 수정 ========");
		System.out.println("이름을 입력해주세요 : ");
		System.out.print("이름 입력 >> ");
		String inputName = sc.next();
		int searchNumb = duplicate(inputName);
		if(searchNumb!=-1) {
			System.out.print("새로운 이름 입력 : ");
			String inputNewName = sc.next();
			System.out.println("새로운 등급 입력 [silver/gold/vip/vvip]");
			System.out.print("새로운 등급 입력 : ");
			String inputGrade = sc.next().toUpperCase();
			System.out.print("새로운 포인트 입력 : ");
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
			System.out.println("찾는 이름이 없습니다.");
		}
	}
	public void delUser() {
		System.out.println("======== 회원 정보 삭제 ========");
		System.out.println("이름을 입력해주세요 : ");
		System.out.print("이름 입력 >> ");
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
