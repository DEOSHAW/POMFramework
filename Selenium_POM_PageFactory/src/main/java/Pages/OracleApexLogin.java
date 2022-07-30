package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class OracleApexLogin {
	WebDriver driver;
	ExtentTest test;
	
	
	public OracleApexLogin(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath="//*[@placeholder='Workspace']")
	WebElement Workspace;
	@FindBy(xpath="//*[@placeholder='Username']")
	WebElement Username;
	@FindBy(xpath="//*[@placeholder='Password']")
	WebElement Password;
	@FindBy(xpath="(//*[@type='button'])[2]")
	WebElement logIn;
	@FindBy(xpath="//*[@class='a-User-name']")
	WebElement accountUser;
	
	
	
	void Login(String wk,String userName,String pwd) throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		signIn.click();
		Workspace.sendKeys(wk);
		Username.sendKeys(userName);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]", Password,pwd);
		js.executeScript("arguments[0].click();", logIn);
		try
		{
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')", accountUser);
		test.log(LogStatus.PASS, "Login successful");
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Login Failed");
			
		}
		
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
