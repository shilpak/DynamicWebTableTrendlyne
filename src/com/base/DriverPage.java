package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverPage {

	//Declare the WebDriver
	public static WebDriver driver;
	BasePage base = new BasePage();

	public static void intialization() {
		String browserName=BasePage.prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(BasePage.prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public static void closeWindow() {
		driver.close();
	}
}