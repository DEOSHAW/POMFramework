package Pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class Etihad 
{
	WebDriver driver;
	ExtentTest test;
	
	public Etihad(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="(//*[@class='dd-floating-caret-icon visible'])[1]")
	WebElement arrow;
	@FindBy(xpath="//div[text()='One way']")
	WebElement oneWayLink;
	@FindBy(id="oneWayOrigin")
	WebElement fromTextBox;
	@FindBy(id="oneWayDestination")
	WebElement toTextBox;
	@FindBy(xpath="//button[text()='Search flights']")
	WebElement searchButton;
	@FindBy(css="h1#body-title")
	WebElement searchResultHeading;
	
	
	void searchFlight(String origin,String destination) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOf(popupCloseButton)).click();
		arrow.click();
		oneWayLink.click();
		wait.until(ExpectedConditions.visibilityOf(fromTextBox)).sendKeys(origin);
		fromTextBox.sendKeys(Keys.ENTER);
		toTextBox.sendKeys(destination);
		toTextBox.sendKeys(Keys.ENTER);
		toTextBox.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", searchButton);
		driver.switchTo().frame("main-iframe");
		wait.until(ExpectedConditions.visibilityOf(searchResultHeading));
		System.out.println(searchResultHeading.getText());
		
		
	}

}
