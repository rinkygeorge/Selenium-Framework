package com.obsqura.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

private WebDriver driver;
WebDriverWait wait;

public WaitUtility(WebDriver driver) {
		
        this.driver= driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(8));
	}

	public void isElemenClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void isElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitTillTextPresentInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void isElementInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void isTextPresentInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	/*
	 * public void isElementInvisible(WebElement element) {
	 * wait.until(ExpectedConditions.presenceOfElementLocated(null)); }
	 */
	
	
}
