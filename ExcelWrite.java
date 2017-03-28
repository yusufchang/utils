  package com.migu.reconciliation.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.migu.reconciliation.dto.KeyValuePair;

public class ExcelWrite {
	
	/**
	 * 把数据写入到Excel文档
	 * @param outPath			文件输出路径
	 * @param sheetAndTitleMap	数据内容：表头和数据
	 * @return
	 * @throws Exception
	 */
	/*public static Workbook writeToExcel3(String outPath, Map<String, Object> sheetAndTitleMap) throws Exception {
	    Workbook wb = new XSSFWorkbook();
	    //创建sheet对象
	    Iterator<String> iterator = sheetAndTitleMap.keySet().iterator();
	    Sheet sheet = null;
	    String sheetName = null;
	    while(iterator.hasNext()) {
	    	sheetName = (String) iterator.next();
	    	sheet = (Sheet) wb.createSheet(sheetName);
	    	KeyValuePair kv = (KeyValuePair) sheetAndTitleMap.get(sheetName);
	    	if(null != kv) {
	    		List<Object> rowList = kv.getValues();
		    	int rowSize = rowList.size();
		    	String[] title = kv.getKey().split(",");
		    	int titleSize = title.length;
		    	Cell cell = null;
			    if((title != null && titleSize > 0) && (rowList != null && rowSize > 0)) {
			    	String data = null;
			    	//循环写入行数据
				    for (int i = 0; i < rowSize+1; i++) {
					    Row row = (Row) sheet.createRow(i);
					    //System.out.println("=========="+rowList.get(i).toString());
					    
					    //循环写入列数据
					    for (int j = 0; j < titleSize; j++) {
					    	if(i == 0) {
					    		data = title[j].trim();
					    	} else {
					    		String[] rowData = rowList.get(i-1).toString().split(",");
					    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
					    		data = rowData[j].trim();
					    	}
					        Cell cell = row.createCell(j);
					        cell.setCellValue(data);
					    }
				    }
			    }
		    	//创建表头
		    	if(title != null && titleSize > 0) {
		    		Row row = (Row) sheet.createRow(0);
		    		for (int j = 0; j < titleSize; j++) {
				        cell = row.createCell(j);
				        cell.setCellValue(title[j].trim());
				    }
		    	}
		    	//创建数据
		    	if(rowList != null && rowSize > 0) {
				    for (int i = 0; i < rowSize; i++) {
					    Row row = (Row) sheet.createRow(i+1);
					    //System.out.println("=========="+rowList.get(i).toString());
					    for (int j = 0; j < titleSize; j++) {
					    	String[] rowData = rowList.get(i).toString().split(",");
					        cell = row.createCell(j);
					        cell.setCellValue(rowData[j].trim());
					    }
				    }
			    }
	    	}
	    }
	    
	    return wb;
	}*/
	
	/**
	 * 把数据写入到Excel文档
	 * @param outPath			文件输出路径
	 * @param sheetAndTitleMap	数据内容：表头和数据
	 * @return
	 * @throws Exception
	 */
	public static String writeToExcel2(String outPath, Map<String, Object> sheetAndTitleMap) throws Exception {
		String fileType = outPath.substring(outPath.lastIndexOf(".") + 1, outPath.length());
	    System.out.println(fileType);
	    //创建工作文档对象
	    Workbook wb = null;
	    if (fileType.equals("xls")) {
	      wb = new HSSFWorkbook();
	    } else if (fileType.equals("xlsx")) {
	      wb = new XSSFWorkbook();
	    } else {
	      System.out.println("您的文档格式不正确！");
	      return Constant.OPERATION_RESULT.OPERATION_REUSLT_FALSE;
	    }
	    
	    //创建sheet对象
	    Iterator<String> iterator = sheetAndTitleMap.keySet().iterator();
	    Sheet sheet = null;
	    String sheetName = null;
	    while(iterator.hasNext()) {
	    	sheetName = (String) iterator.next();
	    	sheet = (Sheet) wb.createSheet(sheetName);
	    	KeyValuePair kv = (KeyValuePair) sheetAndTitleMap.get(sheetName);
	    	if(null != kv) {
	    		List<Object> rowList = kv.getValues();
		    	int rowSize = rowList.size();
		    	String[] title = kv.getKey().split(",");
		    	int titleSize = title.length;

			    if((title != null && titleSize > 0) && (rowList != null && rowSize > 0)) {
			    	String data = null;
			    	//循环写入行数据
				    for (int i = 0; i < rowSize+1; i++) {
					    Row row = (Row) sheet.createRow(i);
					    //System.out.println("=========="+rowList.get(i).toString());
					    
					    //循环写入列数据
					    for (int j = 0; j < titleSize; j++) {
					    	if(i == 0) {
					    		data = title[j].trim();
					    	} else {
					    		String[] rowData = rowList.get(i-1).toString().split(",");
					    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
					    		data = rowData[j].trim();
					    	}
					        Cell cell = row.createCell(j);
					        cell.setCellValue(data);
					    }
				    }
			    }
	    	}
	    }
	    
	    // 创建文件流
	    OutputStream stream = new FileOutputStream(outPath);
	    // 写入数据
	    wb.write(stream);
	    // 关闭文件流
	    stream.close();
	    return Constant.OPERATION_RESULT.OPERATION_REUSLT_SUCCESS;
	}
	
