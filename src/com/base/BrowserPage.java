package com.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.reusablecode.MethodsVariable;
import com.exceptions.MissingConfigPropertyException;
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
	public static ConfigurationFileReader readconfig;
	static String workingdir = System.getProperty("user.dir");
	static String filepath = workingdir+"/src/com/config/config.properties";

	//method to launchbrowser wit the browsername mention in the config file

	public static void launchBrowser() throws Exception {
		readconfig = new ConfigurationFileReader(filepath);

		String browserName = System.getProperty("browser.type");
        String defaultBrowser = readconfig.getProperty("DefaultLocalBrowser");

        if (browserName.equals("")) {
            log.warn("The System Property browser.type was not set.  Defaulting to {}", defaultBrowser);
            if (defaultBrowser.equals("")) {
                log.error("Assuming default local browser but 'DefaultLocalBrowser' was " + 
                        "not set in config.properties.  Set config and retry.");
                        throw new MissingConfigPropertyException("Missing 'DefaultLocalBrowser' property.");
            }
            browserName = defaultBrowser;
        }

		if(browserName.equalsIgnoreCase("chrome")){
			log.info("launch chrome browser");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", readconfig.getProperty("ChromeDriver"));

			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			log.info("launch firefox browser");			
			System.setProperty("webdriver.gecko.driver", readconfig.getProperty("GeckoDriver"));
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");						
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(MethodsVariable.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(MethodsVariable.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}

}

