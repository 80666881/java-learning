package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/*
		如果代码写成这样，就表示跳转到页面 index.jsp
		new ModelAndView("index.jsp");

		所谓的视图定位，指的是代码还是写成这样，但是会跳转到 /WEB-INF/page/index.jsp
		new ModelAndView("index");
		*/

//		ModelAndView mav = new ModelAndView("index.jsp");
		ModelAndView mav = new ModelAndView("index");

		mav.addObject("message", "Hello Spring MVC");
		return mav;
	}
}