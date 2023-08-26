package TestCases;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YoutubeAutomation {
	
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions actions;
	
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator+"chromedriver.exe");
		 
		driver=new ChromeDriver();
		
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, Duration.ofSeconds(8));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']"))).sendKeys("Selenium");
		Thread.sleep(500);
		actions=new Actions(driver);
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='sbqs_c'])[4]"))).click();
		Thread.sleep(4000);
		
		
	}

}
