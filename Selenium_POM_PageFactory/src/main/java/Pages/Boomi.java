package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class Boomi
{
	WebDriver driver;
	ExtentTest test;
	
	public Boomi(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[contains(text(),'Solutions')])[1]")
	WebElement solutionsLink;
	@FindBy(xpath="(//a[contains(text(),'BY APPLICATION')])[1]/../child::ul//span")
	List<WebElement> supportedApplications;
	
	List<WebElement> getListOfMajorSupportedApplications() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(solutionsLink).perform();
		Thread.sleep(2500);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfAllElements(supportedApplications));
		return supportedApplications;
		
		
	}

}
