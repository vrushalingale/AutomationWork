package org.apachePOI_configuration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataBaseToExcel {

	public static void main(String[] args) throws SQLException, IOException {
		// Connect to Database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");

		// CreateStatement
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from city");

		// Create Excel to write data into it.
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("CityData");

		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(0).setCellValue("Name");
		row.createCell(0).setCellValue("CountryCode");
		row.createCell(0).setCellValue("District");
		row.createCell(0).setCellValue("Population");

		int r = 1;
		while (rs.next()) {
			double id = rs.getDouble("ID");
			String name = rs.getString("Name");
			String countryCode = rs.getString("CountryCode");
			String district = rs.getString("District");
			double population = rs.getDouble("Population");

			row = sheet.createRow(r++);

			row.createCell(0).setCellValue(id);
			row.createCell(1).setCellValue(name);
			row.createCell(2).setCellValue(countryCode);
			row.createCell(3).setCellValue(district);
			row.createCell(4).setCellValue(population);

		}

		FileOutputStream fos = new FileOutputStream(".\\datafiles\\city.xlsx");
		workbook.write(fos);

		workbook.close();
		fos.close();
		con.close();

		System.out.println("Done... Database to Excel...");

	}

}
