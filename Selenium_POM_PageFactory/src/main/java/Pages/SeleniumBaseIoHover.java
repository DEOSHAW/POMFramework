package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SeleniumBaseIoHover 
{
	WebDriver driver;
	
	public SeleniumBaseIoHover(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS,using="div#myDropdown")
	WebElement hoverDropdown;
	@FindBy(xpath="//a[contains(@id,'dropOption')]")
	List<WebElement> allMenuOptions;
	
	
	
	List<String> getMenuOptions()
	{
		Actions actions=new Actions(driver);
		FluentWait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(hoverDropdown));
		
		actions.moveToElement(hoverDropdown).pause(Duration.ofSeconds(3)).perform();
		Iterator<WebElement> itr=allMenuOptions.iterator();
		List<String> allOptions=new ArrayList<String>();
		while(itr.hasNext())
		{
			allOptions.add(itr.next().getText());
		}
				
		return allOptions;
		
	}

}
