package or.kr.board.model.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public BoardDao() {
		super();
		System.out.println("boardDao 생성");
	}
	
	
}
