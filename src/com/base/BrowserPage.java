package com.base;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.exceptions.MissingConfigPropertyException;

/**
 * @author Shilpa BrowserPage class is used to start the browsers based on the
 *         values given in the property file. USer can run the test on chrome
 *         and firefox browser. 
 */

public class BrowserPage {

	private static final Logger log = LoggerFactory.getLogger(BrowserPage.class);
	// Declare the WebDriver
	public static WebDriver driver;
	static String workingdir = System.getProperty("user.dir");
	static String filepath = workingdir + "/src/com/config/config.properties";
	public static ConfigurationFileReader readconfig = new ConfigurationFileReader(filepath);
	static String browserName = System.getProperty("browser.type");
	static String defaultBrowser = readconfig.getProperty("DefaultLocalBrowser");
	public static DesiredCapabilities capability;


	// method to launchbrowser wit the browsername mention in the config file

	public static void launchLocalBrowser() throws Exception {		
		browserConfig();
		if (browserName.equalsIgnoreCase("chrome")) {
			log.info("launch chrome browser");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			System.setProperty("webdriver.chrome.driver", readconfig.getProperty("ChromeDriver"));

			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			log.info("launch firefox browser");
			System.setProperty("webdriver.gecko.driver", readconfig.getProperty("GeckoDriver"));
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			driver = new FirefoxDriver();
		}

	}

	public static void launchRemoteBrowser() throws MalformedURLException, UnknownHostException {
		browserConfig();
		String host = System.getProperty("browser.host");
		String ipAddress = InetAddress.getLocalHost().getHostAddress();
		if(host.equalsIgnoreCase("local") || host.equalsIgnoreCase("grid"))
		switch (defaultBrowser) {
		case "chrome":
			capability = DesiredCapabilities.chrome();
			capability.setBrowserName("chrome");
			capability.setPlatform(Platform.ANY);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.merge(capability);
			driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), chromeOptions);

			break;
			
		case "firefox":
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			capability.setCapability("marionette", true);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.merge(capability);
			driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), firefoxOptions);
			break;
			
		default:
			capability = DesiredCapabilities.firefox();
			capability.setBrowserName("firefox");
			capability.setPlatform(Platform.ANY);
			driver = new RemoteWebDriver(new URL("http://"+ipAddress+":4444/wd/hub"), capability);
			break;

		}
	}
	public static void browserConfig() {
		if (browserName.equals("")) {
			log.warn("The System Property browser.type was not set.  Defaulting to {}", defaultBrowser);
			if (defaultBrowser.equals("")) {
				log.error("Assuming default local browser but 'DefaultLocalBrowser' was "
						+ "not set in config.properties.  Set config and retry.");
				throw new MissingConfigPropertyException("Missing 'DefaultLocalBrowser' property.");
			}
			browserName = defaultBrowser;
		}
	}
}
