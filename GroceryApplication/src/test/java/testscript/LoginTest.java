 package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test(priority=1,description="verifying successfull login with valid credentials",groups= {"Smoke"})
	public void verifyUserWithValidCredentials() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		boolean isdashboardispalyed=loginpage.dashboardDisplayed();
		Assert.assertTrue(isdashboardispalyed,Constant.ValidCredentialErrorMessage);
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
		
		String actual=loginpage.getSignInTitle();
		String expected="Sign in to start your session";
		Assert.assertEquals(actual, expected,Constant.InvalidUsernamePasswordErrorMessage);
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
		String actual=loginpage.getPageTitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.InvalidPasswordUsernameErrorMessage);
		
	}
	@Test(priority = 4, description="verifying user login with Invalid username and Invalid password",groups= {"Smoke"},dataProvider="loginProvider")
	public void verifyUserWithInalidUsernameAndInvalidPassword(String username,String password) throws IOException
	{
		//String username=ExcelUtility.getStringData(3, 0, "LoginPage");
		//String password=ExcelUtility.getStringData(3, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		
		String actual=loginpage.getPageTitle();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.InvalidCredentialErrorMessage);
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		
		};
}
}

