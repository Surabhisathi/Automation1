package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base
{
	@Test(description="User can successfully logout",retryAnalyzer=retry.Retry.class)
	public void verifyWhetherUserCanSuccessfullyLogout() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		HomePage homepage =new HomePage(driver);
		homepage.clickTheAdminIcon();
		homepage.clickTheLogoutOption();
		homepage.clickAdminUserTile();
		homepage.clickManageNewsMoreInfo();
		
		boolean isloginpagemessageDisplayed=homepage.loginPagemessageDisplayed();
		Assert.assertTrue(isloginpagemessageDisplayed,Constant.SuccessfullyLogoutErrorMessage);
		
		
	}
}
