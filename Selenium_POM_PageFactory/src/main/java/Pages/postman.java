package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class postman {
	WebDriver driver_postman;
	ExtentTest test;
	WebDriverWait wait=null;
	JavascriptExecutor js=null;
	public postman(WebDriver driver,ExtentTest test)
	{
		driver_postman=driver;
		this.test=test;
		PageFactory.initElements(driver_postman,this);
		 
	}
	
	@FindBy(how=How.XPATH,using="//a[text()='Product']")
	WebElement product;
	@FindBy(xpath="(//a[text()='Automated Testing'])[1]")
	WebElement automatedTesting;
	@FindBy(xpath="//h1[text()='Automated Testing with Postman']")
	WebElement automatedTestingText;
	@FindBy(xpath="//*[starts-with(text(),'As programs grow, so does the risk of breakage')]")
	WebElement automatedTestingScaling;
	
	
	
	
	
	public void getAutomationDetails()
	{
		product.click();
		wait=new WebDriverWait(driver_postman,10);
		js=(JavascriptExecutor)driver_postman;
		wait.until(ExpectedConditions.visibilityOf(automatedTesting)).click();
		Assert.assertEquals(automatedTestingText.getText(), "Automated Testing with Postman");
		test.log(LogStatus.PASS, "Automation testing page found");
		js.executeScript("arguments[0].scrollIntoView();", automatedTestingScaling);
		String text=(String) js.executeScript("return arguments[0].innerHTML;", automatedTestingScaling);
		test.log(LogStatus.PASS, text+" "+"found");
		
		
		
	}

}
