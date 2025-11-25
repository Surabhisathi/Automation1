package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest  extends Base
{
	@Test
	public void verifyWhetherUserCanAddNewNews() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		HomePage homePage=new HomePage(driver);
		homePage.clickManageNewsMoreInfo();
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickNewOption();
		String news=ExcelUtility.getStringData(0, 0,"NewsPage");
		managenewspage.enterTheNewsOnNewsField(news);
		managenewspage.clickSaveButton();
		
		boolean isAlertDisplayed=managenewspage.alertIsDisplayed();
		Assert.assertTrue(isAlertDisplayed,Constant.AddNewNewsErrorMessage);
	}
	@Test
	public void verifyWhetherUserCanSearchNews() throws IOException
	{
		String username=ExcelUtility.getStringData(0, 0, "LoginPage");
		String password=ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickSignIninButton();
		HomePage homePage=new HomePage(driver);
		homePage.clickManageNewsMoreInfo();
		
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.clickSearchOption();
		String news=ExcelUtility.getStringData(0, 0, "NewsPage");
		managenewspage.enterTheNewsOnSerachField(news);
		managenewspage.clickSearchButton();
		
		boolean isSearchbuttonDisplayed=managenewspage.isSearchedUserDisplayed();
		Assert.assertTrue(isSearchbuttonDisplayed,Constant.SearchNewsErrorMesage);
	}
}
