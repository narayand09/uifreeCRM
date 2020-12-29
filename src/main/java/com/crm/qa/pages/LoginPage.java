package com.crm.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.LoggerHelper;


public class LoginPage extends TestBase {

	private final Logger log=LoggerHelper.getLogger(LoginPage.class);
	// Page Factory
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		log.info("LoginPage is initialized");
	}
	
	public String validateLoginPage()
	{
		log.info("Title of the page is .."+driver.getTitle());
		return driver.getTitle();
	}
	
	public HomePage login(String username, String pass)
	{
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();		
		return new HomePage();
		//return new HomePage();
	}
	
	
}
