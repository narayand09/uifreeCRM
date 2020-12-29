package com.crm.qa.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import com.crm.qa.util.ActionsHelper;
import com.crm.qa.util.LoggerHelper;
import com.crm.qa.util.WaitHelper;

public class ContactPage extends TestBase{

	WaitHelper wait;
	ActionsHelper actionHelper;
	private final Logger log=LoggerHelper.getLogger(ContactPage.class);
	
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[text()='Show Filters']")
	WebElement showFilterBtn;
	
	@FindBy(xpath="//button[text()='New']")
	WebElement showNewBtn;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//*[@name='company']")
	WebElement company;
	
	@FindBy(xpath="//*[text()='Save']")
	WebElement saveBtn;
	
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
		actionHelper=new ActionsHelper();
		wait=new WaitHelper(driver);
	}
	
	public boolean verifyContactsLabel()
	{
		
		wait.WaitForElementClickable(contactsLabel, reader.getExplicitWait(), reader.getPollingTime());
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String cName)
	{
		actionHelper.mouseOverElement(showFilterBtn);
		try {
			driver.findElement(By.xpath("//a[text()='"+cName+"']/parent::td/following-sibling::td[5]")).click();
			log.info(cName+" contact is found and checked");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.info(cName+" contact is not found");
		}
		// //a[text()='test test']/parent::td/following-sibling::td[5]
	}
	
	public void clickOnNewContactLink()
	{
		showNewBtn.click();
		driver.navigate().refresh();
	}
	
	public boolean createNewContact(String fName, String lName, String cName)
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		//company.sendKeys(cName);
		saveBtn.click();
		WebElement ele=wait.waitForElement(driver.findElement(By.xpath("//*[text()='"+fName+" "+lName+"']")),reader.getExplicitWait(),reader.getPollingTime());
		return ele.isDisplayed();
		
		// //*[text()='test test']
	}
}
