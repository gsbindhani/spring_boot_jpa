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
import com.empManagement.vo.Message;

@RestController
public class Employee {
	@Autowired
	public EmployeeDaoImpl employeeDaoImpl;
	
	@RequestMapping(path="/employees",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public @ResponseBody Iterable<EmployeeDao> getEmployees(){
		
		return employeeDaoImpl.findAll();
	}

	@RequestMapping(path="/employee",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.POST)
	public @ResponseBody EmployeeDao addEmployee(@RequestBody EmployeeDao employeeDao){
		return employeeDaoImpl.saveEmployee(employeeDao);
	}
	
	@RequestMapping(path="/employee/{empId}",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public @ResponseBody EmployeeDao getEmployee(@PathVariable long empId){
		
		return employeeDaoImpl.findByEmployee(empId);
		
	}
	
	@RequestMapping(path="/employee/{empId}",produces="application/json",consumes="application/json",method=RequestMethod.PUT)
	public EmployeeDao updateEmployee(@PathVariable long empId,@RequestBody EmployeeDao employeeDao){
		System.out.println("Employee updated -"+empId);
		
		return employeeDaoImpl.saveEmployee(employeeDao);
	}
	
	@RequestMapping(path="/employee/{empId}",produces="application/json",method=RequestMethod.DELETE)
	public Message deleteEmployee(@PathVariable int empId){
		
		return employeeDaoImpl.deleteEmployee(empId);
		
	}
}