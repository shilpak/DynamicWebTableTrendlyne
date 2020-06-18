package com.testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.base.BasePage;
import com.base.ReadConfigurationFile;
import com.base.RemoteConfiguration;

public class BasePageTest {

	private static final Logger log = LoggerFactory.getLogger(BasePageTest.class);

	/* This method will call the constructor from the BasePage class and 
	 * will load all the configuration and also invoke the browser url.
	 * TechMStockPageTest will be free from driver instance variable and
	 * as it has @BeforeTest annotation this test will execute before all test
	 */
	public BasePage page;

	@BeforeTest
	public void setup() throws Exception {	
		log.info("****************************** Starting test case execution  *****************************************");		
		//new ReadConfigurationFile();		
		BasePage.intialization();
		new BasePage();

	}
	
/*	public void createpage() {
		page = new BasePage();
	}
	
	public BasePage getPage() {
		return page;
	}*/

	/* This method will call the closewindow method from basePage class
	 * and as it has @AfterTest annotation this test will execute after all the test
	 */

	@AfterTest
	public void tearDown() {
		BasePage.closeWindow();
		log.info("****************************** Browser is closed *****************************************");
	}

	@BeforeSuite
	public void beforeSuite() {

		if(ReadConfigurationFile.prop.getProperty("RunMode").equalsIgnoreCase("Remote")) {
			RemoteConfiguration.remoteStartUp();
		}
	}

	@BeforeSuite
	public void afterSuite() {

		if(ReadConfigurationFile.prop.getProperty("RunMode").equalsIgnoreCase("Remote")) {
			RemoteConfiguration.remoteShutDown();
		}
	}
}
