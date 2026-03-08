package com.lwdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	@FindBy (xpath = "//input[@id='username']")
	WebElement usernameInput;
	
	@FindBy (xpath = "//input[@id='password']")
	WebElement passwordInput;
	
	@FindBy (xpath = "//button[@id='submit']")
	WebElement submitButton;
	
	
	public LoginPage(WebDriver driver) {				
		super(driver);		
	}
	
	// actions / methods 
	
	public void enterUsername(String username) {		
		usernameInput.sendKeys(username);
	}
	
	public void enterPassword(String password) {		
		passwordInput.sendKeys(password);
	}
	
	public void clickOnSubmitButton() {		
		submitButton.click();
	}
	
	

}
