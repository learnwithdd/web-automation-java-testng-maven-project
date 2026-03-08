package com.lwdd.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
WebDriver driver;
	
	@BeforeMethod
	public void initBrowser() {		
		// open the chrome browser 		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");

		driver = new ChromeDriver(options);	
//		Open page
		driver.get("https://practicetestautomation.com/practice-test-login/");	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	@AfterMethod
	public void quiteBrowser() {
		
		if(driver!=null) {
			
			driver.quit();
		}
		
	}

}
