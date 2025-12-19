package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrookField 
{
	WebDriver driver;
	public BrookField(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Accept All Cookies']")
	WebElement acceptCookies;
	@FindBy(xpath="(//span[text()='Who We Are'])[1]")
	WebElement whoWeAreLink;
	@FindBy(xpath="//div[normalize-space(text())='Our Approach']/following-sibling::h2")
	WebElement aboutUsText;
	@FindBy(xpath="(//button[text()='About Us'])[1]")
	WebElement aboutUsMenuLink;
	
	String getAboutUs()
	{
		Actions actions=new Actions(driver);
		acceptCookies.click();
		actions.moveToElement(aboutUsMenuLink).perform();
		whoWeAreLink.click();
		return aboutUsText.getText();
	}
}
