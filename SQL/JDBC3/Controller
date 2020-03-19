package kh.java.member.controller;

import java.util.ArrayList;

import kh.java.member.model.dao.MemberDao;
import kh.java.member.model.vo.Member;
import kh.java.member.view.MemberView;

public class MemberController {
	
	MemberView mv = new MemberView();
	
	public void main() {
		while(true) {
			int sel = mv.mainMenu();
			switch(sel) {
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
			}
		}
	}

	private void deleteMember() {
		String inputId = mv.deleteMember();
		MemberDao md = new MemberDao();
		if(!md.dupliId(inputId)) {
			int result = md.deleteMember(inputId);
			if(result>0) {
				mv.printMSG("삭제 완료되었습니다.");
			}else {
				mv.printMSG("삭제 실패");
			}			
		}else {
			mv.printMSG("해당 아이디는 존재하지 않습니다.");
		}
	}

	private void modifyMember() {
		Member m = new Member();
		String inputId = mv.searchId();
		MemberDao md = new MemberDao();
		if(!md.dupliId(inputId)) {
			m = mv.modifyMember();
			m.setMemberId(inputId);
			int result = md.modifyMember(m);
			if(result > 0) {
				mv.printMSG("수정 완료");
			} else {
				mv.printMSG("수정 실패");
			}
		} else {
			mv.printMSG("해당 아이디는 존재하지 않습니다.");
		}
		
	}

	private void searchName() {
		ArrayList<Member> mList = new ArrayList<Member>();
		String inputName = mv.searchName();
		MemberDao md = new MemberDao();
		mList = md.searchName(inputName);
		if(!mList.isEmpty()) {
			for(Member a : mList) {
				mv.printArr(a);
			}
		} else {
			mv.printMSG("해당 회원 이름은 없습니다. ");
		}
			
	}

	private void searchId() {
		ArrayList<Member> mlist = new ArrayList<Member>();
		String inputId = mv.searchId();
		MemberDao md = new MemberDao();
		mlist = md.searchId(inputId);
		if(!mlist.isEmpty()) {
			mv.printHead();
			mv.printArr(mlist.get(0));
		}else {
			mv.printMSG("해당 아이디는 존재하지 않습니다");
		}
	}

	private void printAll() {
		mv.printAll();
		MemberDao md = new MemberDao();
		ArrayList<Member> mList=md.printAll();
		if(!mList.isEmpty()) {
			for(Member a : mList) {
				mv.printArr(a);
			}
		} else {
			mv.printMSG("회원 정보가 없습니다. ");
		}
		mv.printMSG("--------------------------------------"
				+ "---------------------------");
	}

	private void insertMember() {
		if(dupliId()) {
			Member m = mv.insertMember();
			MemberDao md = new MemberDao();
			int result = md.insertMember(m);
			if(result>0) {
				mv.printMSG("회원가입성공");
			} else {
				mv.printMSG("회원가입실패");
			}				
		} else {
			return;
		}
	}
	
	private boolean dupliId() {
		String dupliId = mv.dupliId();
		MemberDao md = new MemberDao();
		boolean cc = md.dupliId(dupliId);
		if(cc) {
			mv.printMSG("중복되지 않은 아이디입니다.");
			return true;
		} else {
			mv.printMSG("중복된 아이딥니다.");
			return false;
		}
	}
	
	
}