	/**
	 * 页面下载表格，把数据写入到Excel文档
	 * @param sheetAndTitleMap
	 * @return
	 * @throws Exception
	 */
	public static Workbook writeToExcel3(Map<String, Object> sheetAndTitleMap) throws Exception {
	    Workbook wb = new XSSFWorkbook();
	    //创建sheet对象
	    Iterator<String> iterator = sheetAndTitleMap.keySet().iterator();
	    Sheet sheet = null;
	    Row row = null;
	    String sheetName = null;
	    while(iterator.hasNext()) {
	    	sheetName = (String) iterator.next();
	    	sheet = (Sheet) wb.createSheet(sheetName);
	    	KeyValuePair kv = (KeyValuePair) sheetAndTitleMap.get(sheetName);
	    	if(null != kv) {
	    		List<Object> rowList = kv.getValues();
		    	int rowSize = rowList.size();
		    	String[] title = kv.getKey().split(",");
		    	int titleSize = title.length;
		    	String op = kv.getWirteDataOption();
		    	
		    	String data = null;
		    	Cell cell = null;
		    	if(Constant.EXPORT_DATA.WRITE_DATA_H.equals(op)) {//水平
		    		if(title != null && titleSize > 0) {//填充表头
		    			row = (Row) sheet.createRow(0);
		    			for (int j = 0; j < titleSize; j++) {
		    				data = title[j].trim();
		    				cell = row.createCell(j);
					        cell.setCellValue(data);
		    			}
		    		}
		    		if(rowList != null && rowSize > 0) {//填充数据
		    			for (int i = 0; i < rowSize; i++) {
		    				row = (Row) sheet.createRow(i+1);
		    				String[] rowData = rowList.get(i).toString().split(",");
				    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
		    				for(int j = 0; j < rowData.length; j++) {
		    					data = rowData[j].trim();
					    		cell = row.createCell(j);
						        cell.setCellValue(data);
		    				}
				    		
		    			}
		    		}
		    	} else {
		    		if(title != null && titleSize > 0) {//填充表头
		    			for (int j = 0; j < titleSize; j++) {
		    				row = (Row) sheet.createRow(j);
		    				cell = row.createCell(0);
		    				cell.setCellValue(title[j].trim());
		    			}
		    		}
		    		if(rowList != null && rowSize > 0) {//填充数据
		    			String[] rowData = rowList.get(0).toString().split(",");
		    			for (int i = 0; i < rowData.length; i++) {
		    				row = (Row) sheet.getRow(i);
				    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
	    					cell = row.createCell(1);
					        cell.setCellValue(rowData[i].trim());
		    			}
		    		}
		    	}
		    	
		    	
		    	
			    /*if((title != null && titleSize > 0) && (rowList != null && rowSize > 0)) {
			    	String data = null;
			    	//循环写入行数据
			    	if(Constant.EXPORT_DATA.WRITE_DATA_H.equals(op)) {//水平
			    		for (int i = 0; i < rowSize+1; i++) {
				    		row = (Row) sheet.createRow(i);
						    //System.out.println("=========="+rowList.get(i).toString());
						    
						    //循环写入列数据
						    for (int j = 0; j < titleSize; j++) {
						    	if(i == 0) {
						    		data = title[j].trim();
						    	} else {
						    		String[] rowData = rowList.get(i-1).toString().split(",");
						    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
						    		data = rowData[j].trim();
						    	}
						        Cell cell = row.createCell(j);
						        cell.setCellValue(data);
						    }
					    }
			    	} else {
			    		String[] rowData = rowList.get(0).toString().split(",");
			    		for(int i = 0; i < titleSize; i++) {
			    			row = (Row) sheet.createRow(i);
			    			
			    			Cell cell = row.createCell(0);
					        cell.setCellValue(title[i].trim());
					        
					        cell = row.createCell(1);
					        cell.setCellValue(rowData[i].trim());
			    		}
			    	}
				    
			    }*/
	    	}
	    }
	    return wb;
	}
	
	
	public static Workbook writeToExcel4(Map<String, Object> sheetAndTitleMap) throws Exception {
	    Workbook wb = new XSSFWorkbook();
	    //创建sheet对象
	    Iterator<String> iterator = sheetAndTitleMap.keySet().iterator();
	    Sheet sheet = null;
	    Row row = null;
	    String sheetName = null;
	    while(iterator.hasNext()) {
	    	sheetName = (String) iterator.next();
	    	sheet = (Sheet) wb.createSheet(sheetName);
	    	KeyValuePair kv = (KeyValuePair) sheetAndTitleMap.get(sheetName);
	    	if(null != kv) {
	    		List<Object> rowList = kv.getValues();
		    	int rowSize = rowList == null?0:rowList.size();
		    	String[] title = kv.getKey().split(",");
		    	int titleSize = title.length;
		    	String op = kv.getWirteDataOption();
		    	
		    	String data = null;
		    	Cell cell = null;
		    	if(Constant.EXPORT_DATA.WRITE_DATA_H.equals(op)) {//水平
		    		if(title != null && titleSize > 0) {//填充表头
		    			row = (Row) sheet.createRow(0);
		    			for (int j = 0; j < titleSize; j++) {
		    				data = title[j].trim();
		    				cell = row.createCell(j);
					        cell.setCellValue(data);
		    			}
		    		}
		    		if(rowList != null && rowSize > 0) {//填充数据
		    			for (int i = 0; i < rowSize; i++) {
		    				row = (Row) sheet.createRow(i+1);
		    				String[] rowData = rowList.get(i).toString().split(",");
				    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
		    				for(int j = 0; j < rowData.length; j++) {
		    					data = rowData[j].trim();
					    		cell = row.createCell(j);
						        cell.setCellValue(data);
		    				}
				    		
		    			}
		    		}
		    	} else {
		    		if(title != null && titleSize > 0) {//填充表头
		    			for (int j = 0; j < titleSize; j++) {
		    				row = (Row) sheet.createRow(j);
		    				cell = row.createCell(0);
		    				cell.setCellValue(title[j].trim());
		    			}
		    		}
		    		if(rowList != null && rowSize > 0) {//填充数据
		    			String[] rowData = rowList.get(0).toString().split(",");
		    			for (int i = 0; i < rowData.length; i++) {
		    				row = (Row) sheet.getRow(i);
				    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
	    					cell = row.createCell(1);
					        cell.setCellValue(rowData[i].trim());
		    			}
		    		}
		    	}
		    	
		    	
		    	
			    /*if((title != null && titleSize > 0) && (rowList != null && rowSize > 0)) {
			    	String data = null;
			    	//循环写入行数据
			    	if(Constant.EXPORT_DATA.WRITE_DATA_H.equals(op)) {//水平
			    		for (int i = 0; i < rowSize+1; i++) {
				    		row = (Row) sheet.createRow(i);
						    //System.out.println("=========="+rowList.get(i).toString());
						    
						    //循环写入列数据
						    for (int j = 0; j < titleSize; j++) {
						    	if(i == 0) {
						    		data = title[j].trim();
						    	} else {
						    		String[] rowData = rowList.get(i-1).toString().split(",");
						    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
						    		data = rowData[j].trim();
						    	}
						        Cell cell = row.createCell(j);
						        cell.setCellValue(data);
						    }
					    }
			    	} else {
			    		String[] rowData = rowList.get(0).toString().split(",");
			    		for(int i = 0; i < titleSize; i++) {
			    			row = (Row) sheet.createRow(i);
			    			
			    			Cell cell = row.createCell(0);
					        cell.setCellValue(title[i].trim());
					        
					        cell = row.createCell(1);
					        cell.setCellValue(rowData[i].trim());
			    		}
			    	}
				    
			    }*/
	    	}
	    }
	    return wb;
	}
	
	
	/**
	 * 页面下载表格，把数据写入到Excel文档
	 * @param outPath
	 * @param sheetAndTitleMap
	 * @return
	 * @throws Exception
	 */
	public static Workbook writeToExcel3_bak(/*String outPath, */Map<String, Object> sheetAndTitleMap) throws Exception {
	    Workbook wb = new XSSFWorkbook();
	    //创建sheet对象
	    Iterator<String> iterator = sheetAndTitleMap.keySet().iterator();
	    Sheet sheet = null;
	    Row row = null;
	    String sheetName = null;
	    while(iterator.hasNext()) {
	    	sheetName = (String) iterator.next();
	    	sheet = (Sheet) wb.createSheet(sheetName);
	    	KeyValuePair kv = (KeyValuePair) sheetAndTitleMap.get(sheetName);
	    	if(null != kv) {
	    		List<Object> rowList = kv.getValues();
		    	int rowSize = rowList.size();
		    	String[] title = kv.getKey().split(",");
		    	int titleSize = title.length;
		    	String op = kv.getWirteDataOption();
//		    	Cell cell = null;
			    if((title != null && titleSize > 0) && (rowList != null && rowSize > 0)) {
			    	String data = null;
			    	//循环写入行数据
			    	if(Constant.EXPORT_DATA.WRITE_DATA_H.equals(op)) {//水平
			    		for (int i = 0; i < rowSize+1; i++) {
				    		row = (Row) sheet.createRow(i);
						    //System.out.println("=========="+rowList.get(i).toString());
						    
						    //循环写入列数据
						    for (int j = 0; j < titleSize; j++) {
						    	if(i == 0) {
						    		data = title[j].trim();
						    	} else {
						    		String[] rowData = rowList.get(i-1).toString().split(",");
						    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
						    		data = rowData[j].trim();
						    	}
						        Cell cell = row.createCell(j);
						        cell.setCellValue(data);
						    }
					    }
			    	} else {
			    		String[] rowData = rowList.get(0).toString().split(",");
			    		for(int i = 0; i < titleSize; i++) {
			    			row = (Row) sheet.createRow(i);
			    			
			    			Cell cell = row.createCell(0);
					        cell.setCellValue(title[i].trim());
					        
					        cell = row.createCell(1);
					        cell.setCellValue(rowData[i].trim());
			    		}
			    	}
				    
			    }
	    	}
	    }
	    
	    return wb;
	}
	
	
	public static String writeToExcel(String outPath, Map<String, Object> sheetAndTitleMap) throws Exception {
		String fileType = outPath.substring(outPath.lastIndexOf(".") + 1, outPath.length());
	    //System.out.println(fileType);
	    //创建工作文档对象
	    Workbook wb = null;
	    if (fileType.equals("xls")) {
	      wb = new HSSFWorkbook();
	    } else if (fileType.equals("xlsx")) {
	      wb = new XSSFWorkbook();
	    } else {
	      System.out.println("您的文档格式不正确！");
	      return Constant.OPERATION_RESULT.OPERATION_REUSLT_FALSE;
	    }
	    
	    //创建sheet对象
	    Iterator<String> iterator = sheetAndTitleMap.keySet().iterator();
	    Sheet sheet = null;
	    String sheetName = null;
	    Row row = null;
	    while(iterator.hasNext()) {
	    	sheetName = (String) iterator.next();
	    	sheet = (Sheet) wb.createSheet(sheetName);
	    	System.out.println("sheetName=" + sheetName);
	    	KeyValuePair kv = (KeyValuePair) sheetAndTitleMap.get(sheetName);
	    	
	    	if(null != kv) {
	    		List<Object> rowList = kv.getValues();
		    	int rowSize = rowList.size();
		    	String[] title = kv.getKey().split(",");
		    	int titleSize = title.length;
		    	//System.out.println("======title=" + title);
		    	String op = kv.getWirteDataOption();
			    if((title != null && titleSize > 0) && (rowList != null && rowSize > 0)) {
			    	String data = null;
			    	Cell cell = null;
			    	if(Constant.EXPORT_DATA.WRITE_DATA_H.equals(op)) {//水平
			    		if(title != null && titleSize > 0) {//填充表头
			    			row = (Row) sheet.createRow(0);
			    			for (int j = 0; j < titleSize; j++) {
			    				data = title[j].trim();
			    				cell = row.createCell(j);
						        cell.setCellValue(data);
			    			}
			    		}
			    		if(rowList != null && rowSize > 0) {//填充数据
			    			for (int i = 0; i < rowSize; i++) {
			    				row = (Row) sheet.createRow(i+1);
			    				String[] rowData = rowList.get(i).toString().split(",");
					    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
			    				for(int j = 0; j < rowData.length; j++) {
			    					data = rowData[j].trim();
						    		cell = row.createCell(j);
							        cell.setCellValue(data);
			    				}
					    		
			    			}
			    		}
			    	} else {
			    		if(title != null && titleSize > 0) {//填充表头
			    			for (int j = 0; j < titleSize; j++) {
			    				row = (Row) sheet.createRow(j);
			    				cell = row.createCell(0);
			    				cell.setCellValue(title[j].trim());
			    			}
			    		}
			    		if(rowList != null && rowSize > 0) {//填充数据
			    			String[] rowData = rowList.get(0).toString().split(",");
			    			for (int i = 0; i < rowData.length; i++) {
			    				row = sheet.getRow(i);
					    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
			    				cell = row.createCell(1);
						        cell.setCellValue(rowData[i].trim());
			    			}
			    		}
			    	}
			    	
			    	/*String data = null;
			    	//循环写入行数据
			    	if(Constant.EXPORT_DATA.WRITE_DATA_H.equals(op)) {//水平
			    		for (int i = 0; i < rowSize+1; i++) {
				    		row = (Row) sheet.createRow(i);
						    //System.out.println("=========="+rowList.get(i).toString());
						    
						    //循环写入列数据
						    for (int j = 0; j < titleSize; j++) {
						    	if(i == 0) {
						    		data = title[j].trim();
						    	} else {
						    		String[] rowData = rowList.get(i-1).toString().split(",");
						    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
						    		data = rowData[j].trim();
						    	}
						        Cell cell = row.createCell(j);
						        cell.setCellValue(data);
						    }
					    }
			    	} else {
			    		String[] rowData = rowList.get(0).toString().split(",");
			    		for(int i = 0; i < titleSize; i++) {
			    			row = (Row) sheet.createRow(i);
			    			
			    			Cell cell = row.createCell(0);
					        cell.setCellValue(title[i].trim());
					        
					        cell = row.createCell(1);
					        cell.setCellValue(rowData[i].trim());
			    		}
			    	}*/
				    
			    }
	    	}
	    }
	    
	    // 创建文件流
	    OutputStream stream = new FileOutputStream(outPath);
	    // 写入数据
	    wb.write(stream);
	    // 关闭文件流
	    stream.close();
	    return Constant.OPERATION_RESULT.OPERATION_REUSLT_SUCCESS;
	}
	
