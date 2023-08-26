package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

public class FreshWorks {
	WebDriver driver;
	ExtentTest test;
	Actions actions;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	@FindBy(xpath="//*[@class='product-heading']")
	List<WebElement> productsList;
	@FindBy(xpath="//*[contains(text(),'Products')]")
	WebElement Products;
	
	public FreshWorks(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	public void getListOfFreshworkProducts() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		StringBuilder builder=new StringBuilder();
		actions=new Actions(driver);
		js=(JavascriptExecutor)driver;
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		actions.moveToElement(Products).perform();
		test.log(LogStatus.PASS, "Hovered over Products");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='For your customers']")));
		for(int i=0;i<productsList.size();i++)
		{
			builder.append(productsList.get(i).getText());
			builder.append("\n");
		}
		
		js.executeScript("alert(arguments[0])", builder.toString());
		test.log(LogStatus.PASS, "List of products displayed");
		Thread.sleep(3500);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
		
		
		
	}

	
	
}
