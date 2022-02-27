package com.O_HRM.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.O_HRM.pageObjectModel.Admin;
import com.O_HRM.pageObjectModel.LoginPage;

public class TestCase_SearchName_002 extends BaseClass{
	
	
	
	@Test
	public void searchEmpName() throws IOException {
		
		
LP = new LoginPage(driver);
		
		LP.txtusername(username);
		LP.txtpassword(password);
		LP.Submitbtn();
		
		
AD = new Admin(driver);
		
        AD.Adminbtn();
		//AD.Txtusername("Aravind");
		//AD.drpuserRole("ESS");
		//AD.txtempname("Dominic Chase");
		//AD.drpStatus("Enabled");
		//AD.Searchbtn();
		AD.verifyUserName("Aravind");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		if(AD.verifyUserName("Aravind")==true) {
			
			System.out.println("The TestCase_SearchName_002 is passed");
		}else {
			
			CaptureScreenshot(driver,"SearchNameFailed");
			System.out.println("The TestCase_SearchName_002 is failed");
		}
		
		
		
	    
	     
		
		
		
		
		
		}
	

}
