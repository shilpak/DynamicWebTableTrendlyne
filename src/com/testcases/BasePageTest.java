package com.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.base.BasePage;


public class BasePageTest {
	
	/* This method will call the constructor from the BasePage class and 
	 * will load all the configuration and also invoke the browser url.
	 * TechMStockPageTest will be free from driver instance variable and
	 * as it has @BeforeTest annotation this test will execute before all test
	 */

	@BeforeTest
	public void beforeTest() throws Exception {			
		new BasePage();
	}
	
	/* This method will call the closewindow method from basePage class
	 * and as it has @AfterTest annotation this test will execute after all the test
	 */
	
	@AfterTest
	public void tearDown() {
		BasePage.closeWindow();
	}
}
