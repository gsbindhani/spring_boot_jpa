package com.empManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empManagement.dao.EmployeeDao;
import com.empManagement.daoImpl.EmployeeDaoImpl;

@RestController
public class Employee {
	@Autowired
	public EmployeeDaoImpl employeeDaoImpl;

	@RequestMapping(path="/employee",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	
	public @ResponseBody EmployeeDao addEmployee(@RequestBody EmployeeDao employeeDao){
		return employeeDaoImpl.addEmployee(employeeDao);
	}
	
	@RequestMapping(path="/employee/{empId}",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	
	public @ResponseBody EmployeeDao getEmployee(@PathVariable long empId){
		
		return employeeDaoImpl.findEmployee(empId);
		
	}
//	@RequestMapping(path="/employe/{empId}",produces="application/json",consumes="application/json",method=RequestMethod.PUT)
//	public EmployeeVo updateEmployee(@PathVariable int empId,@RequestBody EmployeeVo emp){
//		System.out.println("Employee updated -"+empId);
//		
//		return emp;
//	}
//	@RequestMapping(path="/employe/{empId}",produces="application/json",method=RequestMethod.DELETE)
//	public String deleteEmployee(@PathVariable int empId){
//		
//		return "Employee Deleted -"+empId;
//		
//	}
}