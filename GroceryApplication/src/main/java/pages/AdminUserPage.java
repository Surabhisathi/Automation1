package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage 
{
	public WebDriver driver;
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement addnewuser;
	@FindBy(id="username") WebElement adminUsernameField;
	@FindBy(id="password") WebElement adminPasswordField;
	@FindBy(id="user_type") WebElement adminUserTypeField;
	@FindBy(xpath = "//button[@name='Create']") WebElement savebutton;
	@FindBy(xpath="//a[@onclick=\'click_button(2)\']") WebElement searchOption;
	@FindBy(id="un") WebElement searchUsernameField;
	@FindBy(id="ut") WebElement searchUserTypeField;
	@FindBy(xpath="//button[@value='sr']") WebElement searchButton;
	@FindBy(xpath="//a[@class=\'btn btn-rounded btn-warning\']") WebElement resetOption;
	@FindBy(xpath="//a[@class='page-link']")WebElement usernameresult;
	@FindBy(xpath="//div[@class=\"alert ]alert-success alert-dismissible\"") WebElement alertmessage;

	
	
	//Add newUser
	public void clickAddNewUsersButton()
	{
		addnewuser.click();
	
	}
	public void enterNewAdminUsernameInUsernameField(String username) 
	{
		adminUsernameField.sendKeys(username);
	}
	public void enterNewAdminUserPasswordInPasswordField(String password)
	{
		adminPasswordField.sendKeys(password);
	}
	public void selectUserTypeONTypeField()
	{
		Select select=new Select(adminUserTypeField);
		select.selectByValue("admin");
	}
	public void clickSaveButton()
	{
		savebutton.click();
	}
	
	
	//Search user
	public void clickSearchField()
	{
		searchOption.click();
	}
	public void enterUsernameInUsernameField(String username1) 
	{
		searchUsernameField.sendKeys(username1);
	}
	public void enterUserTypeInUserTypeField()
	{
		Select select=new Select(searchUserTypeField);
		select.selectByValue("admin");
	}
	public void clickOnSearchButton() 
	{
		searchButton.click();
	}
	
	//reset option
	
	public void clickOnResetOption() 
	{
		resetOption.click();
	}
	public boolean viewAlertMessage()
	{
		return alertmessage.isDisplayed();
	}
	public boolean isSearchUserDisplayed()
	{
		return usernameresult.isDisplayed();
	}
	public boolean isResetButtonDisplayed() 
	{
		return resetOption.isDisplayed();
	}
	
}

