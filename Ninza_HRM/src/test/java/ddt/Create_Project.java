package ddt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Create_Project {

	public static void main(String[] args) throws Exception {
		
		
	WebDriver driver;
	FileInputStream fis;
	FileOutputStream fos;
	
	fis=new FileInputStream("C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\ninza.properties");
	Properties p = new Properties();
	p.load(fis);
	
	String browser=p.getProperty("browser");
	String url=p.getProperty("url");
	String username=p.getProperty("username");
	String password=p.getProperty("password");
	
	if(browser.equalsIgnoreCase("chrome"))
		driver = new ChromeDriver();
	else if(browser.equalsIgnoreCase("firefox"))
		driver = new FirefoxDriver();
	else if(browser.equalsIgnoreCase("edge"))
		driver = new EdgeDriver();
	else
		driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//input[@id='username']")).clear();
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	
	driver.findElement(By.xpath("//input[@id='inputPassword']")).clear();
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(password);
	
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	Thread.sleep(5000);
	
	
	
	
	driver.findElement(By.xpath("//a[.='Projects']")).click();
	driver.findElement(By.xpath("//button[contains(.,'Create Project')]")).click();
	
	
	fis= new FileInputStream("C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
	Workbook wb =WorkbookFactory.create(fis);
	
	Random r = new Random();
	int num =r.nextInt();
	
	String pName=wb.getSheet("Project").getRow(0).getCell(0).toString()+num;
	String pManager =wb.getSheet("Project").getRow(1).getCell(1).toString();
	String pStatus =wb.getSheet("Project").getRow(1).getCell(2).toString();
	
	driver.findElement(By.name("projectName")).clear();
	driver.findElement(By.name("projectName")).sendKeys(pName);
	
	driver.findElement(By.name("createdBy")).clear();
	driver.findElement(By.name("createdBy")).sendKeys(pManager);
	
	WebElement dropdown =driver.findElement(By.xpath("//label[.='Project Status* ']/following-sibling::select"));
	
	Select s = new Select(dropdown);
	s.selectByVisibleText(pStatus);
	
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	Thread.sleep(3000);
	
	//getting project id
	String projectID=driver.findElement(By.xpath("//td[.='"+pName+"']/../td[1]")).getText();
	wb.getSheet("Project").getRow(2).createCell(3).setCellValue(projectID);
	wb.getSheet("Project").getRow(2).getCell(0).setCellValue(pName);
	
	
	// writing it in sheet
	fos= new FileOutputStream("C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\Ninza.xlsx");
	wb.write(fos);
	
	Thread.sleep(5000);
	driver.quit();
	
	
	
	
	
	

	}

}
