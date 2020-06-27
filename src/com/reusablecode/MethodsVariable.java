package com.reusablecode;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MethodsVariable {

	public static long Page_Load_TimeOut=40;
	public static long IMPLICIT_WAIT=30;
	
	//method to scrolldown the window
	public static void scrollDownBy(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
	}
	
	//method to click the element using javascriptExecutor
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
