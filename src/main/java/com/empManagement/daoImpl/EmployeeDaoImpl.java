package com.empManagement.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empManagement.dao.AddressDao;
import com.empManagement.dao.EmployeeDao;
@Repository
public class EmployeeDaoImpl{
	
	private final CrudRepository<EmployeeDao, Long> employeeRepository;
	
	@Autowired
	public EmployeeDaoImpl(CrudRepository<EmployeeDao, Long> crd) {
		this.employeeRepository = crd;
	}
	
	public EmployeeDao addEmployee(EmployeeDao employeeDao) {

		//Bidirectional mapping to have foreignKey relation
		for(AddressDao s :employeeDao.getAddressDao())
			s.setEmployeeDao(employeeDao);
		
		return employeeRepository.save(employeeDao);
	}

	public EmployeeDao findEmployee(long empId) {
		return employeeRepository.findOne(empId);
	}
}
