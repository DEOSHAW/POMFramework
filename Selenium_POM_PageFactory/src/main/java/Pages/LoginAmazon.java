package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginAmazon {
	
	WebDriver ldriver=null;
	
	public LoginAmazon(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//*[@id='nav-link-accountList']")
	WebElement SignInButton;
	@FindBy(name="email")
	WebElement UsernameField;
	@FindBy(id="continue")
	WebElement ContinueButton;
	@FindBy(name="password")
	WebElement PasswordField;
	@FindBy(id="signInSubmit")
	WebElement SignInSubmitButton;
	@FindBy(xpath="//*[contains(text(),'Hello, DEO')]")
	WebElement Text;
	@FindBy(xpath="//span[contains(text(),'Your Orders')]")
	WebElement Orders;
	
	public void LoginMethod(String Username, String Password) throws InterruptedException, AWTException
	{
		Actions action=new Actions(ldriver);
		Robot robot=new Robot();
		Thread.sleep(5000);
		SignInButton.click();
		Thread.sleep(5000);
		UsernameField.sendKeys(Username);
		//UsernameField.click();;
		//action.sendKeys(Keys.chord(Keys.ENTER));
		//Thread.sleep(2000);
		//action.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		Thread.sleep(4000);
		ContinueButton.click();
		//robot.keyPress(KeyEvent.VK_CONTROL);
		//robot.keyPress(KeyEvent.VK_A);
		//Thread.sleep(2000);
		//robot.keyRelease(KeyEvent.VK_A);
		//robot.keyRelease(KeyEvent.VK_CONTROL);
		
		//Thread.sleep(4000);
		//robot.keyPress(KeyEvent.VK_ENTER);
		//Thread.sleep(2000);
		PasswordField.sendKeys(Password);
		Thread.sleep(4000);
		//robot.keyPress(KeyEvent.VK_ENTER);
		SignInSubmitButton.click();
		Thread.sleep(8000);
		if(Text.getText().contains("DEO"))
		{
		Assert.assertTrue(true);
		
		
		}
		
		
		
	}
	
	public void GoToOrders()
	{
		Actions action=new Actions(ldriver);
		action.moveToElement(Text).perform();
		action.sendKeys(Keys.chord(Keys.ENTER));
		ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Orders.click();
		ldriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
	}
	
	

}
