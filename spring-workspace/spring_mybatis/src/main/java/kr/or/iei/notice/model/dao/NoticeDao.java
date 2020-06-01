package kr.or.iei.notice.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.iei.notice.model.vo.Notice;
@Repository("noticeDao")
public class NoticeDao {

	@Autowired
	SqlSessionTemplate sqlSession;

	public NoticeDao() {
		super();
		System.out.println("noticeDao 생성 완료");
	}
	
	public int insertNotice(Notice n) {
		return sqlSession.insert("notice.insertNotice", n);
	}

	public int totalCount() {
		return sqlSession.selectOne("notice.totalCountNotice");
	}

	public List noticeAllPage(HashMap<String, Integer> map) {
		return sqlSession.selectList("notice.noticeAllPage", map);
	}

	public Notice selectOneNotice(int noticeNo) {
		return sqlSession.selectOne("notice.selectOneNotice", noticeNo);
	}
	public int noticeDelete(int noticeNo) {
		return sqlSession.delete("notice.noticeDelete", noticeNo);
	}

	public int noticeUpdate(Notice n) {
		return sqlSession.update("notice.noticeUpdate", n);
	}

}
