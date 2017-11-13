package com.cf.demo.redis.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redisThread")
public class RedisThreadController {

	@Autowired
	private RedisThreadService redisThreadService;
	
	@RequestMapping("/test")
	public String test(){
		
		redisThreadService.runTest();
		
		return "";
	}
	
}
