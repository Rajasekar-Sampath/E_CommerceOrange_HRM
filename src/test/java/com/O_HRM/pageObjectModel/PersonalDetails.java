package com.O_HRM.pageObjectModel;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.sikuli.script.FindFailed;
//import org.sikuli.script.Pattern;
//import org.sikuli.script.Screen;

import com.O_HRM.Utilities.WaitHelper;




public class PersonalDetails {

	public WebDriver ldriver;
	
	WaitHelper wait;

	public PersonalDetails(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(ldriver, this);
		
		wait = new WaitHelper(ldriver);
	}

	@FindBy(xpath = "//div[@class='personalDetails' and @ id='pdMainContainer']/child::div/h1[text()=\"Personal Details\"]")
	@CacheLookup
	WebElement PersonalDetailtxt;

	@FindBy(xpath = "//input[@id='btnSave' and @value= 'Edit']")
	@CacheLookup
    WebElement edit;

	@FindBy(xpath = "//label[text()='Other Id']/following::input[@name= 'personal[txtOtherID]']")
	@CacheLookup
	WebElement otherid;

	@FindBy(xpath = "//label[text()=\"Driver's License Number\"]/following::input[@name= 'personal[txtLicenNo]']")
	@CacheLookup
	WebElement driverlicense;

	@FindBy(xpath = "//img[@class='ui-datepicker-trigger']")
	@CacheLookup
	WebElement ClickCalender;

	@FindBy(xpath = "//div[@id='ui-datepicker-div']")
	@CacheLookup
	WebElement calendertable;

	@FindBy(xpath = "//input[@name='personal[txtNICNo]' and @id = 'personal_txtNICNo']")
	@CacheLookup
	WebElement ssn;

	@FindBy(xpath = "//input[@name='personal[txtSINNo]' and @id = 'personal_txtSINNo']")
	@CacheLookup
	WebElement sin;

	@FindBy(xpath = "//input[@name='personal[optGender]' and @id = 'personal_optGender_1']")
	@CacheLookup
	WebElement radiobtn;

	@FindBy(xpath = "//select[@name='personal[cmbMarital]']")
	@CacheLookup
	WebElement maritalstus;

	@FindBy(xpath = "//select[@name='personal[cmbNation]']")
	@CacheLookup
	WebElement Nationalstatus;

	@FindBy(xpath = "//ol/following-sibling::ol[2]//following-sibling::li[4]//following-sibling::img[@class='ui-datepicker-trigger']")
	@CacheLookup
	WebElement ClickCalender2;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	@CacheLookup
	WebElement SMonth;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	@CacheLookup
	WebElement SYear;

	@FindBy(xpath = "//input[@name='personal[txtEmpNickName]']")
	@CacheLookup
	WebElement Nickname;

	@FindBy(xpath = "//input[@id='personal_chkSmokeFlag']")
	@CacheLookup
	WebElement smoke;

	@FindBy(xpath = "//input[@id='personal_txtMilitarySer']")
	@CacheLookup
	WebElement military;

	@FindBy(xpath = "//input[@id='btnSave' and @value='Save']")
	@CacheLookup
	WebElement Savebtn;

	@FindBy(xpath = "//input[@id='btnEditCustom']")
	@CacheLookup
	WebElement EditBtn;

	@FindBy(xpath = "//select[@name='custom1' and @class='editable']")
	@CacheLookup
	WebElement blood;

	@FindBy(xpath = "//input[@id='btnEditCustom']")
	@CacheLookup
	WebElement save2;

	@FindBy(xpath = "//input[@id='btnAddAttachment']")
	@CacheLookup
	WebElement add;

	@FindBy(xpath = "//textarea[@name='txtAttDesc']")
	@CacheLookup
	WebElement text;

	@FindBy(xpath = "//input[@type='button']  [@name='btnSaveAttachment']  [@value='Upload']")
	@CacheLookup
	WebElement upload;

	@FindBy(xpath = "//input[@value='1048576']/following::input[@name='ufile']")
	@CacheLookup
	WebElement imguploadclk;

