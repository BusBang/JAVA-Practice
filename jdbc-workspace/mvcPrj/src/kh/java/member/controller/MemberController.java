package kh.java.member.controller;

import java.util.ArrayList;

import kh.java.member.model.dao.MemberDao;
import kh.java.member.model.service.MemberService;
import kh.java.member.view.MemberView;
import kh.java.member.vo.Member;

public class MemberController {
	MemberView view = new MemberView();
	public void main() {
		while(true) {
			int sel = view.MainMenu();
			switch(sel) {
			case 1 :
				selectAll();
				break;
			case 2 :
				selectOne();
				break;
			case 3 :
				insertMember();
				break;
			case 4 :
				modifyMember();
				break;
			case 5 :
				deleteMember();
				break;
			case 0 :
				return;
			}
		}
	}
	private void modifyMember() {
		String inputId = view.SearchId();
		MemberService service = new MemberService();
		Member m = service.SearchId(inputId);
		if(m!=null) {
			Member m2 = view.ModifyMember();
			int result = service.modifyMember(m, m2);
			if(result>0) {
				view.printMsg("수정이 완료되었습니다.");
			} else {
				view.printMsg("수정 실패");
			}
		} else {
			view.printMsg("해당 아이디 회원은 없습니다.");
		}
	}
	private void selectOne() {
		String inputName = view.selectOne();
		MemberService service = new MemberService();
		Member m = service.selectOne(inputName);
		if(m!=null) {
			view.PrintOne(m);
		} else {
			view.printMsg("해당 이름의 회원은 없습니다. ");
		}
		
	}
	public void selectAll() {
		//전체 조회는 입력 값을 받을 것이 없다. 바로 서비스로 가면 됨
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selectAll();
		if(list.isEmpty()) {
			view.printMsg("회원이 없습니다. ");
		}else {
			view.printAll(list);
		}

	}
	public void insertMember() {
		Member m = view.insertMember();
//		Dao가 하던 작업을 service가 진행하게 된다.
// 		controller가 하던 작업 모두 service가 하게 된다 이제.
//		controller는 이제 입력 값만 받고 보내고, 처리한걸(젠더 구분 등) 받아 처리하는 것만 한다.
		MemberService service = new MemberService();  //service라는 변수는 계속해서 부를 것이기 때문에 전역 변수로 선언해도 무방.
		int result = service.insertMember(m); //결과 값은 모두 int 로 돌아온다.
		
// view에서 값을 받아 controller에게 전달, controoler는 서비스에 값을 전달 -> 서비스는 dao에 보냄 -> dao는 데이터베이스에 접근해서 퀴리문 실행해서 결과 값 반환, 서비스는 커밋과 롤백 진행, 결과를 컨트롤러로 반환. 컨트롤러는 결과 메세지를 출력
		
		if(result>0) {
			view.printMsg("회원 가입 성공!!");
		} else {
			view.printMsg("회원 가입 실패");
		}
		
		

		
		
//		MemberDao dao = new MemberDao();
//		dao.insertMember(m);
		
	}
}
