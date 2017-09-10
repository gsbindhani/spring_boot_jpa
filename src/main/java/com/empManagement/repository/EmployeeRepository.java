package com.empManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.empManagement.dao.EmployeeDao;

public interface EmployeeRepository extends CrudRepository<EmployeeDao, Long> {
	@SuppressWarnings("unchecked")
	@Override
	EmployeeDao save(EmployeeDao entity);
	
	@Override
	EmployeeDao findOne(Long entity); 
	
}
