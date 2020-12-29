package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.LoggerHelper;
import com.crm.qa.util.TestUtils;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	private final Logger log=LoggerHelper.getLogger(ContactsPageTest.class);
	String SheetName="Contacts";
	
	public ContactsPageTest()
	{
		super();
		log.info("ContactsPageTest constructor called");
	}

	
	@BeforeMethod
	public void setup()
	{
		initialization();
		contactPage=new ContactPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(reader.getUserName(),reader.getPassword());
		contactPage=homePage.clickOnContactLink();
		log.info(this.getClass()+"  Setup method is called..");
	}
	@Test(priority=1, enabled=true)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactPage.verifyContactsLabel(),"Contacts Label is missing");
		log.info("verifyContactsPageLabel method called called");
	}
	
	@Test(priority=2)
	public void selectContactsByNameTest()
	{
		contactPage.selectContactsByName("naveen automation");
		log.info("Contacts Name is selected");
	}
	
	@Test(priority=3)
	public void multipleContactsByNameTest()
	{
		contactPage.selectContactsByName("naveen automation");
		//contactPage.selectContactsByName("test test");
		log.info("Multiple Contacts Name is selected");
	}
	
	@Test(priority=4, dataProvider="getCRMTestData", enabled=true)
	public void createNewContactTest(String firstName, String lastName, String company)
	{
		contactPage.clickOnNewContactLink();
		boolean status = contactPage.createNewContact(firstName,lastName,company);
		
		Assert.assertTrue(status);
		log.info("Contact Creation done successfully for "+ firstName);
		
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object[][] data=TestUtils.getTestData(SheetName);
		log.info("Data read successfully from excel sheet");
		return data;
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("tearDown method is called");
	}
}
