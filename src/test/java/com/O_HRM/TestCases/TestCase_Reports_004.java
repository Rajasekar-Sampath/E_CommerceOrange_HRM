package com.O_HRM.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.O_HRM.pageObjectModel.Admin;
import com.O_HRM.pageObjectModel.LoginPage;
import com.O_HRM.pageObjectModel.P_Reports;

public class TestCase_Reports_004 extends BaseClass { 
	
	@Test
	public void searchReports() throws IOException {
		
LP = new LoginPage(driver);
		
		LP.txtusername(username);
		LP.txtpassword(password);
		LP.Submitbtn();
		
	
	
AD = new Admin(driver);

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AD.clickpim();
		
PR = new P_Reports(driver);		
		
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          PR.clickreport();
          PR.txtreportname("Employee Job Details");
          PR.clkSearchbtn();
          PR.searchwanted("Employee Job Details");
          
          if(PR.ldriver.findElement(By.xpath("//tbody//following::tr/td[1]/input[@type='checkbox']")).isSelected()==true) {
        	  
        	  Assert.assertTrue(true);
        	  System.out.println("TestCase_Report_004 is passed");
          }else {
        	  
        	  CaptureScreenshot(driver, "ReportSearchingFailed");
        	  System.out.println("TestCase_Report_004 is failed");
        	  Assert.assertTrue(false);
        	  
          }
		
	}
	
	

}
