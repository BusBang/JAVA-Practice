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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.message.model.dao.MessageDao;
import kr.message.model.vo.Message;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("messageDao")
	private MessageDao dao;
	public HomeController() {
		super();
		System.out.println("홈컨트롤러 생성");
	}
	
	@ResponseBody
	@RequestMapping(value="insertMessage.do", produces = "text/html; charset=utf-8") 
	public String insertMessage (Message m) {
		System.out.println(m.getName());
		System.out.println(m.getMessage());
		int result = dao.insertMessage(m);
		String r;
		if(result >0) {
			r = "1";
		}else {
			r = "0";
		}
		return r;
	}
	@ResponseBody
	@RequestMapping(value = "/listMessage.do", produces = "application/josn; charset=utf-8")
	public String ListMessage() {
		List list = dao.selectMsgList();
		return new Gson().toJson(list);
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}
	
	
}
