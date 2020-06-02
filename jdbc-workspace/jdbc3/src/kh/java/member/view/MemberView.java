package kh.java.member.view;

import java.util.Scanner;

import kh.java.member.model.vo.Member;

public class MemberView {

	
	Scanner sc = new Scanner(System.in);
	
	public int mainMenu() {
		System.out.println("-=-=-=-=-=-=- 회원 관리 프로그램 -=-=-=-=-=-=-");
		System.out.println("1. 회원 전체 출력");
		System.out.println("2. 회원 아이디 검색");
		System.out.println("3. 회원 이름으로 검색");
		System.out.println("4. 회원가입");
		System.out.println("5. 정보수정");
		System.out.println("6. 회원삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 >>");
		return sc.nextInt();
	}
	public void printMSG(String inputMSG) {
		System.out.println(inputMSG);
	}
	public void printArr(Member a) {
		System.out.println(a);
	}
	
	public Member insertMember() {
		System.out.println("----------회원 가입----------");
		Member m = new Member();
		System.out.print("아이디 입력 : ");
		m.setMemberId(sc.next());
		System.out.print("비밀번호 입력 : ");
		m.setMemberPw(sc.next());
		System.out.print("이름 입력 : ");
		m.setMemberName(sc.next());
		System.out.print("성별 입력 (M/F) : ");
		m.setGender(sc.next());
		System.out.print("나이 입력 : ");
		m.setAge(sc.nextInt());
		System.out.print("전화번호 입력  (010-xxxx-xxxx) : ");
		m.setPhone(sc.next());
		System.out.print("취미 입력 : ");
		m.setHobby(sc.next());
		return m;
	}
	public void printAll() {
		System.out.println("----------------------------회원 정보 출력"
				+ "------------------------------");
		printHead();
	}
	public void printHead() {
		System.out.println("아이디\t비번\t이름\t성별\t나이\t전화번호\t\t취미\t가입일자");
	}
	public String searchId() {
		System.out.println("----------회원 아이디 검색---------");
		System.out.print("아이디 입력 : ");
		String inputId = sc.next();
		return inputId;
	}
	public String dupliId() {
		System.out.println("--중복 검색--");
		System.out.print("아이디 입력 : ");
		String inputId = sc.next();
		return inputId;
	}
	public String searchName() {
		System.out.println("-----------회원 이름 검색-----------");
		System.out.print("이름 입력 : ");
		String inputName = sc.next();
		return inputName;
	}
	public String deleteMember() {
		System.out.println("----------회원 삭제------------");
		System.out.print("삭제할 아이디 입력 : ");
		String inputId = sc.next();
		return inputId;
	}
	public Member modifyMember() {
		Member m = new Member();
		System.out.println("-----------회원 정보 수정-----------");
		System.out.print("새 비밀번호 입력 : ");
		m.setMemberPw(sc.next());
		System.out.print("새 전화번호 입력 (010-xxxx-xxxx) : ");
		m.setPhone(sc.next());
		System.out.print("새 취미 입력 : ");
		m.setHobby(sc.next());
		return m;
	}
	
	
	
	
	

}
