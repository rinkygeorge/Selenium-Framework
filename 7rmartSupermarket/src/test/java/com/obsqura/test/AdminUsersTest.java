package com.obsqura.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.Listeners.RetryAnalyzer;
import com.obsqura.utilities.ExcelUtility;

public class AdminUsersTest extends BaseTest {
	
	
	@Test(dependsOnMethods = {"verifyUserIsAbleToAddNewAdminUser"})
	public void verifyUserIsAbleToAddExistingAdminUser() throws InterruptedException
	{	
		
		homepage.navigateToAddAdminUsers();
		
		String adminusername = ExcelUtility.getString(1, 0, "AdminUsers"); 
		String adminpassword	= ExcelUtility.getString(1, 1, "AdminUsers");
		String usertype	= ExcelUtility.getString(1, 2, "AdminUsers");
		String alertText = adminusers.existingUserCheck(adminusername, adminpassword, usertype);
		Assert.assertEquals(alertText, "Username already exists.", "Existing User Validation Failed");
	}
	
	@Test(groups={"smoke"})
	public void verifyUserIsAbleToAddNewAdminUser() throws InterruptedException
	{	
		String username = ExcelUtility.getString(1, 0, "LoginPage"); 
		String password	= ExcelUtility.getString(1, 1, "LoginPage");
		loginpage.loginApplication(username,password);
		
		homepage.navigateToAddAdminUsers();
		
		String adminusername = ExcelUtility.getString(1, 0, "AdminUsers"); 
		String adminpassword	= ExcelUtility.getString(1, 1, "AdminUsers");
		String usertype	= ExcelUtility.getString(1, 2, "AdminUsers");
		String alert = adminusers.addUser(adminusername, adminpassword, usertype);
		Assert.assertEquals(alert, "User Created Successfully", "User Creation Validation Failed");
		
	}
	
	/*
	 * @Test() public void verifyUserIsAbleToSearchExistingAdminUser() throws
	 * InterruptedException {
	 * 
	 * homepage.navigateToAddAdminUsers(); adminusers.search();
	 * 
	 * }
	 */
	
	
}
