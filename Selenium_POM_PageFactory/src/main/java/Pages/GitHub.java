package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GitHub {
	
	WebDriver GitHub_Driver;
	ExtentTest test;
	WebDriverWait wait=null;
	JavascriptExecutor js=null;
	Actions action=null;
	
	public GitHub(WebDriver driver,ExtentTest test)
	{
		GitHub_Driver=driver;
		this.test=test;
		PageFactory.initElements(GitHub_Driver, this);
		wait=new WebDriverWait(GitHub_Driver,20);
		js=(JavascriptExecutor)GitHub_Driver;
		action=new Actions(GitHub_Driver);
		
	}
	
	@FindBy(xpath="//*[contains(@data-ga-click,'Sign in')]")
	WebElement signInLink;
	@FindBy(xpath="//*[normalize-space(text())='Username or email address']/following::input[1]")
	WebElement Username;
	@FindBy(xpath="//*[normalize-space(text())='Password']/following::input[1]")
	WebElement Password;
	@FindBy(xpath="//*[@value='Sign in']")
	WebElement Login;
	@FindBy(xpath="//*[@aria-label='View profile and more']")
	WebElement viewProfile;
	@FindBy(xpath="//*[text()='Your repositories']")
	WebElement yourRepositories;
	@FindBy(xpath="(//*[contains(@data-hydro-click,'TAB_REPOSITORIES')]/child::span)[1]")
	WebElement Repositories;
	
	
	public void getRepositoryCount() throws InterruptedException
	{
		
		signInLink.click();
		wait.until(ExpectedConditions.visibilityOf(Username));
		js.executeScript("arguments[0].value='deoshaw3@gmail.com';", Username);
		Thread.sleep(1500);
		js.executeScript("arguments[0].value='Devanshi@03';", Password);
		js.executeScript("arguments[0].click();", Login);
		test.log(LogStatus.PASS, "Login Successful");
		wait.until(ExpectedConditions.visibilityOf(viewProfile));
		action.moveToElement(viewProfile).click(viewProfile).build().perform();
		wait.until(ExpectedConditions.visibilityOf(yourRepositories));
		yourRepositories.click();
		int repoCount=Integer.parseInt(Repositories.getText());
		System.out.println("Number Of Repositories is: "+repoCount);
		test.log(LogStatus.PASS, "Repository count is: "+repoCount);
		
		
	}

}
