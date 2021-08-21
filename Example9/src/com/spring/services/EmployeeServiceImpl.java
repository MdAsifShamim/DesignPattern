package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.beans.Employee;
import com.spring.daos.EmployeeDAO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	public String addEmployee(Employee bean) {
		return employeeDao.addEmployee(bean);
	}

	@Override
	public String updateEmployee(Employee bean) {
		return employeeDao.updateEmployee(bean);
	}

	@Override
	public String deleteEmployee(String eid) {
		return employeeDao.deleteEmployee(eid);
	}

	@Override
	public Employee searchEmployeeById(String eid) {
		return employeeDao.searchEmployeeById(eid);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

}
