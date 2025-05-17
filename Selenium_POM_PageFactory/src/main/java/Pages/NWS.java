package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NWS
{
	WebDriver driver;
	public NWS(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='PAST WEATHER']")
	WebElement pastWeatherLink;
	@FindBy(how=How.XPATH,using="//a[text()='Certified Weather Data']")
	WebElement certifiedWeatherDataLink;
	@FindBy(how=How.TAG_NAME,using="h1")
	WebElement pageHeading;
	
	String getCertifiedWeatherData() throws InterruptedException
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(pastWeatherLink).pause(Duration.ofSeconds(1)).click(certifiedWeatherDataLink).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(pageHeading));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String heading=(String) js.executeScript("return arguments[0].innerHTML", pageHeading);
		js.executeScript("alert(arguments[0])", heading);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		return heading;
		
	}

}
