package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class BasePage {

	public static Properties prop;

	public BasePage() {
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