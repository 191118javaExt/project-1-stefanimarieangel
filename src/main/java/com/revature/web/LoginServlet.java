package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.EmployeeDTO;
import com.revature.models.LoginTemplate;
import com.revature.services.EmployeeServices;	

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -3041309404795375497L;
	private static Logger logger = Logger.getLogger(LoginServlet.class);
	private static ObjectMapper om = new ObjectMapper();	
	
	protected void doPost (HttpServletRequest req, HttpServletResponse res)
	throws IOException, ServletException {
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		System.out.println(body);
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();
		logger.info("User attempted to login with username " + username);
		Employee e = EmployeeServices.confirmLogin(username, password);
		if(e != null) {
			HttpSession session = req.getSession();
			// Gets the current session, or creates one if it did not exist
			session.setAttribute("username", username);
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			EmployeeDTO eDTO = EmployeeServices.convertToDTO(e);
			out.println(om.writeValueAsString(eDTO));
			logger.info(username + " has successfully logged in");
		} else {
			res.setContentType("application/json");
			res.setStatus(204);
		}
	}
}
