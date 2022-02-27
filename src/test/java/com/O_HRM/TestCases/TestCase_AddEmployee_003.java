package com.O_HRM.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.O_HRM.pageObjectModel.AddEmployee;
import com.O_HRM.pageObjectModel.Admin;
import com.O_HRM.pageObjectModel.LoginPage;
import com.O_HRM.pageObjectModel.PersonalDetails;

public class TestCase_AddEmployee_003 extends BaseClass{
	
	@Test
	public void addingEmployee() throws InterruptedException, IOException {
		
LP = new LoginPage(driver);
		
		LP.txtusername(username);
		LP.txtpassword(password);
		LP.Submitbtn();
		
	
	
AD = new Admin(driver);

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AD.clickpim();
		
AE = new AddEmployee(driver);

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
        AE.Addemp();
        AE.Txtfirstname("kutipadminikm");
        AE.Txtlastname("kutimadminikm");
        AE.Clickdetails();
        AE.TxtUsername("kutigarikm");
        AE.Txtpwd("Raja@Rani38");
        AE.Txtrepwd("Raja@Rani38");
        AE.selectStatus("Enabled");
        AE.Clksave();
        
PD = new PersonalDetails(driver);   

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
        
        if(PD.personalDetail().equals("Personal Details")) {
        	
        	Assert.assertTrue(true);
        	
        	}else {
        		
        		try {
					CaptureScreenshot(driver, "PersonalDetailsFailed");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
        		Assert.assertTrue(false);
        		
        	}
        
        PD.Editclk();
        PD.Otherid("0285");
        PD.Driverli("DTER09869");
        PD.clkcalender();
        Thread.sleep(5000);
        PD.SetCalender();
        PD.txtSSN("19837568");
        PD.txtSIN("90678989");
        PD.radiBtn();
        PD.SelectMStatus("Single");
        PD.SelectNStatus("Indian");
        PD.clkcalender2();
        PD.SetDOB();
        PD.setNick("Raja");
        PD.clksmoke();
        PD.Military("Major");
        PD.BtnSave();
        PD.editbtn();
        PD.BloodType("O+");
        PD.Save2btn();
        PD.addbtn();
        PD.ImgUPclk();
        Thread.sleep(5000);
//      PD.Imageupload(); //sikuli
        PD.Imageupload(); //AutoIT
        PD.txtcomment("Fileupload");
        System.out.println("FileUploaded");
        PD.uploadclk();
	}

}
