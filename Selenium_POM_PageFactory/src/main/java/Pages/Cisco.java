package Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class Cisco
{
	WebDriver driver;
	ExtentTest test;
	
	public Cisco(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Sitemap']")
	WebElement sitemapLink;
	@FindBy(how=How.TAG_NAME,using="h1")
	WebElement sitemapHeading;
	
	String navigateToSiteMap()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", sitemapLink);
		js.executeScript("arguments[0].click();", sitemapLink);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(sitemapHeading));
		
		return sitemapHeading.getText();
		
	}

}
