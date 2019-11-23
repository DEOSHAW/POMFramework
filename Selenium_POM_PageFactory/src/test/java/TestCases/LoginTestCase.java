package TestCases;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.LoginAmazon;

public class LoginTestCase extends Baseclass  {
	
	
	
	
	@Test(dataProvider="DataSupplier")
	public void Login(String Username,String Password) throws InterruptedException, AWTException
	{
		/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		LoginAmazon ob=new LoginAmazon(driver);
		ob.LoginMethod(Username, Password);
		//Actions action=new Actions(driver);
		//action.sendKeys(Keys.chord(Keys.ALT+"a"));
		
		
	
	 }
	
	/*@Test
	public void NavigateToOrders() throws InterruptedException
	{
		LoginAmazon ob=new LoginAmazon(driver);
		ob.GoToOrders();
		
		
	}*/
	

}
