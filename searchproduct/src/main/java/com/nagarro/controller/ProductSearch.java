package com.nagarro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.exceptions.NotExistsException;
import com.nagarro.models.Tshirt;
import com.nagarro.services.ReadCSV;
import com.nagarro.services.SearchImplementation;

@Controller
public class ProductSearch {
	@RequestMapping("/ProductSearch")
	public ModelAndView searchproduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		String gender = request.getParameter("gender");
		String output = request.getParameter("output");
		response.setContentType("text/html");

		// PrintWriter out = response.getWriter();
		System.out.println("<h1>" + color + size + gender + output + "</h1>");

		ReadCSV read = new ReadCSV();
		read.readCSVData();
		Thread thread = new Thread();
		thread.start();

		SearchImplementation search = new SearchImplementation();
		try {
			List<Tshirt> shirt = search.searchTshirt(color, size, gender, output);

			ModelAndView view = new ModelAndView();
			view.setViewName("userhome.jsp");
			view.addObject("result", shirt);
			return view;

		} catch (NotExistsException e) {
			e.printStackTrace();
		}
		return null;

	}

}
