package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TypeInCaps {
	
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		options.setExperimentalOption("useAutomationExtension",false);
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver=new ChromeDriver(options);
		driver.navigate().to("https://www.google.com");
		//driver.manage().window().maximize();
		WebElement searchBox=driver.findElement(By.name("q"));
		Actions action=new Actions(driver);
		action.keyDown(Keys.SHIFT).keyUp(Keys.SHIFT).perform();
		searchBox.sendKeys("Javatpoint tUtorial");
		//Thread.sleep(5000);
		searchBox.clear();
		action.keyDown(Keys.SHIFT).perform();
		searchBox.sendKeys("selenium");
		action.keyDown(Keys.SHIFT).perform();
		searchBox.sendKeys(" tutorial");
		//Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).perform();
		//Thread.sleep(5000);
		driver.close();
		
	}

}
