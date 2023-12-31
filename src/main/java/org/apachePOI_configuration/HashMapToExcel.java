package org.apachePOI_configuration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Student data");
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("101", "Gunu");
		data.put("102","Ovi");
		data.put("103","Keshavi");
		
		int rowno =0;
		for(Map.Entry entry : data.entrySet()) {
			
			XSSFRow row = sheet.createRow(rowno++);
			
			row.createCell(0).setCellValue((String) entry.getKey());
			row.createCell(1).setCellValue((String) entry.getValue());
		}
		
		FileOutputStream fos = new FileOutputStream(".\\datafiles\\student.xlsx");
		workbook.write(fos);
		fos.close();
		
		System.out.println("Done..!");

	}

}
