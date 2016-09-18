package com.mixer.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloWorldController {

	@RequestMapping(value="hello" , method = RequestMethod.GET)
	public String sayHello(Model model) {
		System.out.println("inside sayHello method");
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "welcome";
	}

	@RequestMapping(value = "helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		System.out.println("inside sayHelloAgain method");
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "welcome";
	}

}
