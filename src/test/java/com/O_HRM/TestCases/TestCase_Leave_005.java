package com.O_HRM.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.O_HRM.pageObjectModel.Admin;
import com.O_HRM.pageObjectModel.LoginPage;
import com.O_HRM.pageObjectModel.leavesPortal;

public class TestCase_Leave_005 extends BaseClass {
	
	@Test
	public void leaveportal() throws IOException {
	
LP = new LoginPage(driver);

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	LP.txtusername(username);
	LP.txtpassword(password);
	LP.Submitbtn();

AD = new Admin(driver);

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    AD.clkLeave();
    
lP = new leavesPortal(driver);

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    lP.mouseEntitlement();
    lP.clkCheckbox();
    lP.selectLocation();
    System.out.println("selectLocation clicked");
    lP.scltSubunit("All");
    System.out.println("scltSubunit clicked");
    lP.scltLeaveType("CAN - Bereavement");
    System.out.println("scltLeaveType clicked");
    lP.scltLeavePeriod("2022-01-01$$2022-12-31");
    System.out.println("scltLeavePeriod clicked");
    lP.txtEntitlement("4.73");
    System.out.println("txtEntitlement entered");
    lP.saveBtn();
    System.out.println("save button clicked");
    //lP.MatchingEmps();
    
    
   
    
    
    if(driver.getTitle().equals("OrangeHRM")) {
    	
    	Assert.assertTrue(true);
    	System.out.println(("TestCase_Leave_005 is Passed"));
    	
    } else {
    	
      CaptureScreenshot(driver, "LeavePortalFailed");
  	  System.out.println("TestCase_Report_004 is failed");
  	  Assert.assertTrue(false);
    }
    
    }
	

}
