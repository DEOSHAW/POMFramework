package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuRedirection 
{
	WebDriver driver;
	public HerokuRedirection(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a#redirect")
	WebElement redirectHereLink;
	
	String getRedirectedPageUrl()
	{
		redirectHereLink.click();
		return driver.getCurrentUrl();
		
	}
	
	

}
