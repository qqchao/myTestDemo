package com.cf.demo.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rabbit")
public class RabbitController {
	
	@Autowired
	private RabbitService rabbitService;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(String number){
		
		try {
			rabbitService.test(number);
		} catch (IOException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
}
