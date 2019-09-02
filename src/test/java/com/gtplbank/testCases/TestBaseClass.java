package com.gtplbank.testCases;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.gtplbank.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	
	ReadConfig readConfig= new ReadConfig();
	public String baseUrl=readConfig.getBaseUrl();
	public String userName=readConfig.getUserName();
	public String passWord=readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger= Logger.getLogger("gtplbanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup(); //will automatically import the chrome driver//System.getProperty("user.dir")-> project home directory
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();; //will automatically import the chrome driver//System.getProperty("user.dir")-> project home directory
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		if(br.equals("IE"))
		{
			WebDriverManager.iedriver().setup();; //will automatically import the chrome driver//System.getProperty("user.dir")-> project home directory
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
		if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();; //will automatically import the chrome driver//System.getProperty("user.dir")-> project home directory
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		driver.get(baseUrl);
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException// to Capture the Screen shot and Stored in the Target Folder
	{
		TakesScreenshot takeScreenshot= (TakesScreenshot) driver;
		File source= takeScreenshot.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Failuer Screenshot has been taken and stored.");
	}
	
	public static String randomeNum() { // Random Number Generator
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}
	
	public static String randomAlpha() {// Random Alphabet Genertor
		String generatedAlpha= RandomStringUtils.randomAlphabetic(5);
		return (generatedAlpha);
	}
	
	public void mouseHover(WebElement enterWebElement) // method to click on web element using mouse hover
	{
		Actions action= new Actions(driver);
		action.moveToElement(enterWebElement).click();
		action.perform();
	}
	
	public static String generateDOB() { // For Random Date of Birth Generate
        GregorianCalendar gc = new GregorianCalendar();
        int yyyy = randBetween(1950, 2000);
        gc.set(gc.YEAR, yyyy);
        int dd = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dd);
		String dob= gc.get(gc.DAY_OF_MONTH)+"-"+(gc.get(gc.MONTH) + 1)+"-"+gc.get(gc.YEAR);
        System.out.println(gc.get(gc.DAY_OF_MONTH)+"-"+(gc.get(gc.MONTH) + 1)+"-"+gc.get(gc.YEAR));
		return(dob);
}
	public static int randBetween(int start, int end) {// Sub method for DOB generator
        return start + (int)Math.round(Math.random() * (end - start));
    }
	
	
	public static String generateMobNum() {// Random 10 Digit Mobile Number Genrator
		String number = RandomStringUtils.randomNumeric(10);	
		return (number);
	}
	
	public static String generateEmail() { // Random Email Generator
		String email = RandomStringUtils.randomAlphabetic(5)+"@junk.com";	
		return (email);
	}
	
}
