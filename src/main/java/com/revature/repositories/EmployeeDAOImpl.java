package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean insert(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> el = new ArrayList<>();
		
		try (Connection conn = ConnectionUtil.getConnection()) {
		
			String sql = "SELECT * FROM ERS_User";
			
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		int userId = rs.getInt("ers_user_id");
		String username = rs.getString("ers_username");
		String password = rs.getString("ers_password");
		String firstName = rs.getString("user_first_name");
		String lastName = rs.getString("user_last_name");
		String email = rs.getString("user_email");
		int roleId = rs.getInt("user_role_id");
		
		Employee e = new Employee(userId, username, password, firstName, lastName, email, roleId);
		el.add(e);
		
		rs.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return el;
	}

}
