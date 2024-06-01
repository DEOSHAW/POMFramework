package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mahindra
{
	WebDriver driver;
	
	public Mahindra(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='our businesses']")
	WebElement ourBusinessesLink;
	
	@FindBy(xpath="//a[text()='Overview']")
	WebElement overviewLink;
	
	@FindBy(xpath="//a[text()='OUR BUSINESSES']")
	WebElement ourBusinessesFooterLink;
	
	@FindBy(xpath="//a[text()='OUR BUSINESSES']/parent::span/following-sibling::ul/li/a")
	List<WebElement> businessVerticals;
	
	List<String> getBusinessVerticals() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(ourBusinessesLink).pause(Duration.ofSeconds(1)).click(overviewLink).perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ourBusinessesFooterLink);
		Thread.sleep(2000);
		Iterator<WebElement> itr=businessVerticals.iterator();
		List<String> businessVerticalsList=new ArrayList<String>();
		while(itr.hasNext())
		{
			businessVerticalsList.add(itr.next().getText());		
		}
		return businessVerticalsList;
		
	}	

  }
