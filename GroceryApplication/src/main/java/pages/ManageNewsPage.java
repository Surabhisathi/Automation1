package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage
{
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//a[@class=\'btn btn-rounded btn-danger\']") WebElement newOption;
	@FindBy(id="news") WebElement newsField;
	@FindBy(xpath="//button[@class=\'btn btn-danger\']") WebElement saveButton;
	@FindBy(xpath="//a[@onclick=\'click_button(2)\']") WebElement searchOption;
	@FindBy(name="un") WebElement enterTitleField;
	@FindBy(name="Search") WebElement searchButton;
	//@FindBy(xpath="//a[@class=\'btn btn-rounded btn-warning\']") WebElement resetOption;
	
	
	public void clickNewOption()
	{
		newOption.click();
	}
	public void enterTheNewsOnNewsField(String news)
	{
		newsField.sendKeys(news);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	public void clickSearchOption()
	{
		searchOption.click();
	}
	public void enterTheNewsOnSerachField(String news)
	{
		enterTitleField.sendKeys(news);
	}
	public void clickSearchButton()
	{
		searchButton.click();
	}
	/*public void clickResetOption()
	{
		resetOption.click();
	}*/
}
