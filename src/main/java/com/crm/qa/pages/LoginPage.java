package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtile;

public class LoginPage extends TestBase {
	
	//page factory or object reproestry
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateTitle()
	{
		return driver.getTitle();
	}
	public boolean valiadteImage()
	{
		return crmLogo.isDisplayed();
	}
	public HomePage login(String un,String pw) throws Throwable
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		Thread.sleep(1000);
		loginBtn.click();
		return new HomePage();
	}

}
