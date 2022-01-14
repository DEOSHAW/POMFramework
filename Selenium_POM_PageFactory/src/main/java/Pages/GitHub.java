package Pages;

import java.io.File;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
	@FindBy(xpath="//*[@class='position-absolute color-bg-default rounded-2 color-fg-default px-2 py-1 left-0 bottom-0 ml-2 mb-2 border']")
	WebElement editButton;
	@FindAll({@FindBy(xpath="//*[@type='file']"),
	        @FindBy(className ="manual-file-chooser width-full ml-0")})
	WebElement uploadLink;
	@FindBy(xpath="//*[normalize-space(text())='Set new profile picture']")
	WebElement setProfilePicture;
	
	
	void uploadProfileImage(String Message) throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		//signInLink.click();
		//wait.until(ExpectedConditions.visibilityOf(Username));
		js.executeScript("arguments[0].value='deoshaw3@gmail.com';", Username);
		Thread.sleep(1500);
		js.executeScript("arguments[0].value='Devanshi@03';", Password);
		js.executeScript("arguments[0].click();", Login);
		test.log(LogStatus.PASS, "Login Successful");
		//Thread.sleep(100000);
		//editButton.click();
		uploadLink.sendKeys(System.getProperty("user.dir")+File.separator+"Profile_Image.jpeg");
		setProfilePicture.click();
		js.executeScript("alert(arguments[0])", Message);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Image uploaded");
	    GitHub_Driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
	}
	
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
