package com.lwdd.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenUrlTest {
	
	
	@Test
	
	public void openUrl() {	
		
		// open the chrome browser 		
		WebDriver driver = new ChromeDriver();
		
		// open the url 
		driver.get("https://practicetestautomation.com/practice-test-login");
		
		
	}

}
