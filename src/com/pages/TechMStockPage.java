package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.base.BasePage;
import com.reusablecode.MethodsVariable;


public class TechMStockPage extends BasePage {

	public static String webTable = "table[class*='tl-dataTable']";
	public static String webTableRowCount = "table[class*='tl-dataTable']>tbody>tr";
	public static String webTableFirstColumn = "table[class*='tl-dataTable']>tbody>tr>td:nth-child(1)";
	public static String lastListElement = "div[class*='dataTables_paginate paging_simple_numbers']>ul>li:last-child";

	MethodsVariable methodsvariable;
	private static final Logger log = LoggerFactory.getLogger(TechMStockPage.class);

	//The title value to be verified in the TechMStockPageTest class
	public String getTitle() {
		log.info("get the page title");
		return driver.getTitle();
	}

	//client name to be verified after entering it into the table
	public boolean findClientName(String clientName) throws InterruptedException {
		try {
			List<String> names = new ArrayList<String>();
			driver.findElement(By.cssSelector(webTable));
			MethodsVariable.scrollDownBy(driver);
			List<WebElement> namesElements=driver.findElements(By.cssSelector(webTableFirstColumn)); 
			for(WebElement namesElement : namesElements) {		    
				names.add(namesElement.getText());
			}
			String liclass = driver.findElement(By.cssSelector(lastListElement)).getAttribute("class");

			while(!liclass.contains("disabled")) {
				WebElement nextButton = driver.findElement(By.cssSelector(lastListElement));
				MethodsVariable.javaScriptClick(driver,nextButton);

				namesElements=driver.findElements(By.cssSelector(webTableFirstColumn));				
				for(WebElement namesElement : namesElements) {		    
					names.add(namesElement.getText());
				}

				liclass = driver.findElement(By.cssSelector(lastListElement)).getAttribute("class");
			}
			log.info("trying to find the client name in the webTable column");
			for(String name : names) {
				if(name.trim().equals(clientName))					
					return true;
			}
			return false;
		}catch(NoSuchElementException e){
			return false;
		}
	}

}
