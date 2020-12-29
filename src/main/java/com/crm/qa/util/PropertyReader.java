package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class PropertyReader  {
	private static FileInputStream file;
	public static Properties prop;

	public PropertyReader()
	{
		
		try {
			String filePath = ResourceHelper.getResourcePath("src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			file = new FileInputStream(new File(filePath));
			prop=new Properties();
			prop.load(file);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getImplicitWait() {
		return Integer.parseInt(prop.getProperty("implicitwait"));
		
	}

	public int getExplicitWait() {
		return Integer.parseInt(prop.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(prop.getProperty("pageloadtime"));
	}
	
	public int getPollingTime() {
		return Integer.parseInt(prop.getProperty("pollingtime"));
	}

	public String getBrowserType() {
		
		return prop.getProperty("browser");
	}
	
	public String getUrl() {
		if(System.getProperty("url")!=null)
		{
			return System.getProperty("url");
		}
		
		return prop.getProperty("url");
	}
	
	public String getUserName() {
		if(System.getProperty("userName")!=null)
		{
			return System.getProperty("userName");
		}
			return prop.getProperty("username");
		}
	
	public String getPassword() {
		if(System.getProperty("password")!=null)
		{
			return System.getProperty("password");
		}
		return prop.getProperty("password");
	}

	
}
