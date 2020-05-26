package board.model.serivce;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.BoardDao;
import board.model.vo.BoardData;
import common.SqlSessionTemplate;

public class BoardService {

	public BoardData selectList(int reqPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int numPerPage = 10;
		int totalCount = new BoardDao().totalCount(session);
		int totalPage;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage + 1;
		}
		//게시물 시작 값, 끝 값 조회
		int start = (reqPage-1)*numPerPage + 1;
		int end = reqPage*numPerPage;
		
		HashMap<String, String> map = new HashMap<String, String>();
		//타입형식을 맞춰줘야 함
		map.put("start", String.valueOf(start));
		map.put("end", String.valueOf(end));
		List list = new BoardDao().selectList(session, map);
		//PAGENAVI 작성
		String pageNavi="";
		int pageNaviSize = 3;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		
		
		return null;
	}

}
