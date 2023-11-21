package org.apachePOI_configuration;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromFormulaCell {

	public static void main(String[] args) throws IOException {
		String excelFileLocation = ".\\datafiles\\readformula.xlsx";
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
				case FORMULA:
					System.out.print(cell.getNumericCellValue());
					break;
				}
				System.out.print("\t" + "	|	" + "\t");
			}
			System.out.println();
		}
		
	}

}
