package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constant;
import utilities.PageUtility;

public class AdminUserPage {
	PageUtility pageutility=new PageUtility();
	public WebDriver driver;
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement addnewuser;
	@FindBy(id = "username")
	WebElement adminUsernameField;
	@FindBy(id = "password")
	WebElement adminPasswordField;
	@FindBy(id = "user_type")
	WebElement adminUserTypeField;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//a[@onclick=\'click_button(2)\']")
	WebElement searchOption;
	@FindBy(id = "un")
	WebElement searchUsernameField;
	@FindBy(id = "ut")
	WebElement searchUserTypeField;
	@FindBy(xpath = "//button[@value='sr']")
	WebElement searchButton;
	@FindBy(xpath = "//a[@class=\'btn btn-rounded btn-warning\']")
	WebElement resetOption;
	@FindBy(xpath = "//a[@class='page-link']")
	WebElement usernameresult;
	@FindBy(xpath = "//div[@class=\"alert ]alert-success alert-dismissible\"")
	WebElement alertmessage;

	// Add newUser
	public AdminUserPage clickAddNewUsersButton() {
		addnewuser.click();
		return this;

	}

	public AdminUserPage enterNewAdminUsernameInUsernameField(String username) {
		adminUsernameField.sendKeys(username);
		return this;
	}

	public AdminUserPage enterNewAdminUserPasswordInPasswordField(String password) {
		adminPasswordField.sendKeys(password);
		return this;
	}

	public AdminUserPage selectUserTypeONTypeField() {
		pageutility.selectDropdownWithValue(adminUserTypeField,Constant.SearchDropdownValue);
		return this;
	}

	public AdminUserPage clickSaveButton() {
		savebutton.click();
		return this;
	}

	// Search user
	public AdminUserPage clickSearchField() {
		searchOption.click();
		return this;
	}

	public AdminUserPage enterUsernameInUsernameField(String username1) {
		searchUsernameField.sendKeys(username1);
		return this;
	}

	public AdminUserPage enterUserTypeInUserTypeField() {
		pageutility.selectDropdownWithValue(searchUserTypeField,Constant.DropDownValue);
		//Select select = new Select(searchUserTypeField);
		//select.selectByValue("admin");
		return this;
	}

	public AdminUserPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	// reset option

	public AdminUserPage clickOnResetOption() {
		resetOption.click();
		return this;
	}

	public boolean viewAlertMessage() {
		return alertmessage.isDisplayed();
	}

	public boolean isSearchUserDisplayed() {
		return usernameresult.isDisplayed();
	}

	public boolean isResetButtonDisplayed() {
		return resetOption.isDisplayed();
	}

}
