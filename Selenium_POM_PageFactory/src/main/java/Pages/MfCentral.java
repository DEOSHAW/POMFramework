package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MfCentral 
{
	WebDriver driver;
	public MfCentral(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'quick-links-info')]//p")
	List<WebElement> quickLinkList;
	
	List<String> getQuickLinks() throws InterruptedException
	{
		String quickLinkText;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(3000);
		List<String> quickLinks=new ArrayList<String>();
		for(WebElement quickLink:quickLinkList)
		{
			quickLinkText=(String) js.executeScript("return arguments[0].innerHTML;", quickLink);
			quickLinkText=quickLinkText.trim();
			quickLinks.add(quickLinkText.replaceAll("[^A-Za-z ]","").replaceAll("br", ""));
			
		}
		return quickLinks;
		
	}
	
	

}
