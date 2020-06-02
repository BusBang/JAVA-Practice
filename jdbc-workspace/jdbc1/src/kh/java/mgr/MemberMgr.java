package kh.java.mgr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import kh.java.db.DBConnect;
import kh.java.db.Member;

public class MemberMgr {
	Scanner sc = new Scanner(System.in);

	public void main() {
		while(true) {
			System.out.println("=====회원 관리 프로그램=====");
			System.out.println("1. 회원 전체 조회");		//select
			System.out.println("2. 회원 아이디 조회");	//select 
			System.out.println("3. 회원 이름으로 조회");	//select
			System.out.println("4. 회원 가입");			//insert
			System.out.println("5. 회원 정보 변경");		//update
			System.out.println("6. 회원 삭제");			//delete
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >>");
			int sel = sc.nextInt();
			switch(sel) {
			case 1 : allSearch();
			break;
			case 2 : idSearch();
			break;
			case 3 : nameSearch();
			break;
			case 4 : insertMember();
			break;
			case 5 : modifyMember();
			break;
			case 6 : deleteMember();
			break;
			case 0 :
				System.out.println("프로그램 종료..");
				return;
			}
		}
	}
	
	private void deleteMember() {
		System.out.println("--------회원 삭제--------");
		System.out.print("삭제할 회원 아이디 입력 : ");
		String inputId = sc.next();
		DBConnect db = new DBConnect();
		if(db.idSearch(inputId) == null) {
			System.out.println("해당 회원은 존재하지 않습니다. ");
		} else {
			int result = db.deleteMember(inputId);
			if(result>0) {
				System.out.println("삭제가 완료되었습니다. ");
			} else {
				System.out.println("삭제 거부. 관리자에게 문의바랍니다.");
			}
		}
	}
	
	private void modifyMember() {
		System.out.println("======회원 정보 수정======");
		System.out.print("수정할 아이디 입력 : ");
		String inputId = sc.next();
		DBConnect db = new DBConnect();
		Member searchMember = db.idSearch(inputId);
		if(searchMember == null) {
			System.out.println("해당하는 아이디는 없습니다. ");
		}else {
			System.out.println("비밀번호 : "+searchMember.getMemberPw());
			System.out.println("전화번호 : "+searchMember.getPhone());
			System.out.println("취미 : "+searchMember.getHobby());
			System.out.println("-------------");
			System.out.print("새 비밀번호 입력 : ");
			String newPw = sc.next();
			System.out.print("새 전화번호 입력(010-xxxx-xxxx) : ");
			String newPhone = sc.next();
			System.out.print("새 취미 입력 : ");
			String newHobby = sc.next();
			
			int result = db.modifyMember(inputId, newPw, newPhone, newHobby);
			if(result > 0) {
				System.out.println("수정 완료");
			} else {
				System.out.println("수정 거부. 관리자에게 문의 바랍니다.");
			}
		}
	}
	
	private void allSearch() {
		System.out.println("전체 멤버 조회");
		ArrayList<Member> allMember = new ArrayList<Member>();
		DBConnect db = new DBConnect();
		allMember = db.allSearch();
		System.out.println("아이디\t비밀번호\t이름\t성별\t나이\t전화번호\t\t취미\t가입일자");
		for(Member a : allMember) {
			System.out.println(a);
		}
		System.out.println("--------------------------------------------");
	}
	
	public void insertMember() {
		System.out.println("======회원 정보 입력======");
		System.out.print("아이디 입력 : ");
		String memberId = sc.next();
		DBConnect db = new DBConnect();
		Member memberInput = new Member();
		if(db.idSearch(memberId) == null) {
			System.out.println("가능한 아이디입니다. ");
			memberInput.setMemberName(memberId);
		} else {
			System.out.println("이미 있는 아이디입니다. ");
			return;
		}
		System.out.print("비밀 번호 입력 : ");
		memberInput.setMemberPw(sc.next());
		System.out.print("이름 입력 : ");
		memberInput.setMemberName(sc.next());
		System.out.print("성별 입력 (M/F) : ");
		memberInput.setGender(sc.next());
		System.out.print("나이 입력 : ");
		memberInput.setAge(sc.nextInt());
		System.out.print("전화번호 입력 (010-xxxx-xxxx): ");
		memberInput.setPhone(sc.next());
		System.out.print("취미 : ");
		memberInput.setHobby(sc.next());
		
		int result = db.insertMember(memberInput);
		if(result>0) {
			System.out.println("회원 가입 완료");
		} else {
			System.out.println("회원 가입 실패. 관리자에게 문의 바랍니다.");
		}
	}
	
	public void nameSearch() {
		System.out.print("조회할 이름 입력 : ");
		String memberName = sc.next();
		DBConnect db = new DBConnect();
		ArrayList<Member> memberList = db.nameSearch(memberName);
		if(memberList.isEmpty()) { //개체가 만들어진 것이기 때문에 isEmpty() 라고 써야함
			System.out.println("이름을 조회할 수 없습니다. ");
		} else {
			System.out.println("아이디\t비밀번호\t이름\t성별\t나이\t전화번호\t\t취미\t가입일자");
			for(int i = 0; i<memberList.size(); i++) {
				System.out.println(memberList.get(i));
			}
		}
	}
	
	public void idSearch() {
		System.out.print("조회할 아이디 입력 : ");
		String memberId = sc.next();
		DBConnect db = new DBConnect();
		Member member = db.idSearch(memberId);
		if(member == null) {
			System.out.println("아이디를 조회할 수 없습니다.");
		}else {
			System.out.println("아이디\t비밀번호\t이름\t성별\t나이\t전화번호\t\t취미\t가입일자");
			System.out.println(member.getMemberId()+"\t"+member.getMemberPw()+"\t"+member.getMemberName()+"\t"
			+member.getGender()+"\t"+member.getAge()+"\t"+member.getPhone()+"\t"+member.getHobby()+"\t"+member.getEnrollDate());
		}
	}
	
}
