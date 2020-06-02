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
			System.out.println("<<<<포인트 관리 프로그램 v1.0>>>>");
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
			System.out.print("등급 입력 >> ");
			String inputGrade = sc.next();
			System.out.print("포인트점수 입력 >> ");
			int inputPoint = sc.nextInt();
			
			silvers[index] =new Silver(inputGrade, inputName, inputPoint);
			index++;
		}else {
			System.out.println("중복된 이름이 있습니다. 새로운 이름을 입력해주세요.");
			return;
		}
		
	}
	//중복 검사, 회원 검사
	public int duplicate(String name) {
		for(int i=0;i<index;i++) {
			if(silvers[i].getName().equals(name)) {
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
			System.out.println(silvers[i].getGrade()+"\t"+silvers[i].getName()+"\t"+
								silvers[i].getPoint()+"\t"+silvers[i].getBonus()+"\t");
		}
	}

	public void viewOne() {
		System.out.println("======== 1인 회원 정보 출력 ==========");
		System.out.println("이름을 입력해주세요 : ");
		System.out.print("이름 입력 >> ");
		String inputName = sc.next();
		int searchNumb = duplicate(inputName);
		if(searchNumb!=-1) {
			System.out.println(silvers[searchNumb].getGrade()+"\t"+silvers[searchNumb].getName()+"\t"+
					silvers[searchNumb].getPoint()+"\t"+silvers[searchNumb].getBonus()+"\t");			
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
			System.out.print("이름 입력 : ");
			String inputNewName = sc.next();
			System.out.print("등급 입력 : ");
			String inputGrade = sc.next();
			System.out.print("포인트 입력 : ");
			int inputPoint = sc.nextInt();
			silvers[searchNumb].setGrade(inputGrade);
			silvers[searchNumb].setName(inputNewName);
			silvers[searchNumb].setPoint(inputPoint);
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
			for(int i=searchNumb;i<index-1;i++) {
				silvers[i] = silvers[i+1]; 
			}
			silvers[index-1]=null;
			index--;
		}
	}
}
