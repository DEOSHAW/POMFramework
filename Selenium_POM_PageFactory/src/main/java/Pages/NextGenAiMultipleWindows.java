package Pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class NextGenAiMultipleWindows 
{
	WebDriver driver;
	ExtentTest test;
	
	public NextGenAiMultipleWindows(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[contains(text(),'New Browser Window')]")
	WebElement newBrowserButton;
	
	
	String multipleWindowSwitchingDemo()
	{
		
		String parentWindow=driver.getWindowHandle();
		newBrowserButton.click();
		Set<String> allWindows=driver.getWindowHandles();
		for(String win:allWindows)
		{
			if(!parentWindow.equalsIgnoreCase(win))
			{
				driver.switchTo().window(win);
				break;
			}
		}
		String pageTitle=driver.getTitle();
		System.out.println("Page title is: "+pageTitle);
		return pageTitle;
		
		
		
		
	}

}
