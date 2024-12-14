package TestCases;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Bits;
import utilities.seleniumUtilities;

public class BitsTest extends Baseclass
{
	@Test
	void findProgrammeInBits() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.bits-pilani.ac.in/", driver);
		Bits ob=Bits.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Bits.class.getDeclaredMethod("selectProgram");
		m.setAccessible(true);
		String program=(String) m.invoke(ob);
		Assert.assertEquals(program, "M.E.(Computer Science)");
		test.log(LogStatus.PASS, "Program displayed");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
