package ddt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet("Project");
		System.out.println("getLastRowNum:"+sh.getLastRowNum());
		System.out.println("getPhysicalNumberOfRows: "+sh.getPhysicalNumberOfRows());
		
		Row row =sh.getRow(0);
		System.out.println("getLastCellNum: "+row.getLastCellNum());
		System.out.println("getPhysicalNumberOfCells: "+row.getPhysicalNumberOfCells());
		
		Cell cell =row.getCell(0);
		System.out.println("cell value: "+cell.toString());

	}

}
