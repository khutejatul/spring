package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Logout {

	@RequestMapping("/Logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("authorized");
		request.getSession().invalidate();
		response.sendRedirect("logout.jsp");
	}

}
