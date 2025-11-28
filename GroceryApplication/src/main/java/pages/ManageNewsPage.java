package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class=\'btn btn-rounded btn-danger\']")
	WebElement newOption;
	@FindBy(id = "news")
	WebElement newsField;
	@FindBy(xpath = "//button[@class=\'btn btn-danger\']")
	WebElement saveButton;
	@FindBy(xpath = "//a[@onclick=\'click_button(2)\']")
	WebElement searchOption;
	@FindBy(name = "un")
	WebElement enterTitleField;
	@FindBy(name = "Search")
	WebElement searchButton;
	@FindBy(xpath = "//a[@class=\'btn btn-rounded btn-warning\']")
	WebElement resetOption;
	@FindBy(xpath = "//div[@class=\'alert alert-success alert-dismissible\']")
	WebElement alert;

	public ManageNewsPage clickNewOption() {
		newOption.click();
		return this;
	}

	public ManageNewsPage enterTheNewsOnNewsField(String news) {
		newsField.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	public ManageNewsPage clickSearchOption() {
		searchOption.click();
		return this;
	}

	public ManageNewsPage enterTheNewsOnSerachField(String news) {
		enterTitleField.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSearchButton() {
		searchButton.click();
		return this;
	}

	public ManageNewsPage clickResetOption() {
		resetOption.click();
		return this;
	}

	public boolean alertIsDisplayed() {
		return alert.isDisplayed();
	}

	public boolean isSearchedUserDisplayed() {
		return searchButton.isDisplayed();
	}
}
