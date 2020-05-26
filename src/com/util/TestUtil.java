package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.base.TestBase;

public class TestUtil extends TestBase {
	
	public static WebDriver driver;
	public static long Page_Load_TimeOut=20;
	public static long IMPLICIT_WAIT=10;
	
	public static void scrollDownBy(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
	}
	
	public static void javaScriptClick(WebDriver driver, WebElement element) throws InterruptedException{
		try {
			if (element.isEnabled() && element.isDisplayed()) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				//System.out.println("clicked");
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} 
	}
	
}

	