package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Boomi;
import utilities.seleniumUtilities;

public class BoomiTest extends Baseclass
{
	
	@Test
	void getListOfMajorSupportedApplicationsByBoomi() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://boomi.com/", driver);
		Boomi ob=Boomi.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Boomi.class.getDeclaredMethod("getListOfMajorSupportedApplications");
		m.setAccessible(true);
		List<WebElement> supportedApps=(List<WebElement>) m.invoke(ob);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(WebElement ele:supportedApps)
		{
			System.out.println(js.executeScript(" return arguments[0].innerHTML;", ele));
			
		}
		test.log(LogStatus.PASS, "List of supported applications displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
