package com.O_HRM.TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.O_HRM.Utilities.ReadConfig;
import com.O_HRM.pageObjectModel.LoginPage;

public class BaseClass {
	
	
	ReadConfig readconfig = new ReadConfig();
	
	public  WebDriver driver;
	public Logger logger;
	public String baseURL = readconfig.getApplication();
	public String username = readconfig.setUsername();
	public String password = readconfig.setPassword();
	public String br = readconfig.getBrowser();
	
	public LoginPage LP;
	
	@BeforeClass
	public void setup(String browser) {
		
		logger = Logger.getLogger("E-Commerce_OrangeHRM");
		PropertyConfigurator.configure("Log4j.properties");
	
		if(browser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
			driver = new ChromeDriver();
		}
		else if(browser.equals("ie")) {
			
			System.setProperty("webdriver.ie.driver",readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}
		else if(browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
		}
		
		logger.info("*******Launching Chrome Browser********");
		
		driver.get(baseURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		logger.info("********Application Launched***********");
		
		
}
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
	public void CaptureScreenshot(WebDriver driver, String Screenshotname) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File Destination = new File ("./Screenshots/"+ Screenshotname+ ".png");
		FileUtils.copyFile(source, Destination);
		System.out.println("Image Captured");
	}
	
	public String getRandomAlphabets() {
		
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String getRandomNumbers() {
		
		String generatedString = RandomStringUtils.randomNumeric(5);
		return generatedString;
	}
	
	
	

}
