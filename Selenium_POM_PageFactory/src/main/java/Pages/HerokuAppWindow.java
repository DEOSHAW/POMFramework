package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HerokuAppWindow 
{
	WebDriver driver;
	
	public HerokuAppWindow(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='/windows/new']")
	WebElement clickHereLink;
	@FindBy(how=How.TAG_NAME,using="h3")
	WebElement newWindowHeading;
	
	String switchToNewWindow() throws InterruptedException
	{
		String currentWindow;
		String parentWindow=driver.getWindowHandle();
		clickHereLink.click();
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> itr=allWindows.iterator();
		while(itr.hasNext())
		{
			currentWindow=itr.next();
			if(!parentWindow.equalsIgnoreCase(currentWindow))
			{
				driver.switchTo().window(currentWindow);
				break;
			}
		}
		Thread.sleep(2000);
		
		return newWindowHeading.getText();
		
	}

}
