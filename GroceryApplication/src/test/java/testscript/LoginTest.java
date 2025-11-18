 package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(priority=1,description="verifying successfull login with valid credentials")
	public void verifyUserWithValidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(10, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		boolean isdashboardispalyed=loginpage.dashboardDisplayed();
		Assert.assertTrue(isdashboardispalyed, "user is not able to login with valid credentials");
	}
	@Test(priority = 2,description="verifying user login with Invalid username and valid password")
	public void verifyUserWithInvalidUsernameAndValidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(1, 0, "LoginPage");
		String password=ExcelUtility.getStringData(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		
		String actual=loginpage.getPageTitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,"user was able to login with invalid username");
	}
	@Test(priority = 3, description="verifying user login with valid username and Invalid password")
	public void verifyUserWithValidUsernameAndInvalidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(2, 0, "LoginPage");
		String password=ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		
		boolean isdashboardispalyed=loginpage.dashboardDisplayed();
		Assert.assertFalse(isdashboardispalyed, "user is able to login with Invalid password");
	}
	@Test(priority = 4, description="verifying user login with Invalid username and Invalid password")
	public void verifyUserWithInalidUsernameAndInvalidPassword() throws IOException
	{
		String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		
		boolean isdashboardisplayed=loginpage.dashboardDisplayed();
		Assert.assertFalse(isdashboardisplayed, "User is able to login with Invalid credentials");
	}
}

