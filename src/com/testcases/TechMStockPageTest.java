package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.TechMStockPage;
import com.util.BrowserUtil;
import com.util.TestData;
import com.util.TestUtil;

public class TechMStockPageTest extends TestBase{
	
	TechMStockPage techMstockpage;
	TestUtil testutil;
	TestData testdata;
	BrowserUtil browserUtil;
	
	public TechMStockPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		BrowserUtil browserUtil = new BrowserUtil();
		browserUtil.intialization();
		testutil=new TestUtil();
		techMstockpage=new TechMStockPage();
		testdata = new TestData();
	}
	
	@Test(priority = 1)
	public void verifyPageTitle() {
		String pageTitle = this.techMstockpage.getTitle();
		Assert.assertEquals(pageTitle, "Tech Mahindra Ltd. - Disclosures under Insider Trades & Substantial Acquisition of Shares and Takeovers");
	}
	
	@Test(priority = 2)
	public void verifyClientNameIsPresent() throws InterruptedException {
		Boolean isNamePresent = this.techMstockpage.findClientName(TestData.properties.getProperty("name"));
		Assert.assertTrue(isNamePresent);
	}
	
	  @AfterTest
	  public void tearDown() throws Exception { 
	    driver.quit();
	      } 
	

}
