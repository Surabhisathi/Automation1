package testscript;


import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUserTest extends Base
{
	@Test(description="User can successfully add new users ")
	public void verifyWhetherUserIsAbleToAddNewUsers() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		HomePage homepage =new HomePage(driver);
		homepage.clickAdminUserTile();
		
		FakerUtility utility=new FakerUtility();
		String adminusername=utility.createRandomUserName();
		String adminpassword=utility.createRandomPassword();
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.clickAddNewUsersButton();
		adminuserpage.enterNewAdminUsernameInUsernameField(adminusername);
		adminuserpage.enterNewAdminUserPasswordInPasswordField(adminpassword);
		adminuserpage.selectUserTypeONTypeField();
		adminuserpage.clickSaveButton();

		}
	@Test(description="User can successfully search newly added users")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedUsers() throws IOException
	{

		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		HomePage homepage =new HomePage(driver);
		homepage.clickAdminUserTile();
		
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.clickSearchField();
		String adminusername=ExcelUtility.getStringData(4, 0,"LoginPage");
		adminuserpage.enterUsernameInUsernameField(adminusername);
		adminuserpage.enterUserTypeInUserTypeField();
		adminuserpage.clickOnSearchButton();
		
		
		
	}
	@Test(description="User can successfully reset newly added users")
	public void verifyWhetherUserIsAbleToResetNewlyAddedUsers() throws IOException
	{

		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		HomePage homepage =new HomePage(driver);
		homepage.clickAdminUserTile();
		
		AdminUserPage adminuserpage=new AdminUserPage(driver);
		adminuserpage.clickOnResetOption();
	}
}
