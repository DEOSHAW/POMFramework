package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UltimatixLoginPage {
	WebDriver Ultimatix_Driver;
	
	public UltimatixLoginPage(WebDriver driver)
	{
		Ultimatix_Driver=driver;
		PageFactory.initElements(Ultimatix_Driver, this);
	}
	
	public void FindScrewFixImage()
	{
		
		List<WebElement> Images=Ultimatix_Driver.findElements(By.tagName("img"));
		Iterator<WebElement> itr=Images.iterator();
		while(itr.hasNext())
		{
			WebElement ele=itr.next();
			String Text=ele.getAttribute("title");
			if(Text.contains("Hide username"))
			{
				System.out.println("Text matched");
				System.out.println("Actual Text is: "+Text);
				
				
			}
			
		}
		
	}

}
