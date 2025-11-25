package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="username") WebElement usernameField;
	@FindBy(name="password") WebElement passwordField;
	@FindBy(xpath="//button[text()=\"Sign In\"]") WebElement signinbutton;
	@FindBy(xpath="//p[text()=\'Dashboard\']") WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement title;
	@FindBy(xpath="//p[text()='Sign in to start your session']") WebElement signintitle;
	
	public void enterUsernameOnUsernameField(String username) 
	{
		usernameField.sendKeys(username);
	}
	public void enterPasswordOnPasswordField(String password)
	{
		passwordField.sendKeys(password);
	} 
	public void clickSignIninButton() 
	{
		signinbutton.click();
	}
	public boolean dashboardDisplayed()
	{
		return dashboard.isDisplayed();
	}
	public String getPageTitle()
	{
		return title.getText();
	}
	public String getSignInTitle() 
	{
		return signintitle.getText();
	}
}
