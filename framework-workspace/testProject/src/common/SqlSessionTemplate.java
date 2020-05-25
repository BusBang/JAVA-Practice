package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
		SqlSession session = null;
		String resource = "mybatis-config.xml";
		try {
			// 해당 리소스 경로(xml)파일을 바탕으로 input stream 생성
			InputStream is = Resources.getResourceAsStream(resource);
			// SqlsessionFactory 를 만들 수 있는 팩토리 빌더 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//빌더를 통해 실제 사용할 sqlfactory 생성
			SqlSessionFactory factory = builder.build(is);
			session = factory.openSession(false); //매개변수 false autoCommit을 하지 않는다. //오토커밋을 끈 것.
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
		
	}
}
