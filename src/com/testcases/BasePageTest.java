package com.testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.base.BasePage;



public class BasePageTest {

	private static final Logger log = LoggerFactory.getLogger(BasePageTest.class);

	/* This method will call the constructor from the BasePage class and 
	 * will load all the configuration and also invoke the browser url.
	 * TechMStockPageTest will be free from driver instance variable and
	 * as it has @BeforeTest annotation this test will execute before all test
	 */

	
	@BeforeMethod	
	public void setup() throws Exception {	
		log.info("****************************** Starting test case execution  *****************************************");			
	BasePage.intialization();
	}

	/* This method will call the closewindow method from basePage class
	 * and as it has @AfterTest annotation this test will execute after all the test
	 */

	@AfterMethod
	public void tearDown() {
		BasePage.closeWindow();
		log.info("****************************** Browser is closed *****************************************");
	}

}
