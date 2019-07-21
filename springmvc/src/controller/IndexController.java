package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	/*
	* 	映射 /check 到方法check()
		为方法check()提供参数HttpSession session，这样就可以在方法体中使用session了
		接下来的逻辑就是每次访问为session中的count+1.
		最后跳转到check.jsp页面
	* */
	@RequestMapping("/check")
	public ModelAndView check(HttpSession session) {
		Integer i = (Integer) session.getAttribute("count");
		if (i == null)
			i = 0;
		i++;
		session.setAttribute("count", i);
		ModelAndView mav = new ModelAndView("check");
		return mav;
	}
}