package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WelcomeController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		/*
		 * handleRequestInternal就相当于struts2--action中的execute()方法
		 * 这个方法的返回值是ModelAndView 模型和视图；
		 * 
		 * */
		System.out.println("hello！springMVC");
		/*
		 * 这里的welcome是逻辑视图名，也就是jsp的页面名称，
		 * 对应着是spring-servlet中的 bean中的name的值
		 * */
		return new ModelAndView("welcome");
	}

}
