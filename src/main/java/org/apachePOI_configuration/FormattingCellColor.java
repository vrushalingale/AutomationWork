package org.apachePOI_configuration;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormattingCellColor {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		XSSFRow row = sheet.createRow(1);
		
		//setting background color
		
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
		style.setFillPattern(FillPatternType.BIG_SPOTS);
		
		XSSFCell cell = row.createCell(1);
		cell.setCellValue("Welcome");
		cell.setCellStyle(style);
		
		//Setting Foreground color
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell = row.createCell(2);
		cell.setCellValue("Automation");
		cell.setCellStyle(style);
		
		FileOutputStream fos = new FileOutputStream(".\\datafiles\\styles.xlsx");
		workbook.write(fos);
		workbook.close();
		fos.close();
		
		System.out.println("Done..!");
		
	}

}
