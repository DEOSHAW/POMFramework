package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Whirlpool;
import utilities.seleniumUtilities;

public class WhirlpoolTest extends Baseclass
{
	@Test
	void getWhirlpoolAppliances() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.whirlpoolindia.com/", driver);
		Whirlpool ob=Whirlpool.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Whirlpool.class.getDeclaredMethod("getAppliances");
		m.setAccessible(true);
		List<String> allWhirlpoolAppliances=(List<String>) m.invoke(ob);
		System.out.println(allWhirlpoolAppliances);
		Assert.assertEquals(allWhirlpoolAppliances.get(2), "Air Conditioners");
		test.log(LogStatus.PASS, "Validation Successful");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
