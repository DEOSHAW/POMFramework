package Pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Nitto
{
	WebDriver driver;
	public Nitto(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='in/en/']")
	WebElement indiaLink;
	
	String navigateToIndiaWebSite()
	{
		String parentWindow=driver.getWindowHandle();
		indiaLink.click();
		Set<String> allWindows=driver.getWindowHandles();
		for(String window:allWindows)
		{
			if(!window.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		
		return driver.getTitle();
		
	}

}
