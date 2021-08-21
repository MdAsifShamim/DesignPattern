package com.spring.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.controllers.EmployeeController;
import com.spring.controllers.EmployeeControllerImpl;
import com.spring.daos.EmployeeDAO;
import com.spring.daos.EmployeeDAOImpl;
import com.spring.services.EmployeeService;
import com.spring.services.EmployeeServiceImpl;

import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class EmployeeConfiguration {
	
	@Bean
	public OracleDataSource dataSource() {
		OracleDataSource dataSource=null;
		try {
			dataSource=new OracleDataSource();
			dataSource.setURL("jdbc:oracle:thin:@localhost:1521:XE");
			dataSource.setUser("system");
			dataSource.setPassword("system");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataSource;
	}
	
	@Bean
	public EmployeeService getEmployeeService() {
		return new EmployeeServiceImpl();
	}

	@Bean
	public EmployeeController getEmployeeController() {
		return new EmployeeControllerImpl();
	}
	
	@Bean
	public EmployeeDAO getEmployeeDao() {
		return new EmployeeDAOImpl();
	}
}
