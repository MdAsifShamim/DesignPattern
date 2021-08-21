package com.spring.daos;

import java.util.List;

import com.spring.beans.Employee;

public interface EmployeeDAO {

	public String addEmployee(Employee bean);

	public String updateEmployee(Employee bean);

	public String deleteEmployee(String eid);

	public Employee searchEmployeeById(String eid);

	public List<Employee> getAllEmployees();

}
