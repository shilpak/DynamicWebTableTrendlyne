package com.reusablecode;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MethodsVariable {

	public static long Page_Load_TimeOut=20;
	public static long IMPLICIT_WAIT=10;
	private static final Logger log = LoggerFactory.getLogger(MethodsVariable.class);

	//method to scrolldown the window
	public static void scrollDownBy(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
	}

	//method to click the element using javascriptExecutor
	public static void javaScriptClick(WebDriver driver, WebElement element) throws InterruptedException {

		try {
			if (element.isEnabled() && element.isDisplayed()) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

			} else {
				log.error("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			log.error("Element is not attached to the page document "+ e.getStackTrace());
		} 
	}

}
