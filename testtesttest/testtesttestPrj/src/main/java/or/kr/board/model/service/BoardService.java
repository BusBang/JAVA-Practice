package or.kr.board.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import or.kr.board.model.dao.BoardDao;

@Service("boardService")
public class BoardService {
	@Autowired
	@Qualifier("boardDao")
	private BoardDao dao;
	
	public BoardService() {
		super();
		System.out.println("boardService 생성완료");
	}
	
}
