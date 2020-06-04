package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class BasePage extends BrowserPage {

	private static final Logger log = LoggerFactory.getLogger(BasePage.class);

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
			log.info("load the config properties file");
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
		log.info("open the url in "+prop.getProperty("browser")+"browser");
		log.info("get the value of current URL " + driver.getCurrentUrl());

	}

	//method to close the webapplication
	public static void closeWindow() {
		driver.close();
	}
}