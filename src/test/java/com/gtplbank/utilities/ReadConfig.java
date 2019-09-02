package com.gtplbank.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	private Properties properties;
	private final String propertyFilePath= "ConfigurationFiles//defaultconfig.properties";
	
	public ReadConfig() 
	{
		BufferedReader reader;
		
		try 
		{
			reader= new BufferedReader(new FileReader(propertyFilePath));
			properties= new Properties();
			try 
			{
				properties.load(reader);
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getBaseUrl()
	{
		String baseUrl= properties.getProperty("system.test.baseUrl");
		System.out.println(properties.getProperty("system.test.baseUrl"));
		if(baseUrl != null) return baseUrl;
		else throw new RuntimeException("Base url of the application is not mentioned in the default properties file");
	}
	
	public String getUserName()
	{
		String userName= properties.getProperty("system.test.userName");
		if(userName!= null) return userName;
		else throw new RuntimeException("Username of the application is not mentioned in the default properties file");
	}
	
	public String getPassword()
	{
		String password= properties.getProperty("system.test.passWord");
		if(password!= null) return password;
		else throw new RuntimeException("Password of the application is not mentioned in the default properties file");
	}
	
	public String getImplicitWait()
	{
		String implicitlyWait= properties.getProperty("system.test.implicitlyWait");
		if(implicitlyWait!= null) return implicitlyWait;
		else throw new RuntimeException("ImplicitlyWait of the application is not mentioned in the default properties file");
	}
	
//	 public static void main (String []args)
//	 {
//		 ReadConfig rc= new ReadConfig();
//		 rc.getBaseUrl();
//	 }
}
