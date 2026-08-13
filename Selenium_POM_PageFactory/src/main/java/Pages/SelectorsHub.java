package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectorsHub 
{
	WebDriver driver;
	
	public SelectorsHub(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div#userName")
	WebElement userNameSection;

	void typeInsideShadowDom() throws InterruptedException
	{
		userNameSection.getShadowRoot().findElement(By.cssSelector("input[placeholder='enter name']"))
		.sendKeys("Test User");
		Thread.sleep(3000);
    }
}
