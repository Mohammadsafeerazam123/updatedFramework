package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.ExcelUtility;
import utilities.JavaUtility;
import utilities.PropertyUtility2;
import utilities.WebDriverUtility;

public class CreateProject2 {
	
	public static void main(String[] args) throws Exception {
		
		
		WebDriver driver;
		FileInputStream fis;
		FileOutputStream fos;
		
		PropertyUtility2 pf =new PropertyUtility2();
		
		String browser=pf.readPropertyFile("browser");
		String url=pf.readPropertyFile("url");
		String username=pf.readPropertyFile("username");
		String password=pf.readPropertyFile("password");
		
		/*if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else
			driver = new ChromeDriver();*/
		
		WebDriverUtility wu = new WebDriverUtility();
		driver=wu.launchBrowser(browser);
		
		//driver.manage().window().maximize();
		wu.maximizeBrowser();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wu.implicitWaitMethod();
		//driver.get(url);
		wu.getUrl(url);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='username']")).clear();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@id='inputPassword']")).clear();
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
		
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(5000);
		
		
		
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//button[contains(.,'Create Project')]")).click();
		
		
		//fis= new FileInputStream("C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		//Workbook wb =WorkbookFactory.create(fis);
		
		//Random r = new Random();
		//int num =r.nextInt();
		
		JavaUtility ju = new JavaUtility();
		
		//String pName=wb.getSheet("Project").getRow(0).getCell(0).toString()+ju.randomInputs();
		//String pManager =wb.getSheet("Project").getRow(1).getCell(1).toString();
		//String pStatus =wb.getSheet("Project").getRow(1).getCell(2).toString();
		ExcelUtility eu = new ExcelUtility();
		String pName=eu.readExcelFile("Project", 0, 0)+ju.randomInputs();
		String pManager =eu.readExcelFile("Project", 1, 1);
		String pStatus =eu.readExcelFile("Project", 1, 2);
		
		driver.findElement(By.name("projectName")).clear();
		driver.findElement(By.name("projectName")).sendKeys(pName);
		
		driver.findElement(By.name("createdBy")).clear();
		driver.findElement(By.name("createdBy")).sendKeys(pManager);
		
		WebElement dropdown =driver.findElement(By.xpath("//label[.='Project Status* ']/following-sibling::select"));
		eu.handlingDropdowns(dropdown, pStatus);
		
		
		//Select s = new Select(dropdown);
		//s.selectByVisibleText(pStatus);
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(3000);
		
		//getting project id
		String projectID=driver.findElement(By.xpath("//td[.='"+pName+"']/../td[1]")).getText();
		//wb.getSheet("Project").getRow(2).createCell(3).setCellValue(projectID);
		eu.writeInNewCell("Project", 2, 3, projectID);
		//wb.getSheet("Project").getRow(2).getCell(0).setCellValue(pName);
		eu.writeInExistingCell("Project", 2, 0, pName);
		
		
		// writing it in sheet
		//fos= new FileOutputStream("C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
		//wb.write(fos);
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		

		}


}
