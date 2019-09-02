package com.gtplbank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath= "//input[@name= 'uid']")
	WebElement enterUserName;
	
	@FindBy(xpath="//input[@type= 'password']")
	WebElement enterPassword;
	
	@FindBy(xpath="//input[@type= 'submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//input[@type= 'reset']")
	WebElement resetButton;
	
	public void setUserName(String uname)
	{
		enterUserName.sendKeys(uname);
	}
	
	public void setPassword(String password)
	{
		enterPassword.sendKeys(password);
	}
	
	public void setLogin()
	{
		loginButton.click();
	}
	
	public void setReset()
	{
		resetButton.click();
	}
}
