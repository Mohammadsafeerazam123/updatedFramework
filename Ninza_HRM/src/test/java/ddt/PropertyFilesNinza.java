package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.PropertyUtility;

public class PropertyFilesNinza {

	public static void main(String[] args) throws Exception {
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\ninza.properties");
		
		//Properties p = new Properties();
		//p.load(fis);
		
		PropertyUtility pu = new PropertyUtility();
		
		//System.out.println("Url is: "+p.getProperty("url"));
		//System.out.println("browser is: "+p.getProperty("browser"));
		//System.out.println("Username is: "+p.getProperty("username"));
		//System.out.println("password is: "+p.getProperty("password"));
		
		System.out.println("Url is: "+pu.readPropertyFile("url"));
		System.out.println("browser is: "+pu.readPropertyFile("browser"));
		System.out.println("Username is: "+pu.readPropertyFile("username"));
		System.out.println("password is: "+pu.readPropertyFile("password"));
		
		
		WebDriver driver;
		if(pu.readPropertyFile("browser").equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(pu.readPropertyFile("browser").equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(pu.readPropertyFile("browser").equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else
			driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pu.readPropertyFile("url"));
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(pu.readPropertyFile("username"));
		
		driver.findElement(By.id("inputPassword")).clear();
		driver.findElement(By.id("inputPassword")).sendKeys(pu.readPropertyFile("password"));
		
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		
		Thread.sleep(2000);
		driver.quit();

	}

}
