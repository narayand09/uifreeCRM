package com.crm.qa.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class ActionsHelper extends TestBase{

	
	private Logger log=LoggerHelper.getLogger(ActionsHelper.class);
	Actions action;
	public ActionsHelper()
	{
		action =new Actions(driver);
		log.info("ActionsHelper constructor called");
	}
	
	public void mouseOverElement(WebElement ele)
	{
		action.moveToElement(ele).build().perform();
		log.info("Mouse over to "+ ele+"  performed successfully");
	}
}
