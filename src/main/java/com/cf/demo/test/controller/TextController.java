package com.cf.demo.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cf.demo.test.service.ITestService;

@Controller
@RequestMapping("/test")
public class TextController {
	@Autowired
	ITestService iTestService;

	@RequestMapping("/getMenuJson")
	@ResponseBody
	public String getMenuJson(){
		
		return iTestService.getMenuJson();
	}
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public String getUserInfo(){
		
		return iTestService.getUserInfo();
	}
	
	@RequestMapping(value = "/testUpload", method = RequestMethod.POST)
	@ResponseBody
	public String testUpload(MultipartFile file){
		
		String result = iTestService.uploadFile(file);
		
		return result;
	}
}
