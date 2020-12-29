package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.LoggerHelper;
import com.crm.qa.util.PropertyReader;
import com.crm.qa.util.ResourceHelper;
import com.crm.qa.util.WaitHelper;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	static WebEventListener eventListener;
	public static PropertyReader reader;
	private static Logger log= LoggerHelper.getLogger(TestBase.class);
	
	public TestBase()
	{
		try {
			reader=new PropertyReader();
			/*prop=new Properties();
			FileInputStream fis=new FileInputStream(ResourceHelper.getResourcePath("src\\main\\java\\com\\crm\\qa\\config\\config.properties"));
			prop.load(fis);*/
			log.info("Properties file loaded successfully");
		}catch(Exception e)
		{
			log.info("Unable to load Properties file");
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browserName=reader.getBrowserType();
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ResourceHelper.getResourcePath("Drivers\\chromedriver.exe"));
			driver=new ChromeDriver();
			log.info("Chromer Browser Propery set up and launched successfully");
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("Drivers\\geckodriver.exe"));
			driver=new FirefoxDriver();
			log.info("firefox Browser Propery set up and launched successfully");
			
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(reader.getPageLoadTime(), TimeUnit.SECONDS);
		driver.get(reader.getUrl());
		
		log.info("Driver navigated to..."+reader.getUrl());
	}

}
