package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TigerAnalytics
{
	WebDriver driver;
	
	public TigerAnalytics(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='About Us']")
	WebElement aboutUsMenuLink;
	
	@FindBy(css="div.impact-sub-link>p>a[href='/about-us/']")
	WebElement aboutUsLink;
	
	String navigateToAboutUsPage()
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(aboutUsMenuLink).click(aboutUsLink).perform();
		return driver.getTitle();
	}
}
