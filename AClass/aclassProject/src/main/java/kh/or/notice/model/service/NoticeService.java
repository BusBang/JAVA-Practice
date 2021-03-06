package kh.or.notice.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import kh.or.notice.model.dao.NoticeDao;
import kh.or.notice.model.vo.Notice;
import kh.or.notice.model.vo.NoticeData;

@Service("noticeService")
public class NoticeService {
	
	@Autowired
	@Qualifier("noticeDao")
	private NoticeDao dao;

	public NoticeData selectAllNotice(int reqPage) {
		
		int totalCount = dao.totalCount();
		System.out.println("totalcount : "+totalCount);		
		int numPerPage = 5;
		int totalPage = 0;
		if(totalCount % numPerPage ==0) {
			totalPage = totalCount / numPerPage;
		}else {
			totalPage = totalCount / numPerPage+1;
		}
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage * numPerPage;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end",end);
		
		List list = dao.noticeAllPage(map);
		
		String pageNavi ="";
		int pageNaviSize = 3;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		//페이지 네비 [이전] [현재] [다음]
		if(pageNo != 1) {
			pageNavi += "<a href='/noticeList.do?reqPage="+(pageNo-1)+"'>[이전]</a>";
		}
		for(int i=0; i<pageNaviSize; i++) {
			if(reqPage == pageNo) {
				pageNavi += "<span>"+pageNo+"</span>";
			}else {
				pageNavi += "<a href='/noticeList.do?reqPage="+pageNo+"'>"+pageNo+"</a>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		if(pageNo <= totalPage) {
			pageNavi += "<a href='/noticeList.do?reqPage="+pageNo+"'>[다음]</a>";
		}
		NoticeData nd = new NoticeData((ArrayList<Notice>)list, pageNavi);
		return nd;
	}

	public int insertNotice(Notice n) {
		return dao.insertNotice(n);
	}

	public Notice selectOne(Notice n) {
		return dao.selectOne(n);
	}
}
