package kh.exam.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;

public class ExamDao {

	public int enrollMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into exam_member values (seq_member.nextval, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getPhone());
			result =pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public String searchId(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String id = null;
		
		String query = "select * from exam_member "
				+ "where member_name = ? and phone =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2, m.getPhone());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				id = rset.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return id;		
	}

	public Member login(Connection conn, Member m) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member lMember = null;
		
		String query = "select * from exam_member where member_id = ? and member_pw =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPw());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				lMember = new Member();
				lMember.setMemberNo(rset.getInt(1));
				lMember.setMemberId(rset.getString(2));
				lMember.setMemberPw(rset.getString(3));
				lMember.setMemberName(rset.getString(4));
				lMember.setPhone(rset.getString(5));
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return lMember;	
	}

	public Member myState(Connection conn, Member loginMember) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member myState = new Member();
		
		String query = "select * from exam_member where member_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, loginMember.getMemberNo());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				myState.setMemberNo(rset.getInt(1));
				myState.setMemberId(rset.getString(2));
				myState.setMemberPw(rset.getString(3));
				myState.setMemberName(rset.getString(4));
				myState.setPhone(rset.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return myState;
	}

	public int modifyState(Connection conn, Member loginMember, Member modi) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update exam_member set member_pw = ?, phone = ? where member_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, modi.getMemberPw());
			pstmt.setString(2, modi.getPhone());
			pstmt.setInt(3, loginMember.getMemberNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, Member loginMember) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from exam_member where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginMember.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertBoard(Connection conn, Board board, Member loginMember) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into exam_board values (seq_board.nextval, ?, ?, ?, default, default)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setString(3, loginMember.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<Board> allBoard(Connection conn) {
		ArrayList<Board> allBoard = new ArrayList<Board>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select board_no, board_title, member_name, read_count, write_date from exam_board left join exam_member on (member_id=board_writer)";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board board = new Board();
				board.setBoardNo(rset.getInt(1));
				board.setBoardTitle(rset.getString(2));
				board.setBoardWriter((rset.getString(3)!=null)?rset.getString(3):"탈퇴회원");
				board.setReadCount(rset.getInt(4));
				board.setWriteDate(rset.getDate(5));
				allBoard.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allBoard;
	}

	public Board detailBoard(Connection conn, int sel) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board dBoard = null;
		
		String query = "select board_no, board_title, board_content, member_name, read_count, "
				+ "write_date from exam_board left join exam_member on"
				+ " (member_id=board_writer) where board_no = ?";
		
		try {
			pstmt =	conn.prepareStatement(query);
			pstmt.setInt(1, sel);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				dBoard = new Board();
				dBoard.setBoardNo(rset.getInt(1));	
				dBoard.setBoardTitle(rset.getString(2));	
				dBoard.setBoardContent(rset.getString(3));	
				dBoard.setBoardWriter((rset.getString(4)!=null)?rset.getString(4):"탈퇴회원");	
				dBoard.setReadCount(rset.getInt(5));	
				dBoard.setWriteDate(rset.getDate(6));
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}		
		return dBoard;
	}

	public int addCount(Connection conn, int sel, int adder) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update exam_board set read_count = ? where board_no = ?";
		
		try {
			pstmt =conn.prepareStatement(query);
			pstmt.setInt(1, adder);
			pstmt.setInt(2, sel);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Board searchBoard(Connection conn, int bNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board searchBoard = null;
		
		String query = "select board_no, board_title, board_content, board_writer, read_count, write_date from exam_board join exam_member on (member_id=board_writer) where board_no = ?";
		
		try {
			pstmt= conn.prepareStatement(query);
			pstmt.setInt(1, bNum);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				searchBoard = new Board();
				searchBoard.setBoardNo(rset.getInt(1));
				searchBoard.setBoardTitle(rset.getString(2));
				searchBoard.setBoardContent(rset.getString(3));
				searchBoard.setBoardWriter(rset.getString(4));
				searchBoard.setReadCount(rset.getInt(5));
				searchBoard.setWriteDate(rset.getDate(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
	return searchBoard;
	}

	public int deleteBoard(Connection conn, int bNum, Member loginMember) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from (select board_no, board_title, board_content, board_writer, read_count, write_date from exam_board join exam_member on(member_id=board_writer) where board_no = ?) where board_writer = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,bNum);
			pstmt.setString(2, loginMember.getMemberId());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return result;
	}

	public Board searchMyBoard(Connection conn, int mNum, Member loginMember) {
		PreparedStatement pstmt = null;
		Board searchMyBoard = null;
		ResultSet rset = null;
		
		String query = "select * from (select board_no, board_title, board_content, board_writer, read_count, write_date from exam_board join exam_member on(member_id=board_writer) where board_no = ?) where board_writer = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mNum);
			pstmt.setString(2, loginMember.getMemberId());
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				searchMyBoard = new Board();
				searchMyBoard.setBoardNo(rset.getInt(1));
				searchMyBoard.setBoardTitle(rset.getString(2));
				searchMyBoard.setBoardContent(rset.getString(3));
				searchMyBoard.setBoardWriter(rset.getString(4));
				searchMyBoard.setReadCount(rset.getInt(5));
				searchMyBoard.setWriteDate(rset.getDate(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}		
		return searchMyBoard;
	}

	public int modifyInfo(Connection conn, int mNum, Board newBoard) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update exam_board set board_title = ?, board_content=? where board_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newBoard.getBoardTitle());
			pstmt.setString(2, newBoard.getBoardContent());
			pstmt.setInt(3, mNum);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
}
