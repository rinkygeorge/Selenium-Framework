package com.obsqura.test;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.utilities.DateUtility;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.utilities.GenerateRandomNumber;

public class ManageExpenseTest extends BaseTest {

	@Test (priority = 0, groups= {"smoke"})
	public void verifyUserIsAbleToCreateNewExpense() throws InterruptedException, AWTException  {
		String username = ExcelUtility.getString(1, 0, "LoginPage"); 
		String password	= ExcelUtility.getString(1, 1, "LoginPage");
		loginpage.loginApplication(username,password);
		homepage.navigateToExpenseCategory();

		
		int randomNumber = GenerateRandomNumber.getRandomNumber();
		String User = ExcelUtility.getString(1, 0, "ManageExpense"); 
		String Month = ExcelUtility.getString(1, 1, "ManageExpense"); 
		String DateValue = ExcelUtility.getNumeric(1, 2, "ManageExpense");
		String Category = ExcelUtility.getString(1, 3, "ManageExpense"); 
		String Type = ExcelUtility.getString(1, 4, "ManageExpense"); 
		String alertTextCreation = manageexpense.addExpense(User, Month, DateValue, Category, Type, randomNumber); 
		Assert.assertEquals(alertTextCreation, "Expense Record Created Successfully", "Record Creation Validation Failed");
		
	}
	
	
	@Test (priority = 1, enabled=false)
	public void verifyUserIsAbleToEditExpense() throws InterruptedException  {
		homepage.navigateToExpenseCategory();
		
		int randomNumberEdit = GenerateRandomNumber.getRandomNumber();
		String User = ExcelUtility.getString(4, 0, "ManageExpense"); 
		String Month = ExcelUtility.getString(4, 1, "ManageExpense"); 
		String DateValue = ExcelUtility.getNumeric(4, 2, "ManageExpense");
		String NextMonth = ExcelUtility.getString(4, 3, "ManageExpense"); 
		String NextDateValue = ExcelUtility.getNumeric(4, 4, "ManageExpense"); 
		String alertText = manageexpense.editExpense(User, Month, DateValue, NextMonth, NextDateValue, randomNumberEdit);
		Assert.assertEquals(alertText, "Expense Record Updated Successfully", "Edit Validation Failed");
		
	}
	
	@Test (priority = 2, enabled=false)
	public void verifyUserIsAbleToDeleteExpense() throws InterruptedException  {
		homepage.navigateToExpenseCategory();
		
		String User = ExcelUtility.getString(4, 0, "ManageExpense"); 
		String Month = ExcelUtility.getString(4, 1, "ManageExpense"); 
		String DateValue = ExcelUtility.getNumeric(4, 2, "ManageExpense"); 
		String NextMonth = ExcelUtility.getString(4, 3, "ManageExpense"); 
		String NextDateValue = ExcelUtility.getNumeric(4, 4, "ManageExpense"); 
		String alertTextDeletion = manageexpense.deleteExpense(User, Month, DateValue, NextMonth, NextDateValue);
		Assert.assertEquals(alertTextDeletion, "Expense Record Deleted Successfully", "Record Deletion Validation Failed");
		 
	}
	
	
	
	  @Test(priority = 3, enabled=false) 
	  public void verifyUserIsAbleToGetResultNotFoundMessage()
	  throws InterruptedException {
	  	  
	  homepage.navigateToExpenseCategory();
	  String User = ExcelUtility.getString(7, 0, "ManageExpense"); 
	  String Month = ExcelUtility.getString(7, 1, "ManageExpense"); 
	  String DateValue = ExcelUtility.getNumeric(7, 2, "ManageExpense"); 
	  String NextMonth = ExcelUtility.getString(7, 3, "ManageExpense"); 
	  String NextDateValue = ExcelUtility.getNumeric(7, 4, "ManageExpense"); 
	  String Category = ExcelUtility.getString(7, 5, "ManageExpense"); 
	  String Type = ExcelUtility.getString(7, 6, "ManageExpense"); 
	  String message = manageexpense.searchInvalidData(User, Month, DateValue, NextMonth, NextDateValue,Category,Type);
	  Assert.assertEquals(message,".........RESULT NOT FOUND.......",
	  "Result Not Found Validation Failed");
	  
	  }
	 

}
