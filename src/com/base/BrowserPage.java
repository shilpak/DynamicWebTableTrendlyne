package com.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.reusablecode.MethodsVariable;
import com.base.ReadConfigurationFile;
/**
 * @author Shilpa
 * BrowserPage class is used to start the browsers based on the values given in the property file.
 * USer can run the test on chrome and firefox browser.
 * Private constructor to avoid external initialization - SingletonPattern
 */

public class BrowserPage {

	private static final Logger log = LoggerFactory.getLogger(BrowserPage.class);
	//Declare the WebDriver
	public static WebDriver driver;
	static ReadConfigurationFile readconfig;

	//method to launchbrowser with the browsername mention in the config file
	public static void launchBrowser() throws Exception {
		readconfig = new ReadConfigurationFile();
		
		String browserName = System.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			log.info("launch chrome browser");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", ReadConfigurationFile.prop.getProperty("ChromeDriver"));
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			log.info("launch firefox browser");
			System.setProperty("webdriver.gecko.driver", ReadConfigurationFile.prop.getProperty("GeckoDriver"));
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");						
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(MethodsVariable.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(MethodsVariable.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

}

