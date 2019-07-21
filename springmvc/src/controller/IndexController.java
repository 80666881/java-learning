package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//不必再实现Controller接口
@Controller
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("index");

		mav.addObject("message", "Hello Spring MVC");
		return mav;
	}

	@RequestMapping("/jump")
	public ModelAndView jump() {
		ModelAndView mav = new ModelAndView("redirect:/index");
		return mav;
	}
}