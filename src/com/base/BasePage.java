package com.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BasePage extends BrowserPage {

	private static final Logger log = LoggerFactory.getLogger(BasePage.class);

	//method to start the browser 
	public static void intialization() throws Exception {
		
		log.info("it will launch browser at runtime");
		BrowserPage.launchBrowser();
		log.info("open the web application");
		
		BrowserPage.driver.get(readconfig.getProperty("url"));
		

	}


	//method to close the webapplication
	public static void closeWindow() {
	log.info("close the webpage");
		driver.quit();

	}
}