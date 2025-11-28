package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility waitUtility=new WaitUtility();
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminicon;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutoption;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminusertile;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement manageNewsMoreInfo;
	@FindBy(xpath = "\"//b[text()='7rmart supermarket']\"")
	WebElement loginpagemessage;

	public HomePage clickTheAdminIcon() {
		adminicon.click();
		return this;
	}

	public LoginPage clickTheLogoutOption() {
		waitUtility.waitUntilElementToBeClickable(driver, logoutoption);
		logoutoption.click();
		return new LoginPage(driver);
	}

	public AdminUserPage clickAdminUserTile() {
		adminusertile.click();
		return new AdminUserPage(driver);
	}

	public ManageNewsPage clickManageNewsMoreInfo() {
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}

	public boolean loginPagemessageDisplayed() {
		return loginpagemessage.isDisplayed();
	}
}
