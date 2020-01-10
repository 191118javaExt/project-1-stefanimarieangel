package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.EmployeeDTO;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeServices {
	public static List<Employee> findAll() {
		return new EmployeeDAOImpl().findAll();
	}
	public static Employee findByUsername(String username) {
		List<Employee> all = new EmployeeDAOImpl().findAll();
		for(Employee e : all) {
			if(e.getUsername().equals(username)) {
				return e;
			}
		}
		return null;
	}
	public static Employee confirmLogin(String username, String password) {
		System.out.println("in here");
		Employee e = findByUsername(username);
		if(e == null) {
			System.out.println("return null");
			return null;
		
		}
		
		if(e.getPassword().equals(password)) {
			System.out.println("found employee");
			return e;
		} else {
			return null;
		}
	}
	public static EmployeeDTO convertToDTO(Employee e) {
		return new EmployeeDTO(e.getUserId(),
				e.getFirstName(),
				e.getLastName(),
				e.getUsername(),
				e.getPassword());
	}
}
