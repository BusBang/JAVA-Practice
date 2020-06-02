package kh.java.mgr;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.db.DBConnect;
import kh.java.db.Member;

public class MemberMgr {
	
	Scanner sc = new Scanner(System.in);
	
	public void main() {
		while(true) {
			System.out.println("1. 회원 전체 출력");
			System.out.println("2. 회원 아이디 검색");
			System.out.println("3. 회원 이름으로 검색");
			System.out.println("4. 회원가입");
			System.out.println("5. 정보수정");
			System.out.println("6. 회원삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >>");
			int sel = sc.nextInt();
			switch(sel) {
			case 1 :
				searchAll();
				break;
			case 2 :
				searchId();
				break;
			case 3 : 
				searchName();
				break;
			case 4 :
				insertMember();
				break;
			case 5 :
				modifyMember();
				break;
			case 6 :
				deleteMember();
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다 ...");
				return;
			}
		}
	}
	
	
	
	private void insertMember() {
		System.out.println("------- 회원 정보 입력 -------");
		DBConnect db = new DBConnect();

		System.out.print("아이디 입력 : ");
		String newId = sc.next();
		if(!db.searchID(newId).isEmpty()) {
			System.out.println("이미 해당 아이디는 존재합니다.");
		} else {
			Member member = new Member();
			member.setMemberId(newId);
			System.out.print("이름 입력 : ");
			member.setMemberName(sc.next());
			System.out.print("비밀번호 입력 : ");
			member.setMemberPw(sc.next());
			System.out.print("성별(M,F) : ");
			member.setGender(sc.next());
			System.out.print("나이 입력 : ");
			member.setAge(sc.nextInt());
			System.out.print("번호 입력 (010-xxxx-xxxx) : ");
			member.setPhone(sc.next());
			System.out.print("취미 입력 : ");
			member.setHobby(sc.next());
			if(db.insertMember(member)>0) {
				System.out.println("회원 등록 성공");
			}else {
				System.out.println("회원 등록 실패");
			}
		}		
	}

	private void deleteMember() {
		System.out.println("----------회원 삭제----------");
		DBConnect db = new DBConnect();
		System.out.print("회원 아이디 입력 : ");
		String inputId = sc.next();
		if(db.deleteMember(inputId)>0) {
			System.out.println("삭제 완료");
		}
	}

	private void searchName() {
		System.out.println("-----------회원 이름 조회------------");
		DBConnect db = new DBConnect();
		System.out.print("검색할 이름 입력 : ");
		String inputName = sc.next();
		ArrayList <Member> memberList =  db.searchName(inputName);
		if(!memberList.isEmpty()) {
			System.out.println("------------------------------------------");
			System.out.println("아이디\t비밀번호\t이름\t성별\t나이\t전화번호\t\t취미\t가입일자");
			for(Member a : memberList) {
				System.out.println(a);
			}
		} else {
			System.out.println("해당 이름은 존재하지 않습니다. ");
		}
	}

	private void searchAll() {
		System.out.println("-------------회원 전체 조회----------------");
		DBConnect db = new DBConnect();
		ArrayList <Member> memberList = db.searchAll();
		System.out.println("아이디\t비밀번호\t이름\t성별\t나이\t전화번호\t\t취미\t가입일자");
		for(Member a : memberList) {
			System.out.println(a);
		}		
	}

	private void searchId() {
		ArrayList<Member> memberList = new ArrayList<Member>();
		System.out.println("----------회원 아이디 검색----------");
		System.out.print("아이디를 입력하세요 : ");
		String inputId = sc.next();
		DBConnect db =new DBConnect();
		memberList = db.searchID(inputId);
		if(!memberList.isEmpty()) {
			System.out.println("------------------------------------------");
			System.out.println("아이디\t비밀번호\t이름\t성별\t나이\t전화번호\t\t취미\t가입일자");
			for(Member a : memberList) {
				System.out.println(a);
		}
		}
	}

	private void modifyMember() {
		System.out.println("-----------정보 수정----------");
		Member m = new Member();
		System.out.print("아이디를 입력하세요 : ");
		String inputId = sc.next();
		m.setMemberId(inputId);
		// 중복검사
		System.out.print("비밀번호 입력 : ");
		m.setMemberPw(sc.next());
		System.out.print("전화번호 입력 (010-xxxx-xxxx) : ");
		m.setPhone(sc.next());
		System.out.print("취미 입력 : ");
		m.setHobby(sc.next());
		DBConnect db = new DBConnect();
		int result = db.modifyMember(m);
		if(result > 0 ) {
			System.out.println("정보 변경 완료");
		} else {
			System.out.println("정보 변경 실패");
		}
	}

}
