package kh.or.department.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kh.or.department.model.dao.DepartmentDao;

@Service("departmentService")
public class DepartmentService {
	@Autowired
	@Qualifier("departmentDao")
	private DepartmentDao dao;
	
}
