package com.obsqura.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.utilities.ExcelUtility;

public class ManageContactTest extends BaseTest {
	
	@Test
	public void verifyUserIsAbleToUpdateContactUsPage() throws InterruptedException {
		String username = ExcelUtility.getString(1, 0, "LoginPage"); 
		String password	= ExcelUtility.getString(1, 1, "LoginPage");
		loginpage.loginApplication(username,password);
		homepage.navigateToContactUs();
		
		String phone = ExcelUtility.getNumeric(1, 0, "ManageContact"); 
		String email = ExcelUtility.getString(1, 1, "ManageContact"); 
		String Address = ExcelUtility.getString(1, 2, "ManageContact");
		String deliverytime = ExcelUtility.getString(1, 3, "ManageContact"); 
		String deliverychargelimit = ExcelUtility.getNumeric(1, 4, "ManageContact"); 
		
		String alertText = managecontact.enterDataOnContactUsPageFields(phone, email, Address, deliverytime, deliverychargelimit);
		Assert.assertEquals(alertText, "Contact Updated Successfully", "Contact Update Validation Failed");
		
		
	}

}
