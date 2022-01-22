package Pages;

import java.util.List;

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

public class CreditSuisse {
	WebDriver driver;
	ExtentTest test;
	Actions actions;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	public CreditSuisse(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[normalize-space(text())='Careers']")
	WebElement careersMenu;
	
	@FindBy(xpath="(//span[text()='Locations'])[2]")
	WebElement locationsMenuItem;
	
	@FindBy(xpath="//b[text()='India']")
	WebElement India;
	
	@FindBy(xpath="//*[text()='Ex­plore our fea­tured loc­a­tions']/following::b")
	List<WebElement> allLocations;
	
	@FindBy(xpath="//*[text()='Accept and continue']")
	WebElement acceptAndContinue;
	
	
	
	void getCreditSuisseLocation() throws Exception
	{
		test.log(LogStatus.PASS, "Test started");
		actions=new Actions(driver);
		wait=new WebDriverWait(driver,10);
		js=(JavascriptExecutor)driver;
		if(acceptAndContinue.isDisplayed())
		{
			acceptAndContinue.click();
			Thread.sleep(800);
		}
		actions.moveToElement(careersMenu).pause(2000).click(locationsMenuItem).build().perform();
		test.log(LogStatus.PASS, "Navigated to locations page");
		js.executeScript("arguments[0].scrollIntoView();", India);
		wait.until(ExpectedConditions.visibilityOf(India));
		StringBuilder countriesList=new StringBuilder();
		for(int i=0;i<7;i++)
		{
			
			countriesList.append(allLocations.get(i).getText());
			countriesList.append("\n");
		}
		js.executeScript("alert(arguments[0])", countriesList.toString());
		test.log(LogStatus.PASS, "Displayed the list of countries");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
		
	}

}
