package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Comcast;
import utilities.seleniumUtilities;

public class ComcastTest extends Baseclass
{
	
	
	@Test
	void getComcastOverview() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://corporate.comcast.com/", driver);
		Comcast ob=Comcast.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Comcast.class.getDeclaredMethod("getCompanyOverview");
		m.setAccessible(true);
		String text=(String) m.invoke(ob);
		System.out.println(text);
		test.log(LogStatus.PASS, "Company Overview displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
