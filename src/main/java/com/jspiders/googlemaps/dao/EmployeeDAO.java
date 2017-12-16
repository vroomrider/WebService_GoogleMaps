package com.jspiders.googlemaps.dao;

import java.util.HashSet;

import javax.ws.rs.BeanParam;

import com.jspiders.googlemaps.dao.Employee;

public class EmployeeDAO {
	static private HashSet<Employee> employees = new HashSet<Employee>();

	/**
	 * @BeanParam
	 * @param e
	 * @return
	 */
	public HashSet<Employee> createEmployeeUsingBeanParam(Employee e) {
		employees.add(e);
		return employees;
	}
	
	/**
	 * @BeanParam and @Produces
	 * @param employee
	 * @return
	 */
	public HashSet<Employee> createEmployeeUsingBeanParamAndProducesObject(Employee employee) {
		employees.add(employee);
		return employees;	
	}
	
	public boolean createEmployee(Employee e) {
		return employees.add(e);
	}

	public boolean deleteEmployee(Employee e) {
		return employees.remove(e);
	}

	public Employee readEmployee(int eid) {
		Employee emp = new Employee();
		for (Employee employee : employees) {
			if (employee.getEid() == eid)
				emp = employee;
		}
		return emp;
	}

	public HashSet<Employee> readEmployees() {
		return employees;
	}

	public boolean modifyEmployee(Employee e) {
		for (Employee employee : employees) {
			if (employee.equals(e)) {
				employee.setEid(e.getEid());
				employee.setFname(e.getFname());
				employee.setLname(e.getLname());
				employee.setDesignation(e.getDesignation());
				employee.setAddress1(e.getAddress1());
				employee.setAddress2(e.getAddress2());
				employee.setSalary(e.getSalary());
				return true;
			} else
				return false;
		}
		return false;
	}

	
}
