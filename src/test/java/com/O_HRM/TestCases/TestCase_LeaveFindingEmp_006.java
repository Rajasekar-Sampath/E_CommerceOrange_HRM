package com.O_HRM.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.O_HRM.pageObjectModel.Admin;
import com.O_HRM.pageObjectModel.L_Reports;
import com.O_HRM.pageObjectModel.LoginPage;

public class TestCase_LeaveFindingEmp_006 extends BaseClass { 
	
	@Test	
	public void findingEmp() throws IOException, InterruptedException {
		
LP = new LoginPage(driver);

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			LP.txtusername(username);
			LP.txtpassword(password);
			LP.Submitbtn();

AD = new Admin(driver);

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		    AD.clkLeave();
	
LR = new L_Reports(driver);

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
            LR.report_LeaveEntitle();
            LR.scltGenerate("Leave Type");
            LR.clkCheckBox();
            LR.clkViewbtn();
            LR.findWanted();
            
            
            
		
		
	}

}
