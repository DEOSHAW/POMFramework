package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QSpiderFrames
{
	WebDriver driver;
	public QSpiderFrames(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="input#username")
	WebElement userTextBox;
	@FindBy(css="input#password")
	WebElement passwordTextBox;
	@FindBy(css="button#submitButton")
	WebElement loginButton;
	@FindBy(xpath="//div[@role='status']")
	WebElement loginSuccessMessage;
	@FindBy(xpath="//iframe")
	WebElement frameElement;
	
	String Login()
	{
		driver.switchTo().frame(frameElement);
		userTextBox.sendKeys("test");
		passwordTextBox.sendKeys("test");
		loginButton.click();
		driver.switchTo().defaultContent();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return (String) js.executeScript("return arguments[0].innerHTML;", loginSuccessMessage);
		
	}

}
