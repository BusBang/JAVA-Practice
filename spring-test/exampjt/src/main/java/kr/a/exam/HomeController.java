package kr.a.exam;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.member.model.dao.MemberDao;
import kr.member.model.vo.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("memberDao")
	private MemberDao dao;
	public HomeController() {
		super();
		System.out.println("홈컨트롤러 생성");
	}
	
	@ResponseBody
	@RequestMapping(value="/insertMember.do", produces = "text/html; charset=utf-8") 
	public String insertMember (Member m) {
		System.out.println(m.getId());
		System.out.println(m.getName());
		int result = dao.insertMember(m);
		String r;
		if(result >0) {
			r = "1";
		}else {
			r = "0";
		}
		return r;
	}
	@RequestMapping("/error.do")
	public String error() {
		return "member/error";
	}	
	@ExceptionHandler(RuntimeException.class)
	public String errorHandler() {
		return "redirect:/error.do";
	}	
	
	@ResponseBody
	@RequestMapping(value="/listMember.do", produces = "application/json; charset=utf-8")
	public String selectAllMember() {
		ArrayList<Member> memberList = dao.select();
		return new Gson().toJson(memberList);
	}	
}
