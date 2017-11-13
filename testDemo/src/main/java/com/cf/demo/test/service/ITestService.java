package com.cf.demo.test.service;

import org.springframework.web.multipart.MultipartFile;

public interface ITestService {
	public String getMenuJson();

	public String getUserInfo();

	public String uploadFile(MultipartFile file);
}
