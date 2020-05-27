package board.model.serivce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import board.model.vo.BoardData;
import common.SqlSessionTemplate;

public class BoardService {

	public BoardData selectList(int reqPage, String type, String keyword) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int numPerPage = 10;
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("type", type);
		map.put("keyword", keyword);
		int totalCount = new BoardDao().totalCount(session, map);
		int totalPage;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage + 1;
		}
		//게시물 시작 값, 끝 값 조회
		int start = (reqPage-1)*numPerPage + 1;
		int end = reqPage*numPerPage;
		

		//타입형식을 맞춰줘야 함
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));
		List list = new BoardDao().selectList(session, map);
		//PAGENAVI 작성
		String pageNavi="";
		int pageNaviSize = 3;
		//pageNo 연산 -> 페이지 시작번호 -> 요청페이지 기준으로 -1 요청페이지 +1
		//1페이지와 마지막 페이지가 문제가 생김
		int pageNo = 1;
		        if (reqPage != 1) {
		            pageNo = reqPage - 1;
		        }
		//이전버튼 생성
		if(pageNo != 1) {
			pageNavi += "<a href='/boardList?reqPage="+(pageNo-1);
			if(type != null) {
				pageNavi += "&type="+type+"&keyword="+keyword;
			}
			pageNavi += "'>이전</a>";
			
		}
		//페이지 버튼 생성
		for (int i = 0; i <pageNaviSize; i++) {
			if(reqPage == pageNo) {
				pageNavi += "<span>"+pageNo+"</span>";
			}else {
				pageNavi += "<a href='/boardList?reqPage="+pageNo;
				if(type != null) {
					pageNavi += "&type="+type+"&keyword="+keyword;
				}
				pageNavi += "'>"+pageNo+"</a>";
			}
			pageNo++;
			if(pageNo > totalPage) {
				break;
			}
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavi += "<a href='/boardList?reqPage="+pageNo;
			if(type != null) {
				pageNavi += "&type="+type+"&keyword="+keyword;
			}
			pageNavi += "'>다음</a>";
		}
		BoardData db = new BoardData((ArrayList<Board>)list, pageNavi);
		session.close();
		return db;
	}

	public int insertBoard(Board b) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new BoardDao().insertBoard(session, b);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public Board selectOneBoard(int boardNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Board b = new BoardDao().selectOneBoard(session, boardNo);
		int result = new BoardDao().addCount(session, boardNo);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return b;
	}

	public int updateBoard(Board b) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new BoardDao().updateBoard(session, b);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteBoard(int boardNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new BoardDao().deleteBoard(session, boardNo);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteBoard(String[] delNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new BoardDao().deleteBoard(session, delNo);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

}
