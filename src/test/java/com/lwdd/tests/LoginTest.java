package com.lwdd.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lwdd.pages.HomePage;
import com.lwdd.pages.LoginPage;
import com.lwdd.utils.ScreenshotUtil;

public class LoginTest extends BaseTest {

	@Test(description = "Test case 1: Positive LogIn test", priority = 1)

	public void validUserLogin() throws InterruptedException {

		try {

//		Test case 1: Positive LogIn test

			LoginPage loginPage = new LoginPage(driver);
			HomePage homePage = new HomePage(driver);

//		Type username student into Username field		
			loginPage.enterUsername("student");

//		Type password Password123 into Password field
			loginPage.enterPassword("Password123");

//		Push Submit button submit
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

//		Thread.sleep(3000);

			boolean status = homePage.isLogoutButtonVisible();

			Assert.assertTrue(status);
			homePage.clickOnLogoutButton();

		} catch (Exception e) {

			String path = ScreenshotUtil.takeScreenshot(driver, "validUserLogin");

			System.out.println(path);

		}

	}

	@Test(description = "Test case 2: Negative username test", priority = 2)

	public void invalidUserLogin() throws InterruptedException {

//			Test case 2: Negative LogIn test

		LoginPage loginPage = new LoginPage(driver);

//		Type username student into Username field		
		loginPage.enterUsername("wrongUser");

//		Type password Password123 into Password field
		loginPage.enterPassword("Password123");

//		Push Submit button submit
		loginPage.clickOnSubmitButton();
		
		Thread.sleep(3000);

//    		Verify error message is displayed
		WebElement errorMessage = driver.findElement(By.xpath("//div[@id=\"error\"]"));
		boolean status = errorMessage.isDisplayed();
		Assert.assertTrue(status);

//			Verify error message text is Your username is invalid!			
		String actText = errorMessage.getText();
		Assert.assertEquals(actText, "Your username is invalid!");

	}

}
