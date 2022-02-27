package com.O_HRM.pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddEmployee {
	
	public WebDriver ldriver;
	
	public AddEmployee(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver,this);
	}
	
	
	
	
	@FindBy(xpath = "//a[text()=\"Add Employee\"]")
	@CacheLookup
	WebElement addemp;
	
	@FindBy(xpath = "//input[@class='formInputText' and @name= 'firstName']")
	@CacheLookup
	WebElement txtfirstname;
	
	@FindBy(xpath = "//input[@class='formInputText' and @name= 'lastName']")
	@CacheLookup
	WebElement txtlastname;
	
	/*@FindBy(xpath = "//input[@class='formInputText' and @name= 'employeeId']")
	@CacheLookup
	WebElement  addEmp;*/
	
	@FindBy(xpath = "//input[@id='chkLogin' and @name= 'chkLogin']")
	@CacheLookup
	WebElement clkdetails;
	
	@FindBy(xpath = "//input[@class='formInputText' and @name= 'user_name']")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(xpath = "//input[@class='formInputText passwordRequired' and @name= 'user_password']")
	@CacheLookup
	WebElement txtpwd;
	
	@FindBy(xpath = "//input[@class='formInputText passwordRequired' and @name= 're_password']")
	@CacheLookup
	WebElement txtrepwd;
	
	@FindBy(xpath = "//select[@class='formInputText' and @name= 'status']")
	@CacheLookup
	WebElement status;
	
	@FindBy (xpath = "//input[@id='btnSave' and  @value= 'Save']")
	@CacheLookup
	WebElement clksave;
	
	
	
	
	public void Addemp() {
		
		addemp.click();
	}
	
	public void Txtfirstname(String txtFname) {
		
		txtfirstname.clear();
		txtfirstname.sendKeys(txtFname);
	}
	
	public void Txtlastname(String txtLname) {
		
		txtlastname.clear();
		txtlastname.sendKeys(txtLname);
	}
	
	/*public void TxtEID(String txtempid) {
		
		addEmp.sendKeys(txtempid);
	}*/
	
	public void Clickdetails() {
		
		clkdetails.click();
	}
	
	public void TxtUsername(String Uname) {
		
		txtusername.sendKeys(Uname);
	}
	
	public void Txtpwd(String Pwd) {
		
		txtpwd.sendKeys(Pwd);
	}

	public void Txtrepwd(String rePwd) {
		
		txtrepwd.sendKeys(rePwd);
	}
	
	public void selectStatus(String Status) {
		
		Select se  = new Select(status);
		se.selectByVisibleText(Status);
	}
	
	public void Clksave() {
		
		clksave.click();
	}
	
	
	
}
