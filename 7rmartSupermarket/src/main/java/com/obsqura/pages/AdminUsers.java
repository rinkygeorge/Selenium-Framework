package com.obsqura.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class AdminUsers extends PageUtility {
	
	WebDriver driver;

	public AdminUsers(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[class='btn btn-rounded btn-danger']")
	private WebElement New;
	
	@FindBy(id = "username")
	private WebElement Username;

	@FindBy(id = "password")
	private WebElement Password;
	
	@FindBy(id = "user_type")
	private WebElement UserType;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement Save;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement AlertText ;
	

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement DangerAlertText ;
	
	@FindBy(css = "a[class='btn btn-rounded btn-primary']")
	private WebElement Search;
	
	@FindBy(css = "input[id='un']")
	private WebElement UsernameinSearch;
	
	@FindBy(css = "button[name='Search']")
	private WebElement Searchbutton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/thead")
	private List<WebElement> TableHeadings; 
	

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr")
	private List<WebElement> TableRows; 
	
	public String addUser(String adminusername, String adminpassword, String usertype) {
		
		elementClick(New);
		setTextBox(Username, adminusername);
		setTextBox(Password, adminpassword);
		staticDropDown(UserType, usertype);
		elementClick(Save);
		String alertText = getElementText(AlertText);
		System.out.println(alertText.split("Alert!")[1].trim());
		return alertText.split("Alert!")[1].trim();
	}
	
public String existingUserCheck(String adminusername, String adminpassword, String usertype) {
		
		elementClick(New);
		setTextBox(Username, adminusername);
		setTextBox(Password, adminpassword);
		staticDropDown(UserType, usertype);
		elementClick(Save);
		String alertText = getElementText(DangerAlertText);
		System.out.println(alertText.split("Alert!")[1].trim());
		return alertText.split("Alert!")[1].trim();
	}

public void search() throws InterruptedException {
	
	elementClick(Search);
	String name = "alphonsameri20";
	Thread.sleep(1000);
	setTextBox( UsernameinSearch,name);
	elementClick(Searchbutton);
	
	//dynamicTable(TableHeadings, TableRows, name);
	
	
	
	
}
}
