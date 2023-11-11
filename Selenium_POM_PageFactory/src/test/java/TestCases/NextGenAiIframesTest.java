package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.NextGenAiIframes;
import utilities.seleniumUtilities;

public class NextGenAiIframesTest extends Baseclass
{
	
	@Test
	void switchBetweenIframesTest() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://nxtgenaiacademy.com/iframe/", driver);
		NextGenAiIframes ob=NextGenAiIframes.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=NextGenAiIframes.class.getDeclaredMethod("switchBetweenIframes");
		m.setAccessible(true);
		String pageText=(String) m.invoke(ob);
		  try
		  {
		    Assert.assertEquals(pageText, "I Frame Demo Page");
		    test.log(LogStatus.PASS, "Page text validation passed");
		  }
		  catch(AssertionError e)
		  {
		
			test.log(LogStatus.FAIL, "Page text validation failed");
			Assert.assertTrue(false,"Page text validation failed");
		   }
		    
		
	 }

}
