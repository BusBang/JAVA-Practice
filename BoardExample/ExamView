package kh.exam.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;

public class ExamView {
	Scanner sc = new Scanner(System.in);

	public int main() {
			System.out.println("----------- KH 커뮤니티 -----------");
			System.out.println("1. 로그인하기");
			System.out.println("2. 회원가입");
			System.out.println("3. 아이디 찾기");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 >>");
			int sel = sc.nextInt();
			return sel;
	}
	
	public void printMSG(String MSG) {
		System.out.println(MSG);
	}
	public void printMSG2(String MSG) {
		System.out.print(MSG);
	}
	

	public Member enrollMember() {
		Member m = new Member();
		System.out.println("--------- 회원가입 ----------");
		System.out.print("ID 입력 : ");
		m.setMemberId(sc.next());
		System.out.print("PW 입력 : ");
		m.setMemberPw(sc.next());
		System.out.print("이름 입력 : ");
		m.setMemberName(sc.next());
		System.out.print("전화번호 입력 (ex.01012345678) : ");
		m.setPhone(sc.next());
		return m;
		
	}

	public Member searchID() {
		Member m = new Member();
		System.out.println("---------- 아이디 찾기 -----------");
		System.out.print("이름 입력 : ");
		m.setMemberName(sc.next());
		System.out.print("전화번호 입력 : ");
		m.setPhone(sc.next());
		return m;
	}

	public Member login() {
		Member m = new Member();
		System.out.println("-------- 로그인 --------");
		System.out.print("아이디 입력 : ");
		m.setMemberId(sc.next());
		System.out.print("비밀번호 입력 : ");
		m.setMemberPw(sc.next());
		return m;
	}

	public int loginMain() {
		System.out.println("----------- KH커뮤니티 ------------");
		System.out.println("1. 게시물 목록 보기");
		System.out.println("2. 게시물 상세 보기");
		System.out.println("3. 게시물 등록");
		System.out.println("4. 게시물 수정");
		System.out.println("5. 게시물 삭제");
		System.out.println("6. 내 정보 보기");
		System.out.println("7. 내 정보 변경");
		System.out.println("8. 회원 탈퇴");
		System.out.println("0. 로그아웃");
		System.out.print("선택 >>");
		return sc.nextInt();
	}

	public void myState() {
		System.out.println("-------- 내 정보 보기 --------");
	}

	public Member modifyState() {
		Member modi = new Member();
		System.out.println("-------- 내 정보 수정 ---------");
		System.out.print("PW 입력 : ");
		modi.setMemberPw(sc.next());
		System.out.print("전화번호 입력 (ex.01011112222) : ");
		modi.setPhone(sc.next());
		return modi;
	}

	public int deleteMember() {
		System.out.println("정말 탈퇴하시겠습니까? (1.Yes 2. No)");
		System.out.print("선택 >>");
		return sc.nextInt();
	}

	public Board insertBoard() {
		Board b = new Board();
		System.out.print("제목 입력 : ");
		b.setBoardTitle(sc.next());
		System.out.print("내용 입력 : ");
		b.setBoardContent(sc.next());
		return b;
	}

	public void allBoard() {
		System.out.println("----------------- 게시글 목록 ---------------");
		System.out.println("게시글번호\t게시글 제목\t작성자\t조회수\t작성시간");
	}

	public void printBoard(Board a) {
		System.out.println(a.getBoardNo()+"\t"+a.getBoardTitle()+"\t"+a.getBoardWriter()+"\t"+a.getReadCount()+"\t"+a.getWriteDate());
	}

	public int detailBoard() {
		System.out.print("게시물 번호 입력 : ");
		return sc.nextInt();
	}

	public int deleteBoard() {
		System.out.print("게시물 번호 입력 : ");
		return sc.nextInt();
	}

	public int modifyBoard() {
		System.out.print("게시물 번호 입력 : ");
		return sc.nextInt();
	}

	public Board modifyInfo() {
		Board b = new Board();
		System.out.print("제목 입력 : ");
		b.setBoardTitle(sc.next());
		System.out.print("내용 입력 : ");
		b.setBoardContent(sc.next());
		return b;
	}
}
