package com.obsqura.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import com.obsqura.constants.Constants;
import com.obsqura.pages.AdminUsers;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.ManageExpense;
import com.obsqura.pages.ManageContact;
import com.obsqura.utilities.TestProperties;

public class BaseTest {

	public WebDriver driver;
	Properties prop;
	LoginPage loginpage;
	HomePage homepage;
	ManageExpense manageexpense;
	AdminUsers adminusers;
	ManageContact managecontact;

	@BeforeTest
	public void initializeDriver() throws IOException {


		//calling properties class
		prop = TestProperties.getProperties();
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("URL");

		if (browserName.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
			
		}
		else if (browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		initializePages();

	}
	
	public void initializePages() {
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		manageexpense = new ManageExpense(driver);
		adminusers = new AdminUsers(driver);
		managecontact = new ManageContact(driver);
	}
	
	public String getScreenshot(String testcaseName,  WebDriver driver) throws IOException {
		TakesScreenshot scrshot=(TakesScreenshot)driver;
		File source = scrshot.getScreenshotAs(OutputType.FILE);
		File path= new File(Constants.SCREENSHOTPATH);
		FileUtils.copyFile(source, path);
		return Constants.SCREENSHOTPATH;
	}


	
	/*
	 * @AfterTest public void tearDown() {
	 * 
	 * driver.quit();
	 * 
	 * }
	 */
	 
	 

}
