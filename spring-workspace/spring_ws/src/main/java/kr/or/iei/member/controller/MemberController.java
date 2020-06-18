package kr.or.iei.member.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.ibatis.jdbc.SQL;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.ParserAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Attributes;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import jdk.internal.org.xml.sax.helpers.DefaultHandler;
import kr.or.iei.common.AladdinOpenAPI;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Book;
import kr.or.iei.member.model.vo.Member;
import net.sf.json.JSONObject;

@Controller
public class MemberController {
	
	//만들어진 memberService를 private service로 만든다. 객체를 계속 생성하지 않고 만들고 고대로 쓴다ㅡ
	@Autowired
	@Qualifier("memberService")
	private MemberService service;
	
	public MemberController() {
		super();
		String test = "국내도서>청소년>청소년 문학>청소년 소설";
//		String [] arr = test.split(">");
//		String resultTest = arr[1];
		String resultTest = test.split(">")[1];
		System.out.println(resultTest);
		
		
		System.out.println("MemberController 생성 완료");
	}
	
	@ResponseBody
	@RequestMapping(value="/selectAllMember.do", produces = "application/json; charset=utf-8")
	public String selectAllMember() {
		ArrayList<Member> memberList = service.selectAllMember();
		return new Gson().toJson(memberList);
	}
	
	@RequestMapping(value="/allMember.do")
	public String allMember() {
		return "member/allMember";
	}
	@CrossOrigin(origins = {"http://192.168.10.179","http://192.168.10.188","http://localhost"})
	@ResponseBody
	@RequestMapping(value="/checkId.do", produces = "text/html; charset=utf-8")
	public String checkId(Member m) {
		Member member = service.checkId(m);
		//member null -> 사용 가능
		//member !null -> 사용 불가
		if(member == null) {
			return "0"; 			
		}else {
			return "1";
		}
	}
	
	@RequestMapping(value="/login.do")
	public String loginMember(HttpSession session, Member m) {
		
		//비즈니스 로직 호출 -- 계속해서 호출하던 것을 DI방식으로 한다
//		Member member = new MemberService().selectOneMember(m);
		Member member = service.selectOneMember(m);
		
		if(member != null) {
			session.setAttribute("member", member);
			return "member/loginSuccess";			
		}else {
			return "member/loginFailed";
		}
	}
	
	@RequestMapping(value="/joinFrm.do")
	public String joinFrm() {
		return "member/join";
	}
	
	@RequestMapping(value="/join.do")
	public String join(Member m) {
		int result = service.insertMember(m);
		if(result > 0) {
			return "member/joinSuccess";
		}else {
			return "member/joinFailed";
		}
	}

