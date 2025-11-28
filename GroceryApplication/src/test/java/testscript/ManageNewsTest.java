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

public class ManageNewsTest extends Base {
	HomePage homePage;
	ManageNewsPage managenewspage;

	@Test
	public void verifyWhetherUserCanAddNewNews() throws IOException{
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homePage = loginpage.clickSignIninButton();
		managenewspage = homePage.clickManageNewsMoreInfo();
		String news = ExcelUtility.getStringData(0, 0, "NewsPage");
		managenewspage.clickNewOption().enterTheNewsOnNewsField(news).enterTheNewsOnNewsField(news).clickSaveButton();
		boolean isAlertDisplayed = managenewspage.alertIsDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constant.AddNewNewsErrorMessage);
	}

	@Test
	public void verifyWhetherUserCanSearchNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		homePage = loginpage.clickSignIninButton();
		managenewspage = homePage.clickManageNewsMoreInfo();
		managenewspage.clickSearchOption();
		String news = ExcelUtility.getStringData(0, 0, "NewsPage");
		managenewspage.enterTheNewsOnSerachField(news).clickSearchButton();
		boolean isSearchbuttonDisplayed = managenewspage.isSearchedUserDisplayed();
		Assert.assertTrue(isSearchbuttonDisplayed, Constant.SearchNewsErrorMesage);
	}
}
