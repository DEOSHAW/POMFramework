package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class seleniumUtilities {
	
	static JavascriptExecutor js=null;
	WebDriver Seldriver=null;
	
	
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
		driver=driver;
		driver.manage().window().maximize();
	    driver.navigate().to(Url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	public static void closeBrowser()
	{
		//Seldriver.quit();
	}


}
