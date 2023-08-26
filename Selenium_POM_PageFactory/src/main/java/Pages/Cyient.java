package Pages;

import java.time.Duration;
import java.util.List;

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

public class Cyient {
	
	WebDriver driver;
	ExtentTest test;
	
	public Cyient(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[text()='Accept All Cookies']")
	List<WebElement> acceptAllCookies;
	
	@FindBy(xpath="(//span[string()='About'])[1]")
	WebElement aboutLink;
	
	@FindBy(xpath="(//span[string()='About Us'])[2]")
	List<WebElement> aboutUsLink;
	
	@FindBy(xpath="//p[contains(text(),'Cyient (Estd: 1991, NSE: CYIENT) is a global Engineering')]")
	WebElement companyInfoText;
	
	
	public void getCompanyInformation() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test Started");
		if(acceptAllCookies.size()>0)
		{
			acceptAllCookies.get(0).click();
		}
		Thread.sleep(2500);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		Actions actions=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//wait.until(ExpectedConditions.visibilityOf(aboutLink)).click();
		
		//js.executeScript("arguments[0].click();", aboutLink);
		actions.moveToElement(aboutLink).click(aboutLink).perform();
		wait.until(ExpectedConditions.visibilityOfAllElements(aboutUsLink)).get(0).click();
		String infoText=(String) js.executeScript("return arguments[0].innerHTML;", companyInfoText);
		
		js.executeScript("alert(arguments[0])", infoText);
		Thread.sleep(2500);
		driver.switchTo().alert().accept();
		Thread.sleep(800);
		test.log(LogStatus.PASS, "Company information displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
