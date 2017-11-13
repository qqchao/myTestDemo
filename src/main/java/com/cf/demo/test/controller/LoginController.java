package com.cf.demo.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class LoginController {

	@RequestMapping("/login")
	public String login(){
		
		
		
		return "login";
	}
	@RequestMapping(value = "/testDelete", method = RequestMethod.DELETE)
	@ResponseBody
	public String textDelete(HttpServletRequest request){
		String a = request.getParameter("aaa");
		
		System.out.println("qwer");
		System.out.println(a);
		
		
		return  a;
	}
	
}
