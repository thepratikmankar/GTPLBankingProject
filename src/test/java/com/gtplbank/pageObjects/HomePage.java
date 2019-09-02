package com.gtplbank.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver ldriver;
	public HomePage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[text()= 'New Customer']")
	WebElement addNewCustomer;
	
	@FindBy(xpath= "//*[text()= 'Edit Customer']")
	WebElement editCustomer;
	
	@FindBy(xpath="//*[text()= 'Delete Customer']")
	WebElement deleteCustomer;
	
	@FindBy(xpath= "//a[contains(@href, 'addAccount.php')]")
	WebElement newAccount;
	
	@FindBy(xpath= "//*[text()= 'Edit Account'] ")
	WebElement editAccount;
	
	@FindBy(xpath= "//*[text()= 'Delete Account'] ")
	WebElement deleteAccount;
	
	@FindBy(xpath= "//*[text()= 'Mini Statement']")
	WebElement miniStatement;
	
	@FindBy(xpath= "//*[text()= 'Customised Statement']")
	WebElement customizeStatement;
	
	@FindBy(xpath= "//*[text()= 'Log out']")
	WebElement logOut;
	
	public void setAddNewCustomer()
	{
		addNewCustomer.click();
	}
	
	public void setEditCustomer()
	{
		editCustomer.click();
	}
	
	public void setDeleteCustomer()
	{
		deleteCustomer.click();
	}
	
	public void setNewAccount()
	{
		JavascriptExecutor ex = (JavascriptExecutor)ldriver;
		ex.executeScript("arguments[0].click();", newAccount);
	}
	
	public void setEditAccount()
	{
		editAccount.click();
	}
	
	public void setDeleteAccount()
	{
		deleteAccount.click();
	}
	
	public void setMiniStatement()
	{
		JavascriptExecutor ex = (JavascriptExecutor)ldriver;
		ex.executeScript("arguments[0].click();", miniStatement);
	}
	
	public void setCustomizeStatement()
	{
		customizeStatement.click();;
	}
	
	public void setLogOut()
	{
		logOut.click();
	}
}
