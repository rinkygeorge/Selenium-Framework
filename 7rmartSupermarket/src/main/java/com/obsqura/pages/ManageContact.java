package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obsqura.utilities.PageUtility;

public class ManageContact extends PageUtility {
	
	WebDriver driver;
	
	public ManageContact(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	@FindBy(css = "a[class='btn btn-sm btn btn-primary btncss']")
	private WebElement Edit	;
	
	@FindBy(id = "phone")
	private WebElement phone;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(css = "textarea[name='address']")
	private WebElement address;
	
	@FindBy(css = "textarea[name='del_time']")
	private WebElement deliverytime;
	
	@FindBy(css = "input[id='del_limit']")
	private WebElement deliverychargelimit;
	
	@FindBy(css = "	button[type='submit']")
	private WebElement update;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement AlertText ;

	
	
	public String enterDataOnContactUsPageFields(String Phone,String Email,String Address,String Deliverytime,String Deliverychargelimit) throws InterruptedException 
	{
		  elementClick(Edit); 
		  setTextBox(phone, Phone); 
		  setTextBox(email, Email);
		  setTextBox(address, Address); 
		  setTextBox(deliverytime, Deliverytime);
		  setTextBox(deliverychargelimit, Deliverychargelimit);
		  pageScroll(update);
		  Thread.sleep(2000);
		  //isElemenClickable(update);
		  elementClick(update); 
		  String alertText = getElementText(AlertText);
		  return alertText.split("Alert!")[1].trim();
	}

}
