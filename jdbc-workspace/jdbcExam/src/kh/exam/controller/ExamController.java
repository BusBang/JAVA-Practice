package kh.exam.controller;

import java.sql.Connection;
import java.util.ArrayList;

import kh.exam.model.dao.ExamDao;
import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;
import kh.exam.view.ExamView;
import common.JDBCTemplate;

public class ExamController {
	ExamView ev = new ExamView();
	Member loginMember;
	
	public void main() {
		while(true) {
			int sel = ev.main();
			switch(sel) {
			case 1 :
				login();
				break;
			case 2 :
				enrollMember();
				break;
			case 3 :
				searchId();
				break;
			case 0 : 
				ev.printMSG("프로그램을 종료합니다..");
				return;
				default : ev.printMSG("잘못된 번호를 입력하였습니다. ");
			}
		}
	}
	public void loginMain() {
		while(true) {
			int select = ev.loginMain();
			switch(select) {
			case 1:
				allBoard();
				break;
			case 2:
				detailBoard();
				break;
			case 3:
				insertBoard();
				break;
			case 4:
				modifyBoard();
				break;
			case 5:
				deleteBoard();
				break;
			case 6:
				myState();
				break;
			case 7:
				modifyState();
				break;
			case 8:
				if(deleteMember()==1) {
					return;
				} else {
					break;					
				}
			case 0:
				return;
			}
		}
	}

	private void modifyBoard() {
		int mNum = ev.modifyBoard();
		Connection conn =JDBCTemplate.getConnection();
		ExamDao ed = new ExamDao();
		Board searchBoard = ed.searchBoard(conn, mNum);
		if(searchBoard != null) { //게시글 존재 확인
			Board searchMyBoard = ed.searchMyBoard(conn, mNum, loginMember); //내 게시글인지 확인
			if(searchMyBoard != null) {
				Board newBoard = ev.modifyInfo();
				int result = ed.modifyInfo(conn, mNum, newBoard);
				if(result > 0) {
					ev.printMSG("수정 완료");
					JDBCTemplate.commit(conn);
				}else {
					ev.printMSG("수정 실패");
					JDBCTemplate.rollback(conn);
				}
			} else {
				JDBCTemplate.rollback(conn);
				ev.printMSG("작성자만 수정이 가능합니다. ");
			}
		}else {
			ev.printMSG("게시물 번호를 확인하세요. ");
		}
		JDBCTemplate.close(conn);		
	}
	
	private void deleteBoard() {
		int bNum = ev.deleteBoard();
		Connection conn = JDBCTemplate.getConnection();
		ExamDao ed = new ExamDao();
		Board searchBoard = ed.searchBoard(conn, bNum);
		if(searchBoard != null) {
			int result = ed.deleteBoard(conn, bNum, loginMember);
			if(result > 0) {
				JDBCTemplate.commit(conn);
				System.out.println("게시글 삭제 성공 !!");
			} else {
				JDBCTemplate.rollback(conn);
				ev.printMSG("작성자만 삭제가 가능합니다.");
			}
		} else {
			ev.printMSG("게시물 번호를 확인하세요");
		}
		JDBCTemplate.close(conn);
	}
	private void detailBoard() {
		int sel = ev.detailBoard();
		Connection conn = JDBCTemplate.getConnection();
		ExamDao ed = new ExamDao();
		Board deBoard =new Board();
		deBoard = ed.detailBoard(conn, sel);
		if(deBoard != null) {
			ev.printMSG("-------------게시글 정보---------");
			ev.printMSG("게시물 번호 : "+deBoard.getBoardNo());
			ev.printMSG("게시물 제목 : "+deBoard.getBoardTitle());
			ev.printMSG("게시물 내용 : "+deBoard.getBoardContent());
			ev.printMSG("작성자 이름 : "+deBoard.getBoardWriter());
			ev.printMSG("조회수 : "+deBoard.getReadCount());
			ev.printMSG("작성일자 : "+deBoard.getWriteDate());
			int adder = deBoard.getReadCount();
			adder++;
			int result = ed.addCount(conn, sel, adder);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			ev.printMSG("해당 번호의 게시글은 없습니다. ");
		}
		JDBCTemplate.close(conn);
	}
	
	
	private void allBoard() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList <Board> allBoard = new ArrayList<Board>();

