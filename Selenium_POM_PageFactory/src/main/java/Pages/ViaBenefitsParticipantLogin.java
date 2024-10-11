package Pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViaBenefitsParticipantLogin
{
	WebDriver driver;
	
	public ViaBenefitsParticipantLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#username")
	WebElement userNameInputBox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	@FindBy(xpath="//label[text()='Password']/following-sibling::input")
	WebElement passwordInputBox;
	@FindBy(css="p.err-message:nth-child(2)")
	WebElement errorMessageElement;
	
	String loginAsParticipantWithWrongCredentials()
	{
		userNameInputBox.sendKeys("Test123@gmail.com");
		continueButton.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
		passwordInputBox.sendKeys("test123");
		passwordInputBox.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(errorMessageElement));
		return errorMessageElement.getText();
		
	}

}
