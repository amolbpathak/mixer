package com.mixer.presentation.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mixer.presentation.tableau.Demo;

@Controller
@RequestMapping("/")
public class TableauController {


	
	@RequestMapping(value="trustedRequest" , method = RequestMethod.GET)
	public String trustedRequest(Model model) {
		
		 final String user = "amolbpathak@gmail.com";
	        final String wgserver = "10az.online.tableau.com";
	        final String dst = "views/Book1/Sheet1";
	        final String params = ":embed=yes&:toolbar=yes";
	        OutputStreamWriter out = null;
	        BufferedReader in = null;
	
	        StringBuffer data = new StringBuffer();
            try {
				data.append(URLEncoder.encode("username", "UTF-8"));
			
            data.append("=");
            data.append(URLEncoder.encode(user, "UTF-8"));
            data.append("&");
            data.append(URLEncoder.encode("client_ip", "UTF-8"));
            data.append("=");
            data.append(URLEncoder.encode( "Amol-PC", "UTF-8"));
            } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            // Send the request
            
			try {
				URL url = new URL("https://" + wgserver + "/trusted");
		 
            URLConnection	conn = url.openConnection();
			
            conn.setDoOutput(true);
            
            out = new OutputStreamWriter(conn.getOutputStream());
            
            // Read the response
            StringBuffer rsp = new StringBuffer();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ( (line = in.readLine()) != null) {
                rsp.append(line);
            }
            
            
            String ticket = rsp.toString();
	        
            model.addAttribute("greeting", ticket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        
	        
		return "trustedResponse";
	}
	
	
	
	
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
