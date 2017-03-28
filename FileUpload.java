package com.example.util;


import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileUpload {
	
	/**
	 * 文件上传（上传单个文件）
	 * @param filePath 文件存放路径
	 * @param file	
	 * xiaoyong
	 */
	public static void upload(String filePath,MultipartFile file){
		try {
			//FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
			//file.getOriginalFilename()获取原文件名
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath,file.getOriginalFilename()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 上传多个文件
	 * @param request
	 * @return
	 */
	public static  String handleFileUpload(HttpServletRequest request){
		List<MultipartFile> files =((MultipartHttpServletRequest)request).getFiles("file");
		MultipartFile file = null;
		BufferedOutputStream stream = null;
		//获取项目路径，如：D:\worksoftware\apache-tomcat-7.0.68-windows-x64\apache-tomcat-7.0.68\webapps\
		String projectPath = request.getSession().getServletContext().getRealPath(File.separator) + File.separator;
		String fileDir = "upload";
		String filePath = projectPath + fileDir + File.separator;
		//生成目录
		try {
			com.example.util.FileUtils.createDirectiory(filePath);
			for (int i = 0; i < files.size(); i++) {
				file = files.get(i);
				if (!file.isEmpty()){
					byte[] bytes = new byte[0];
					bytes = file.getBytes();
					stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + file.getOriginalFilename())));
					stream.write(bytes);
				}
		}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		} finally {
			if (stream != null){
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