	public static String writeToExcel_bak(String outPath, Map<String, Object> sheetAndTitleMap) throws Exception {
		String fileType = outPath.substring(outPath.lastIndexOf(".") + 1, outPath.length());
	    //System.out.println(fileType);
	    //创建工作文档对象
	    Workbook wb = null;
	    if (fileType.equals("xls")) {
	      wb = new HSSFWorkbook();
	    } else if (fileType.equals("xlsx")) {
	      wb = new XSSFWorkbook();
	    } else {
	      System.out.println("您的文档格式不正确！");
	      return Constant.OPERATION_RESULT.OPERATION_REUSLT_FALSE;
	    }
	    
	    //创建sheet对象
	    Iterator<String> iterator = sheetAndTitleMap.keySet().iterator();
	    Sheet sheet = null;
	    String sheetName = null;
	    Row row = null;
	    while(iterator.hasNext()) {
	    	sheetName = (String) iterator.next();
	    	sheet = (Sheet) wb.createSheet(sheetName);
	    	System.out.println("sheetName=" + sheetName);
	    	KeyValuePair kv = (KeyValuePair) sheetAndTitleMap.get(sheetName);
	    	
	    	if(null != kv) {
	    		List<Object> rowList = kv.getValues();
		    	int rowSize = rowList.size();
		    	String[] title = kv.getKey().split(",");
		    	int titleSize = title.length;
		    	//System.out.println("======title=" + title);
		    	String op = kv.getWirteDataOption();
			    if((title != null && titleSize > 0) && (rowList != null && rowSize > 0)) {
			    	String data = null;
			    	//循环写入行数据
			    	if(Constant.EXPORT_DATA.WRITE_DATA_H.equals(op)) {//水平
			    		for (int i = 0; i < rowSize+1; i++) {
				    		row = (Row) sheet.createRow(i);
						    //System.out.println("=========="+rowList.get(i).toString());
						    
						    //循环写入列数据
						    for (int j = 0; j < titleSize; j++) {
						    	if(i == 0) {
						    		data = title[j].trim();
						    	} else {
						    		String[] rowData = rowList.get(i-1).toString().split(",");
						    		//System.out.println("titleSize=" + titleSize + ",rowDataSize=" + rowData.length);
						    		data = rowData[j].trim();
						    	}
						        Cell cell = row.createCell(j);
						        cell.setCellValue(data);
						    }
					    }
			    	} else {
			    		String[] rowData = rowList.get(0).toString().split(",");
			    		for(int i = 0; i < titleSize; i++) {
			    			row = (Row) sheet.createRow(i);
			    			
			    			Cell cell = row.createCell(0);
					        cell.setCellValue(title[i].trim());
					        
					        cell = row.createCell(1);
					        cell.setCellValue(rowData[i].trim());
			    		}
			    	}
				    
			    }
	    	}
	    }
	    
	    // 创建文件流
	    OutputStream stream = new FileOutputStream(outPath);
	    // 写入数据
	    wb.write(stream);
	    // 关闭文件流
	    stream.close();
	    return Constant.OPERATION_RESULT.OPERATION_REUSLT_SUCCESS;
	}
	
