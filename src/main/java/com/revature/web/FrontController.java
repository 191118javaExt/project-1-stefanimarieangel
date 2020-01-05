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
		final String URI = req.getRequestURI().replace("/project_1/", "");
		switch (URI) {
		case "login":
			RequestHelper.processLogin(req, res);
			break;
		case "logout":
			RequestHelper.processLogout(req, res);
			break;
		case "employees":
			RequestHelper.processEmployees(req, res);
			break;
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
