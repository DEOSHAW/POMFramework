package Pages;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

public class Infosys 
{
	WebDriver driver;
	ExtentTest test;
	
	public Infosys(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[contains(@title,'Infosys Knowledge Institute Business')]")
	WebElement infosysInstituteLink;
	
	@FindBy(how=How.XPATH,using="//a[@title='Learn More']")
	WebElement learnLink;
	
	boolean navigateToKnowledgeInstitute() throws Exception
	{
		String parentWindow=driver.getWindowHandle();
		String inputKeys=Keys.chord(Keys.CONTROL,Keys.ENTER);
		infosysInstituteLink.sendKeys(inputKeys);
		Set<String> allWindows=driver.getWindowHandles();
		for(String Window:allWindows)
		{
			if(!Window.equalsIgnoreCase(parentWindow))
			{
			driver.switchTo().window(Window);
			break;
			}
		}
		try
		{
			//System.out.println(driver.getCurrentUrl());
		if(learnLink.isEnabled())
		{
			return true;
			
		}
		else
		{
			
			return false;
		}
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			return false;
		}
		
		
		
		
	}

}
