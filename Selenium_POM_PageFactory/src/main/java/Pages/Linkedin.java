package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.seleniumUtilities;


public class Linkedin {
	WebDriver Linkedin_Driver;
	WebDriverWait wait;
	ExtentTest test1;
	
	
	
	public Linkedin(WebDriver driver,ExtentTest test)
	{
		Linkedin_Driver=driver;
		PageFactory.initElements(Linkedin_Driver, this);
		wait=new WebDriverWait(Linkedin_Driver,10);
		test1=test;
		
	}
	
	@FindBy(xpath="//*[text()='Sign in']")
	WebElement signIn;
	@FindBy(xpath="//*[@aria-label='Email or Phone']")
	WebElement Username;
	@FindBy(xpath="//*[@aria-label='Password']")
	WebElement Password;
	@FindBy(xpath="//*[@data-control-name='identity_welcome_message']")
	WebElement Name;
	@FindBy(xpath="//*[@data-control-name='identity_welcome_message']/following::p[1]")
	WebElement Skill;
	
	
	public void searchProfile()
	{
		String skill = null;
		String name;
		wait.until(ExpectedConditions.visibilityOf(signIn));
		seleniumUtilities.jsClick(Linkedin_Driver,signIn);
		test1.log(LogStatus.PASS, "Clicked on Sign In");
		wait.until(ExpectedConditions.visibilityOf(Username));
		seleniumUtilities.jsType(Linkedin_Driver,Username,"deoshaw3@gmail.com");
		test1.log(LogStatus.PASS, "Entered Username");
		wait.until(ExpectedConditions.visibilityOf(Password));
		seleniumUtilities.jsType(Linkedin_Driver,Password,"Dd03091991");
		test1.log(LogStatus.PASS, "Entered Password");
		wait.until(ExpectedConditions.visibilityOf(signIn));
		seleniumUtilities.jsClick(Linkedin_Driver,signIn);
		test1.log(LogStatus.FAIL, "Logged in");
		try
		{
		seleniumUtilities.jsClick(Linkedin_Driver,Name);
		name=Name.getText();
		skill=Skill.getText();
		System.out.println("Name: "+name+" Skill: "+skill);
		}
		catch(Exception e)
		{
		if(skill.length()>0)
		{
		test1.log(LogStatus.PASS, "Extracted Skill details");
		}
		else
		{
			test1.log(LogStatus.FAIL, "Extracted Skill details");	
		}
		
		}
		
		
		
		
		
		
	}

}
