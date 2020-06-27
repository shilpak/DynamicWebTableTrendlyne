package com.base;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
	
	
	public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		
		return webdriver.get();

    }
	
	public static void setWebDriver(WebDriver driver) {
		
		webdriver.set(driver);
		
	}

}



























//https://rationaleemotions.wordpress.com/2013/07/31/parallel-webdriver-executions-using-testng/