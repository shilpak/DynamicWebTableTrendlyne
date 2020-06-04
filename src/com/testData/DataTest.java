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
				FileInputStream file = new FileInputStream("C:\\Users\\Shilpa\\eclipse-workspace\\mavenjenkins\\dynamicWebTableStock\\src\\main\\java\\com\\config\\testData.properties");
				//load the testData.properties file
				properties.load(file);
				log.info("load the testdata properties file");
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
