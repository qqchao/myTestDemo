package com.cf.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisServece redisServece;
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(String number){
		
		redisServece.runTest(number);
		
		return "success";
	}
	
	@RequestMapping("/testPop")
	@ResponseBody
	public String testPop(String number){
		
		redisServece.testPop(number);
		
		return "success";
	}
	
}
