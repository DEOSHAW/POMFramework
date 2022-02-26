package Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.seleniumUtilities;

public class OracleApex {
	WebDriver driver;
	ExtentTest test;
	
	
	public OracleApex(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Sign In')]")
	WebElement initialSignInLink;
	@FindBy(xpath="//*[@placeholder='Workspace']")
	WebElement workspaceName;
	@FindBy(xpath="//*[@placeholder='Username']")
	WebElement Username;
	@FindBy(xpath="//*[@placeholder='Password']")
	WebElement Password;
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signIn;	
	@FindBy(xpath="//span[contains(text(),'SQL Workshop')]")
	WebElement sqlWorkshop;
	@FindBy(xpath="//span[contains(text(),'SQL Commands')]")
	WebElement sqlCommands;
	@FindBy(xpath="//*[@class='view-line']")
	WebElement sqlEditor;
	@FindBy(xpath="//button[text()='Run']")
	WebElement runButton;
	@FindBy(xpath="//*[@headers='ENAME']")
	WebElement empName;
	

	void executeQueryInOracleApex() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		WebDriverWait wait=new WebDriverWait(driver, 15);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		wait.until(ExpectedConditions.visibilityOf(initialSignInLink));
		initialSignInLink.click();
		wait.until(ExpectedConditions.visibilityOf(workspaceName));
		workspaceName.clear();
		workspaceName.sendKeys(seleniumUtilities.getDataForKey("WORKSPACE"));
		Thread.sleep(500);
		Username.clear();
		Username.sendKeys(seleniumUtilities.getDataForKey("EMAIL"));
		Thread.sleep(500);
		Password.clear();
		Password.sendKeys(seleniumUtilities.getDataForKey("PASSWORD"));
		Thread.sleep(500);
		signIn.click();
		test.log(LogStatus.PASS, "Login successful");
		wait.until(ExpectedConditions.visibilityOf(sqlWorkshop));
		js.executeScript("arguments[0].click();", sqlWorkshop);
		//sqlWorkshop.click();
		wait.until(ExpectedConditions.visibilityOf(sqlCommands));
		js.executeScript("arguments[0].click();", sqlCommands);
		//sqlCommands.click();
		wait.until(ExpectedConditions.visibilityOf(sqlEditor));
		//js.executeScript("arguments[0].innerHTML=arguments[1];", sqlEditor,seleniumUtilities.getDataForKey("QUERY"));
		Thread.sleep(8000);
		//sqlEditor.sendKeys(seleniumUtilities.getDataForKey("QUERY"));
		//sqlEditor.sendKeys(Keys.ENTER);
		js.executeScript("arguments[0].click();", runButton);
		//runButton.click();
		test.log(LogStatus.PASS, "Query executed");
		wait.until(ExpectedConditions.visibilityOf(empName));
		js.executeScript("alert(arguments[0])", "Employee name is: "+empName.getText());
		test.log(LogStatus.PASS, "Employee name displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
	}
}
