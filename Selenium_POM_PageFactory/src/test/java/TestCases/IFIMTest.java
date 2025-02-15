package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.IFIM;
import utilities.seleniumUtilities;

public class IFIMTest extends Baseclass
{
	
	@Test
	void getIfimFaculties() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://ifim.edu.in/", driver);
		IFIM ob=IFIM.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=IFIM.class.getDeclaredMethod("getFaculties");
		m.setAccessible(true);
		List<String> facultiesList=(List<String>) m.invoke(ob);
		Assert.assertEquals(facultiesList.get(1), "Faculty of Computer Applications");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
     }

}
