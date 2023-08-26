package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guru99ScrollWebPage {
	
	WebDriver ScrollDriver;
	
	public Guru99ScrollWebPage(WebDriver driver)
	{
		ScrollDriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="VBScript")
	WebElement VBScript;
	@FindBy(xpath="//*[starts-with(text(),'Home')]")
	WebElement Home;
	
	public void ScrollWebPage()
	{
		JavascriptExecutor js=(JavascriptExecutor)ScrollDriver;
		js.executeScript("arguments[0].scrollIntoView();",VBScript);
		VBScript.click();
		WebDriverWait wait=new WebDriverWait(ScrollDriver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[starts-with(text(),'Home')]")));
		System.out.println("Text is "+Home.getText());
	}

}
