package com.gtplbank.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gtplbank.pageObjects.LoginPage;

public class TC_UserLoginTest_001 extends TestBaseClass
{
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("GTPL Bank url is opended.");
		
		LoginPage loginPage= new LoginPage(driver);
		loginPage.setUserName(userName);
		logger.info("Username has been entered successfully into the username filed.");
		loginPage.setPassword(passWord);
		logger.info("Password has been entered successfully into the password filed.");
		loginPage.setLogin();
		logger.info("User has been successfully clicked on the Click button.");
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed: User successfully login to the application.");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Test Case failed: User cann't able to login to the application.");
		}
	}
}
