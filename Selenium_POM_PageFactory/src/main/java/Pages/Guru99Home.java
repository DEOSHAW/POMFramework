package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Home {
	WebDriver guru_driver;
	
	public Guru99Home(WebDriver driver)
	{
		guru_driver=driver;
		PageFactory.initElements(guru_driver, this);
	}
	
	@FindBy(xpath="//*[starts-with(text(),'Linux')]")
	WebElement Linux_Link;
	
	public void ClickOnLinux()
	{
		JavascriptExecutor js=(JavascriptExecutor)guru_driver;
		js.executeScript("arguments[0].scrollIntoView();", Linux_Link);
		guru_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Linux_Link.click();
	}
}
