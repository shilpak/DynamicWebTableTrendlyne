package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class TestData {

	//declare variable for testData.properties
	public static Properties properties;

	public TestData() {
		
		properties = new Properties();
		try {
			//take reference to the testData.properties file
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/com/config/testData.properties");
			//load the testData.properties file
			properties.load(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}


