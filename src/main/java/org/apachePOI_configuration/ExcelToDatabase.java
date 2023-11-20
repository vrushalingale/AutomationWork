package org.apachePOI_configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDatabase {

	public static void main(String[] args) throws SQLException, IOException {
		// Connect to Database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");

		// CreateStatement
		Statement stmt = con.createStatement();

		String sql = "create table cityDemo (ID decimal(4,0), Name varchar(40), CountryCode varchar(40), District varchar(40), Population int )";
		stmt.execute(sql);

		// Excel
		FileInputStream fis = new FileInputStream(".\\datafiles\\city.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("CityData");

		int rows = sheet.getLastRowNum();

		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);

			double id = row.getCell(0).getNumericCellValue();
			String name = row.getCell(1).getStringCellValue();
			String countryCode = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			int population = (int) row.getCell(4).getNumericCellValue();

			sql = "insert into cityDemo values ('" + id + "','" + name + "','" + countryCode + "','" + district + "','"
					+ population + "')";

			stmt.execute(sql);
			stmt.execute("commit");

		}
		workbook.close();
		fis.close();
		con.close();

		System.out.println("Done ... ---- Insert-------Excel to Database ......");

	}

}
