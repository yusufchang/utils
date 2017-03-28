package com.migu.reconciliation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class CSVUtils {

	public static List<String[]> parseFile(String path, boolean withHeader) {

		File file = null;
		InputStreamReader fReader = null;
		CSVReader csvReader = null;
		List<String[]> list = null;

		try {

			file = new File(path);
//			fReader = new InputStreamReader(new FileInputStream(file), "UTF-8");
			fReader = new InputStreamReader(new FileInputStream(file), "gbk");
			csvReader = new CSVReader(fReader);
			if (withHeader) {
				csvReader.readNext();
			}
			list = csvReader.readAll();
			csvReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static void generateFile(String path,
			List<String[]> stringArrayList, String[] headers) {

		File file = null;
		Writer writer = null;
		CSVWriter csvWriter = null;
		try {
			file = new File(path);
			writer = new FileWriter(file);
			csvWriter = new CSVWriter(writer, ',');
			csvWriter.writeNext(headers);
			csvWriter.writeAll(stringArrayList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				csvWriter.close();
				csvWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// public static void main(String[] args) {
	//
	// List<String[]> list = parseFile("C:/Test/OSS/Charge.csv", true);
	// for (String[] stringArray : list) {
	// for (String s : stringArray) {
	// System.out.print(s + " ");
	// }
	// System.out.println("");
	// }
	// }
}
