package kh.java.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.java.member.model.service.MemberService;
import kh.java.member.model.vo.Member;

/**
 * Servlet implementation class joinServlet
 */
@WebServlet(name = "join", urlPatterns = { "/join" })
public class joinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public joinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값 저장
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("memberPw"));
		member.setMemberName(request.getParameter("memberName"));
		member.setFootSize(Integer.parseInt(request.getParameter("footSize")));
	//3. 비즈니스 로직 처리
		int result = new MemberService().insertMember(member);
	//4. 결과 처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><tilte>회원가입결과</title></head>");
		out.println("<body>");
		out.println("<script>");
		if(result>0) {
			//회원가입성공
			out.println("alert('회원가입성공!!!');");

		}else {
			//회원가입 실패
			out.println("alert('회원가입실패!!!');");
		}
		out.println("location.href='/html/member/main.html';");
		out.println("</script>");
		out.println("</body>");
		out.println("</body></html>");		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
