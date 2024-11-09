package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.MakeABeeline;
import utilities.seleniumUtilities;

public class MakeABeelineTest extends Baseclass
{
	@Test
	void getTextFromCarouselOnPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://makeabeeline.com/", driver);
		MakeABeeline ob=MakeABeeline.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=MakeABeeline.class.getDeclaredMethod("getTextFromCarousel");
		m.setAccessible(true);
		m.invoke(ob);	
		test.log(LogStatus.PASS, "Text from all cards highlighted");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
