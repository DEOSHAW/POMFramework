package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JaneStreet {
	WebDriver driver;
	ExtentTest test;
	
	
	public JaneStreet(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[normalize-space(text())='What We Do']")
	WebElement whatWeDoLink;
	@FindBy(xpath="//*[@class='featured-content']")
	WebElement informationText;
	
	
	void getInformationOnWhatWeDo() throws Exception
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		test.log(LogStatus.PASS, "Test Started");
		//wait.until(ExpectedConditions.visibilityOf(whatWeDoLink));
		whatWeDoLink.click();
		test.log(LogStatus.PASS, "Clicked on What We Do link");
		String infoText=informationText.getText();
		js.executeScript("alert(arguments[0])", infoText);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Information displayed");
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
