package member.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Check;
import member.model.vo.Member;
import member.model.vo.MemberData;
import member.model.vo.Search;

public class MemberService {

	public Member selectOneMember(Member m) {
		//커넥션 대신 세션을 쓰게 된다.
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Member member = new MemberDao().selectOneMember(session, m);
		session.close();
		return member;
	}

	public int insertmember(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDao().insertMember(session, m);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public ArrayList<Member> selectAllMember() {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List list = new MemberDao().selectAllMember(session);
		session.close();
		return (ArrayList<Member>)list;
	}

	public int updateMember(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDao().updateMember(session, m);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteMember(String memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = new MemberDao().deleteMember(session, memberId);
		if(result>0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public MemberData selectAllMemberPage(int reqPage) {
		//한 페이지 당 게시물 수 numperPage
		//총 게시물 수 totalCount => DB조회
		//해당 페이지의 게시물, 끝 번호 start/end => totalPage, reqPage로 계산
		//페이징길이 pageNavisize => 개발자지정
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int totalCount = new MemberDao().totalCount(session);
		System.out.println("totalCount : "+totalCount);
		int numPerPage = 5;
		// 전체 페이지 수 연산
		int totalPage = 0;
		if(totalCount % numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		//조회해 올 게시물 시작번호와 끝 번호 조회
		//시작 번호
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		List list = new MemberDao().selectAllMemberPage(session, map); 
		
		//페이지 네비게이션 작성 시작
		String pageNavi ="";
		
		//네비 길이
		int pageNaviSize = 3;
		
		//1요청시 1~3, 4요청시 4~6
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		
		//페이지 네비 [이전] [현재] [다음]
		if(pageNo != 1) {
			pageNavi += "<a href='/allMemberPage?reqPage="+(pageNo-1)+"'>[이전]</a>";
		}
		for(int i=0; i<pageNaviSize; i++) {
			if(reqPage == pageNo) {
				pageNavi += "<span>"+pageNo+"</span>";
			}else {
				pageNavi += "<a href='/allMemberPage?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		if(pageNo <= totalPage) {
			pageNavi += "<a href='/allMemberPage?reqPage="+pageNo+"'>[다음]</a>";
		}
		MemberData md = new MemberData((ArrayList<Member>)list, pageNavi);
		session.close();
		return md;
	}

	public ArrayList<Member> memberInfo(Check ck) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List list = new MemberDao().memberInfo(session, ck);
		session.close();
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> search(Search search) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List list = new MemberDao().search(session, search);
		session.close();
		return (ArrayList<Member>)list;
	}
	public ArrayList<Member> search(Member m) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List list = new MemberDao().search(session, m);
		session.close();
		return (ArrayList<Member>)list;
	}

	public ArrayList<Member> search(String[] memberId) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List list = new MemberDao().search(session, memberId);
		session.close();
		return (ArrayList<Member>)list;
	}
}
