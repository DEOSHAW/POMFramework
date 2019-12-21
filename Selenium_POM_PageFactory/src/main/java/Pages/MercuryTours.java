package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MercuryTours {
	WebDriver Tours_Driver;
	
	public MercuryTours(WebDriver driver)
	{
		Tours_Driver=driver;
		PageFactory.initElements(Tours_Driver, this);
		
	}
	
	public void ExtractText()
	{
		String page_Source=Tours_Driver.getPageSource();
		System.out.println(page_Source);
		boolean Boolean=page_Source.contains("Registered");
		if(Boolean)
		{
			
			Assert.assertTrue(Boolean, "Text validation successful");
			
		}
		else
		{
			Assert.assertTrue(Boolean, "Text validation Unsuccessful");
		}
		
	}

}
