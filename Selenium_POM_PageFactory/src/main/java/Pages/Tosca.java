package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Tosca
{
	WebDriver driver;
	public Tosca(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	String getToscaTitle()
	{
		
		return driver.getTitle();
				
	}

}
