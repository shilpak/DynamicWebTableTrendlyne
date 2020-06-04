package com.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.reusablecode.MethodsVariable;

public class BrowserPage {
	
	private static final Logger log = LoggerFactory.getLogger(BrowserPage.class);

	//Declare the WebDriver
	public static WebDriver driver;

	//method to launchbrowser with the browsername mention in the config file
	public static void launchBrowser(String browserName) throws Exception {
		if(browserName.equalsIgnoreCase("chrome")){
			
			log.info("launch chrome browser");
			
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			log.info("launch firefox browser");
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(MethodsVariable.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(MethodsVariable.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
}