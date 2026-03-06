package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class IBSF
{
	WebDriver driver;
	
	public IBSF(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	String menuLocator="//a[contains(text(),'%s')]";
	
	String getTheMenuText(String text)
	{
		String menuLocatorUpdated=String.format(menuLocator, text);
		return driver.findElement(By.xpath(menuLocatorUpdated)).getText();
		
	}

}
