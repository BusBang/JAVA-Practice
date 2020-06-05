package kh.or.notice.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.or.notice.model.vo.Notice;
import kh.or.notice.model.vo.NoticeData;

@Repository("noticeDao")
public class NoticeDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;


	public int totalCount() {
		return sqlSession.selectOne("notice.totalCountNotice");
	}

	public List noticeAllPage(HashMap<String, Integer> map) {
		return sqlSession.selectList("notice.selectAllNotice", map);
	}

	public int insertNotice(Notice n) {
		return sqlSession.insert("notice.insertNotice", n);
	}

	public Notice selectOne(Notice n) {
		return sqlSession.selectOne("notice.selectOne", n);
	}
	
}
