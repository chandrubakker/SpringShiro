package com.sorcererpaws.SpringShiro.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class SampleProps {

	String result = "";
	InputStream inputStream;
	
	public String getPropValues() throws IOException {
		 
		try {
			Properties prop = new Properties();
			String propFileName = "application.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			String user = prop.getProperty("jdbc.url");
			String company1 = prop.getProperty("jdbc.username");
			String company2 = prop.getProperty("jdbc.password");
			String company3 = System.getenv("PATH");
 
			result = "Company List = " + company1 + ", " + company2 + ", " + company3;
			System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		try {
			new SampleProps().getPropValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
