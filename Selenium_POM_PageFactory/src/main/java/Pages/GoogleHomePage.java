package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
	WebDriver Google_Driver;
	
	public GoogleHomePage(WebDriver driver)
	{
		Google_Driver=driver;
		PageFactory.initElements(Google_Driver, this);
		
	}
	
	@FindBy(xpath="//*[@name='q']")
	WebElement SearchBox;
	
	
	
	
	
	public void SearchForContent() throws InterruptedException
	{
		SearchBox.sendKeys("Selenium");
		Thread.sleep(2000);
		Actions action=new Actions(Google_Driver);
		JavascriptExecutor js=(JavascriptExecutor)Google_Driver;
		
	while(!((String) js.executeScript("return arguments[0].value", SearchBox)).contains("tutorial"))
	{
		
		action.sendKeys(SearchBox,Keys.ARROW_DOWN).perform();
		
		
	}
		String SearchValue=(String) js.executeScript("return arguments[0].value", SearchBox);
		System.out.println("You searched for: "+SearchValue);
		SearchBox.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		
		
	}

}
