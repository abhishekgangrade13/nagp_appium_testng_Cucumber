package com.nagp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

	public static String getConfigPropertyVal(String propertyName) {
		 String reportConfigPath = "";
		 try (InputStream input = new FileInputStream("src/test/resources/Configuration.properties")) {

	            Properties prop = new Properties();

	            // load a properties file
	            prop.load(input);
	            reportConfigPath = prop.getProperty(propertyName);
	           
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	 return reportConfigPath;
	 }

	public String getReportConfigPath(){
		String reportConfigPath = getConfigPropertyVal("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}
	 
	
}
