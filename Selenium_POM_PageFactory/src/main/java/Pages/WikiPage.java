package Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WikiPage {
	
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	Actions actions;
	WebDriverWait wait;
	
	public WikiPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({
		@FindBy(name="search"),
		@FindBy(xpath="//*[@placeholder='Search Wikipedia']")
	               })
	WebElement searchBox;
	
	@FindBy(xpath="//*[@class='firstHeading']")
	WebElement textElement;
	
	@FindBy(xpath="//*[@class='firstHeading']/following::p[2]")
	WebElement Description;
	
	
	public void searchTopics() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		js=(JavascriptExecutor)driver;
		actions=new Actions(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		js.executeScript("arguments[0].value=arguments[1]",searchBox,"Oracle Corporation");
		searchBox.click();
		Thread.sleep(500);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//Thread.sleep(1000);
		//robot.keyPress(KeyEvent.VK_DOWN);
		//robot.keyRelease(KeyEvent.VK_DOWN);
		//Thread.sleep(1000);
		
		Thread.sleep(2000);
		//actions.sendKeys(Keys.ENTER).perform();
	    test.log(LogStatus.PASS, "Search performed");
		wait.until(ExpectedConditions.visibilityOf(textElement));
		String description=(String) js.executeScript("return arguments[0].innerHTML",Description);
		js.executeScript("alert(arguments[0])", description);
		test.log(LogStatus.PASS, "Result displayed");
		Thread.sleep(2800);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
		
		
		
		
		
	}
	

}
