package kh.or.iei.student;

import java.util.Scanner;

public class StudentFunc {

	Scanner sc = new Scanner(System.in);
	String [] name = new String [100];
	int [] age = new int [100];
	String [] address = new String [100] ;
	int index;
	
	public void main(){
	
		while(true) {
			System.out.println("====== 학생 관리 프로그램 v1.0 ======");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생 정보 조회(전체)");
			System.out.println("3. 학생 정보 조회(1명)");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int selMain = sc.nextInt();
			
			switch(selMain) {
			case 1 : //학생 등록
				enroll();
				break;
			case 2 : //학생 정보 조회 전체
				viewAllStudent();
				break;
			case 3 : //학생 정보 조회 1명
				viewStudent();
				break;
			case 4 : //학생 정보 수정
				modify();
				break;
			case 5 : //학생 정보 삭 제
				delete();
				break;
			case 0 : //프로그램종료
				System.out.println("프로그램을 종료합니다.");
				return;
			default : System.out.println("잘못 입력하셨습니다.  다시 입력해주세요.");
			}
		}
		
	}
	public void enroll() {
		System.out.println();
		System.out.println("====== 학생 정보 등록 ======");
		System.out.print("이름 : ");
		name[index] = sc.next();
		System.out.print("나이 : ");
		age[index] = sc.nextInt();
		System.out.print("주소 : ");
		sc.nextLine();
		address[index] = sc.nextLine();
		index++;
	}
	public void viewAllStudent() {
		System.out.println();
		System.out.println("==== 학생 정보 조회 (전체) ====");
		System.out.println("이름\t나이\t주소");
		for(int i=0;i<index;i++) {
			System.out.println(name[i]+"\t"+age[i]+"\t"+address[i]);
		}
		System.out.println();
	}
	public void delete() {
		System.out.println();
		System.out.println("====== 학생 정보 삭제 ======");
		int searchIndex = search();
		if(searchIndex!=1) {
			for(int i=searchIndex; i<index-1; i++) {
				name[i]=name[i+1];
				age[i]=age[i+1];
				address[i]=address[i+1];
			}
		name[searchIndex]=null;
		age[searchIndex]=0;
		address[searchIndex]=null;
		index--;
		}
	}

	public void modify() {
		System.out.println();
		System.out.println("====== 학생 정보 수정 ======");
		int searchIndex = search();
		if(searchIndex != -1) {
			System.out.print("이름 재입력 : ");
			name[searchIndex] = sc.next();
			System.out.print("나이 재입력 : ");	
			age[searchIndex] = sc.nextInt();
			System.out.print("주소 재입력 : ");
			sc.nextLine();
			address[searchIndex] = sc.nextLine();
			System.out.println("재입력 완료하였습니다.");
		}	
	}
	
	public void viewStudent() {
		System.out.println();
		System.out.println("==== 학생 정보 조회 (1명) ====");
		int searchIndex = search();
		if(searchIndex != -1) {
			System.out.println(name[searchIndex]+"\t"+age[searchIndex]+"\t"+address[searchIndex]);		
		}
		System.out.println();
	}
	
	public int search() {
		System.out.print("검색 이름 입력 : ");
		String inputName = sc.next();
		for(int i=0;i<index;i++) {
			if(name[i].equals(inputName)) {
				return i;
			}
		}
		System.out.println("학생 정보가 없습니다.");
		return -1;
		
	}

}
