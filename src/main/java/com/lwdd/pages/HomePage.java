package com.lwdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {	
	
	@FindBy (xpath = "//a[text()='Log out123']")
	WebElement logoutButton;
	
	
	public HomePage(WebDriver driver) {		
		super(driver);	
		
	}
	
	// actions / methods 	
	public void clickOnLogoutButton() {		
		
		
		logoutButton.click();
	}
	
	public boolean isLogoutButtonVisible() {
		
		return logoutButton.isDisplayed();
	}
	
	
}
