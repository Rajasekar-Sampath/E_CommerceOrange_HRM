package com.O_HRM.pageObjectModel;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class L_Reports {
	
	public WebDriver ldriver;
	
	public L_Reports(WebDriver rdriver) {
		
		ldriver = rdriver;
		
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//a[text()=\"Reports\" and @id='menu_leave_Reports']")
	@CacheLookup
	WebElement reports;
	
	@FindBy(xpath = "//a[text()=\"Reports\" and @id='menu_leave_Reports']//following::li//child::a[@id='menu_leave_viewLeaveBalanceReport']")
	@CacheLookup
	WebElement leaveEntitle ;
	
	@FindBy(xpath = "//select[@name='leave_balance[report_type]']")
	@CacheLookup
	WebElement slcgenerate;
	
	@FindBy(xpath = "//input[@type='checkbox' and @name = 'leave_balance[include_terminated]']")
	@CacheLookup
	WebElement clkbox;
	
	@FindBy(xpath = "//input[@id='viewBtn' and @value = 'View']")
	@CacheLookup
	WebElement viewbtn  ;
	
	@FindBy(xpath = "//table[@class='table nosort']//following-sibling::tbody//child::tr/td[1]")
	@CacheLookup
	List <WebElement> tables ;
	
	@FindBy(xpath = "//table[@class ='table nosort']//following::tbody//child::tr//td[1]")
	@CacheLookup
	List <WebElement> tablestwo ;
	
	
	
	public void report_LeaveEntitle() {
		
		Actions act = new Actions(ldriver);
		
		act.moveToElement(reports).moveToElement(leaveEntitle).click().build().perform();
	}
	
	public void scltGenerate(String text) {
		
		Select se = new Select(slcgenerate);
		se.selectByVisibleText(text); //Leave Type
	}
	
	public void clkCheckBox() {
		
		clkbox.click();
	}
	
	public void clkViewbtn() {
		
		viewbtn.click();
		
	}
	
	public int getTableRows() {
		
		return tables.size();
		
	}

	public void findWanted() {
		
	List <String> names = new ArrayList<String>();	
		
		
 for(int i=1; i<=2; i++) 
 {
		    	
String table ="//table[@class='table nosort']//following-sibling::div//following-sibling::li//child::a[text()='"+i+"']";
ldriver.findElement(By.xpath(table)).click();

System.out.println("clicked");

List <WebElement> currenttble = tables;      

for(WebElement name : currenttble ) {
	
	System.out.println("Entered forloop");
	names.add(name.getText());
}

 }

 for(String Allnames : names) {
	
	System.out.println(Allnames);
}
 
 int NoOfNames = names.size();
 
 System.out.println(NoOfNames);

}
		     
		    

//		    JavascriptExecutor js = (JavascriptExecutor) ldriver;
//		    js.executeScript("window.scrollBy(0,1000)","");
			
		    
				
				}
		    
		   
			
			
			
			
		
		
		
		
		
		
		
		
	
	
	
	
	

