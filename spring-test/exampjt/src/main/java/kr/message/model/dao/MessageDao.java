package kr.message.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.message.model.vo.Message;

@Repository("messageDao")
public class MessageDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	public MessageDao () {
		super();
		System.out.println("dao 생성확인");
	}
	public int insertMessage(Message m) {
		return sqlSession.insert("message.insertMessage", m);
	}
	public List selectMsgList() {
		return sqlSession.selectList("message.select");
	}
}
