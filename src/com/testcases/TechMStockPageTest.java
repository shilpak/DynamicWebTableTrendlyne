package com.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.TechMStockPage;
import com.util.TestUtil;


public class TechMStockPageTest extends TestBase{
	
	TechMStockPage techMstockpage;
	TestUtil testutil;
	
	public TechMStockPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		intialization();
		testutil=new TestUtil();
		techMstockpage=new TechMStockPage();
	}
	
	@Test(priority = 1)
	public void verifyPageTitle() {
		String pageTitle = this.techMstockpage.getTitle();
		Assert.assertEquals(pageTitle, "Tech Mahindra Ltd. - Disclosures under Insider Trades & Substantial Acquisition of Shares and Takeovers");
	}
	
	@Test(priority = 2)
	public void verifyClientNameIsPresent() throws InterruptedException {
		Boolean isNamePresent = this.techMstockpage.findClientName(prop.getProperty("name"));
		Assert.assertTrue(isNamePresent);
	}
	
	  @AfterTest
	  public void tearDown() throws Exception { 
	    driver.quit();
	      } 
	

}
