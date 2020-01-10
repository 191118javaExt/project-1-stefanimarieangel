package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestHelper;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = -4854248294011883310L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		final String URI = req.getRequestURI().replace("/project-1/", "");
		switch (URI) {
		case "login.main":
			System.out.println("in login.main FC");
			RequestHelper.processLogin(req, res);
			break;
		case "logout.main":
			RequestHelper.processLogout(req, res);
			break;
		case "employees.main":
			RequestHelper.processEmployees(req, res);
			break;
		default: 
			System.out.println(URI);
			res.sendRedirect("/project-1/index.html");
			break;
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("In GEt");
		final String URI = req.getRequestURI();
		if(URI.equals("/project-1/index.html")) {
			System.out.println("in the thing");
			res.sendRedirect("/project-1/index.html");
		}else {
		doPost(req, res);
		}
	}
}
