package com.gtplbank.testCases;

import java.io.IOException;
import org.testng.annotations.Test;

import com.gtplbank.pageObjects.AddNewCustomerPage;
import com.gtplbank.pageObjects.HomePage;

public class TC_AddNewCustomer_003 extends TestBaseClass // This test case is for Adding a New Customer to the Application.
{
	HomePage home;
	AddNewCustomerPage newCust;
	
	@Test
	public void verifyAddNewCust() throws IOException, InterruptedException
	{
		TC_UserLoginTest_001 userLogin= new TC_UserLoginTest_001();
		userLogin.loginTest();
		
		home = new HomePage(driver);
		logger.info(driver.getTitle());
		newCust= new AddNewCustomerPage(driver);
		
		home.setAddNewCustomer();
		logger.info("User has navigated to the Add New Customer Page");
		
		newCust.setEnterCustName("Test"+ " "+ "Tester"+randomAlpha());
		logger.info("Step 1: Customer Name is entered succesfully.");
		
		newCust.setEnterDOB(generateDOB());
		logger.info("Step 2: Customer DOB is generated & entered succesfully.");
		
		newCust.setSelectGeneder();
		logger.info("Step 3: Customer gender is selected succesfully.");
		
		newCust.setEnterAddress("Plot No"+" "+randomeNum()+", Test Nagar");
		logger.info("Step 4: Customer Address Line 1 is generated & entered succesfully.");
		
		newCust.setEnterCity("Testerpur");
		logger.info("Step 5: Customer City is entered succesfully.");
		
		newCust.setEnterState("Testrashtra");
		logger.info("Step 6: Customer State is entered succesfully.");
		
		newCust.setEnterPin("440009");
		logger.info("Step 7: Customer Pin Code is entered succesfully.");
		
		newCust.setEnterTelNumber(generateMobNum());
		logger.info("Step 8: Customer Mobile Number is generated & entered succesfully.");
		
		newCust.setEnterEmail(generateEmail());
		logger.info("Step 9: Customer Email is generated & entered succesfully.");
		
		newCust.setSubmit();
		logger.info("Step 10: Click on Subimt Button.");
		
	}
}
