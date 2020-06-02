package kh.java.member.controller;

import java.sql.Connection;
import java.util.ArrayList;

import kh.java.member.common.JDBCTemplate;
import kh.java.member.model.dao.MemberDao;
import kh.java.member.model.vo.Member;
import kh.java.member.view.MemberView;

public class MemberController {

	MemberView mv = new MemberView();

	public void main() {
		while (true) {
			int sel = mv.mainMenu();
			switch (sel) {
			case 1:
				printAll();
				break;
			case 2:
				searchId();
				break;
			case 3:
				searchName();
				break;
			case 4:
				insertMember();
				break;
			case 5:
				modifyMember();
				break;
			case 6:
				deleteMember();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("숫자를 잘못 입력하였습니다. ");
			}
		}
	}

	// 멤버 삭제 -> 삭제 명단에 명단 업데이트 : 트랜잭션
	private void deleteMember() {
		String inputId = mv.deleteMember();
		MemberDao md = new MemberDao();
		// 트랜잭션을 위해 Connection을 생성
		Connection conn = JDBCTemplate.getConnection();

		if (!md.dupliId(conn, inputId)) {
			// 멤버 테이블에서 해당하는 Tuple삭제
			int result1 = md.deleteMember(conn, inputId);
			// DEL_MEMBER 테이블에 해당 Tuple 추가
			int result2 = md.insertDelMember(conn, inputId);
			if (result1 > 0 && result2 > 0) {
				JDBCTemplate.commit(conn);
				mv.printMSG("삭제 완료되었습니다.");
			} else {
				JDBCTemplate.rollback(conn);
				mv.printMSG("삭제 실패");
			}
		} else {
			mv.printMSG("해당 아이디는 존재하지 않습니다.");
		}
		JDBCTemplate.close(conn);
	}

	private void modifyMember() {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new Member();
		String inputId = mv.searchId();
		MemberDao md = new MemberDao();

		if (!md.dupliId(conn, inputId)) {
			m = mv.modifyMember();
			m.setMemberId(inputId);
			int result = md.modifyMember(conn, m);
			if (result > 0) {
				JDBCTemplate.commit(conn);
				mv.printMSG("수정 완료");
			} else {
				JDBCTemplate.rollback(conn);
				mv.printMSG("수정 실패");
			}
		} else {
			mv.printMSG("해당 아이디는 존재하지 않습니다.");
		}
		JDBCTemplate.close(conn);
	}

	private void searchName() {
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Member> mList = new ArrayList<Member>();
		String inputName = mv.searchName();
		MemberDao md = new MemberDao();
		mList = md.searchName(conn, inputName);
		if (!mList.isEmpty()) {
			for (Member a : mList) {
				mv.printArr(a);
			}
		} else {
			mv.printMSG("해당 회원 이름은 없습니다. ");
		}
		JDBCTemplate.close(conn);
	}

	private void searchId() {
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Member> mlist = new ArrayList<Member>();
		String inputId = mv.searchId();
		MemberDao md = new MemberDao();

		mlist = md.searchId(conn, inputId);
		if (!mlist.isEmpty()) {
			mv.printHead();
			mv.printArr(mlist.get(0));
		} else {
			mv.printMSG("해당 아이디는 존재하지 않습니다");
		}
		JDBCTemplate.close(conn);
	}

	private void printAll() {
		Connection conn = JDBCTemplate.getConnection();

		mv.printAll();
		MemberDao md = new MemberDao();
		ArrayList<Member> mList = md.printAll(conn);
		if (!mList.isEmpty()) {
			for (Member a : mList) {
				mv.printArr(a);
			}
		} else {
			mv.printMSG("회원 정보가 없습니다. ");
		}
		mv.printMSG("--------------------------------------" + "---------------------------");
		JDBCTemplate.close(conn);
	}

	private void insertMember() {
		Connection conn = JDBCTemplate.getConnection();

		if (dupliId(conn)) {
			Member m = mv.insertMember();
			MemberDao md = new MemberDao();
			int result = md.insertMember(conn, m);
			if (result > 0) {
				JDBCTemplate.commit(conn);
				mv.printMSG("회원가입성공");
			} else {
				JDBCTemplate.rollback(conn);
				mv.printMSG("회원가입실패");
			}
			JDBCTemplate.close(conn);
		} else {
			JDBCTemplate.close(conn);
			return;
		}
	}

	private boolean dupliId(Connection conn) {
		String dupliId = mv.dupliId();
		MemberDao md = new MemberDao();
		boolean cc = md.dupliId(conn, dupliId);
		if (cc) {
			mv.printMSG("존재하지 않는 아이디입니다.");
			return true;
		} else {
			mv.printMSG("존재하는 아이디입니다.");
			return false;
		}
	}

}