	/*public static void main(String[] args) throws Exception {
		Map<String, Object> sheetAndTitleMap = new HashMap<>();
		List<Object> value = new ArrayList<>();
		value.add("1,2,3,4,5,6,7,8,9,10,11,12");
		value.add("2");
		value.add("3");
		value.add("4");
		value.add("5");
		value.add("6");
		value.add("7");
		value.add("8");
		value.add("9");
		value.add("10");
		value.add("11");
		value.add("12");
		KeyValuePair kv = new KeyValuePair();
		String title = "账务流水号,业务流水号,商户订单号,商品名称,发生时间,对方账号,收入金额（+元）,支出金额（-元）,账户余额（元）,交易渠道,业务类型,备注";
		kv.setKey(title);
		kv.setValues(value);
		kv.setWirteDataOption(Constant.EXPORT_DATA.WRITE_DATA_V);
		sheetAndTitleMap.put("提现", kv);
		
		kv = new KeyValuePair();
		kv.setKey(title);
		kv.setValues(value);
		kv.setWirteDataOption(Constant.EXPORT_DATA.WRITE_DATA_H);
		sheetAndTitleMap.put("手续费", kv);
		kv.setWirteDataOption(Constant.EXPORT_DATA.WRITE_DATA_H);
		sheetAndTitleMap.put("在线支付", kv);
		//sheetAndTitleMap.put("对账汇总", null);
		kv.setWirteDataOption(Constant.EXPORT_DATA.WRITE_DATA_H);
		sheetAndTitleMap.put("退款", kv);
		//sheetAndTitleMap.put("本地交易流水", null);
		//sheetAndTitleMap.put("支付对账", null);
		//sheetAndTitleMap.put("退款对账", null);
		System.out.println(writeToExcel("c:/fzf/1.xls", sheetAndTitleMap));
	}*/
	
}
