package com.estesfitnesshelp.model.services.propertymanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.estesfitnesshelp.model.business.exception.PropFileNotFoundException;

public class PropertyManager {
	
	private static Properties props;

	//Load the properties file so the properties are available for other tiers
	public static void loadProps(String propFileLocation) throws PropFileNotFoundException {
		props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("config/application.properties");
			props.load(fis);
			System.out.println("Properties loaded. Loaded from " + propFileLocation);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			System.out.println("Property file Not Found Exception");
			throw new PropFileNotFoundException("Properties File not found", fnfe);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Property File IOException");
			throw new PropFileNotFoundException("IOException Properties File", e);
		} finally {
			if (fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}
	
	//Call getProperty method to go to external properties file 
	//to check if val exists
	static public String getPropValue(String val){
		return props.getProperty(val);
	}
}
