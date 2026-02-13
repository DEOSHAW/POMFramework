package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuJsAlert
{
	WebDriver driver;
	
	public HerokuJsAlert(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	String jsButton="//button[text()='%s']";
	
	String getAlertText(String buttonName) throws InterruptedException
	{
		jsButton=String.format(jsButton, buttonName);
		driver.findElement(By.xpath(jsButton)).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertText=alert.getText();
		alert.sendKeys("How are You?");
		Thread.sleep(3000);
		alert.accept();
		Thread.sleep(1000);
		return alertText;
	}
}
