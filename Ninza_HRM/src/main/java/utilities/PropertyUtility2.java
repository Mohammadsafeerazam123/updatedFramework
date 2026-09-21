package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility2 {
	FileInputStream fis;
	public String readPropertyFile(String Key) throws Exception {
		
		fis= new FileInputStream("C:\\Users\\singh\\OneDrive\\Desktop\\TekPyramid\\Ninza_HRM\\src\\test\\resources\\ninza.properties");
		Properties p= new Properties();
		p.load(fis);
		
		return p.getProperty(Key);
		
		
		
		
	}

}
