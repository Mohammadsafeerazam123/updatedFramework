package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ExcelUtility {
	FileInputStream fis;
	FileOutputStream fos;

	public String readExcelFile(String sheet, int row, int cell) throws Exception {

		fis = new FileInputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getCell(cell).toString();

	}

	public int getRowCount(String sheet) throws Exception {

		fis = new FileInputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getPhysicalNumberOfRows();

	}

	public int getCellCount(String sheet, int row) throws Exception {

		fis = new FileInputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");

		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getPhysicalNumberOfCells();

	}

	public void writeInExistingCell(String sheet, int row, int cell, String value) throws Exception {
		fis = new FileInputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(value);

		fos = new FileOutputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		wb.write(fos);

	}

	public void writeInNewCell(String sheet, int row, int cell, String value) throws Exception {
		fis = new FileInputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(row).createCell(cell).setCellValue(value);

		fos = new FileOutputStream(
				"C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		wb.write(fos);

	}

	public void handlingDropdowns(WebElement dropdown, String pStatus) {
		//WebElement dropdown = driver.findElement(By.xpath("//label[.='Project Status* ']/following-sibling::select"));

		Select s = new Select(dropdown);
		s.selectByVisibleText(pStatus);
	}

}
