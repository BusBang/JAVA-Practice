package kh.or.iei.student;

import java.util.Scanner;

public class StudentFunc {
	String [] names = new String [10];		//학생 이름 저장 배열
	int [] ages = new int [10];				//학생 나이 저장 배열
	String [] addrs = new String [10];		//학생 주소 저장 배열
	int index;								//배열 인덱스 관리용 변수
	Scanner sc= new Scanner(System.in);

	public void main() {
		while(true) {
			System.out.println("======== 학생 관리 프로그램 v1.0 ========");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생 정보 조회(전체)");
			System.out.println("3. 학생 정보 조회(1명");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >> ");
			int selMain = sc.nextInt();
			switch(selMain) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudents();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				modifyStudent();
				break;
			case 5:
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 입력하였습니다. 다시 입력하세요.");
			}
		}
	}
	
	public void insertStudent() {
		
		System.out.println();
		System.out.println("======학생 정보 입력======");
		System.out.print("이름 입력 : ");
		String insertName = sc.next();
		System.out.print("나이 입력 : ");
		int insertAge = sc.nextInt();
		System.out.print("주소 입력 : ");
		sc.nextLine(); //개행 문자 제거용 코드
		String insertAddr = sc.nextLine();
		
		names[index] = insertName;
		ages[index] = insertAge;
		addrs[index] = insertAddr;
		index++;
		
		System.out.println("학생 정보 등록 성공 !!");
	}
	public void deleteStudent() {
		System.out.println("\n===== 학생 정보 삭제 =====");
		int searchIndex = searchStudent("삭제");
		if(searchIndex != -1) {
			for(int i=searchIndex;i<index-1;i++) {
				names[i] = names[i+1];
				ages[i] = ages[i+1];
				addrs[i] = addrs[i+1];
			}
			names[index] = null;
			ages[index] = 0;
			addrs[index] = null;
			index--;
			
		}
		
	}
	public void printAllStudents() {
		System.out.println("\n ====== 학생 정보 전체 출력 ====== ");
		System.out.println("[이름]\t[나이]\t[주소] ");
		for(int i=0; i<index; i++) {
			System.out.println(names[i]+"\t"+ages[i]+"\t"+addrs[i]);
		}
	}
	
	public void printOneStudent() {
		System.out.println("\n ====== 학생 정보 출력 ====== ");
		int searchIndex = searchStudent("조회");
		
		if(searchIndex!=-1) {
			System.out.println("[이름]\t[나이]\t[주소] ");
			System.out.println(names[searchIndex]+"\t"+ages[searchIndex]+"\t"+addrs[searchIndex]);
		}
	}
	
	public void modifyStudent() {
		System.out.println("\n===== 학생 정보 수정 =====");
		int searchIndex = searchStudent("수정");
		
		if(searchIndex!=-1) {
			System.out.println("======학생 정보 입력======");
			System.out.print("이름 입력 : ");
			names[searchIndex] = sc.next();
			System.out.print("나이 입력 : ");
			ages[searchIndex] = sc.nextInt();
			System.out.print("주소 입력 : ");
			sc.nextLine(); //개행 문자 제거용 코드
			addrs[searchIndex] = sc.nextLine();
		}
	}
	public void insertStudentData(String inName, int inAge, String inAddr) {
		
	}
	public int searchStudent(String msg) {
		System.out.print(msg+"할 학생 이름 입력 : ");
		String name = sc.next();
		for(int i=0;i<index;i++) {
			if(names[i].equals(name)) {
				return i;
			}
		}
		System.out.println("학생 정보가 없습니다.");
		return -1;
	}

}
