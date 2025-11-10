package automationcore;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	public WebDriver driver;
	@BeforeMethod
	public void intializeBrowser()
	{
		 driver =new ChromeDriver(); 
		 driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@AfterMethod
	public void closeAndQuit()
	{
		//driver.close();
		//driver.quit();
	}

}
