package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.models.User;
import com.nagarro.services.LoginImplementation;

@Controller
public class ResetPassword {
	@RequestMapping("/ResetPassword")
	public void reset(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message = "";
		request.getSession().setAttribute("message", "");
		LoginImplementation login = new LoginImplementation();
		String username = request.getParameter("username");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("passwordnew");
		String passwordConfirm = request.getParameter("passwordnewconfirm");
		User user = login.getUserDetails(username);
		if (user != null) {
			if (password.equals(passwordConfirm)) {
				if (user.getFullName().equalsIgnoreCase(fullName)) {
					login.updatePassword(username, password);
					request.getSession().setAttribute("passwordmessage", "Password Updated Successfully");
					message = "Success";
				} else {
					request.getSession().setAttribute("passwordmessage",
							"One of the given information is incorrect... (Full Name)");
					message = "One of the given information is incorrect... (Full Name)";
				}
			} else {
				request.getSession().setAttribute("passwordmessage", "Password does not match");
				message = "Password does not match";
			}
		} else {
			request.getSession().setAttribute("passwordmessage", "No user exists with such username");
			message = "No user exists with such username";
		}
		System.out.println(message);

		response.sendRedirect("index.jsp");
	}

}
