package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MarshMcLennan {
	WebDriver driver;
	ExtentTest test;
	
	public MarshMcLennan(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[contains(@href,'/solutions.html')])[1]")
	WebElement solutionsLink;
	
	@FindBy(xpath="(//a[contains(@href,'/solutions.html')])[1]/following-sibling::div//a")
	List<WebElement> allSolutions;
	
	void getSolutions() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(solutionsLink).perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Iterator<WebElement> itr=allSolutions.iterator();
		while(itr.hasNext())
		{
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid green; background:Red')", itr.next());
		Thread.sleep(500);
		}
		test.log(LogStatus.PASS, "All the solutions displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
