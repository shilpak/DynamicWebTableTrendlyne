package com.base;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	public static WebDriver driver = null;
	public static DesiredCapabilities capabilities;


	//method to launchbrowser with the browsername mention in the config file

	public void launchLocalBrowser() throws Exception {
		String browserParamFromEnv = System.getProperty("browser");
		System.out.println(browserParamFromEnv);
		String browserName = browserParamFromEnv == null ? ReadConfigurationFile.prop.getProperty("browser") : browserParamFromEnv;
		System.out.println(browserName);
		if(browserName.equalsIgnoreCase("chrome")){
			log.info("launch chrome browser");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")){
			log.info("launch firefox browser");
			System.setProperty("webdriver.gecko.driver", getFirefoxDriverPath());
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");						
			driver=new FirefoxDriver();
		}
	}


	public void launchRemoteBrowser() throws MalformedURLException {

		String browser=ReadConfigurationFile.prop.getProperty("browser");
		switch(browser){

		case "chrome":
			capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.ANY);
			ChromeOptions options = new ChromeOptions();
			capabilities.merge(options);
			driver=new RemoteWebDriver(new URL(ReadConfigurationFile.prop.getProperty("RemoteUrl")),options);
			break;
		case "firefox":		
			capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.ANY);
			driver=new RemoteWebDriver(new URL(ReadConfigurationFile.prop.getProperty("RemoteUrl")),capabilities);
			break;
		default:
			capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(Platform.ANY);
			capabilities.setCapability("marionette",true);
			driver=new RemoteWebDriver(new URL(ReadConfigurationFile.prop.getProperty("RemoteUrl")),capabilities);
			break;
		}
	}

	public static String getChromeDriverPath() {
		String OS = System.getProperty("os.name");
		if (OS.contains("Window")) {
			return ReadConfigurationFile.prop.getProperty("ChromeDriverWin");
		} else if (OS.contains("Mac")) {
			return ReadConfigurationFile.prop.getProperty("ChromeDriverMac");
		} else {
			return ReadConfigurationFile.prop.getProperty("ChromeDriverLinux");
		}
	}

	public static String getFirefoxDriverPath() {
		String OS = System.getProperty("os.name");
		if (OS.contains("Window")) {
			return ReadConfigurationFile.prop.getProperty("GeckoDriverWin");
		} else if (OS.contains("Mac")) {
			return ReadConfigurationFile.prop.getProperty("GeckoDriverMac");
		} else {
			return ReadConfigurationFile.prop.getProperty("GeckoDriverLinux");
		}
	}

}