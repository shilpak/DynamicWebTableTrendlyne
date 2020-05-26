package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil extends TestBase{

	public BrowserUtil(){
		super();
	}

	public void intialization()
	{
		String browserName=prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver();

		}
		else if(browserName.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();

		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

	}
}