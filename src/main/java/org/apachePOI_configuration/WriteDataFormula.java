package org.apachePOI_configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataFormula {
	
	public void calculateFormulaInCell_RowWise() throws IOException {
		String filePath = ".\\datafiles\\writeFormulaRowCellWise.xlsx";
		
		FileInputStream inputFileStream = new FileInputStream(filePath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputFileStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		sheet.getRow(0).getCell(4).setCellFormula("SUM(B1:D1)");
		inputFileStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(filePath);
		workbook.write(outputStream);
		
		workbook.close();
		outputStream.close();
		System.out.println("Done..");
		
	}

	public void calculateFormulaInCell() throws IOException {
		//Create new Workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		//Create new Sheet in Above workbook
		XSSFSheet sheet = workbook.createSheet("sheet1");
		
		XSSFRow row  = sheet.createRow(0);
		row.createCell(0).setCellValue(10);
		row.createCell(1).setCellValue(20);
		row.createCell(2).setCellValue(30);
		
		row.createCell(3).setCellFormula("A1*B1*C1");
		
		String filePath = ".\\datafiles\\writeformula.xlsx";
		FileOutputStream outputStream = new FileOutputStream(filePath);
		
		workbook.write(outputStream);
		outputStream.close();
		
		System.out.println("Data added into Excel file...");
	}
	
	public static void main(String[] args) throws IOException {
		WriteDataFormula writeFormula = new WriteDataFormula();
		writeFormula.calculateFormulaInCell_RowWise();

	}

}
