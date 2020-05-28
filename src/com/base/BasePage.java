package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class BasePage extends BrowserPage {

	//declare variable for config.properties
	public static Properties prop;

	//constructor of base class to initialize the object
	public BasePage() {
		prop = new Properties();
		try {
			//take reference to the config.properties file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/com/config/config.properties");
			//load the config.properties file
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

	//method to start the browser 
	public static void intialization() throws Exception {
		BrowserPage.launchBrowser( prop.getProperty("browser"));
		//open the webapplication
		driver.get(prop.getProperty("url"));

	}

	//method to close the webapplication
	public static void closeWindow() {
		driver.close();
	}
}