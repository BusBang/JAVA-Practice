package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.serivce.BoardService;

/**
 * Servlet implementation class DeleteBoardSerlvet
 */
@WebServlet(name = "DeleteBoard", urlPatterns = { "/deleteBoard" })
public class DeleteBoardSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
/*		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String[] delNo = new String[1];
*/		
		
		
		String [] delNo = request.getParameterValues("delNo");
		int result = new BoardService().deleteBoard(delNo);
		if(result > 0) {
			request.setAttribute("msg", "삭제 성공");
		}else {
			request.setAttribute("msg", "삭제 실패");
		}
		request.setAttribute("loc", "/boardList?reqPage=1");
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
