package com.migu.reconciliation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class FtpUtil {
	private static Channel channel = null;
	private static String ftpHost = null;	//FTP主机地址
	private static int ftpPort = 0;			//FTP主机端口
	private static String ftpUser = null;	//FTP用户
	private static String ftpPwd = null;	//FTP用户密码
	private static String ftpDir = null;	//FTP主机远程文件夹路径

	static {
		ftpHost = ClientProperty.getProperty("ftp", "ProrateFTP_SERVER_HOST");
		ftpPort = Integer.parseInt(ClientProperty.getProperty("ftp", "ProrateFTP_SERVER_PORT"));
		ftpUser = ClientProperty.getProperty("ftp", "ProrateFTP_SERVER_USER");
		ftpPwd = ClientProperty.getProperty("ftp", "ProrateFTP_SERVER_PWD");
		ftpDir = ClientProperty.getProperty("ftp", "ProrateFTP_SERVER_DIR");
	}
	
	
	/**
	 * 连接sftp服务器
	 * 
	 * @param host
	 *            主机
	 * @param port
	 *            端口
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	private static ChannelSftp connect(String host, int port, String username, String password) {
		ChannelSftp sftp = null;
		try {
			JSch jsch = new JSch();
			jsch.getSession(username, host, port);
			Session sshSession = jsch.getSession(username, host, port);
			System.out.println("ftp:Session created.");
			sshSession.setPassword(password);
			Properties sshConfig = new Properties();
			sshConfig.put("StrictHostKeyChecking", "no");
			sshSession.setConfig(sshConfig);
			sshSession.connect();
			System.out.println("ftp:Session connected.");
			System.out.println("ftp:Opening Channel.");
			channel = sshSession.openChannel("sftp");
			channel.connect();
			sftp = (ChannelSftp) channel;
			System.out.println("ftp:Connected to " + host + ".");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sftp;
	}
	
	
	/**
	 * 下载文件
	 * 
	 * @param directory
	 *            下载目录
	 * @param downloadFile
	 *            下载的文件
	 * @param saveFile
	 *            存在本地的路径
	 * @param sftp
	 */
	private static String download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
		//log.info("==========进入 download==========");
		//log.info("===入参:directory:[" + directory + "],downloadFile:[" + downloadFile + "]===");
		String result = null;
		try {
			sftp.cd(directory);
			File file = new File(saveFile);
			sftp.get(downloadFile, new FileOutputStream(file));
			result = Constant.OPERATION_RESULT.OPERATION_REUSLT_SUCCESS;
		} catch (Exception e) {
			//e.printStackTrace();
			result = "error:" + e.getMessage();
		}
		//log.info("==========退出 download==========");
		return result;
	}
	
	public static String downloadFTPFile(String day, String remoteOutputFileName, String localInputFilePath) {
		//log.info("==========进入 downloadFTPFile==========");
		//log.info("===入参:remoteOutputFileName:[" + remoteOutputFileName + "],localInputFilePath:[" + localInputFilePath + "]===");
		ChannelSftp sftp = connect(ftpHost, ftpPort, ftpUser, ftpPwd);
		String result = download(ftpDir + "/" + day, remoteOutputFileName, localInputFilePath + remoteOutputFileName, sftp);
		//log.info("==========退出 downloadFTPFile==========");
		return result;
	}
	
	/*public static String downloadFTPFile(String ftpHost, int ftpPort, String ftpUser, String ftpPwd, String ftpDir, String day, String remoteOutputFileName, String localInputFilePath) {
		//log.info("==========进入 downloadFTPFile==========");
		//log.info("===入参:remoteOutputFileName:[" + remoteOutputFileName + "],localInputFilePath:[" + localInputFilePath + "]===");
		ChannelSftp sftp = connect(ftpHost, ftpPort, ftpUser, ftpPwd);
		String result = download(ftpDir + "/" + day, remoteOutputFileName, localInputFilePath + remoteOutputFileName, sftp);
		//log.info("==========退出 downloadFTPFile==========");
		return result;
	}*/
	
	/**
	 * 上传文件
	 * 
	 * @param directory
	 *            上传的目录
	 * @param uploadFile
	 *            要上传的文件
	 * @param sftp
	 */
	private static String upload(String directory, String uploadFile, ChannelSftp sftp) {
		//log.info("==========进入upload==========");
		//log.info("===入参:directory:[" + directory + "],uploadFile:[" + uploadFile + "]===");
		String result = null;
		try {
			sftp.cd(directory);
			File file = new File(uploadFile);
			sftp.put(new FileInputStream(file), file.getName());
			result = Constant.OPERATOR_RESULT.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			result = Constant.OPERATOR_RESULT.FALSE;
		}
		//log.info("==========退出upload==========");
		return result;
	}
	
	/**
	 * 上传文件到FTP服务器
	 * @param localOutputFilePath
	 * 			上传的文件路径
	 * @param localOutputFileName
	 * 			上传的文件名
	 * @return String
	 */
	public static String uploadFile(String rmoteDir, String localFilePath) {
		//log.info("==========进入 uploadFile==========");
		//log.info("===入参:localOutputFilePath:[" + localOutputFilePath + "],localOutputFileName:[" + localOutputFileName + "]===");
		
		ChannelSftp sftp = connect(ftpHost, ftpPort, ftpUser, ftpPwd);
		//System.out.println("localOutputFilePath=" + (localOutputFilePath + localOutputFileName) + ",remotepath=" + Constant.FTPSERVER_UPLOADPATH);
		String result = upload(ftpDir + rmoteDir, localFilePath, sftp);
		System.out.println("ftpHost=" + ftpHost+ ",ftpPort=" + ftpPort + ",ftpUser=" + ftpUser + ",ftpPwd=" + ftpPwd + ",ftpdir=" + ftpDir + rmoteDir);
		System.out.println("ftp:result=" +result);
		//log.info("==========退出 uploadFile==========");
		return result;
	}
	
}
