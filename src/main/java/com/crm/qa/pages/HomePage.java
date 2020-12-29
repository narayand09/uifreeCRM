package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.ActionsHelper;

public class HomePage extends TestBase{

	
	@FindBy(xpath="//a[text()='Free account']/parent::span/parent::div/child::span[1]")
	WebElement nameLabel;
	
	@FindBy(xpath="//a[@href='/contacts']/child::i")
	WebElement contactsIcon;
	
	@FindBy(xpath="//a[@href='/deals']/child::i")
	WebElement dealsIcon;
	
	@FindBy(xpath="//a[@href='/tasks']/child::i")
	WebElement tasksIcon;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserName()
	{
		return nameLabel.isDisplayed();
	}
	
	public ContactPage clickOnContactLink()
	{
		contactsIcon.click();
		return new ContactPage();
	}
	
	
	
	public DealPage clickOnDealLink()
	{
		dealsIcon.click();
		return new DealPage();
	}
	
	public TaskPage clickOnTaskLink()
	{
		tasksIcon.click();
		return new TaskPage();
	}
}
