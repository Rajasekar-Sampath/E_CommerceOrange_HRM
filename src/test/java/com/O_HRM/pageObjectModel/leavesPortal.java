package com.O_HRM.pageObjectModel;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class leavesPortal {

	public WebDriver ldriver;

	public leavesPortal(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//a[@id='menu_leave_Entitlements' and @class='arrow']")
	@CacheLookup
	WebElement Entitlement;

	@FindBy(xpath = "//a[@id='menu_leave_addLeaveEntitlement' and text()=\"Add Entitlements\"]")
	@CacheLookup
	WebElement addLvEntitle;

	@FindBy(xpath = "//input[@type='checkbox' and @name='entitlements[filters][bulk_assign]']")
	@CacheLookup
	WebElement checkclk;

	@FindBy(xpath = "//select[@class='selectableGroupWidget' and @name='entitlements[filters][location]']")
	@CacheLookup
	WebElement Location;

	@FindBy(xpath = "//select[@name='entitlements[filters][subunit]']")
	@CacheLookup
	WebElement subunit;

	@FindBy(xpath = "//select[@id='entitlements_leave_type' and @name='entitlements[leave_type]']")
	@CacheLookup
	WebElement LeaveType;

	@FindBy(xpath = "//select[@id='period']")
	@CacheLookup
	WebElement LeavePeriod;

	@FindBy(xpath = "//label[@for = 'entitlements_entitlement']//following-sibling::input[@name='entitlements[entitlement]']")
	@CacheLookup
	WebElement entitlement;

	@FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
	@CacheLookup
	WebElement savebtn;

	@FindBy(xpath = "//tbody//following-sibling::tr/td[1]")
	@CacheLookup
	List<WebElement> matchemps;
	
	@FindBy(xpath = "//input[@id ='dialogConfirmBtn']")
	@CacheLookup
	WebElement confirm;

	public void mouseEntitlement() {

		Actions act = new Actions(ldriver);

		act.moveToElement(Entitlement).moveToElement(addLvEntitle).click().build().perform();
	}

	public void clkCheckbox() {

		checkclk.click();
	}

	public void selectLocation() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the List Integer Value :");
		int list = scan.nextInt();
		Select se = new Select(Location);
		se.selectByIndex(--list);
	}

	public void scltSubunit(String selected) {

		Select se = new Select(subunit);
		se.selectByVisibleText(selected);
	}

	public void scltLeaveType(String slctType) {

		Select se = new Select(LeaveType);
		se.selectByVisibleText(slctType);
	}

	public void scltLeavePeriod(String slctPeriod) {

		Select se = new Select(LeavePeriod);
		se.selectByValue(slctPeriod);
	}

	public void txtEntitlement(String title) {

		entitlement.sendKeys(title);

	}

	public void saveBtn() {

		savebtn.click();
	}

	
	 public void MatchingEmps(String value) {

		for (WebElement s : matchemps) {

			String Actual = s.getText();
			

			if (Actual.equals(value)) {
				System.out.println("Actual equals value");
				confirm.click();
				break;
			}
		}
	}
	

}
