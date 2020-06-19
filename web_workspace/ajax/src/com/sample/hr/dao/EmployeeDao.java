package com.sample.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.hr.vo.Department;
import com.sample.hr.vo.Employee;
import com.simple.util.QueryUtil;
import com.simple.util.connectionUtil;

public class EmployeeDao {

	public List<Department> getAllDepartments() throws SQLException {
		
		List<Department> depts = new ArrayList<Department>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("hr.getAllDepartments"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Department dept = new Department();
			dept.setId(rs.getInt("department_id"));
			dept.setName(rs.getString("department_name"));
			
			depts.add(dept);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return depts;
	}
	
	public List<Employee> getEmployeesByDept(int departmentId) throws SQLException {
		
		List<Employee> employees = new ArrayList<Employee>();
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("hr.getEmployeesByDept"));
		pstmt.setInt(1, departmentId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setHireDate(rs.getDate("hire_date"));
			
			employees.add(emp);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return employees;
			
	}
	
	public Employee getEmployeeById(int employeedId) throws SQLException {  
		
		Employee employee = null;
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("hr.getEmployeeById"));
		pstmt.setInt(1, employeedId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			employee = new Employee();
			
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			employee.setJobId(rs.getString("job_id"));
			employee.setSalary(rs.getDouble("salary"));
			employee.setHireDate(rs.getDate("hire_date"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return employee;
	}
}
