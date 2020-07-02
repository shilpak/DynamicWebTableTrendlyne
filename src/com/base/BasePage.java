package com.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends BrowserPage{

	private static final Logger log = LoggerFactory.getLogger(BasePage.class);

	//method to start the browser 
	public static void intialization() throws Exception {
		BrowserPage.launchBrowser();
		//open the webapplication
		System.out.println("check 1");
		driver.get(ReadConfigurationFile.prop.getProperty("url"));
		System.out.println("check 2");

	}


	//method to close the webapplication
	public static void closeWindow() {

		driver.close();

	}
}