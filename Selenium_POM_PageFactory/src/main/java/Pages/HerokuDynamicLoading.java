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

public class HerokuDynamicLoading
{
	WebDriver driver;
	ExtentTest test;
	
	public HerokuDynamicLoading(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Example 2')]")
	WebElement dynamicLoadingLink2;
	
	@FindBy(xpath="//button[contains(text(),'Start')]")
	WebElement startButton;
	@FindBy(how=How.CSS,using="#finish>h4")
	WebElement dynamicallyLoadedElement;
	
	
	
	String getDynamicallyLoadedContent()
	{
		
		dynamicLoadingLink2.click();
		startButton.click();
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOf(dynamicallyLoadedElement)).getText();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String text=(String) js.executeScript("return arguments[0].innerHTML;", dynamicallyLoadedElement);
		
		return text;
		
		
	}

}
