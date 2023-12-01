package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.HerokuDynamicLoading;
import utilities.seleniumUtilities;

public class HerokuDynamicLoadingTest extends Baseclass
{
	
	@Test
	void getDynamicallyLoadedContentOnHerokuPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://the-internet.herokuapp.com/dynamic_loading", driver);
		test.log(LogStatus.PASS, "Heroku portal launched");
		HerokuDynamicLoading ob=HerokuDynamicLoading.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=HerokuDynamicLoading.class.getDeclaredMethod("getDynamicallyLoadedContent");
		m.setAccessible(true);
		String dynamicText=(String) m.invoke(ob);
		System.out.println("Dynamically loaded text is: "+dynamicText);
		test.log(LogStatus.PASS, "Dynamically loaded text dispalyed");
		test.log(LogStatus.PASS, "Test Ended");
		
  	} 

}