	@RequestMapping(value="logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value="mypage.do")
	public String mypage(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("member");
		model.addAttribute("m",m);
		return "member/mypage";
	}
	
	@RequestMapping(value="mUpdate.do")
	public String mUpdate(HttpSession session, Member m, Model model) {
		int result = service.updateMember(m);
		if(result >0) {
			Member member = service.selectOneMember(m);
			session.setAttribute("member", member);
			model.addAttribute("m", member);
			System.out.println("정보수정성공");
			return "member/mypage";
		}else {
			System.out.println("정보수정실패");
			return "redirect:/";
		}
	}

	@RequestMapping(value="mDelete.do")
	public String mDelete(HttpSession session, Model model) {
		Member m = (Member)session.getAttribute("member");
		int result = service.deleteMember(m);
		if(result > 0) {
			session.invalidate();
			System.out.println("탈퇴성공");
			return "redirect:/";
		}else {
			System.out.println("탈퇴실패");
			model.addAttribute("m",m);
			return "member/mypage";			
		}
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
	@RequestMapping("/arduinoTest.do")
	public String arduino(String str) {
		System.out.println(str);
		return "ok";
	}
	
	////////////////////////////////
	@Autowired
	@Qualifier("AladdinOpenAPI")
	private AladdinOpenAPI aladdin;
	
	@ResponseBody
	@RequestMapping(value="/aladdin.do", produces = "application/json; charset=utf-8")
	public String aladdin(String title, HttpServletRequest request) {

		System.out.println("title:"+title);
		String BASE_URL ="";
		//20070901 20131101
		//베스트셀러
		BASE_URL = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx?ttbkey=ttbbang82550812001&Query="+title+"&QueryType=Bestseller&MaxResults=100&start=1&SearchTarget=Book&output=js&Version=20070901";
		//편집자 추천
//		BASE_URL = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx?ttbkey=ttbbang82550812001&Query="+title+"&QueryType=ItemEditorChoice&MaxResults=100&start=1&SearchTarget=Book&output=js&Version=20070901";
		//인기 신간
		BASE_URL = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx?ttbkey=ttbbang82550812001&Query="+title+"&QueryType=ItemNewSpecial&MaxResults=100&start=1&SearchTarget=Book&output=js&Version=20070901";

		try {
			HttpClient client = HttpClientBuilder.create().build(); // HttpClient 생성
			HttpGet getRequest = new HttpGet(BASE_URL); //GET 메소드 URL 생성
			getRequest.addHeader("ttbkey", "ttbbang82550812001"); //KEY 입력

			HttpResponse response = client.execute(getRequest);

			//Response 출력
			if (response.getStatusLine().getStatusCode() == 200) {
				ResponseHandler<String> handler = new BasicResponseHandler();
				String body = handler.handleResponse(response);
				body = body.replaceAll(";", "");
				System.out.println(body);
				JsonParser parser = new JsonParser();
				JsonObject resultJson = (JsonObject)parser.parse(body);
				JsonArray resultJson2 = (JsonArray)resultJson.get("item");				
				System.out.println("resultJson : "+resultJson);
				System.out.println("resultJson2 : "+resultJson2);
				
				
//				String from = "2013-04-08 10:10:10";
//				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				Date to = transFormat.parse(from);

//				java.sql.Timestamp t = java.sql.Timestamp.valueOf("2020-06-01");
				System.out.println(resultJson2.get(0).getAsJsonObject().get("pubDate").getAsString());
				System.out.println(resultJson2.get(0).getAsJsonObject().get("pubDate").getClass().getName());
				System.out.println(resultJson2.get(0).getAsJsonObject().get("pubDate").getAsString().getClass().getName());

				ArrayList<Book> list = new ArrayList<Book>();
				for(int i=0; i<resultJson2.size(); i++) {
					Book b = new Book();
					b.setBookName(resultJson2.get(i).getAsJsonObject().get("title").getAsString());
					b.setBookContent(resultJson2.get(i).getAsJsonObject().get("description").getAsString());
					b.setBookImg(resultJson2.get(i).getAsJsonObject().get("cover").getAsString());
					b.setBookWriter(resultJson2.get(i).getAsJsonObject().get("author").getAsString());
					b.setBookPublisher(resultJson2.get(i).getAsJsonObject().get("publisher").getAsString());
					b.setBookCategory(resultJson2.get(i).getAsJsonObject().get("categoryName").getAsString().split(">")[1]);
					java.sql.Date d = java.sql.Date.valueOf(resultJson2.get(i).getAsJsonObject().get("pubDate").getAsString());
					b.setBookPubDate(d);
					list.add(b);
				}
				System.out.println("listSize : "+list.size());
				////////////////////////
				////////엑셀파일로 빼기//////
				////////////////////////
				XSSFRow row;
				XSSFCell cell;
				int countRow = 0;
				int countCell = 0;
				XSSFWorkbook workbook = new XSSFWorkbook();
				
				//Sheet명 설정
				XSSFSheet sheet = workbook.createSheet("mySheet");
				
				for(int i=0; i<list.size(); i++) {
					//출력 row 생성
					row = sheet.createRow(i);
					//출력 cell 생성
					row.createCell(0).setCellValue(i);
					row.createCell(1).setCellValue(list.get(i).getBookName());
					row.createCell(2).setCellValue(list.get(i).getBookWriter());
					row.createCell(3).setCellValue(list.get(i).getBookPublisher());
					row.createCell(4).setCellValue(list.get(i).getBookCategory());
					row.createCell(5).setCellValue(list.get(i).getBookImg());
					row.createCell(6).setCellValue(list.get(i).getBookPubDate());
					row.createCell(7).setCellValue(list.get(i).getBookStatus());
					row.createCell(8).setCellValue(list.get(i).getBookContent());
				}

				// 출력 파일 위치및 파일명 설정

				FileOutputStream outFile;
				try {
					outFile = new FileOutputStream("인기신간 나.xlsx");
					workbook.write(outFile);
					outFile.close();		
					System.out.println("파일생성 완료");
					return new Gson().toJson(resultJson2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("response is error : " + response.getStatusLine().getStatusCode());
			}
		} catch (Exception e){
			System.err.println(e.toString());
		}
		return "fail";
		
	}
}
