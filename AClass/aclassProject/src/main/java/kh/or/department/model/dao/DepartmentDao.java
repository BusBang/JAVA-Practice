package kh.or.department.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("departmentDao")
public class DepartmentDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
}
