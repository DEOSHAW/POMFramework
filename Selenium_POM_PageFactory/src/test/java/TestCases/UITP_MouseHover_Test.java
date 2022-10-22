package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.UITP_MouseHover;
import utilities.seleniumUtilities;

public class UITP_MouseHover_Test extends Baseclass {
	
	
	
	
	@Test
	void testMouseHover() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("http://uitestingplayground.com/mouseover", driver);
		UITP_MouseHover ob=UITP_MouseHover.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=UITP_MouseHover.class.getDeclaredMethod("validateMouseClickIncrementsCounter");
		m.setAccessible(true);
		boolean boolVal= (Boolean) m.invoke(ob);
		Assert.assertTrue(boolVal, "Count not updated properly");
		test.log(LogStatus.PASS, "Count correctly updated");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
