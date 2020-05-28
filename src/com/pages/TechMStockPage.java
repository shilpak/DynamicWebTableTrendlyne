package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.base.BasePage;
import com.util.TestUtil;

public class TechMStockPage extends BasePage {
	
	public static String webTable = "table[class*='tl-dataTable']";
	public static String webTableRowCount = "table[class*='tl-dataTable']>tbody>tr";
	public static String webTableFirstColumn = "table[class*='tl-dataTable']>tbody>tr>td:nth-child(1)";
	public static String lastListElement = "div[class*='dataTables_paginate paging_simple_numbers']>ul>li:last-child";

	TestUtil testutil;
	
	//The title value to be verified in the TechMStockPageTest class
	public String getTitle() {
		return driver.getTitle();
	}

	//client name to be verified after entering it into the table
	public boolean findClientName(String clientName) throws InterruptedException {
		try {
			List<String> names = new ArrayList<String>();
			driver.findElement(By.cssSelector(webTable));
			TestUtil.scrollDownBy(driver);
			List<WebElement> namesElements=driver.findElements(By.cssSelector(webTableFirstColumn)); 

			for(WebElement namesElement : namesElements) {		    
				names.add(namesElement.getText());
			}
			String liclass = driver.findElement(By.cssSelector(lastListElement)).getAttribute("class");

			while(!liclass.contains("disabled")) {
				WebElement nextButton = driver.findElement(By.cssSelector(lastListElement));
				TestUtil.javaScriptClick(driver,nextButton);

				namesElements=driver.findElements(By.cssSelector(webTableFirstColumn));				
				for(WebElement namesElement : namesElements) {		    
					names.add(namesElement.getText());
				}

				liclass = driver.findElement(By.cssSelector(lastListElement)).getAttribute("class");
			}
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
