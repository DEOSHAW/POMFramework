package Pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnePlus 
{
	WebDriver driver;
	public OnePlus(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@href=\"/store\" and not(contains(@tabindex,-1))]")
	WebElement storeLink;
	
	
	String navigateToStore()
	{
		String parentWin=driver.getWindowHandle();
		storeLink.click();
		Set<String> allWindows=driver.getWindowHandles();
		for(String win:allWindows)
		{
			if(!parentWin.equals(win))
			{
				driver.switchTo().window(win);
				break;
			}
		}
		return driver.getCurrentUrl();
		
	}

}
