package com.spring.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.spring.constants.Constants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.DBUtils.DBUtils8;
import com.spring.beans.Employee;

import oracle.jdbc.pool.OracleDataSource;

@Repository("employeeDao")
//@Component("employeeDao")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	OracleDataSource dataSource;
	String msg = "";
	Connection connection = null;
	//@Autowired
	Employee empBean;

	@Override
	public String addEmployee(Employee bean) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection connection = dataSource.getConnection();) {

			String query = "select * from employee where eid=?";
			ps = connection.prepareStatement(query);
			ps.setString(1, bean.getEid());
			rs = ps.executeQuery();
			if (rs.next()) {
				msg = "Employee " + bean.getEid() + " Already Exsisted";
			} else {
				query = "insert into employee values(?,?,?,?)";
				ps = connection.prepareStatement(query);
				ps.setString(1, bean.getEid());
				ps.setString(2, bean.getEname());
				ps.setDouble(3, bean.getEsal());
				ps.setString(4, bean.getEaddr());
				int count = ps.executeUpdate();
				if (count == 1) {
					msg = "Employee " + bean.getEid() + " Added Successfully...";
				} else {
					msg = Constants.DB_ERR;
				}
			}
			//DBUtils8.closeStatment_ResultSet.accept(ps, rs);
			//DBUtils8.closeConnection.accept(connection);
		} catch (SQLException e) {
			msg = Constants.DB_ERR;
			//DBUtils8.closeStatment_ResultSet.accept(ps, rs);
			//DBUtils8.closeConnection.accept(connection);
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public String updateEmployee(Employee bean) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection connection = dataSource.getConnection();) {

			String query = "select * from employee where eid=?";
			ps = connection.prepareStatement(query);
			ps.setString(1, bean.getEid());
			rs = ps.executeQuery();
			if (rs.next()) {

				query = "update employee set ename=? , esal=?,eaddr=? where eid=?";
				ps = connection.prepareStatement(query);
				ps.setString(1, bean.getEname());
				ps.setDouble(2, bean.getEsal());
				ps.setString(3, bean.getEaddr());
				ps.setString(4, bean.getEid());
				int count = ps.executeUpdate();
				if (count == 1) {
					msg = "Employee " + bean.getEid() + " Data Updated Successfully...";
				} else {
					msg = Constants.DB_ERR;
				}

			} else {
				msg = "Employee " + bean.getEid() + " Not Exsisted!!!";
			}

			//DBUtils8.closeStatment_ResultSet.accept(ps, rs);
			//DBUtils8.closeConnection.accept(connection);

		} catch (SQLException e) {
			msg = Constants.DB_ERR;
			//DBUtils8.closeStatment_ResultSet.accept(ps, rs);
		//	DBUtils8.closeConnection.accept(connection);
			e.printStackTrace();
		}

		return msg;
	}

	@Override
	public String deleteEmployee(String eid) {

		PreparedStatement ps = null;
		try (Connection connection = dataSource.getConnection();) {

			String query = "delete from employee where eid=?";
			ps = connection.prepareStatement(query);
			ps.setString(1, query);
			int count = ps.executeUpdate();
			if (count == 1) {
				msg = "Employee " + eid + " Deleted successfully!!!";
			} else {
				msg = "Employee " + eid + " is Not Exsisted !!!";
			}

		//	DBUtils8.closeStatement.accept(ps);
		//	DBUtils8.closeConnection.accept(connection);
		} catch (SQLException e) {
			msg = Constants.DB_ERR;
			//DBUtils8.closeStatement.accept(ps);
			//DBUtils8.closeConnection.accept(connection);
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Employee searchEmployeeById(String eid) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			empBean=new Employee();
			String query = "select * from employee where eid=?";
			ps = connection.prepareStatement(query);
			ps.setString(1, eid);
			rs = ps.executeQuery();
			if (rs.next()) {
				empBean.setEid(rs.getString(1));
				empBean.setEname(rs.getString(2));
				empBean.setEsal(rs.getDouble(3));
				empBean.setEaddr(rs.getString(4));
			} else {
				empBean = null;
			}
		//	DBUtils8.closeStatment_ResultSet.accept(ps, rs);
		//	DBUtils8.closeConnection.accept(connection);
		} catch (Exception e) {
			empBean = null;
		//	DBUtils8.closeStatment_ResultSet.accept(ps, rs);
			//DBUtils8.closeConnection.accept(connection);
			System.out.println(Constants.DB_ERR);
			e.printStackTrace();

		}

		return empBean;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees=new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			empBean=new Employee();
			String query = "select * from employee";
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				empBean=new Employee();
				empBean.setEid(rs.getString(1));
				empBean.setEname(rs.getString(2));
				empBean.setEsal(rs.getDouble(3));
				empBean.setEaddr(rs.getString(4));
				employees.add(empBean);
			}
		//	DBUtils8.closeStatment_ResultSet.accept(ps, rs);
		//	DBUtils8.closeConnection.accept(connection);
		} catch (Exception e) {
		//	DBUtils8.closeStatment_ResultSet.accept(ps, rs);
		//	DBUtils8.closeConnection.accept(connection);
			System.out.println(Constants.DB_ERR);
			e.printStackTrace();

		}
		return employees;
	}

}
