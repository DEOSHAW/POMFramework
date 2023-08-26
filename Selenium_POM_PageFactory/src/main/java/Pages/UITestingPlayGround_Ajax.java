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
import com.relevantcodes.extentreports.LogStatus;

public class UITestingPlayGround_Ajax {
	
	WebDriver driver;
	ExtentTest test;
	
	public UITestingPlayGround_Ajax(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.XPATH,using="//*[@id='ajaxButton']")
	WebElement ajaxButton;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Data loaded with AJAX')]")
	WebElement ajaxResponseElement;
	
	
	void triggerAjaxRequest()
	{
		test.log(LogStatus.PASS, "Test Started");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ajaxButton);
		test.log(LogStatus.PASS, "Clicked on ajax button");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(ajaxResponseElement));
		String ajaxResponseText=ajaxResponseElement.getText();
		System.out.println(ajaxResponseText);
		test.log(LogStatus.PASS, "Got ajax response text");
		
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
