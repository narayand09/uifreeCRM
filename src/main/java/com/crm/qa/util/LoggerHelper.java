package com.crm.qa.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;





public class LoggerHelper {
	
	private static boolean root=false;
	
	public static Logger getLogger(Class cls)
	{
		if(root)
		{
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("src\\main\\java\\com\\crm\\qa\\config\\log4j.properties"));
		root=true;
		return Logger.getLogger(cls);
	}

	public static void main(String args[])
	{
		Logger log = LoggerHelper.getLogger(LoggerHelper.class);
		log.info("Logger is configured");
	}
}
