package com.base;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.reusablecode.MethodsVariable;


public class BasePage extends BrowserPage {

	private static final Logger log = LoggerFactory.getLogger(BasePage.class);
	public static ConfigurationFileReader readconfig = new ConfigurationFileReader(filepath);

	//method to start the browser 
	public static void intialization() throws Exception {
		
		log.info("it will launch browser at runtime");
		
		String browserHost = System.getProperty("browser.host");
		switch(browserHost)		
		{
		case "local":
			BrowserPage.launchLocalBrowser();
			break;
		case "grid":
			BrowserPage.launchRemoteBrowser();
			break;
		default:
			System.out.println(browserHost +" value is invalid");	
			BrowserPage.launchLocalBrowser();
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