		ExamDao ed = new ExamDao();
		allBoard = ed.allBoard(conn);
		ev.allBoard();
		if(!allBoard.isEmpty()) {
			for(Board a : allBoard) {
				ev.printBoard(a);
			}
			ev.printMSG("----------------------------------------");
		}else {
			ev.printMSG("작성된 글이 없습니다. ");
		}
		JDBCTemplate.close(conn);

	}
	private void insertBoard() {
		Connection conn = JDBCTemplate.getConnection();
		Board board = new Board();
		board = ev.insertBoard();
		ExamDao ed = new ExamDao();
		int result = ed.insertBoard(conn, board, loginMember);
		if(result > 0 ) {
			ev.printMSG("게시글 생성 완료 !!");
			JDBCTemplate.commit(conn);
		} else {
			ev.printMSG("게시글 생성 실패 ㅠ ㅠ");
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
	}
	
	
	private int deleteMember() {
		int sel = ev.deleteMember();
		switch(sel) {
		case 1:
			Connection conn = JDBCTemplate.getConnection();
			ExamDao ed = new ExamDao();
			int result = ed.deleteMember(conn, loginMember);
			if(result >0) {
				ev.printMSG("삭제가 완료되었습니다. ");
				JDBCTemplate.close(conn);
				return 1;
			} else {
				ev.printMSG("삭제 실패");
			}
			JDBCTemplate.close(conn);
			break;
		case 2:
			ev.printMSG("취소하였습니다. ");
			return 0;
			default : ev.printMSG("잘못된 숫자를 입력하였습니다.");	
		}
		return 0;
	}
	private void modifyState() {
		Connection conn = JDBCTemplate.getConnection();
		
		Member modi = ev.modifyState();
		ExamDao ed = new ExamDao();
		
		int result = ed.modifyState(conn, loginMember, modi);
		if(result > 0) {
			ev.printMSG("정보 수정 성공");
			JDBCTemplate.commit(conn);
			Member lMember = ed.myState(conn, loginMember);
			loginMember = lMember;
		} else {
			ev.printMSG("정보 수정 실패 ㅠㅠ");
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
	}
	private void myState() {
		ev.myState();
		ev.printMSG("회원번호 : "+loginMember.getMemberNo());
		ev.printMSG("아이디 : "+loginMember.getMemberId());
		ev.printMSG("비밀번호 : "+loginMember.getMemberPw());
		ev.printMSG("이름 : "+loginMember.getMemberName());
		ev.printMSG("전화번호 : "+loginMember.getPhone());
		ev.printMSG("================================");	

	}
	private void login() {
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = ev.login();
		ExamDao md = new ExamDao();
		loginMember = md.login(conn, m);
		if(loginMember != null) {
			ev.printMSG("로그인 성공!!");
			loginMain();
		} else {
			ev.printMSG("아이디 또는 비밀번호를 확인하세요. ");
		}
		JDBCTemplate.close(conn);
	}

	private void enrollMember() {
		Connection conn = JDBCTemplate.getConnection();
		
		Member m = ev.enrollMember();
		ExamDao md =new ExamDao();
		int result =md.enrollMember(conn, m);
		if(result > 0) {
			ev.printMSG("회원 가입 완료");
			JDBCTemplate.commit(conn);
		} else {
			ev.printMSG("회원 가입 실패.\n중복된 아이디가 아니라면 관리자에게 문의 바랍니다.");
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
	}
	
	private void searchId() {
		Connection conn = JDBCTemplate.getConnection();
		Member m = ev.searchID();
		ExamDao md = new ExamDao();
		String id = md.searchId(conn, m);
		if (id != null) {
			ev.printMSG("아이디는 ["+id+"] 입니다.");
		} else {
			ev.printMSG("일치하는 정보가 없습니다. ");
		}
		JDBCTemplate.close(conn);
	}

	
	

	
	
	
	
	
}
