package com.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage extends BrowserPage{

	private static final Logger log = LoggerFactory.getLogger(BasePage.class);

	//method to start the browser 
	public static void intialization() throws Exception {
		BrowserPage.launchBrowser();
		//open the webapplication
		driver.get(ReadConfigurationFile.prop.getProperty("url"));

	}


	//method to close the webapplication
	public static void closeWindow() {

		driver.close();

	}
}