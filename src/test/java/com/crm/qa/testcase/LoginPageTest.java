package com.crm.qa.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtile;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() throws Throwable{
		String title = loginPage.validateTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		TestUtile.takeScreenshotAtEndOfTest();
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() throws Throwable{
		boolean flag = loginPage.valiadteImage();
		Assert.assertTrue(flag);
		TestUtile.takeScreenshotAtEndOfTest();
	}
	
	@Test(priority=3)
	public void loginTest() throws Throwable{
		
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		TestUtile.takeScreenshotAtEndOfTest();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}

	


