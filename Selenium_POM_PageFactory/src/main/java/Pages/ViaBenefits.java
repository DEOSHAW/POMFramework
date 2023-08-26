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

public class ViaBenefits {
	WebDriver driver;
	ExtentTest test;
	
	public ViaBenefits(WebDriver driver,ExtentTest test)
	{
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using="//strong[contains(text(),'Elevate Your Retiree Healthcare Benefits')]")
	WebElement benefitsLabel;
	@FindBy(xpath="//p[contains(text(),'The cost of retiree healthcare')]")
	WebElement Benefits;
	
	void getBenefitsForRetirees() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(benefitsLabel));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", benefitsLabel);
		test.log(LogStatus.PASS, "Navigated to Benefits section");
		js.executeScript("alert(arguments[0])", Benefits.getText());
		test.log(LogStatus.PASS, "List of Benefits displayed");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
