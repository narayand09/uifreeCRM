package com.crm.qa.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.base.TestBase;

public class WebEventListener extends TestBase implements WebDriverEventListener{

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before accepting Alert");
		
	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After accepting Alert");
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigating to: "+url+ " ");
		
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("Navigated to: "+url+ " ");
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Navigated back ");
		
	}

	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Before find by element: "+element);
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("After find by element: "+element);
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking on element: "+element);
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on element: "+element);
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Going to switch on window: "+windowName);
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println("Switched on window: "+windowName+ " successfully");
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("---------Exception Occurred ------");
		System.out.println(throwable.getMessage());
		try {
			TestUtils.takeScreenShotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		System.out.println("Going to capture ScreenShot");
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		System.out.println("Screen shot captured successfully");
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		System.out.println("Going to getText");
		
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println("getTextcdone successfully");
		
	}

}