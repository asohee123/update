package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.util.connectionUtil;
import com.sample.vo.Employee;

public class EmployeeDao {

	public List<Employee> getAllEmployees() throws SQLException{
		
		List<Employee> employees = new ArrayList<Employee>();
		
		String sql = "select A.employee_id, A.first_name, A.last_name, A.job_id, B.department_id, B.department_name " 
				+ "from employees A, departments B "
				+ "where a.department_id = b.department_id(+) " 
				+ "order by employee_id asc";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Employee emp = new Employee();
			emp.setId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setJobId(rs.getString("job_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			emp.setDepartmentName(rs.getString("department_name"));
			
			employees.add(emp);

			
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return employees;
		
	}
	
	public List<Employee> getEmployeesByRange(int beginNumber, int endNumber) throws SQLException{
		
		List<Employee> emps = new ArrayList<Employee>();
		String sql = "select a.employee_id, a.first_name, a.last_name, a.email, a.phone_number, "
			       	   	   + "a.hire_date, a.job_id, a.salary, a.commission_pct, "
			       	   	   + "c.employee_id manager_id, c.first_name manager_first_name, c.last_name manager_last_name, "
			       	   	   + "b.department_id, b.department_name "
			       	+ "from (select  employee_id, first_name, last_name, email, phone_number, "
			       		  + "hire_date, job_id, salary, commission_pct, manager_id, department_id, "
			       		  + "row_number() over(order by employee_id asc) rownumber "
			       		  + "from employees) a, departments b, employees c "
			       	+ "where a.rownumber >=? and a.rownumber <= ? "
			       	+ "and a.department_id = b.department_id(+) "
			       	+ "and a.manager_id = c.employee_id(+) ";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, beginNumber);
		pstmt.setInt(2, endNumber);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			Employee employee = new Employee();
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			employee.setHireDate(rs.getDate("hire_date"));
			employee.setJobId(rs.getString("job_id"));
			employee.setSalary(rs.getInt("salary"));
			employee.setCommission_pct(rs.getInt("commission_pct"));
			employee.setManagerId(rs.getInt("manager_id"));
			employee.setManagerFirstName(rs.getString("manager_first_name"));
			employee.setManagerLastName(rs.getString("manager_last_name"));
			employee.setDepartmentId(rs.getInt("department_id"));
			employee.setDepartmentName(rs.getString("department_name"));
			
			emps.add(employee);
			
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return emps;
	}
	
	public int getEmployeesCount() throws SQLException {
		
		int rowCount = 0;
		String sql = "select count(*) cnt from employees ";
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		rowCount = rs.getInt("cnt");
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return rowCount;
	}
	
	public Employee getEmployeeBtId(int employeeId) throws SQLException {
		
		String sql = "select A.employee_id, A.first_name, B.last_name, A.email, A.phone_number,"
						+ "A.job_id, A.hire_date, A.salary, A.commission_pct,"
						+ "B.employee_id manager_Id, B.first_name manager_first_name, B.last_name manager_last_name,"
						+ "C.department_id, C.department_name "
					+ "from employees A, employees B, departments C "
					+ "where A.manager_id = B.employee_id "
					+ "		and A.department_id = C.department_id "
					+ "		and A.employee_id = ?";
		
		Employee employee = null;
		
		Connection connection = connectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, employeeId);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			
			employee = new Employee();
			
			employee.setId(rs.getInt("employee_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setEmail(rs.getString("email"));
			employee.setPhoneNumber(rs.getString("phone_number"));
			employee.setHireDate(rs.getDate("hire_date"));
			employee.setJobId(rs.getString("job_id"));
			employee.setSalary(rs.getInt("salary"));
			employee.setCommission_pct(rs.getInt("commission_pct"));
			employee.setManagerId(rs.getInt("manager_id"));
			employee.setManagerFirstName(rs.getString("manager_first_name"));
			employee.setManagerLastName(rs.getString("manager_last_name"));
			employee.setDepartmentId(rs.getInt("department_id"));
			employee.setDepartmentName(rs.getString("department_name"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return employee;
		
	}
	
}
