package com.O_HRM.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Admin {

	public WebDriver ldriver;

	public Admin(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(ldriver, this);

	}

	@FindBy(xpath = "//a[@class='firstLevelMenu' and @id='menu_admin_viewAdminModule']//child::b")
	@CacheLookup
	WebElement adminbtn;
	
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule' and @class='firstLevelMenu']//child::b")
	@CacheLookup
	WebElement PIM;
	
	@FindBy(xpath = "//a[@id='menu_leave_viewLeaveModule' and @class='firstLevelMenu']//child::b[text()=\"Leave\"]")
	@CacheLookup
	WebElement Leave;

	/*@FindBy(xpath = "//input[@id='searchSystemUser_userName']")
	@CacheLookup
	WebElement txtusername;

	@FindBy(xpath = "//select[@id='searchSystemUser_userType']")
	@CacheLookup
	WebElement userRole;

	@FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
	@CacheLookup
	WebElement empName;

	@FindBy(xpath = "//select[@name='searchSystemUser[status]']")
	@CacheLookup
	WebElement status;

	@FindBy(xpath = "//input[@name='_search']")
	@CacheLookup
	WebElement search;*/

	@FindBy(xpath = "//table[@id='resultTable']")
	@CacheLookup
	WebElement table;

	@FindBy(xpath = "//table[@id='resultTable']//following::tr")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='resultTable']//following::tr/td")
	@CacheLookup
	List<WebElement> tableColumns;

	public void Adminbtn() {

		adminbtn.click();
	}

    public void clickpim() {
		
		PIM.click();
	}
    
    public void clkLeave() {
    	
    	Leave.click();
    	
    }
	/*public void Txtusername(String username) {

		txtusername.sendKeys(username);
	}

	public void drpuserRole(String role) {

		Select se = new Select(userRole);
		se.selectByVisibleText(role);
	}

	public void txtempname(String name) {

		empName.sendKeys(name);
	}

	public void drpStatus(String Status) {
		Select se = new Select(status);
		se.selectByVisibleText(Status);
	}

	public void Searchbtn() {

		search.click();
	}*/

	public int getRows() {

		return (tableRows.size());
	}

	public int getColumns() {

		return (tableColumns.size());
	}

	public boolean verifyUserName(String userName) {

      boolean flag = false;		

		for (int i = 1; i <= getRows(); i++) {

			String username = table.findElement(By.xpath("//table[@id='resultTable']//following::tr[" + i + "]/td[2]"))
					.getText();

			if (username.equals(userName)) {

				table.findElement(By.xpath("//table[@id='resultTable']//following::tr[" + i + "]/td[1]")).click();
				flag = true;
				break;

			}

		}
		return flag;

	}

}
