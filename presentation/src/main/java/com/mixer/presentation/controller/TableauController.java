package com.mixer.presentation.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mixer.presentation.tableau.Demo;

@Controller
@RequestMapping("/")
public class TableauController {


	
	@RequestMapping(value="basicEmbed" , method = RequestMethod.GET)
	public String signIn(Model model) {
		System.out.println("inside signIn method");
		System.out.println("inside sayHello method");
		Demo d = new Demo();
		String token = d.getToken();
		
		
		model.addAttribute("greeting", token);
		return "basicEmbed";
	}
	
	@RequestMapping(value="embedScript" , method = RequestMethod.GET)
	public String embedSignIn(Model model) {
		System.out.println("inside signIn method");
		System.out.println("inside sayHello method");
		Demo d = new Demo();
		String token = d.getToken();
		
		
		model.addAttribute("greeting", token);
		return "embedScript";
	}
	
	@RequestMapping(value="iFrameView" , method = RequestMethod.GET)
	public String iFrameView(Model model) {
		System.out.println("inside signIn method");
		System.out.println("inside sayHello method");
		Demo d = new Demo();
		String token = d.getToken();
		
		
		model.addAttribute("greeting", token);
		return "iFrameView";
	}
}
