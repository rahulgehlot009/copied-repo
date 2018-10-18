package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//font[contains(text(),'User: Naveen K')]")
	@CacheLookup
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[text()='Contacts']")
	@CacheLookup
	WebElement contactLinks;
	
	@FindBy(xpath="//a[text()='Deals']")
	@CacheLookup
	WebElement dealsLinks;
	
	@FindBy(xpath="//a[text()='Tasks']")
	@CacheLookup
	WebElement tasksLinks;
	
	@FindBy(xpath="//a[text()='New Contact']")
	@CacheLookup
	WebElement newContactLinks;

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName()
	{
		return usernamelabel.isDisplayed();
	}
	public  ContactPage clickOnContactLink()
	{
		 contactLinks.click();
		 return new ContactPage();
	}
	public DeatelsPage clickOnDeatelsLink()
	{
		dealsLinks.click();
		return new DeatelsPage();
		
	}
	public TasksPage clickOnTasksLink()
	{
		tasksLinks.click();
		return new TasksPage();
		
	}	
	
	public NewContact clickOnNewContackLinks()
	{
		newContactLinks.click();
		return new NewContact();
	}
}
