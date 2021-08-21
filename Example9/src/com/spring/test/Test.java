package com.spring.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.configurations.EmployeeConfiguration;
import com.spring.controllers.EmployeeController;

public class Test {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		//ApplicationContext context = new ClassPathXmlApplicationContext("/com/spring/resources/applicationContext.xml");
		ApplicationContext context=new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
		EmployeeController employeeController = (EmployeeController) context.getBean("getEmployeeController");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char Y_N;
		do {
			System.out.println("______________________________________________________________");
			System.out.println("            1. Enter 1 for Add New Employee Record            ");
			System.out.println("            2. Enter 2 for Update Employee Record             ");
			System.out.println("            3. Enter 3 for Delete Employee Record             ");
			System.out.println("            4. Enter 4 For Search Employee By ID              ");
			System.out.println("            5. Enter 5 For See All Employee Records           ");
			System.out.println("______________________________________________________________");
			System.out.println("");
			System.out.println("Enter Your Choice");
			String choice = br.readLine();
			switch (choice) {
			case "1":
				employeeController.addEmployee();
				break;

			case "2":
				employeeController.updateEmployee();
				break;

			case "3":
				employeeController.deleteEmployee();
				break;

			case "4":
				employeeController.searchEmployeeById();
				break;

			case "5":
				employeeController.showAllEmployeeRecords();
				break;

			default:
				System.out.println("Invalid Choice kindly Choose Right Option");
			}
			System.out.println();
			System.out.print("Do you Want to Continue (Y/N): ");
			Y_N = (char) br.read();
			br.readLine();
		} while (Y_N == 'Y' || Y_N == 'y');
		System.out.println("exit...");
		System.out.println("!!!!!!!!!!!!!1Thanks For using Applicaion!!!!!!!!!!!!!!!!");
	}

}
