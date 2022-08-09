package com.nagarro.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.models.User;
import com.nagarro.services.LoginImplementation;

@Controller
public class Login {

	@RequestMapping("/Login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("student");
//		LoginImplementation login = new LoginImplementation();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html");
//
		PrintWriter out = response.getWriter();
		out.println("<h1>" + username + password + "</h1>");
		ModelAndView view = new ModelAndView();
//		if (login.userAuthentication(username, password)) {
//			User user = login.getUserDetails(username);
//			request.getSession().setAttribute("authorized", "true");
//			request.getSession().setAttribute("user", user);
			view.setViewName("userhome.jsp");
//		} else {
//			request.getSession().setAttribute("authorized", "false");
//			view.setViewName("index.jsp");
//			view.addObject("error", "Wrong credentials");
//		}
		return view;
	}
}
