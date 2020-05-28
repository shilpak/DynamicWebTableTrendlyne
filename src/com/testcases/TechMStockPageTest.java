
package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.TechMStockPage;
import com.util.TestData;

public class TechMStockPageTest extends BasePageTest {

	//Instantiate TechMStockPage and TestData class object
	TechMStockPage techMstockpage = new TechMStockPage();
	TestData testdata = new TestData();

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
	
}
