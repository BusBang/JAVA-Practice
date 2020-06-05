package kh.or.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import kh.or.department.model.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	@Qualifier("departmentService")
	private DepartmentService service;
	
}
