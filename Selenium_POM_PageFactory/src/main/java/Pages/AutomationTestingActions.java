package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationTestingActions
{
	WebDriver driver;
	
	public AutomationTestingActions(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Hold Shift & Click Here']")
	WebElement holdShiftAndClickButton;
	
	String holdShiftAndClick() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.SHIFT).pause(500).click(holdShiftAndClickButton).pause(100).keyUp(Keys.SHIFT).pause(500).perform();
		String successmsg=driver.switchTo().alert().getText();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		return successmsg;
	}

}