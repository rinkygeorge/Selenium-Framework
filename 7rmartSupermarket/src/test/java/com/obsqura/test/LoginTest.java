package com.obsqura.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.utilities.ExcelUtility;

public class LoginTest extends BaseTest{

	@Test(priority = 0,dataProvider = "getData") 
	public void verifyUserIsAbleToLoginWithIncorrectUserNameAndPassword(String username, String password) 
	{
		String alert = loginpage.incorrectLoginCheck(username,
				password); 
		Assert.assertEquals(alert, "Invalid Username/Password",
				"Invalid User Validation Failed"); 
	}



	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];

		data[0][0]="admin";
		data[0][1]="123";
		data[1][0]="yui";
		data[1][1]="admin";

		return data;

	}



	@Test(priority = 1, groups={"smoke"}) public void
	verifyUserIsAbleToLoginWithCorrectUserNameAndPassword() {

		String username = ExcelUtility.getString(1, 0, "LoginPage"); 
		String password	= ExcelUtility.getString(1, 1, "LoginPage");
		loginpage.loginApplication(username,password);
	}




}
