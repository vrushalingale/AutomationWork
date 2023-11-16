package org.apachePOI_configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcelData {
	public void readExcelUsing_For_Loop() throws IOException {
		String excelFileLocation = ".\\datafiles\\countries.xlsx";
		FileInputStream inputFile = new FileInputStream(excelFileLocation);

		XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
		XSSFSheet sheet = workbook.getSheetAt(0); // workbook.getSheet("Sheet1");

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

	public static void main(String[] args) throws IOException {
		//ReadExcelData readExcelForLoop = new ReadExcelData();
		//readExcelForLoop.readExcelUsing_For_Loop();
		
		String excelFileLocation = ".\\datafiles\\countries.xlsx";
		FileInputStream inputFile = new FileInputStream(excelFileLocation);

		XSSFWorkbook workbook = new XSSFWorkbook(inputFile);
		XSSFSheet sheet = workbook.getSheetAt(0); // workbook.getSheet("Sheet1");
		System.out.println("Access Excel data using Iterator.");
		Iterator sheetDataIerator = sheet.iterator();
		while (sheetDataIerator.hasNext()) {
			XSSFRow row = (XSSFRow) sheetDataIerator.next();

			Iterator cellIterator = row.cellIterator();

			while (cellIterator.hasNext()) {
				XSSFCell cell = (XSSFCell) cellIterator.next();

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
