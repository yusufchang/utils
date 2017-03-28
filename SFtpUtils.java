package com.migu.reconciliation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class SFtpUtils {
	//定义日志文件
	static Logger logger = LoggerFactory.getLogger(SFtpUtils.class.getName());
	
	//private Channel channel = null;
	/** Sftp */ 
	ChannelSftp sftp = null;
	/** 主机 */ 
    private String host = ""; 
    /** 端口 */ 
    private int port = 0; 
    /** 用户名 */ 
    private String username = ""; 
    /** 密码 */ 
    private String password = ""; 
    
	/** 
	* 构造函数 
	* 
	* @param host 
	*            主机 
	* @param port 
	*            端口 
	* @param username 
	*            用户名 
	* @param password 
	*            密码 
	*            
	*/ 
    public SFtpUtils(String host, int port, String username, String password){ 
        this.host = host; 
        this.port = port; 
        this.username = username; 
        this.password = password; 
    } 
	
	/** 
	* 连接sftp服务器 
	*            
	* @throws Exception      
	*/ 
	public void connect() throws Exception { 
		try {
			JSch jsch = new JSch();
			jsch.getSession(this.username, this.host, this.port);
			Session sshSession = jsch.getSession(this.username, this.host, this.port);
			logger.info("ftp:Session created.");
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			logger.info("ftp:Session connected.");
			logger.info("ftp:Opening Channel.");
			Channel channel = sshSession.openChannel("sftp");
			channel.connect();
			this.sftp = (ChannelSftp) channel;
			logger.info("ftp:Connected to " + host + ".");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭SFTP
	 * @throws Exception
	 */
	public void disconnect() throws Exception { 
        if(this.sftp != null) { 
            if(this.sftp.isConnected()) { 
            	this.sftp.disconnect(); 
            }else if(this.sftp.isClosed()) { 
            	logger.info(SFtpUtils.class + " sftp is closed already"); 
            } 
        } 
    }
	
	/** 
	* 上传单个文件 
	* 
	* @param directory 
	*            上传的目录 
	* @param uploadFile 
	*            要上传的文件 
	*            
	* @throws Exception      
	*/ 
	public void upload(String directory, String uploadFile) throws Exception { 
		this.sftp.cd(directory); 
		File file = new File(uploadFile); 
		this.sftp.put(new FileInputStream(file), file.getName());
	}
	
	/** 
	* 上传目录下全部文件 
	* 
	* @param directory 
	*            上传的目录 
	*            
	* @throws Exception      
	*/ 
	public void uploadByDirectory(String directory) throws Exception { 
		String uploadFile = ""; 
		List<String> uploadFileList = listFiles(directory); 
		Iterator<String> it = uploadFileList.iterator(); 
	
		while(it.hasNext()) 
		{ 
			uploadFile = it.next().toString(); 
			upload(directory, uploadFile); 
		}
	}
	
	/** 
	* 下载单个文件 
	* 
	* @param directory 
	*            下载目录 
	* @param downloadFile 
	*            下载的文件 
	* @param saveDirectory 
	*            存在本地的路径 
	*            
	* @throws Exception      
	*/ 
	public void download(String directory, String downloadFile, String saveDirectory) throws Exception { 
		String saveFile = saveDirectory + "//" + downloadFile; 
		this.sftp.cd(directory); 
		File file = new File(saveFile); 
		this.sftp.get(downloadFile, new FileOutputStream(file));
	} 
	
	/** 
	* 下载目录下全部文件 
	* 
	* @param directory 
	*            下载目录 
	*            
	* @param saveDirectory 
	*            存在本地的路径 
	*            
	* @throws Exception      
	*/ 
	public void downloadByDirectory(String directory, String saveDirectory) throws Exception { 
		String downloadFile = ""; 
		List<String> downloadFileList = listFiles(directory); 
		Iterator<String> it = downloadFileList.iterator(); 
	
		while(it.hasNext()) 
		{ 
			downloadFile = it.next().toString(); 
			if(downloadFile.toString().indexOf(".") < 0){ 
				continue; 
			} 
			download(directory, downloadFile, saveDirectory); 
		}
	}
	
	/** 
	* 删除文件 
	* 
	* @param directory 
	*            要删除文件所在目录 
	* @param deleteFile 
	*            要删除的文件 
	*            
	* @throws Exception      
	*/ 
	public void delete(String directory, String deleteFile) throws Exception { 
		this.sftp.cd(directory); 
		this.sftp.rm(deleteFile);
	}
	
	/** 
	* 列出目录下的文件 
	* 
	* @param directory 
	*            要列出的目录 
	*            
	* @return list 文件名列表 
	* 
	* @throws Exception 
	*/ 
	@SuppressWarnings("unchecked") 
	public List<String> listFiles(String directory) throws Exception { 
		Vector fileList; 
		List<String> fileNameList = new ArrayList<String>(); 
	
		fileList = this.sftp.ls(directory); 
		Iterator it = fileList.iterator(); 
	
		while(it.hasNext()) 
		{ 
			String fileName = ((LsEntry)it.next()).getFilename(); 
		    if(".".equals(fileName) || "..".equals(fileName)){ 
		        continue; 
		    } 
		    fileNameList.add(fileName); 
		} 
		return fileNameList; 
	}

	/** 
	* 更改文件名 
	* 
	* @param directory 
	*            文件所在目录 
	* @param oldFileNm 
	*            原文件名 
	* @param newFileNm 
	*            新文件名 
	*            
	* @throws Exception      
	*/ 
	public void rename(String directory, String oldFileNm, String newFileNm) throws Exception { 
		this.sftp.cd(directory); 
		this.sftp.rename(oldFileNm, newFileNm); 
	} 

	/**
	 * 改变目录
	 * @param sftp
	 * @param directory
	 * @throws Exception
	 */
	private void cd(String directory)throws Exception { 
		this.sftp.cd(directory); 
	}
	
	private InputStream get(String directory) throws Exception{ 
		InputStream streatm = this.sftp.get(directory); 
		return streatm; 
	} 

}
