package com.migu.reconciliation.utils;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.zip.GZIPInputStream;

public class FileUtils {

	/**
	 * 将流转换为string
	 * 
	 * @param iStream
	 * @return
	 * @throws Exception
	 */
	public static String reader(InputStream iStream) throws Exception {
		BufferedReader br = null;
		InputStreamReader reader = null;
		StringBuffer buff = new StringBuffer();
		try {
			reader = new InputStreamReader(iStream);
			br = new BufferedReader(reader);
			String line = null;
			while ((line = br.readLine()) != null) {
				buff.append(line);
			}
		} finally {
			if (null != iStream) {
				iStream.close();
			}
			if (null != reader) {
				reader.close();
			}
			if (null != br) {
				br.close();
			}
		}
		return buff.toString();
	}

	public static void downloadNet(String path, HttpServletResponse response) throws MalformedURLException {
		try {
			// path是指欲下载的文件的路径。
			File file = new File(path);
			// 取得文件名。
			String filename = file.getName();
			// 取得文件的后缀名。
			// String ext = filename.substring(filename.lastIndexOf(".") +
			// 1).toUpperCase();

			URL url = new URL(path);
			URLConnection conn = url.openConnection();
			InputStream inStream = conn.getInputStream();

			// 获得此 URL 的内容。
			int length = Integer.parseInt(conn.getHeaderField("Content-Length"));
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(inStream);
			byte[] buffer = InputStreamToByte(fis);

			// 清空response
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
			response.addHeader("Content-Length", "" + length);
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
			inStream.close();
			fis.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 文件下载（测试可用）
	 * @param path
	 * @param fileName
	 * @param request
	 * @param response
	 */
	public static void download(String path, String fileName, HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		try {
			response.setHeader("Content-Disposition","attachment;filename=" + new String(fileName.getBytes(Constant.CHARACTER.CHARACTER_UTF8), Constant.CHARACTER.CHARACTER_ISO));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			//String path = request.getSession().getServletContext().getRealPath("//") + "/";
			InputStream inputStream = new FileInputStream(new File(path
					+ File.separator + fileName));

			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
			os.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static byte[] InputStreamToByte(InputStream is) throws IOException {
		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
		int ch;
		while ((ch = is.read()) != -1) {
			bytestream.write(ch);
		}
		byte imgdata[] = bytestream.toByteArray();
		bytestream.close();
		return imgdata;
	}

	/**
	 * 创建文件夹
	 * 
	 * @param destFileName
	 * @return
	 * @throws IOException
	 */
	public static boolean createDirectiory(String destFileName) throws IOException {
		boolean flag = true;
		File destFile = new File(destFileName);
		if (!destFile.exists()) {
			flag = destFile.mkdirs();// 目标文件所在目录不存在
		}
		return flag;
	}

	/**
	 * 重命名文件名(可以变更新文件路径)
	 * 
	 * @param srcFile
	 *            文件原名
	 * @param destFile
	 *            文件新名
	 * @return
	 * @throws IOException
	 */
	public static File renameFile(String srcFile, String destFile) throws IOException {
		File file = new File(srcFile);
		if (file.exists()) {
			if (file.renameTo(new File(destFile))) {
				return new File(destFile);
			}
		}
		return null;
	}

	public static String[] getAllFilesOfFileDir(String filePath) throws Exception {
		File file = new File(filePath);
		String[] files = null;
		if (file.isDirectory()) {
			files = file.list();
		}
		return files;
	}

	/**
	 * 读取文件内容，并把内容输出到List数组中
	 * 
	 * @param inputFilePath
	 *            文件路径
	 * @param inputFileName
	 *            文件名称
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> readFileContent(String inputFilePath, String inputFileName,
			String[] dataTitle) throws Exception {
		String encoding = "utf-8";
		String[] strSplit = null;
		InputStreamReader read = null;
		BufferedReader bufferedReader = null;
		String newFileName = inputFileName + ".tmp";
		List<Map<String, Object>> rsultMap = new ArrayList<Map<String, Object>>();// 文件内容
		// String[] title = null;//文件标题
		String[] title = dataTitle;// 文件标题
		// 变更文件名
		File newFile = FileUtils.renameFile(inputFilePath + "/" + inputFileName, inputFilePath + "/" + newFileName);
		//System.out.println(newFile.getPath());
		//System.out.println("name=" + newFile.getName());
		try {
			if (newFile.isFile() && newFile.exists()) {// 判断文件是否存在
				int i = 1;
				read = new InputStreamReader(new FileInputStream(inputFilePath + "/" + newFileName), encoding);// 考虑到编码格式
				bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// System.out.println("lineTxt1=" + lineTxt);
					lineTxt = lineTxt.replace("\"", "");
					// System.out.println("lineTxt2=" + lineTxt);
					strSplit = StringUtils.commaDelimitedListToStringArray(lineTxt);

					/*
					 * if(i == 1) { title = new
					 * String[strSplit.length];//初始化标题数组 for(int j = 0; j <
					 * strSplit.length; j++) {//填充文件标题数组 title[j] = strSplit[j];
					 * } //for(int j = 0; j < title.length; j++) {
					 * //System.out.println("j=" + j + ",value=" + title[j]);
					 * //} } else { Map<String, Object> lineMap = new
					 * HashMap<String, Object>(); //System.out.println("title="
					 * + title.length); //System.out.println("strSplit=" +
					 * strSplit.length); for (int j = 0; j < strSplit.length;
					 * j++) { lineMap.put(title[j], strSplit[j]); }
					 * rsultMap.add(lineMap); }
					 */
					// System.out.println("title=" + title.length);
					// System.out.println("strSplit.length=" + strSplit.length);
					if (i >= 2) {
						Map<String, Object> lineMap = new HashMap<String, Object>();
						for (int j = 0; j < strSplit.length; j++) {
							// System.out.println("----" + strSplit[j]);
							if (strSplit[j].indexOf("月 -") > 0 || strSplit[j].indexOf("月-") > 0) {
								String transTimeStr = DateTimeUtil.getStandardTimeFormat(strSplit[j]);
								/*
								 * if(title[j].equals("FINISHTIME")) {
								 * System.out.println("key=" + title[j] +
								 * ",transTimeStr=" + transTimeStr); }
								 */

								lineMap.put(title[j], transTimeStr);
							} else {
								lineMap.put(title[j], strSplit[j]);
							}

						}
						rsultMap.add(lineMap);
					}

					i++;

				}

			}
			return rsultMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				read.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				// result.append("关闭文件出错.").append("error:" + e.getMessage());
				// log.error("===关闭文件出错===.error:" + e.getMessage() + "===");
			}
			// 把文件名变更到原名
			File oldFile = FileUtils.renameFile(inputFilePath + "/" + newFileName, inputFilePath + "/" + inputFileName);
			//System.out.println(oldFile.getPath());

		}
	}

	/**
	 * 读取文件内容，并把内容输出到List数组中
	 * 
	 * @param inputFilePath
	 *            文件路径
	 * @param inputFileName
	 *            文件名称
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, Object>> readFileContent2(String inputFilePath, String inputFileName,
			String[] dataTitle, String encoding) throws Exception {
		// String encoding="utf-8";
		// String encoding="gbk";
		String[] strSplit = null;
		InputStreamReader read = null;
		BufferedReader bufferedReader = null;
		List<Map<String, Object>> rsultMap = new ArrayList<Map<String, Object>>();// 文件内容
		String[] title = dataTitle;// 文件标题
		// 变更文件名
		File newFile = new File(inputFilePath + "/" + inputFileName);
		//System.out.println(newFile.getPath());
		//System.out.println("name=" + newFile.getName());
		try {
			if (newFile.isFile() && newFile.exists()) {// 判断文件是否存在
				int i = 1;
				read = new InputStreamReader(new FileInputStream(inputFilePath + "/" + inputFileName), encoding);// 考虑到编码格式
				bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					// System.out.println("lineTxt1=" + lineTxt);
					lineTxt = lineTxt.replace("\"", "");
					// System.out.println("lineTxt2=" + lineTxt);
					strSplit = StringUtils.commaDelimitedListToStringArray(lineTxt);

					Map<String, Object> lineMap = new HashMap<String, Object>();
					for (int j = 0; j < strSplit.length; j++) {
						lineMap.put(title[j], strSplit[j]);
						// System.out.println("----" + strSplit[j]);
						/*
						 * if(strSplit[j].indexOf("月 -") > 0 ||
						 * strSplit[j].indexOf("月-") > 0) { String transTimeStr
						 * = DateTimeUtil.getStandardTimeFormat(strSplit[j]);
						 * if(title[j].equals("FINISHTIME")) {
						 * System.out.println("key=" + title[j] +
						 * ",transTimeStr=" + transTimeStr); }
						 * 
						 * lineMap.put(title[j], transTimeStr); } else {
						 * lineMap.put(title[j], strSplit[j]); }
						 */

					}
					rsultMap.add(lineMap);

				}

			}
			return rsultMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				read.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				// result.append("关闭文件出错.").append("error:" + e.getMessage());
				// log.error("===关闭文件出错===.error:" + e.getMessage() + "===");
			}
			// 把文件名变更到原名
			// File oldFile = FileUtils.renameFile(inputFilePath + "/" +
			// newFileName, inputFilePath + "/" + inputFileName);
			// System.out.println(oldFile.getPath());

		}
	}

	/**
	 * 读取文件内容，并把内容输出到List数组中
	 * 
	 * @param inputFilePath
	 *            文件路径
	 * @param inputFileName
	 *            文件名称
	 * @return
	 * @throws Exception
	 */
	public static List<String> readFileContent3(String inputFilePath, String inputFileName) throws Exception {
		InputStreamReader read = null;
		BufferedReader bufferedReader = null;
		List<String> rsultMap = new ArrayList<String>();// 文件内容

		//System.err.println(inputFilePath + "/" + inputFileName);
		File file = new File(inputFilePath + "/" + inputFileName);

		try {
			if (file.isFile() && file.exists()) {// 判断文件是否存在
				read = new InputStreamReader(new FileInputStream(file), "utf-8");// 考虑到编码格式
				bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					rsultMap.add(lineTxt);
				}
			}

			bufferedReader.close();
			read.close();

			return rsultMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * 读取文件内容，并把内容输出到List数组中
	 * 
	 * @param inputFilePath
	 *            文件路径
	 * @param inputFileName
	 *            文件名称
	 * @return
	 * @throws Exception
	 */
	public static List<String> readFileContent4(String inputFilePath, String inputFileName, String encoding)
			throws Exception {
		InputStreamReader read = null;
		BufferedReader bufferedReader = null;
		List<String> rsultMap = new ArrayList<String>();// 文件内容

		File file = new File(inputFilePath + "/" + inputFileName);

		try {
			if (file.isFile() && file.exists()) {// 判断文件是否存在
				read = new InputStreamReader(new FileInputStream(inputFilePath + "/" + inputFileName), encoding);// 考虑到编码格式
				bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					rsultMap.add(lineTxt);
				}
			}
			return rsultMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				read.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			file = null;
		}
	}

	/**
	 * 读取文件内容，并符合筛选条件的数据把内容输出到List数组中
	 * 
	 * @param inputFilePath
	 *            文件路径
	 * @param inputFileName
	 *            文件名称
	 * @param encoding
	 *            文件编码格式
	 * @param filerField
	 *            文件中需要对哪个字段进行过滤的下标(从1开始)
	 * @param filterCondition
	 *            文件中需要对字段进行过滤的条件
	 * @return
	 * @throws Exception
	 */
	public static List<String> readFileContent5(String inputFilePath, String inputFileName, String encoding,
			Integer filerField, Set<String> filterCondition) throws Exception {
		InputStreamReader read = null;
		BufferedReader bufferedReader = null;
		List<String> rsultMap = new ArrayList<String>();// 文件内容

		File file = new File(inputFilePath + "/" + inputFileName);

		try {
			if (file.isFile() && file.exists()) {// 判断文件是否存在
				read = new InputStreamReader(new FileInputStream(inputFilePath + "/" + inputFileName), encoding);// 考虑到编码格式
				bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (filerField != null) {
						String[] strSplit = StringUtils.commaDelimitedListToStringArray(lineTxt);
						if (strSplit.length >= filerField.intValue() - 1) {// 数组长度必须大于过来字段下标
							String _tmpFilterFieldValue = strSplit[filerField.intValue() - 1];
							if (filterCondition.contains(_tmpFilterFieldValue)) {// 过滤条件包括了数据，则表示需要该行数据
								rsultMap.add(lineTxt);
							}
						}
					} else {
						rsultMap.add(lineTxt);
					}
				}
			}
			return rsultMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				read.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			file = null;
		}
	}

	/**
	 * 读取文件内容，并符合筛选条件的数据把内容输出到List数组中
	 * 
	 * @param inputFilePath
	 *            文件路径
	 * @param inputFileName
	 *            文件名称
	 * @param encoding
	 *            文件编码格式
	 * @param filerField
	 *            文件中需要对哪个字段进行过滤的下标(从1开始)
	 * @param filterCondition
	 *            文件中需要对字段进行过滤的条件
	 * @return
	 * @throws Exception
	 */
	public static List<String> readFileContent6(String inputFilePath, String inputFileName, String encoding,
			String filerField, Set<String> filterCondition) throws Exception {
		InputStreamReader read = null;
		BufferedReader bufferedReader = null;
		List<String> rsultMap = new ArrayList<String>();// 文件内容
		StringBuffer _subStr = null;
		String str = null;

		File file = new File(inputFilePath + "/" + inputFileName);

		try {
			if (file.isFile() && file.exists()) {// 判断文件是否存在
				read = new InputStreamReader(new FileInputStream(inputFilePath + "/" + inputFileName), encoding);// 考虑到编码格式
				bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					if (StringUtil.isNotEmptyString(filerField)) {
						if (lineTxt.contains(filerField)) {
							_subStr = new StringBuffer().append(lineTxt.substring(lineTxt.indexOf(filerField) + 10));
							_subStr.delete(_subStr.indexOf(",") - 1, _subStr.length());

							// TODO
							str = _subStr.toString();
							if (filterCondition.contains(str)) {// 过滤条件包括了数据，则表示需要该行数据
								rsultMap.add(lineTxt);
							}
						}

					} else {
						rsultMap.add(lineTxt);
					}
				}
			}
			return rsultMap;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try {
				read.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			file = null;
		}
	}

	/**
	 * 将字符串写入到文件中，
	 * 
	 * @param filePath
	 *            文件路径+文件名
	 * @param fileContent
	 *            文件内容
	 * @param encoding
	 *            字符串编码格式 默认系统编码
	 * @param append
	 *            如果为true表示将fileContent中的内容添加到文件file末尾处
	 * @throws Exception
	 * 
	 * @author duguocheng
	 */
	public static void writeFileByString(String filePath, String fileContent, String encoding, boolean append,
			boolean isNewLine) {
		PrintWriter out = null;
		try {
			if (filePath == null || fileContent == null || fileContent.length() < 0) {
				return;
			}

			if (append) {
				File tempFile = new File(filePath);
				if (!tempFile.exists()) {
					tempFile.getParentFile().mkdirs();
					tempFile.createNewFile();
				}
			} else
				createNewFile(new File(filePath));

			if (encoding == null || encoding.trim().length() <= 0) {
				out = new PrintWriter(new FileWriter(filePath));
			} else {
				out = new PrintWriter(
						new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, append), encoding)),
						true);
			}
			if (isNewLine) {
				out.println();
			}
			out.print(fileContent);

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * 创建文件，如果存在，删除后，新建
	 * 
	 * @param f
	 * @throws IOException
	 */
	public static void createNewFile(File f) throws IOException {
		if (f.exists()) {
			f.delete();
		}
		f.getParentFile().mkdirs();
		f.createNewFile();
	}

	/**
	 * 删除空目录
	 * 
	 * @param dir
	 *            将要删除的目录路径
	 */
	private static void doDeleteEmptyDir(String dir) {
		boolean success = (new File(dir)).delete();
		if (success) {
			System.out.println("Successfully deleted empty directory: " + dir);
		} else {
			System.out.println("Failed to delete empty directory: " + dir);
		}
	}

	/**
	 * 递归删除目录下的所有文件及子目录下所有文件
	 * 
	 * @param dir
	 *            将要删除的文件目录
	 * @return boolean Returns "true" if all deletions were successful. If a
	 *         deletion fails, the method stops attempting to delete and returns
	 *         "false".
	 */
	public static boolean deleteDir(File dir, boolean deleteDir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			// 递归删除目录中的子目录下
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]), deleteDir);
				if (!success) {
					return false;
				}
			}
		}
		// 目录此时为空，可以删除
		if (deleteDir) {
			return dir.delete();
		}
		return true;
	}

	/**
	 * 解压文件
	 * 
	 * @param targetFileName
	 * @return
	 */
	public static String uncompressFile(String targetFileName) {

		String outFileName = "";
		try {

			GZIPInputStream in = null;

			try {
				in = new GZIPInputStream(new FileInputStream(targetFileName));
			} catch (FileNotFoundException e) {
				System.err.println("File not found. " + targetFileName);
			}

			outFileName = targetFileName.substring(0, targetFileName.lastIndexOf("."));
			FileOutputStream out = null;
			try {
				out = new FileOutputStream(outFileName);
			} catch (FileNotFoundException e) {
				System.err.println("Could not write to file. " + outFileName);
			}

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}

			in.close();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return outFileName.substring(outFileName.lastIndexOf("/") + 1);
	}

	/*public static void main(String[] args) throws Exception {
		// renameFile("c:/fzf","20160420.txt","C:/fzf/vm","20160420.txt.tmp");
		
		 * ArrayList<Map<String, Object>> rsultMap =
		 * readFileContent("c:/fzf","20160426.txt"); for(Map<String, Object> map
		 * : rsultMap) { Iterator<String> iterator = map.keySet().iterator();
		 * while(iterator.hasNext()) { String key = iterator.next();
		 * System.out.println("key=" + key + ",value=" + map.get(key)); }
		 * 
		 * System.out.println("-----------map to json------------"); String
		 * jsonStr = JsonUtil.map2Json(map); System.out.println(jsonStr);
		 * System.out.println("-----------json to Object------------");
		 * OriginOrder oo = (OriginOrder) JsonUtil.Json2Obj(jsonStr,
		 * OriginOrder.class); System.out.println("orderId=" + oo.getOrderid());
		 * }
		 

		
		 * String[] s = getAllFilesOfDir("C:/fzf/vm/1"); for(String str : s) {
		 * System.out.println(str); }
		 
		Set<String> filterValue = new HashSet<>();
		// ----------支付宝
		filterValue.add("17");
		filterValue.add("23");
		filterValue.add("44");
		filterValue.add("61");
		filterValue.add("300");
		filterValue.add("303");
		// ----------微信
		filterValue.add("55");
		filterValue.add("301");
		// ----------咪咕一级支付
		filterValue.add("58");
		filterValue.add("59");
		// ---------苹果
		filterValue.add("26");
		readFileContent6("C:/fzf/vm/", "test.txt", "gbk", "payType", filterValue);
	}*/

}
