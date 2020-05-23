package utilities;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class seleniumUtilities {
	
	static JavascriptExecutor js=null;
	static WebDriver driver=null;
	
	public seleniumUtilities(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public static void jsClick(WebDriver driver,WebElement element)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
		
	}
	
	
	public static void jsType(WebDriver driver,WebElement element,String value)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1];", element,value);
		
		
	}
	
	public void LaunchBrowser(String Url)
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.silentOutput", "true");
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("useAutomationExtension", false);
		//options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation")); 
		//driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to(Url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public void closeBrowser()
	{
		driver.quit();
	}


}
