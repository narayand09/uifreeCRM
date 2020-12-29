package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.LoggerHelper;



public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	private final Logger log=LoggerHelper.getLogger(LoginPageTest.class);
	public LoginPageTest()
	{
		super();
		log.info("Super constructor is called");
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
		log.info("Initialization method is called");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("tearDown method is called");
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPage();
		Assert.assertEquals(title, "Cogmento CRM","Home Page Title not matched");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		homePage=loginPage.login(reader.getUserName(),reader.getPassword());
	}
}
