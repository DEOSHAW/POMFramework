package utilities;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumUtilities {
	
	static JavascriptExecutor js=null;
	WebDriver Seldriver=null;
	static WebDriverWait wait;
	static Actions actions;
	
	
	public static String getDataForKey(String key)
	{
		
try {
			FileReader reader=new FileReader(new File(System.getProperty("user.dir")+File.separator+"src/test/resources/testdata.properties"));
			Properties prop=new Properties();
			prop.load(reader);
			String value=prop.getProperty(key).trim();
			if(value.length()>0)
			{
				return value;
			}
			else
			{
				return "NoData";
			}
			
	} 
  catch (Exception e) 
     {
			e.printStackTrace();
			return "NoData";
			
		}
		
		
	}
	
	public static void jsClick(WebDriver driver,WebElement element)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
		
	}
	
	public static void waitForElement(WebDriver driver,WebElement element)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	
	public static void jsType(WebDriver driver,WebElement element,String value)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1];", element,value);
		
		
	}
	
	public static void hoverOnElement(WebDriver driver,WebElement element)
	{
		actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
		
	}
	
	public static void LaunchBrowser(String Url,WebDriver driver)
	{
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bishal\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.silentOutput", "true");
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("useAutomationExtension", false);
		//options.addArguments("--log-level=3");
		//driver=new ChromeDriver(options);
		driver.manage().window().maximize();
	    driver.get(Url);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	}
	
	public static void showAlert(WebDriver driver,String Message)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", Message);
	}
	
	public static void highlightElement(WebDriver driver,WebElement element)
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'border:2px solid blue; background:Green')", element);
		
	}
	public static void closeBrowser()
	{
		//Seldriver.quit();
	}


}