	public String personalDetail() {

		String PersoDetail = PersonalDetailtxt.getText();
		return PersoDetail;
	}

	public void Editclk() {

		edit.click();
	}

	public void Otherid(String Oid) {

		otherid.sendKeys(Oid);
	}

	public void Driverli(String Dlicense) {

		driverlicense.sendKeys(Dlicense);
	}

	public void clkcalender() {

		ClickCalender.click();
	}

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	WebElement month;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	WebElement year;

	public void SetCalender() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the date value in Integer:");
		int date = scanner.nextInt();

		System.out.println("Enter the month value in Integer:");
		int mon = scanner.nextInt();
		Select mm = new Select(month);
		mm.selectByIndex(--mon);

		System.out.println("Enter the year value in Integer:");
		String yy = scanner.next();
		Select yyyy = new Select(year);
		yyyy.selectByVisibleText(yy);

		ldriver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + date + "']")).click();
	}

	public void txtSSN(String Txtssn) {

		ssn.sendKeys(Txtssn);
	}

	public void txtSIN(String Txtsin) {

		sin.sendKeys(Txtsin);
	}

	public void radiBtn() {

		if (radiobtn.isSelected() == false) {

			radiobtn.click();
		}
	}

	public void SelectMStatus(String Mstatus) {

		Select se = new Select(maritalstus);
		se.selectByVisibleText(Mstatus);
	}

	public void SelectNStatus(String Nstatus) {

		Select se = new Select(Nationalstatus);
		se.selectByVisibleText(Nstatus);
	}

	public void clkcalender2() {

		ClickCalender2.click();
	}

	public void SetDOB() {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the Date value in Integer :");
		int Date = scan.nextInt();

		System.out.println("Enter the Month value in Integer :");
		int Month = scan.nextInt();
		Select MM = new Select(SMonth);
		MM.selectByIndex(--Month);

		System.out.println("Enter the Year value in String :");
		String Year = scan.next();
		Select YY = new Select(SYear);
		YY.selectByVisibleText(Year);

		ldriver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + Date + "']")).click();
	}

	public void setNick(String Nicky) {

		Nickname.sendKeys(Nicky);
	}

	public void clksmoke() {

		smoke.click();
	}

	public void Military(String miliTary) {

		military.sendKeys(miliTary);
	}

	public void BtnSave() {

		Savebtn.click();
	}

	public void editbtn() {

		EditBtn.click();
	}

	public void BloodType(String Blood) {

		Select se = new Select(blood);
		se.selectByVisibleText(Blood);
	}

	public void Save2btn() {

		save2.click();
	}

	public void addbtn() {

		add.click();
	}

	public void txtcomment(String comment) {

		text.sendKeys(comment);
	}

	public void uploadclk() {

		JavascriptExecutor js = (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView(true);",upload);

	}

	public void ImgUPclk() {
        
	JavascriptExecutor js = (JavascriptExecutor) ldriver;
	js.executeScript("arguments[0].click();",imguploadclk);
		 
		
		
	}

	   /*public void Imageupload() { //sikuli
		   
		   
		   
		String imagesFilePath = "D:\\images\\";
		String InputFilePath = "D:\\inputpath\\";

		Screen s = new Screen();

		Pattern FileInputTextBox = new Pattern("D:\\inputpath\\FileTextBox.PNG\\");

		Pattern OpenButton = new Pattern("D:\\inputpath\\OpenButton.PNG\\");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		try {
			s.wait(FileInputTextBox, 20);
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		try {
			s.type(FileInputTextBox,"D:\\images\\image.jpg\\");
		} catch (FindFailed e) {

			e.printStackTrace();
		}
		try {
			s.click(OpenButton);
		} catch (FindFailed e) {

			e.printStackTrace();
		}

	}*/
	
	public void Imageupload() throws IOException { //AutoIT
		
		Runtime.getRuntime().exec("C:\\AutoITFiles\\Fileupload"+" "+"D:\\images\\image.jpg");
}
}