package com.pcr.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontPageController {

	    //fetch the front page
		@GetMapping("/front")     
		public ModelAndView front() {	
		System.out.println("FrontPageController>front");
	    //assign index.html file to mv
	    ModelAndView mv = new ModelAndView("front.html");
		return mv;
		}
		
		 //fetch the admin page
		@GetMapping("/admin")     
		public ModelAndView admin() {	
		System.out.println("FrontPageController>admin");
	    //assign index.html file to mv
	    ModelAndView mv = new ModelAndView("admin.html");
		return mv;
		}
		
		 //fetch the user page
		@GetMapping("/user")
		public ModelAndView user() {
		System.out.println("FrontPageController>user");
		// assign index.html file to mv
		ModelAndView mv = new ModelAndView("user.html");
		return mv;
		}
}
