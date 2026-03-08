package com.lwdd.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lwdd.pages.HomePage;
import com.lwdd.pages.LoginPage;

public class LogoutTest extends BaseTest {


	@Test(description = "Test case 3: LogoutTest test", priority = 3)
	public void userLogoutTest() {

//		Test case 3: LogoutTest test

		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);

//Type username student into Username field		
		loginPage.enterUsername("student");

//Type password Password123 into Password field
		loginPage.enterPassword("Password123");

//Push Submit button submit
		loginPage.clickOnSubmitButton();

//		Verify new page URL contains practicetestautomation.com/logged-in-successfully/

		String actUrl = driver.getCurrentUrl();
		Assert.assertEquals(actUrl, "https://practicetestautomation.com/logged-in-successfully/");

//		Verify new page contains expected text ('Congratulations' or 'successfully logged in')

		String actText = driver
				.findElement(By.xpath("//strong[text()='Congratulations student. You successfully logged in!']"))
				.getText();
		Assert.assertEquals(actText, "Congratulations student. You successfully logged in!");

//		Verify button Log out is displayed on the new page
		WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));

		boolean status = logoutButton.isDisplayed();
		Assert.assertTrue(status);

//      click on the Logout button 		
		logoutButton.click();

	}

}
