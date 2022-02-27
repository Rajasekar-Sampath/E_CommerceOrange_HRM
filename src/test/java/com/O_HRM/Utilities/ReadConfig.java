package com.O_HRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	public Properties configProp;
	
	public ReadConfig()  {
		
		File src = new File("./Configuration/config.properties");
		
		try {
	
		FileInputStream configFileProp = new FileInputStream(src);
		
		configProp = new Properties();
		
		configProp.load(configFileProp);
		}catch(Exception e) {
			
			System.out.println("The catched Exception is :"+e.getMessage());
		}
		
	}
	
	public String getApplication() {
		
		String baseURL = configProp.getProperty("baseURL");
		return baseURL;
	}
	
	public String setUsername() {
		
		String username = configProp.getProperty("username");
		return username;
	}
	
	public String setPassword() {
		
		String password = configProp.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		
		String chromepath = configProp.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEpath() {
		
		String iepath = configProp.getProperty("iepath");
		return iepath;
	}
	
	public String getFirefoxpath() {
		
		String firefoxpath = configProp.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	
	

}
