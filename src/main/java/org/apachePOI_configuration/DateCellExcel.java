package org.apachePOI_configuration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DateCellExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create new Sheet in Above workbook
		XSSFSheet sheet = workbook.createSheet("Date Formats");

		// Data in Number format
		XSSFCell cell = sheet.createRow(0).createCell(0);
		cell.setCellValue(new Date());

		// CreationHelper class
		XSSFCreationHelper creationHelper = workbook.getCreationHelper();

		// format 1 : dd-mm-yyyy
		XSSFCellStyle style1 = workbook.createCellStyle();
		style1.setDataFormat(creationHelper.createDataFormat().getFormat("dd-mm-yyyy"));
		XSSFCell cell1 = sheet.createRow(1).createCell(0);
		cell1.setCellValue(new Date());
		cell1.setCellStyle(style1);

		// format 2 : mm-dd-yyyy
		XSSFCellStyle style2 = workbook.createCellStyle();
		style2.setDataFormat(creationHelper.createDataFormat().getFormat("mm-dd-yyyy"));
		XSSFCell cell2 = sheet.createRow(2).createCell(0);
		cell2.setCellValue(new Date());
		cell2.setCellStyle(style2);

		// format 3 : mm-yyyy
		XSSFCellStyle style3 = workbook.createCellStyle();
		style3.setDataFormat(creationHelper.createDataFormat().getFormat("mm-yyyy"));
		XSSFCell cell3 = sheet.createRow(3).createCell(0);
		cell3.setCellValue(new Date());
		cell3.setCellStyle(style3);

		String filePath = ".\\datafiles\\dateFormats.xlsx";
		FileOutputStream outputStream = new FileOutputStream(filePath);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

		System.out.println("Done... Date Working");

	}

}
