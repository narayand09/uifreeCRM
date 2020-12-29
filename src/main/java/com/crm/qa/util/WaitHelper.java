package com.crm.qa.util;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	private WebDriver driver;
	private Logger log=LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver)
	{
		this.driver=driver;
		log.info("WaitHelper object created");
	}
	public void setImplicitWait(long timeout, TimeUnit unit)
	{
		log.info("Implicit wait has been set to  .. "+timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	private WebDriverWait getWait(int TimoutInSeconds, int PollingEveryMillSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver,TimoutInSeconds);
		wait.pollingEvery(Duration.ofMillis(PollingEveryMillSeconds));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}
	
	/**
	 * This will make sure Element is visible
	 * @param element
	 * @param TimoutInSeconds
	 * @param PollingEveryMillSeconds
	 */
	 
	
	public void WaitForElementVisibleWithPollingTime(WebElement element, int TimoutInSeconds,int PollingEveryMillSeconds)
	{
		log.info("Waiting for Element for "+element.toString() +"  for  "+TimoutInSeconds +"  seconds");
		WebDriverWait wait=getWait(TimoutInSeconds, PollingEveryMillSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("Element is visible now");
	}
	
	/**
	 * This will make sure Element is clickable
	 * @param element
	 * @param TimoutInSeconds
	 * @param PollingEveryMillSeconds
	 */
	
	public void WaitForElementClickable(WebElement element, int TimoutInSeconds,int PollingEveryMillSeconds)
	{
		log.info("Waiting for Element for "+element.toString() +"  for  "+TimoutInSeconds +"  seconds");
		WebDriverWait wait=new WebDriverWait(driver,TimoutInSeconds);	
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("Element is clickable now");
	}
	
	/**
	 * This will make sure element is invisible
	 * @param element
	 * @param TimoutInSeconds
	 * @return
	 */
	public boolean WaitForElementNotPresent(WebElement element, int TimoutInSeconds)
	{
		log.info("Waiting for Element for "+element.toString() +"  for  "+TimoutInSeconds +"  seconds");
		WebDriverWait wait=new WebDriverWait(driver,TimoutInSeconds);	
		boolean status=wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("Element is invisible now");
		return status;
	}
	
	
	/**
	 * This will wait for frame and switched to it
	 * @param element
	 * @param TimoutInSeconds
	 */
	public void WaitForframeToBeAvailableAndSwitchToIt(WebElement element, int TimoutInSeconds)
	{
		log.info("Waiting for Element for "+element.toString() +"  for  "+TimoutInSeconds +"  seconds");
		WebDriverWait wait=new WebDriverWait(driver,TimoutInSeconds);	
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("Frame is available now");
		
	}

	/**
	 * This method will give us Fluent wait object
	 * @param TimoutInSeconds
	 * @param PollingEveryMillSeconds
	 * @return
	 */
	private Wait<WebDriver> getFluentWait(int TimoutInSeconds,int PollingEveryMillSeconds)
	{
		Wait<WebDriver> fwait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(TimoutInSeconds))
				.pollingEvery(Duration.ofMillis(PollingEveryMillSeconds)).ignoring(NoSuchElementException.class);	
		return fwait;
	}
	
	public WebElement waitForElement(WebElement element,int TimoutInSeconds,int PollingEveryMillSeconds)
	{
		Wait<WebDriver> fwait = getFluentWait(TimoutInSeconds, PollingEveryMillSeconds);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void waitForElement(WebElement element,int timeOutInSeconds)
	{
		log.info("waiting for :"+element.toString()+" for "+timeOutInSeconds);
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info(element.toString()+ "  is visible now");
	}
	
	public void pageLoadTime(long timeout,TimeUnit unit)
	{
		log.info("Waiting Page to lod for  "+unit+ "  seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout,unit);
		log.info("Page is loaded");
	}

}
