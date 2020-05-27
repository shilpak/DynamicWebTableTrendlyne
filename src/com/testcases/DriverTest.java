package com.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.base.DriverPage;

public class DriverTest {
	DriverPage driverpage = new DriverPage();

	@BeforeTest
	public void beforeTest() {		
		DriverPage.intialization();		
	}

	@AfterTest
	public void tearDown() {
		DriverPage.closeWindow();
	}
}
