package or.kr.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import or.kr.board.model.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardService")
	private BoardService service;
	
	public BoardController() {
		super();
		System.out.println("boardController 생성완료");
	}
}
