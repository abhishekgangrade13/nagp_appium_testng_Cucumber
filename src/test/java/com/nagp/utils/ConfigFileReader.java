// '##################################################################################################################################
// 'Script Name      : ConfigFileReader
// 'Description      : utils file to read configuration properties file
// 'Application      : in.workindia.nileshdungarwal.workindiaandroid
// 'Created On       : 15-11-2023
// 'Updated On       : NA
// 'Created By       : Abhishek Gangrade
// '###################################################################################################################################


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
	
}
