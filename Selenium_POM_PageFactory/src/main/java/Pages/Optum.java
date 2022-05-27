package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Optum {
	WebDriver driver;
	ExtentTest test;
	
	
	
	public Optum(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="(//input[@placeholder='Search' and @type='text'])[2]")
	WebElement searchTextBox;
	@FindBy(xpath="//*[contains(text(),'What insights does Optum publish')]")
	WebElement insightsOption;
	@FindBy(xpath="//*[contains(text(),'Your search results')]")
	WebElement searchResultsText;
	@FindBy(xpath="//div[@class='HitchhikerProductProminentImage-detailsText js-HitchhikerCard-detailsText']")
	List<WebElement> insightsList;
	@FindBy(xpath="//*[string()='Optum Insights']")
	WebElement optumInsights;
	
	
	
	void getInsightsPublishedByOptum() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		test.log(LogStatus.PASS, "Test started");
		searchTextBox.click();
		test.log(LogStatus.PASS, "Clicked on search box");
		insightsOption.click();
		test.log(LogStatus.PASS, "Clicked on insights link");
		wait.until(ExpectedConditions.visibilityOf(searchResultsText));
		driver.switchTo().frame(0);
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')",optumInsights );
		Thread.sleep(500);
		Iterator<WebElement> itr=insightsList.iterator();
		while(itr.hasNext())
		{
			WebElement ele=itr.next();
			js.executeScript("arguments[0].scrollIntoView();", ele);
			js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Red')",ele );
			Thread.sleep(1000);
			
		}
		test.log(LogStatus.PASS, "Highlighted all the insight elements");
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
