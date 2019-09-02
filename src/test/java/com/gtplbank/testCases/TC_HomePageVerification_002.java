package com.gtplbank.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gtplbank.pageObjects.HomePage;

public class TC_HomePageVerification_002 extends TestBaseClass
{
	HomePage homePage;
	@Test
	public void verfiyHomePage() throws IOException, InterruptedException
	{
		TC_UserLoginTest_001 userLogin= new TC_UserLoginTest_001();
		userLogin.loginTest();
		homePage= new HomePage(driver);
		logger.info(driver.getTitle());
		
		homePage.setNewAccount();
		    if(driver.getTitle().equals("Gtpl bank add new account"))
			{
				Assert.assertTrue(true);
				logger.info("Test Case Passed: User is able to navigate to the New Account page.");
			}
			else
			{
				captureScreen(driver, "VerifyNewAccount");
				Assert.assertTrue(false);
				logger.info("Test Case failed: User cann't able to navigate to the New Account page.");
			}
	
		
		homePage.setEditAccount();
		if(driver.getTitle().equals("GTPL Edit Account Page"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed: User is able to navigate to the Edit Account page.");
		}
		else
		{
			captureScreen(driver, "VerifyEditAccount");
			Assert.assertTrue(false);
			logger.info("Test Case failed: User cann't able to navigate to the Edit Account page.");
		}
	
		homePage.setDeleteAccount();
		
		if(driver.getTitle().equals("GTPL Bank Delete Account Page"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed: User is able to navigate to the Delete Account page.");
		}
		else
		{
			captureScreen(driver, "VerifyDeleteAccount");
			Assert.assertTrue(false);
			logger.info("Test Case failed: User cann't able to navigate to the Delete Account page.");
		}
	
		homePage.setMiniStatement();
		
		logger.info("Successfully click on the Mini Statement option.");
		if(driver.getTitle().equals("GTPL Bank Mini Statement Page"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed: User is able to navigate to the Mini Statement page.");
		}
		else
		{
			captureScreen(driver, "VerifyMiniStatement");
			Assert.assertTrue(false);
			logger.info("Test Case failed: User cann't able to navigate to the Mini Statement page.");
		}
		

		homePage.setCustomizeStatement();
		if(driver.getTitle().equals("GTPL Bank Statement Page"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case Passed: User is able to navigate to the Customized Statement page.");
		}
		else
		{
			captureScreen(driver, "VerifyCustomizeStatement");
			Assert.assertTrue(false);
			logger.info("Test Case failed: User cann't able to navigate to the Customized Statement page.");
		}
		homePage.setLogOut();
		logger.info("Successfully click on the Logout button.");
		driver.switchTo().alert().accept();//close logout alert
		logger.info("Test Case Passed: User Successfully logged out.");
		
	}

}
 