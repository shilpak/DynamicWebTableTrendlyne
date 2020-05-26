package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/com/config/config.properties");
			prop.load(fis);
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