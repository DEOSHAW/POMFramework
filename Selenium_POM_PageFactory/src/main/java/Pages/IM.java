package Pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class IM
{
	WebDriver driver;
	public IM(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='See Plans']")
	WebElement seePlansLink;
	@FindBy(how=How.TAG_NAME,using="h1")
	WebElement pageHeading;
	
	String navigateToShopForPlans() throws InterruptedException
	{
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(seePlansLink)).click();
		wait.until(ExpectedConditions.visibilityOf(pageHeading));
		return pageHeading.getText();
		
	}

}
