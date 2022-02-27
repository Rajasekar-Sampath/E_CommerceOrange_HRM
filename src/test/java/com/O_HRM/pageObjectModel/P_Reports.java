package com.O_HRM.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P_Reports {

	
 public WebDriver ldriver;
 
 public P_Reports(WebDriver rdriver) {
	 
	 ldriver = rdriver;
	 
	 PageFactory.initElements(ldriver, this);
 }
 
 @FindBy(xpath = "//a[@id='menu_core_viewDefinedPredefinedReports' and text()=\"Reports\"]")
 @CacheLookup
 WebElement reports;
 
 @FindBy(xpath = "//input[@class='ac_input']")
 @CacheLookup
 WebElement reportname;
 
 @FindBy(xpath = "//input[@name='_search']")
 @CacheLookup
 WebElement searchbtn;
 
 @FindBy(xpath = "//tbody//following::tr/td[2]")
 @CacheLookup
 WebElement tabletwo;
 
 public void clickreport() {
	 
	 JavascriptExecutor js = (JavascriptExecutor) ldriver;
	 js.executeScript("arguments[0].click();", reports);
	 
	 
 }
 
 public void txtreportname(String txtRname) {
	 reportname.clear();
	 reportname.sendKeys(txtRname);
 }
 
 public void clkSearchbtn() {
	 
	 searchbtn.click();
 }
 
 public void searchwanted(String given) {
	 
	 String tbletwo = tabletwo.getText();
	 
	 System.out.println(tbletwo);
	 
	 if(tbletwo.equals(given)) {
		 
		 ldriver.findElement(By.xpath("//tbody//following::tr/td[1]/input[@type='checkbox']")).click();
	 }
 }
 
}
