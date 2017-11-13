package testFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class file {
	// 文件所在的层数
	  JSONObject dataJson = new JSONObject();
	  

	  /**
	  * 输出给定目录下的文件，包括子目录中的文件
	  * @param dirPath 给定的目录
	  */
	  public JSONArray readFile(String rootPath) {

		  JSONArray fileArray = new JSONArray();
			JSONArray returnfileArray = new JSONArray();

			// 建立当前目录中文件的File对象
			File file = new File(rootPath);
			// 取得代表目录中所有文件的File对象数组
			File[] list = file.listFiles();
			// 遍历file数组
			for (int i = 0; i < list.length; i++) {
				String fileName = list[i].getName();
			
				JSONObject fileJson = new JSONObject();
				if (list[i].isDirectory()) {
					// 递归子目录
					fileJson.put("name", fileName);
					fileArray = readFile(list[i].getPath());
					if(fileArray.size() != 0)
						fileJson.put("children", fileArray);
					fileJson.put("isDirectory", 1);
				} else if(fileName.endsWith("jsp") || fileName.endsWith("html") || fileName.endsWith("cpt")){
					fileJson.put("name", fileName);
					fileJson.put("isDirectory", 0);
			}else{
				continue;
			}
				returnfileArray.add(fileJson);
	   }
	   return returnfileArray;
	  }
	  public static void main(String[] args) {
//		  file rd = new file();
//		  String dirPath = "D:\\workspace-ICP-git\\ICP\\store\\src\\main\\webapp";
//		  JSONArray dataArray = rd.readFile(dirPath);
//		  System.out.println(dataArray.toJSONString());
		  
		  System.out.println("aa");
		  try {
			FileOutputStream fos = new FileOutputStream("D:\\a.txt");
			
			
			//用FileOutputStream 的write方法写入字节数组
			fos.write("aaaa".getBytes());
			fos.write("aabbaa".getBytes());
			fos.write("aaccaa".getBytes());
			fos.write("aaddaa".getBytes());
			fos.write("aaeeaa".getBytes());
			//为了节省IO流的开销，需要关闭
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("bb");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
