package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	public static int EXPLICITWAIT=5;
	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) 
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilElementIsVisible(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitUntilElementToBeSelected(WebDriver driver, WebElement element) 
	{

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void waitUntilTextIsPresent(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, null));
	}
	public void waitUntilAllElementsIsVisible(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOfAllElements(element, null));
	}
	

}
