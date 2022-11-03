package Pages;

import java.time.Duration;

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

public class PaloAlto {
	WebDriver driver;
	ExtentTest test;
	
	public PaloAlto(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//*[@id='nav_company']")
	WebElement companyLink;
	@FindBy(xpath="//*[contains(text(),'About Us')]")
	WebElement aboutLink;
	@FindBy(xpath="//h1[contains(text(),'Our vision is a world')]")
	WebElement aboutText;
	
	void getAboutText() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		Actions actions=new Actions(driver);
		actions.moveToElement(companyLink).pause(Duration.ofSeconds(2)).click(aboutLink).perform();
		test.log(LogStatus.PASS, "Navigated to about page");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(aboutText));
		String aboutTextValue=aboutText.getText();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("alert(arguments[0])", aboutTextValue);
		System.out.println(aboutTextValue);
		test.log(LogStatus.PASS, "About text displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
		
	}

}
