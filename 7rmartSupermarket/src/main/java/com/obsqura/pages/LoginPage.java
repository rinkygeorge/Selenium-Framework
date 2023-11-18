package com.obsqura.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import com.obsqura.utilities.PageUtility;

public class LoginPage extends PageUtility {

	WebDriver driver;


	public LoginPage(WebDriver driver){
		
		//calling parent constructor
		super(driver);
		
		//initializing driver
		this.driver = driver;

		//below line of code is to initialize the web elements written below using driver.
		PageFactory.initElements(driver, this);
	}

	/*
	 * WebElement username =
	 * driver.findElement(By.cssSelector("input[name='username']")); 
	 * Instead of writing the above code, we can write webelements using findby
	 */

	@FindBy(css = "input[name='username']")
	private WebElement username;

	@FindBy(css = "input[name='password']")
	private WebElement password;

	@FindBy(css = "button[type='submit']")
	private WebElement submit;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement AlertText ;
	
	@FindBy(xpath = "//ol[@class='breadcrumb float-sm-right']/li[2]")
	private WebElement DashboardText;

	//We can put all log in actions in one action method
	
	public String incorrectLoginCheck(String Username, String Password) {
		
		
		  setTextBox(username,Username); 
		  setTextBox(password,Password);
		  elementClick(submit); 
		
		String alertText = getElementText(AlertText);
		System.out.println(alertText.split("Alert!")[1].trim());
		return alertText.split("Alert!")[1].trim();

		
	}

	public void loginApplication(String Username, String Password) {
		
		setTextBox(username,Username);
		setTextBox(password,Password);
		elementClick(submit);
		String dashboard = DashboardText.getText();
		
	}
	
	


}
