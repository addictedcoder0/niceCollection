package com.rudra.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;
import org.w3c.dom.views.AbstractView;

public class HelloController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String name = req.getParameter("name");
		
		Map msg =  new HashMap();
		msg.put("message","Hello "+name+" .. using AbstractController with ControllerClassNameHandler mapping  ");
		return new ModelAndView("success",msg);
	}
}
