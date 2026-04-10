package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MastersGolf 
{
	WebDriver driver;
	public MastersGolf(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	String getMastersPageTitle()
	{
		return driver.getTitle();
	}

}
