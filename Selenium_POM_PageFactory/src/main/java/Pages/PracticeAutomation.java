package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PracticeAutomation 
{
	WebDriver driver;
	
	public PracticeAutomation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CSS, using="input#username")
	WebElement userNameInputBox;
	
	@FindBy(how=How.CSS, using="input#password")
	WebElement passwordInputBox;
	
	@FindBy(how=How.CSS, using="button#submit")
	WebElement loginButton;
	
	@FindBy(how=How.CSS, using="h1.post-title")
	WebElement loginSuccessMessage;
	
	String login(String userName, String password)
	{
		userNameInputBox.sendKeys(userName);
		passwordInputBox.sendKeys(password);
		loginButton.click();
		
		return loginSuccessMessage.getText();
	}
}
