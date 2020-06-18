package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadConfigurationFile {

	private static final Logger log = LoggerFactory.getLogger(ReadConfigurationFile.class);

	//declare variable for config.properties
	public static Properties prop = new Properties(); 

	public ReadConfigurationFile() {
		//prop = new Properties();
		try {
			//take reference to the config.properties file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/com/config/config.properties");
			//load the config.properties file
			prop.load(fis);
			log.info("load the config properties file");
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