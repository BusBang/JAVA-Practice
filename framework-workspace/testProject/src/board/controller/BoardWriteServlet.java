package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.serivce.BoardService;
import board.model.vo.Board;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet(name = "BoardWrite", urlPatterns = { "/boardWrite" })
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Board b = new Board();
		b.setBoardContent(request.getParameter("boardContent"));
		b.setBoardTitle(request.getParameter("boardTitle"));
		b.setBoardWriter(request.getParameter("boardWriter"));
		System.out.println(b.getBoardTitle());
		System.out.println(b.getBoardContent());
		System.out.println(b.getBoardWriter());
		int result = new BoardService().insertBoard(b);
		//4. 결과처리
		if(result>0) {
			request.setAttribute("msg", "등록 성공 !");
			request.setAttribute("loc", "/boardList?reqPage=1");
		}else {
			request.setAttribute("msg", "등록 실패 !");
			request.setAttribute("loc", "/boardWriteFrm");
		}
		request.getRequestDispatcher("/WEB-INF/views/msg.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
