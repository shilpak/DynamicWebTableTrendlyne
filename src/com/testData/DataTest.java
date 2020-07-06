package com.testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DataTest {
	private static final Logger log = LoggerFactory.getLogger(DataTest.class);
	//declare variable for testData.properties
	public static Properties properties;

	public DataTest() {

		properties = new Properties();
		try {
			//take reference to the testData.properties file
			FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\config\\testData.properties");
			//load the testData.properties file
			properties.load(file);
			log.info("load the testdata properties file");
		} 
		catch (FileNotFoundException e) {
			log.error("file not found "+ e.getStackTrace());
		}
		catch(Exception e)
		{
			log.error("exception check" + e.getStackTrace());
		}
	}

}
