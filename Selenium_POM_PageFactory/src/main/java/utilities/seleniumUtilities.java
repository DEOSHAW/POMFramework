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
	static WebDriver Seldriver=null;
	
	
	
	
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
	
	public static void LaunchBrowser(String Url,WebDriver driver)
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.silentOutput", "true");
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("useAutomationExtension", false);
		//options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation")); 
		//driver=new ChromeDriver(options);
		Seldriver=driver;
		Seldriver.manage().window().maximize();
		Seldriver.navigate().to(Url);
		Seldriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public static void closeBrowser()
	{
		Seldriver.quit();
	}


}
