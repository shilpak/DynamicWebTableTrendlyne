package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;


public class TestData extends BrowserUtil {
	
	public static WebDriver driver;
	public static Properties properties;

	public TestData() {
		
		properties = new Properties();
		try {
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/com/config/testData.properties");
			properties.load(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


