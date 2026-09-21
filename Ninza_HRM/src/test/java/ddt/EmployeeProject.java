package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.JavaUtility;
import utilities.PropertyUtility2;
import utilities.WebDriverUtility;

public class EmployeeProject {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver;
		FileInputStream fis;
		FileOutputStream fos;
		
		PropertyUtility2 pf =new PropertyUtility2();
		
		String browser=pf.readPropertyFile("browser");
		String url=pf.readPropertyFile("url");
		String username=pf.readPropertyFile("username");
		String password=pf.readPropertyFile("password");
		
		
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
		
		driver.findElement(By.xpath("//a[.='Employees']")).click();
		driver.findElement(By.xpath("//button[contains(.,'Add New Employee')]")).click();
		
		JavaUtility ju = new JavaUtility();
		ExcelUtility2 eu = new ExcelUtility2();
		
		String name=eu.readExcelFile("Emp", 1, 0)+ju.randomInputs();
		String email=eu.readExcelFile("Emp", 1, 1);
		DataFormatter df =new DataFormatter();
		//String phone=eu.readExcelFile("Emp", 1, 2);
		//String phone=df.formatCellValue(eu.readExcelFile("Emp", 1, 2));
		String phone=eu.formatDataFromExcel("Emp", 2, 2);
		String username1=eu.readExcelFile("Emp", 1, 3)+ju.randomInputs();
		String designation=eu.readExcelFile("Emp", 1, 4);
		String experience=eu.readExcelFile("Emp", 1, 5);
		String project=eu.readExcelFile("Emp", 1, 6);
		
		driver.findElement(By.xpath("//label[.='Name*']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[.='Name*']/following-sibling::input")).sendKeys(name);
		
		driver.findElement(By.xpath("//label[.='Email*']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[.='Email*']/following-sibling::input")).sendKeys(email);
		
		driver.findElement(By.xpath("//label[.='Phone*']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[.='Phone*']/following-sibling::input")).sendKeys(phone);
		
		driver.findElement(By.xpath("//label[.='Username*']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[.='Username*']/following-sibling::input")).sendKeys(username1);
		
		driver.findElement(By.xpath("//label[.='Designation*']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[.='Designation*']/following-sibling::input")).sendKeys(designation);
		
		driver.findElement(By.xpath("//label[.='Experience*']/following-sibling::input")).clear();
		driver.findElement(By.xpath("//label[.='Experience*']/following-sibling::input")).sendKeys(experience);
		
		WebElement dropdown =driver.findElement(By.xpath("//label[.=' Project*']/following-sibling::select"));
		Select s= new Select(dropdown);
		
		s.selectByVisibleText(project);
		
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		

	}

}
