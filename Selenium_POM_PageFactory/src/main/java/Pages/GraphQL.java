package Pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GraphQL {
	WebDriver driver;
	ExtentTest test;
	Actions actions;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	
	public GraphQL(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="hero-search-input")
	WebElement searchBox;
	@FindBy(xpath="//h1[contains(text(),'Introduction to GraphQL')]")
	WebElement resultTitle;
	@FindBy(xpath="//h1[contains(text(),'Introduction to GraphQL')]/parent::div/child::div/child::p[1]")
	WebElement graphQLInfo;
	
	void searchInfo() throws Exception
	{
		int size=-1;
		test.log(LogStatus.PASS, "Test started");
		actions=new Actions(driver);
		actions.keyDown(Keys.SHIFT).perform();
		searchBox.sendKeys("graphql");
		actions.keyUp(Keys.SHIFT).perform();
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ENTER);
		size=driver.findElements(By.xpath("//h1[contains(text(),'Introduction to GraphQL')]")).size();
		if(size==0)
		{
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}
		//actions.sendKeys(searchBox, Keys.ENTER).perform();
		test.log(LogStatus.PASS, "Information searched");
		Thread.sleep(1000);
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(resultTitle));
		js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", graphQLInfo.getText());
		test.log(LogStatus.PASS, "Information displayed");
		Thread.sleep(2800);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
		
		
	}

}
