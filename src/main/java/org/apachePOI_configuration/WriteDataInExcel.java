package org.apachePOI_configuration;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataInExcel {

	public static void main(String[] args) throws IOException {
		
		//Create new Workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//Create new Sheet in Above workbook
		XSSFSheet sheet = workbook.createSheet("sheet1");
		
		//Data-Set to add into EXcel file
		Object empData[][]= {
								{"EmployeeId","Employee Name", "Designation"},
								{101,"Gunu","CEO"},
								{102,"Bhavin","CFO"},
								{103,"Ovi","CFO"},
								{104,"K","CO"},
							};
		//Count Rows and Columns for data
		int rows = empData.length;
		int cols = empData[0].length;
		
		System.out.println("Number of Rows : " + rows);
		System.out.println("Number of Cols : " + cols);
		
		for(int r =0; r<rows; r++) {
			//Create a New Row
			XSSFRow	row = sheet.createRow(r);
			
			for(int c =0; c<cols; c++) {
				XSSFCell cell = row.createCell(c);
				
				/*
				 * 1. Mapping row and column to empData and Adding empData into Object variable
				 * 2. Reading empData and identifying its type to store
				 * */
				Object value = empData[r][c];
				
				if(value instanceof String)
					cell.setCellValue((String) value);
				if(value instanceof Integer)
					cell.setCellValue((Integer) value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean) value);
			}
		}
		String filePath = ".\\datafiles\\employee.xlsx";
		FileOutputStream outputStream = new FileOutputStream(filePath);
		workbook.write(outputStream);
		outputStream.close();
		
		System.out.println("Data added into Excel file...");
	}

}
