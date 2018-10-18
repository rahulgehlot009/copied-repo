package com.crm.qa.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.DeatelsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContact;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtile;

import junit.framework.Assert;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtile testUtile;
	ContactPage contactPage;
	DeatelsPage deatelsLinks;
	TasksPage taskPage;
	NewContact newContact;
	public HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp() throws Throwable
	{
		testUtile= new TestUtile();
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyUserTitelTest() throws Throwable
	{
		homePage=new HomePage();
		String titel=homePage.verifyHomePageTitle();
		Assert.assertEquals(titel, "CRMPRO");
		testUtile.takeScreenshotAtEndOfTest();
	}
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		homePage=new HomePage();
		testUtile.switchToFrame();
		boolean username=homePage.verifyCorrectUserName();
		Assert.assertTrue(username);
	}
	@Test(priority=3)
	public void clickOnContactPageLink()
	{
		testUtile.switchToFrame();
		contactPage=homePage.clickOnContactLink();
	}
	@Test(priority=4)
	public void clickOnDeatelsLinkTest()
	{
		testUtile.switchToFrame();
		deatelsLinks=homePage.clickOnDeatelsLink();
	}
	@Test(priority=4)
	public void clickOnTasksLinkTest()
	{
		testUtile.switchToFrame();
		taskPage=homePage.clickOnTasksLink();
	}
	@Test(priority=5)
	public void clickOnNewContackLinksTest()
	{
		testUtile.switchToFrame();
		testUtile.mouseOver(driver.findElement(By.xpath("//font[contains(text(),'User: Naveen K')]")));
		newContact=homePage.clickOnNewContackLinks();
	}
	@AfterMethod
	public void tearDown(){
	    driver.quit();
	}

	
}
