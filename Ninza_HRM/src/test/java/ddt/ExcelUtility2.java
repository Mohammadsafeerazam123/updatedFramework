package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility2 {
	FileInputStream fis;
	FileOutputStream fos;

	public String readExcelFile(String sheet, int row, int cell) throws Exception {
		fis = new FileInputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	}

	public void writeDataInExistingCell(String sheet, int row, int cell, String value) throws Exception {

		fis = new FileInputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);
		fos = new FileOutputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		wb.write(fos);

	}

	public void writeDataInNewCell(String sheet, int row, int cell, String value) throws Exception {

		fis = new FileInputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		Workbook wb = WorkbookFactory.create(fis);

		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);
		fos = new FileOutputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		wb.write(fos);

	}
	
	public String formatDataFromExcel(String sheet,int row, int cell) throws Exception {
		
		fis = new FileInputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		DataFormatter df = new DataFormatter();
		return df.formatCellValue(wb.getSheet(sheet).getRow(row).getCell(cell));
		
	}

}
