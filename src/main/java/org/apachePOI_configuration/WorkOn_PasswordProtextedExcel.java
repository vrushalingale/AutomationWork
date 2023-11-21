package org.apachePOI_configuration;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WorkOn_PasswordProtextedExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		String excelFileLocation = ".\\datafiles\\passwordProtected.xlsx";
		FileInputStream inputFile = new FileInputStream(excelFileLocation);
		String password = "vrushal";
		
		/*
		 * There are 2 ways to pass password to a excel file 
		 * 	Useing :
		 * 		1.  XSSFWorkbook <Class>
		 * 		2. 	Workbook <Interface>
		 * */
		//XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(inputFile, password);
		
		Workbook workbook = WorkbookFactory.create(inputFile, password);
		
		XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0); // workbook.getSheet("Sheet1");

		int rows = sheet.getLastRowNum();

		int cols = sheet.getRow(1).getLastCellNum();

		// Use For Loop to retrieve / Read Excel data

		for (int r = 0; r <= rows; r++) {

			XSSFRow row = sheet.getRow(r);

			for (int c = 0; c < cols; c++) {

				XSSFCell cell = row.getCell(c);

				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				}
				System.out.print("\t" + "	|	" + "\t");
			}
			System.out.println();
		}
		
		

	}

}
