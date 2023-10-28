package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.NextGenAiProgressBar;
import utilities.seleniumUtilities;

public class NextGenAiProgressBarTest extends Baseclass
{
	
	
	@Test
	void validateNextGenAIProgressBar() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://nxtgenaiacademy.com/progress-bar/", driver);
		NextGenAiProgressBar ob=NextGenAiProgressBar.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=NextGenAiProgressBar.class.getDeclaredMethod("validateProgressBar");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
