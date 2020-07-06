package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationFileReader {

	private static final Logger log = LoggerFactory.getLogger(ConfigurationFileReader.class);

	private Properties prop = null;
	private String filepath = null;

	public ConfigurationFileReader(String filepath) { 
		this.filepath = filepath;
		readFile(this.filepath); 
	}

	private void readFile(String filepath) {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(filepath);
			prop.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("property file not found in the classpath");
		}

	}

	public String getProperty(String propertyName) {

		String value = prop.getProperty(propertyName);

		if (value == null) {
			log.warn("propertyName (" + propertyName + ") not found in property file (" + filepath + ")");
		}
		return value;

	}
}



/*
 * public class ConfigurationFileReader { 
 * private void readFile(){...} 
 * public void getProperty(String propertyNameToGet) {...} }
 */