package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationWindowsDemo
{
	WebDriver driver;
	
	public AutomationWindowsDemo(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="(//a[@data-toggle='tab'])[1]")
	WebElement openNewTabLink;
	@FindBy(css="button.btn.btn-info:nth-child(1)")
	WebElement clickLink;
	
	String getPageTitleOfNewWindow()
	{
		String parentWindow=driver.getWindowHandle();
		openNewTabLink.click();
		clickLink.click();
		Set<String> allWindows=driver.getWindowHandles();
		for(String window:allWindows)
		{
			if(!window.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		JavascriptExecutor js=(JavascriptExecutor)driver;
		new WebDriverWait(driver, Duration.ofSeconds(2)).until((ExpectedCondition<Boolean>) wd ->
        ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
		System.out.println(js.executeScript("return document.readyState").equals("complete"));
		return driver.getTitle();
		
	}

}
