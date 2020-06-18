package com.base;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.reusablecode.MethodsVariable;
import com.base.ReadConfigurationFile;

public class BasePage extends BrowserPage {

	private static final Logger log = LoggerFactory.getLogger(BasePage.class);
	ReadConfigurationFile readconfig;

	public BasePage() {
		readconfig = new ReadConfigurationFile();

		if(ReadConfigurationFile.prop.getProperty("RunMode").equalsIgnoreCase("local")) {
			try {
				launchLocalBrowser();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		else if(ReadConfigurationFile.prop.getProperty("RunMode").equalsIgnoreCase("remote")) {
			try {
				launchRemoteBrowser();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				throw new Exception("Please check your runmode in the config file");
			}catch(Exception e) {
				log.error("property name not found");
				e.printStackTrace();
			}
		}

		driver.manage().window().maximize();		
		driver.manage().timeouts().pageLoadTimeout(MethodsVariable.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(MethodsVariable.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(ReadConfigurationFile.prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		WebDriverManager.setWebDriver(driver);

	}


	//method to start the browser 
	public static void intialization() {
		if(WebDriverManager.getDriver() == null) {
			new WebDriverManager();
			log.info("use of singleton");
		}
	}

	//method to close the webapplication
	public static void closeWindow() {
		if(WebDriverManager.getDriver()!=null) {
			WebDriverManager.getDriver().quit();
		}


	}
}