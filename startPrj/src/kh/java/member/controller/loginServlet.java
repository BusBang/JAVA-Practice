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
 * Servlet implementation class loginServlet
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. request에서 사용자 값 꺼내서 변수에 저장
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		//3. 비즈니스 로직 처리
		Member login = new Member();
		login.setMemberId(memberId);
		login.setMemberPw(memberPw);
		MemberService service = new MemberService();
		Member m = service.selectOneMember(login);
		//4. 결과처리
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><tilte>로그인결과</title></head>");
		out.println("<body>");
		if(m!=null) {
			//로그인 성공
			out.println("<h1>"+m.getMemberName()+"님 환영합니다. </h1>");

		} else {
			//로그인 실패
			out.println("<script>");
			out.println("alert('로그인실패');");
			out.println("location.href='/html/member/main.html';");
			out.println("</script>");
		}
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
