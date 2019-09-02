package com.gtplbank.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage 
{
	WebDriver ldriver;
	public AddNewCustomerPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//*[text()='New Customer']")
	WebElement addNewCustomer;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement enterCustName;
	
	@FindBy(xpath="//input[@name='rad1']")
	List<WebElement> selectGeneder;
	
	@FindBy(xpath="//input[@name= 'dob']")
	WebElement enterDOB;
	
	@FindBy(xpath="//td/textarea[@name= 'addr']")
	WebElement enterAddress;
	
	@FindBy(xpath="//input[@name= 'city']")
	WebElement enterCity;
	
	@FindBy(xpath="//input[@name= 'state']")
	WebElement enterState;
	
	@FindBy(xpath="//input[@name= 'pinno']")
	WebElement enterPin;
	
	@FindBy(xpath="//input[@name= 'telephoneno']")
	WebElement enterTelNumber;
	
	@FindBy(xpath="//input[@name= 'emailid']")
	WebElement enterEmail;
	
	@FindBy(xpath="//input[@name= 'sub']")
	WebElement submit;
	
	@FindBy(xpath="//input[@name= 'res']")
	WebElement reset;
	
	public void setEnterCustName(String custName)
	{
		enterCustName.sendKeys(custName);
	}
	
	public void setSelectGeneder()
	{
		boolean select= false;
		select= selectGeneder.get(0).isSelected();
		
		if(select= true)
		{
			selectGeneder.get(0).click();
		}
		else
		{
			selectGeneder.get(1).click();
		}
	}
	
	public void setEnterDOB(String dob)
	{
		enterDOB.sendKeys(dob);
	}
	
	public void setEnterAddress(String address)
	{
		enterAddress.sendKeys(address);
	}
	
	public void setEnterCity(String city)
	{
		enterCity.sendKeys(city);
	}
	
	public void setEnterState(String state)
	{
		enterState.sendKeys(state);
	}
	
	public void setEnterPin(String pin)
	{
		enterPin.sendKeys(pin);
	}
	
	public void setEnterTelNumber(String numb)
	{
		enterTelNumber.sendKeys(numb);
	}
	
	public void setEnterEmail(String email)
	{
		enterEmail.sendKeys(email);
	}
	
	public void setSubmit()
	{
		submit.click();
	}
	
	public void setReset()
	{
		reset.click();
	}
}
