package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AnnaUniversity
{
	WebDriver driver;
	public AnnaUniversity(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='sub-menu tab-content']/preceding-sibling::a")
	WebElement aboutUs;
	
	@FindBy(how=How.XPATH,using="//a[text()='About us: Overview']")
	WebElement aboutUsLink;
	
	String navigateToAboutPage()
	{
		String parentWindow=driver.getWindowHandle();
		Actions actions=new Actions(driver);
		actions.moveToElement(aboutUs).pause(Duration.ofSeconds(1)).click(aboutUsLink).perform();
		Set<String> allWindows=driver.getWindowHandles();
		for(String win:allWindows)
		{
			if(!parentWindow.equals(win))
			{
				driver.switchTo().window(win);
				break;
			}
		}
		return driver.getCurrentUrl();
	}
}
