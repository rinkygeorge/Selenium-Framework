package com.obsqura.pages;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.utilities.PageUtility;

public class ManageExpense extends PageUtility {

	WebDriver driver;

	public ManageExpense(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "li[class='nav-item has-treeview menu-open'] ul:nth-child(3)")
	private WebElement ManageExpense;

	@FindBy(css = "div[class='col-sm-12'] a[class='btn btn-rounded btn-danger']")
	private WebElement New;

	@FindBy(css = "div[class='col-sm-12'] a[class='btn btn-rounded btn-primary']")
	private WebElement MenuSearch;	

	@FindBy(css = "select[id='user_id']") 
	private WebElement User;

	@FindBy(css = "input[class='form-control date']")
	private WebElement Date;

	@FindBy(xpath = "(//th[@class='datepicker-switch']) [1]")
	private WebElement Selectmonth;

	@FindBy(xpath = "(//th[@class='next']) [1]")
	private WebElement Nexticon;

	@FindBy(css = "td[class='day']")
	private List<WebElement> Days;

	@FindBy(xpath = "(//select[@class='form-control selectpicker'])[2]")
	private WebElement Category;

	@FindBy(id = "ex_type")
	private WebElement Type;

	@FindBy(css = "input[id='amount']")
	private WebElement Amount;

	@FindBy(id = "content")
	private WebElement Remarks;

	@FindBy(xpath = "//button[@name='create']")
	private WebElement save;

	@FindBy(xpath = "//tbody/tr/td[9]/a[1]")
	private WebElement Edit;

	@FindBy(css = "button[name='update']")
	private WebElement Update;

	@FindBy(xpath = "//tbody/tr/td[9]/a[2]")
	private WebElement Delete;

	@FindBy(xpath = "(//input[@placeholder='Enter the Date'])[1]")
	private WebElement DateFrom;

	@FindBy(xpath = "(//input[@placeholder='Enter the Date'])[2]")
	private WebElement DateTo;

	@FindBy(css = "button[name='Search']")
	private WebElement FormSearch;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement AlertText ;

	@FindBy(css = "select[class='form-control selectpicker']")
	private WebElement UserinSearch;

	@FindBy(id = "ty")
	private WebElement TypeinSearch;

	@FindBy(css = "span[id='res']")
	private WebElement ResultNotFound;
	
	@FindBy(css = "input[name='userfile']")
	private WebElement UploadFile;

	

	public String addExpense( String user, String month, String dateValue, String category,String type, int randomNumber) throws InterruptedException, AWTException {

		elementClick(New); 		
		staticDropDown(User, user);
		getCalendarValue(Date, Selectmonth, month, Nexticon, Days, dateValue);
		staticDropDown(Category, category);
		staticDropDown(Type, type); 
		setTextBox(Amount, Integer.toString(randomNumber));
		pageScroll(save);
		Thread.sleep(1000);	
		//isElemenClickable(save);
		//isElementVisible(save);
		//isTextPresentInElement(save,"Save");
		
		elementClick(save);
		String alertText = getElementText(AlertText);
		System.out.println(alertText.split("Alert!")[1].trim());
		return alertText.split("Alert!")[1].trim();

	}


	public String searchInvalidData(String User, String Month, String DateValue, String NextMonth, String NextDateValue, String category, String Type) throws InterruptedException 
	{

		elementClick(MenuSearch); 
		staticDropDown(UserinSearch, User);
		getCalendarValue(DateFrom, Selectmonth, Month, Nexticon, Days, DateValue);	
		getCalendarValue(DateTo, Selectmonth, NextMonth, Nexticon, Days, NextDateValue);
		staticDropDown(Category, category);
		staticDropDown(TypeinSearch, Type); 
		pageScrollFixed(FormSearch);	 
		Thread.sleep(3000);
		elementClick(FormSearch);
		pageScrollFixed(FormSearch);		
		String message = getElementText(ResultNotFound);
		System.out.println(message);
		return message;
	}


	public String editExpense(String User, String Month, String DateValue, String NextMonth, String NextDateValue, int randomNumber) throws InterruptedException {


		elementClick(MenuSearch);
		staticDropDown(UserinSearch, User);
		getCalendarValue(DateFrom, Selectmonth, Month, Nexticon, Days, DateValue);	
		getCalendarValue(DateTo, Selectmonth, NextMonth, Nexticon, Days, NextDateValue);
		pageScrollFixed(FormSearch);	 
		Thread.sleep(3000);
		elementClick(FormSearch); 
		pageScrollFixed(Edit);
		Thread.sleep(2000);

		elementClick(Edit);
		setTextBox(Amount, Integer.toString(randomNumber));
		pageScroll(Update);	  
		Thread.sleep(1000);
		elementClick(Update);
		String alertText = getElementText(AlertText);
		System.out.println(alertText.split("Alert!")[1].trim());
		return alertText.split("Alert!")[1].trim();


	}

	public String deleteExpense(String User, String Month, String DateValue, String NextMonth, String NextDateValue) throws InterruptedException {


		elementClick(MenuSearch);
		staticDropDown(UserinSearch, User);
		getCalendarValue(DateFrom, Selectmonth, Month, Nexticon, Days, DateValue);	
		getCalendarValue(DateTo, Selectmonth, NextMonth, Nexticon, Days, NextDateValue);
		pageScrollFixed(FormSearch);	 
		Thread.sleep(3000);
		elementClick(FormSearch); 
		pageScrollFixed(Delete);
		Thread.sleep(2000);
		elementClick(Delete);
		AcceptAlert();
		String alertText = getElementText(AlertText);
		System.out.println(alertText.split("Alert!")[1].trim());
		return alertText.split("Alert!")[1].trim();

	}

	/*
	 * public void ValidateFileUpload() throws AWTException { uploadFile(); }
	 */







}
