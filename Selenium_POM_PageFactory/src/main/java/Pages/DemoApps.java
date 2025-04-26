package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DemoApps 
{
	WebDriver driver;
	public DemoApps(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	void enterLoginCredentials() throws Exception
	{
		//For shadow root, We need to use css selectors, xpaths do not work here
		driver.findElement(By.cssSelector("div.my-3:nth-child(1)")).getShadowRoot()
		.findElement(By.cssSelector("input[placeholder='Enter your username']")).sendKeys("Test");
		
		driver.findElement(By.cssSelector("div.my-3:nth-child(2)")).getShadowRoot()
		.findElement(By.cssSelector("input[placeholder='Enter your password']")).sendKeys("Test123");
		Thread.sleep(3000);
	}

}
