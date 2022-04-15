package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Hexaware {
	
	WebDriver driver;
	ExtentTest test;
	
	public Hexaware(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[string()='Strategy']")
	WebElement strategyLink;
	@FindBy(xpath="//*[@class='menu-item-heading text-center']")
	List<WebElement> strategies;
	
	void getHexawareStrategy() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test started");
		Actions actions=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		actions.moveToElement(strategyLink).perform();
		test.log(LogStatus.PASS, "Hovered over strategy link");
		StringBuilder listOfStrategies=new StringBuilder();
		for(int i=0;i<strategies.size();i++)
		{
			listOfStrategies.append(strategies.get(i).getText().replaceAll("[^A-Za-z0-9\\s]", ""));
			listOfStrategies.append("\n");
			
		}
		js.executeScript("alert(arguments[0])", listOfStrategies.toString());
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Hexaware strategies displayed");
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
