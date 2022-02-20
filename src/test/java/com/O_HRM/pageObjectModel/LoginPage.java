package com.O_HRM.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//input[@name='txtUsername']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath = "//input[@name='txtPassword']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath  = "//input[@name='Submit']")
	@CacheLookup
	WebElement submit;
	
	
	
	
	public void txtusername(String uname) {
		
		username.sendKeys(uname);
	}
	
	public void txtpassword(String pwd) {
		
		password.sendKeys(pwd);
	}
	
	public void Submitbtn() {
		
		submit.click();
	}

}
