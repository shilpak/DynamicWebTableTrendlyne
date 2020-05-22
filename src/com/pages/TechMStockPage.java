package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.base.TestBase;
import com.util.TestUtil;
import com.util.LocatorsPage;

public class TechMStockPage extends TestBase {

	static Properties prop;
	TestUtil testutil;
	LocatorsPage locators;

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean findClientName(String clientName) throws InterruptedException {
		try {
			List<String> names = new ArrayList<String>();
			driver.findElement(By.cssSelector(LocatorsPage.webTable));
			TestUtil.scrollDownBy(driver);
			List<WebElement> namesElements=driver.findElements(By.cssSelector(LocatorsPage.webTableFirstColumn)); 

			for(WebElement namesElement : namesElements) {		    
				names.add(namesElement.getText());
			}
			String liclass = driver.findElement(By.cssSelector(LocatorsPage.lastListElement)).getAttribute("class");

			while(!liclass.contains("disabled")) {
				WebElement nextButton = driver.findElement(By.cssSelector(LocatorsPage.lastListElement));
				TestUtil.javaScriptClick(driver,nextButton);

				namesElements=driver.findElements(By.cssSelector(LocatorsPage.webTableFirstColumn));				
				for(WebElement namesElement : namesElements) {		    
					names.add(namesElement.getText());
				}

				liclass = driver.findElement(By.cssSelector(LocatorsPage.lastListElement)).getAttribute("class");
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
