package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuShadowDom
{
	WebDriver driver;
	
	public HerokuShadowDom(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//my-paragraph[2]")
	WebElement shadowDomParagraph;
	
	String getShadowDomElementText()
	{
		return shadowDomParagraph.getShadowRoot().findElement(By.cssSelector("slot[name='my-text']")).getText();
		
	}
}
