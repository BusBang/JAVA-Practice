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
			System.out.println("<<<<포인트 관리 프로그램 v1.2>>>>");
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
			System.out.println("회원 등급 입력 [Silver/Gold/Vip]");
			System.out.print("등급 입력 >>");
			String inputGrade = sc.next().toUpperCase();
			System.out.print("포인트점수 입력 >> ");
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
			System.out.println("중복된 이름이 있습니다. 새로운 이름을 입력해주세요.");
			return;
		}	
	}
	//중복 검사, 회원 검사
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
	//모든 회원 정보 출력
	public void viewAll() {
		System.out.println("======== 회원 전체 정보 출력 ==========");
		System.out.println("등급\t이름\t포인트\t보너스포인트");
		//실버 출력
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
		System.out.println("======== 1인 회원 정보 출력 ==========");
		System.out.println("이름을 입력해주세요 : ");
		System.out.print("이름 입력 >> ");
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
			//등급을 나누는 변수 int grade를 만들어서 구분하는 방법 
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
			System.out.println("찾는 이름이 없습니다.");
		}
	}
	
	public void modiUser() {
		System.out.println("======== 회원 정보 수정 ========");
		System.out.println("이름을 입력해주세요 : ");
		System.out.print("이름 입력 >> ");
		String inputName = sc.next();
		int searchNumb = duplicate(inputName);
		if(searchNumb==-1) {
			System.out.println("찾는 이름이 없습니다.");
			return;
		}
		System.out.print("새로운 이름 입력 : ");
		String inputNewName = sc.next();
		System.out.print("새로운 등급 입력 : ");
		String inputGrade = sc.next();
		System.out.print("새로운 포인트 입력 : ");
		int inputPoint = sc.nextInt();
		if(searchNumb!=-1) {
			if(searchNumb/100==1) {//기존 등급이 vip인 경우
				searchNumb-=100;
				if(vips[searchNumb].getGrade().equals(inputGrade.toUpperCase())) {
					//등급 변화가 없음
					vips[searchNumb].setName(inputNewName);
					vips[searchNumb].setPoint(inputPoint);
				}else {
					//등급 변화가 있는 경우
					//vip 배열에서 삭제
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
			}else if(searchNumb/10==1) {//기존 등급이 gold인 경우
				searchNumb-=10;
				if(golds[searchNumb].getGrade().equals(inputGrade.toUpperCase())) {
					//등급 변화가 없음

					golds[searchNumb].setGrade(inputGrade);
					golds[searchNumb].setName(inputNewName);
					golds[searchNumb].setPoint(inputPoint);

				}else {
					//등급 변화가 있는 경우
					//GOLD 배열에서 삭제
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
			}else if(searchNumb/10==0) {//기존 등급이 silver인 경우
				if(silvers[searchNumb].getGrade().equals(inputGrade.toUpperCase())) {
					//등급 변화가 없음
					silvers[searchNumb] = new Silver(inputGrade, inputNewName,inputPoint);
				}else {
					//등급 변화가 있는 경우
					//SILVER 배열에서 삭제
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
