package com.testcases;


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
	public void ValidateHomePageTest() {
		this.techMstockpage.validateTitle();
	}
	
	@Test(priority = 2)
	public void ValidateTotalnamesAndCount() throws InterruptedException {
		this.techMstockpage.printFirstColumnData();
	}
	
	  @AfterTest
	  public void tearDown() throws Exception { 
	    driver.quit();
	      } 
	

}
