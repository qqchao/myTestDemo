package com.cf.demo.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cf.demo.test.service.ITestService;
/**
 * 
 * @author Q.chao
 * 2017-08-18 15:02:34
 */
@Service
public class TestService implements ITestService{
	/**
	 * 页面菜单json测试数据
	 * @return
	 */
	@Override
	public String getMenuJson(){
		JSONArray menuArrayA = new JSONArray();
		
		for(int i = 0; i < 3; i++){
			JSONObject menuInfoA = new JSONObject();
			JSONObject menuInfo = new JSONObject();
			JSONArray menuArrayB = new JSONArray();
			
			for(int j = 0; j < 3; j++){
				JSONObject menuInfoB = new JSONObject();
				JSONObject menuInfoC = new JSONObject();
				
				menuInfoC.put("menuName", "testMenuB");
				menuInfoC.put("menuId", "166");
				menuInfoC.put("menuIcon", "");
				menuInfoC.put("menuUrl", "http://www.baidu.com");
				menuInfoB.put("menuInfo", menuInfoC);
				menuArrayB.add(menuInfoB);
			}
			
			menuInfoA.put("menuName", "testMenuA");
			menuInfoA.put("menuId", "168");
			menuInfoA.put("menuIcon", "iconfont icon-gongyeqitiyun");
			menuInfoA.put("menuUrl", "http://0.baidu.com");
			menuInfo.put("menuInfo", menuInfoA);
			menuInfo.put("subMenu", menuArrayB);

			menuArrayA.add(menuInfo);
		}
		
		return menuArrayA.toJSONString();
	}
	/**
	 * 获取用户信息
	 */
	@Override
	public String getUserInfo() {
		JSONObject usedrInfo = new JSONObject();
		usedrInfo.put("userId", "101");
		usedrInfo.put("userName", "qqChao");
		usedrInfo.put("avatarIcon", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1503051580961&di=df5f0779bcf06ae4922237948cf0efce&imgtype=0&src=http%3A%2F%2Fdepot.nipic.com%2Ffile%2F20151223%2F19303748_18052418547.jpg");
		
		return usedrInfo.toJSONString();
	}
	
	public String testJson(){
		
		JSONObject testA = new JSONObject();
		
		Collection<Object> collectionA = testA.values();
		
		for(Object o : collectionA){
			if (o instanceof ArrayList<?>){
		        List<String>  taskList = (ArrayList<String>)o;
			}
		}
		
		testA.remove("{", "");
		
		return "";
	}
	
	//上传文件
	@Override
	public String uploadFile(MultipartFile file) {
		
		if (file != null && !file.isEmpty() && file.getName() != "") {
			
			if (file.getSize() > 4 * 1024 * 1024) {
				return "文件太大了";
			}
			
			return saveFile(file);
			
		}
		
		return "-.-!";
	}
	
	/**
	 * 保存上传文件
	 * @param file
	 * @return
	 */
	private String saveFile(MultipartFile file){
		
		String fileName = "";
		
		fileName = file.getOriginalFilename();
		
		String expandedName = fileName.substring(fileName.lastIndexOf("."));
		
		String path = TestService.class.getClassLoader().getResource("../../").getPath();
		
		// webapps绝对
		File uploadFile = new File(path + "cptFile");
		
		fileName = "Test_" + System.currentTimeMillis() + expandedName;
		
		if (!uploadFile.exists()) {// 上传目录不存在则创建
			uploadFile.mkdirs();
		}

		try {
			file.transferTo(new File(path + "cptFile/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "0.0";
	}
}
