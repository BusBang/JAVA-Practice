package kh.java.member.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.member.vo.Member;

public class MemberView {
	
	Scanner sc = new Scanner(System.in);
	public int MainMenu() {
		System.out.println("========회원관리===========");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 1명 조회");
		System.out.println("3. 회원 등록");
		System.out.println("4. 회원 정보 수정");
		System.out.println("5. 회원 삭제");
		System.out.println("0. 프로그램 종료");
		int sel = sc.nextInt();
		return sel;
	}

	public Member insertMember() {
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		System.out.print("이름 입력 : ");
		String memberName = sc.next();
		System.out.print("성별[M/F] 입력 : ");
		String gender = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("전화번호 입력 [000-0000-0000] : ");
		String phone = sc.next();
		System.out.print("취미 입력 : ");
		String hobby = sc.next();
		Member m = new Member(memberId, memberPw, memberName, gender, age, phone, hobby, null);
		return m;		
	}
	public void printMsg(String msg) {
		System.out.println(msg);
	}

	public void printAll(ArrayList<Member> list) {
		System.out.println("아이디\t비밀번호\t이름\t성별\t나이\t휴대폰번호\t\t취미\t가입일자");
		for(Member m : list) {
			System.out.print(m);
			System.out.println();
		}
		
	}

	public String selectOne() {
		System.out.print("검색할 이름 입력 : ");
		String inputName = sc.next();
		return inputName;
	}

	public void PrintOne(Member m) {
		System.out.println("아이디\t비밀번호\t이름\t성별\t나이\t휴대폰번호\t\t취미\t가입일자");
		System.out.println(m);
	}


	public String SearchId() {
		System.out.print("회원 아이디 입력 : ");
		String inputId = sc.next();
		return inputId;	}

	public Member ModifyMember() {
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();		
		System.out.print("비밀번호 입력 : ");
		String memberPw = sc.next();
		System.out.print("이름 입력 : ");
		String memberName = sc.next();
		System.out.print("성별[M/F] 입력 : ");
		String gender = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("전화번호 입력 [000-0000-0000] : ");
		String phone = sc.next();
		System.out.print("취미 입력 : ");
		String hobby = sc.next();
		Member m = new Member(memberId, memberPw, memberName, gender, age, phone, hobby, null);
		return m;		
	}
}
