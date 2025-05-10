package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RSAutomation 
{
	WebDriver driver;
	public RSAutomation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//p[text()='1. Java Interview Questions']/../../../following-sibling::div")
	WebElement goToLink;
	
	String navigateToJavaInterviewQuestionsSite()
	{
		String parentWin=driver.getWindowHandle();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", goToLink);
		goToLink.click();
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> itr=allWindows.iterator();
		String currentWin="";
		while(itr.hasNext())
		{
			currentWin=itr.next();
			if(!parentWin.equalsIgnoreCase(currentWin))
			{
				driver.switchTo().window(currentWin);
				break;
			}
		}
		return driver.getTitle();
		
		
	}

}
