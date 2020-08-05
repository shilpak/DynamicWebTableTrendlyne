package com.base;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.reusablecode.MethodsVariable;


public class BasePage extends BrowserPage {

	private static final Logger log = LoggerFactory.getLogger(BasePage.class);

	//method to start the browser 
	public static void intialization() throws Exception {
		readconfig = new ConfigurationFileReader(filepath);
		log.info("it will launch browser at runtime");
		if(readconfig.getProperty("RunMode").equalsIgnoreCase("local")) {
			BrowserPage.launchLocalBrowser();
			log.info("open the web application");
		} else if(readconfig.getProperty("RunMode").equalsIgnoreCase("Remote"))
		{
			BrowserPage.launchRemoteBrowser();
		}
		else { 
			try { 
				throw new Exception("Please set up the run mode properly in config.properties"); 
			} catch (Exception e) { 
				e.printStackTrace(); 
			} 
		}

		BrowserPage.driver.get(readconfig.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(MethodsVariable.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(MethodsVariable.IMPLICIT_WAIT, TimeUnit.SECONDS);


	}

	//method to close the webapplication
	public static void closeWindow() {
		log.info("close the webpage");
		driver.quit();

	}
}
