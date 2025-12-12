package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewFront 
{
	WebDriver driver;
	public NewFront(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement loginLink;
	@FindBy(xpath="//img[@alt='Newfront logo']")
	WebElement newFrontLogo;
	
	String navigateToLoginPage()
	{
		String parentWindow=driver.getWindowHandle();
		loginLink.click();
		Set<String> allWindows=driver.getWindowHandles();
		for(String window:allWindows)
		{
			if(!parentWindow.equalsIgnoreCase(window))
			{
				driver.switchTo().window(window);
				break;
			}
		}
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(newFrontLogo));
		
		return driver.getCurrentUrl();
		
	}

}
