package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;

	String userName = null;
	String password =null;
	String DashboardValidationText = null;

	@Test
	@Parameters({"userName", "password"})
	public void ValidUserShouldBeAbleToLogin(String userName, String password) {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();

		 DashboardPage dashboardPage = PageFactory.initElements(driver,
		 DashboardPage.class);
		 dashboardPage.varifyDashboardPage(DashboardValidationText);

		BrowserFactory.TearDown();
	}

}
