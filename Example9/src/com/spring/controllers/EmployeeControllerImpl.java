package com.spring.controllers;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.spring.beans.Employee;
import com.spring.services.EmployeeService;

@Controller("employeeController")
public class EmployeeControllerImpl implements EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//@Autowired
	Employee empBean;

	static Scanner sc = null;

	static {
		sc = new Scanner(System.in);
	}

	@Override
	public void addEmployee() {
		empBean=new Employee();
		System.out.print("Enter Employee ID : ");
		empBean.setEid(sc.nextLine());

		System.out.print("Enter Employee Name : ");
		empBean.setEname(sc.nextLine());

		System.out.print("Enter Employee Salary : ");
		empBean.setEsal(sc.nextDouble());
		sc.nextLine();
		System.out.print("Enter Employee Address :");
		empBean.setEaddr(sc.nextLine());

		String msg = employeeService.addEmployee(empBean);

		System.out.println(msg);

	}

	@Override
	public void updateEmployee() {
		empBean=new Employee();
		System.out.print("Enter Employee ID : ");
		empBean.setEid(sc.nextLine());

		Employee isExistBean = employeeService.searchEmployeeById(empBean.getEid());

		if (StringUtils.isEmpty(isExistBean)) {

			System.out.println("Employee " + empBean.getEid() + " is Not Existed...");

		} else {

			System.out.print("Enter Employee Name : ");
			empBean.setEname(sc.nextLine());

			System.out.print("Enter Employee Salary : ");
			empBean.setEsal(sc.nextDouble());
			sc.nextLine();
			System.out.print("Enter Employee Address :");
			empBean.setEaddr(sc.nextLine());

			String msg = employeeService.updateEmployee(empBean);

			System.out.println(msg);
		}

	}

	@Override
	public void deleteEmployee() {

		System.out.print("Enter Employee ID : ");
		String eid = sc.nextLine();

		String msg = employeeService.deleteEmployee(eid);
		System.out.println(msg);

	}

	@Override
	public void searchEmployeeById() {

		System.out.print("Enter Employee ID : ");
		String eid = sc.nextLine();
		
		empBean = employeeService.searchEmployeeById(eid);

		if (StringUtils.isEmpty(empBean)) {
			System.out.println(" Employee " + eid + " is Not Exsisted...");
		} else {
			System.out.println(".......Employee Detail.....");
			System.out.println("Employe Id     : " + empBean.getEid());
			System.out.println("Employe Name   : " + empBean.getEname());
			System.out.println("Employe Salary : " + empBean.getEsal());
			System.out.println("Employe Address: " + empBean.getEaddr());
		}

	}

	@Override
	public void showAllEmployeeRecords() {

		List<Employee> employees = employeeService.getAllEmployees();

		System.out.println("*************All Employees Detail*******************");
		employees.stream().forEach(bean -> {

			System.out.println("Employee Id :" + bean.getEid() + " Employee Name :" + bean.getEname()
					+ " Employee Salary :" + bean.getEsal() + " Employee Address :" + bean.getEaddr());

		});

	}

}
