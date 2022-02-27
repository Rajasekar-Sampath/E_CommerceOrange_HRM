package com.O_HRM.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.O_HRM.pageObjectModel.LoginPage;

public class TestCase_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws IOException {
		
		LP = new LoginPage(driver);
		
		LP.txtusername(username);
		LP.txtpassword(password);
		LP.Submitbtn();
		
		if(driver.getTitle().contains("")) {
			
			System.out.println("LoginTest is passed");
			Assert.assertTrue(true);
		} else {
			
			CaptureScreenshot(driver, "LoginTestFailed");
			Assert.assertTrue(false);
		}
	}
	

}
