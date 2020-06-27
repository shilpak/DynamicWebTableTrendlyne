package com.testcases;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.TechMStockPage;
import com.testData.DataTest;

public class TechMStockPageTest extends BasePageTest {
	
	private static final Logger log = LoggerFactory.getLogger(TechMStockPageTest.class);
	
	//Instantiate TechMStockPage and TestData class object
	//TechMStockPage techMstockpage = new TechMStockPage();
	DataTest datatest = new DataTest();
	TechMStockPage techMstockapge  = new TechMStockPage();

	@Test(priority = 1)
	public void verifyPageTitle() {
		String pageTitle = this.techMstockapge.getTitle();
		log.info("TechM page title is --->" + pageTitle);
		Assert.assertEquals(pageTitle, "Tech Mahindra Ltd. - Disclosures under Insider Trades & Substantial Acquisition of Shares and Takeovers");
		log.info("****************************** ending verifyPageTitle test case *****************************************");
	}
	
	@Test(priority = 2)
	public void verifyClientNameIsPresent() throws InterruptedException {
		log.info("clientName present in the webTable --->" + DataTest.properties.getProperty("name"));
		Boolean isNamePresent = this.techMstockapge.findClientName(DataTest.properties.getProperty("name"));
		Assert.assertTrue(isNamePresent);
		log.info("****************************** ending verifyClientNameIsPresent test case *****************************************");
		
	}
	

	
}
