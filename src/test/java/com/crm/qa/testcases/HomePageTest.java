package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.LoggerHelper;

public class HomePageTest extends TestBase{

	private final Logger log=LoggerHelper.getLogger(HomePageTest.class);
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactsPage;
	public HomePageTest()
	{
		super();
		log.info("HomePageTest constructor called");
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
		contactsPage=new ContactPage();
		log.info("Initialization method is called");
		homePage=loginPage.login(reader.getUserName(),reader.getPassword());
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home Page Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		assertTrue(homePage.verifyUserName());
	}
	@Test(priority=3)
	public void verifyContactLinkTest() throws InterruptedException
	{
		
		contactsPage = homePage.clickOnContactLink();
		Thread.sleep(8000);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
