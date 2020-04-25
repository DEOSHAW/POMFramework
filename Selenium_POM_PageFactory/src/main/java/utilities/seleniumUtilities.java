package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class seleniumUtilities {
	
	static JavascriptExecutor js=null;
	
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


}
