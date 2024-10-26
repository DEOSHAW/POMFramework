package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.JarDigiGold;
import utilities.seleniumUtilities;

public class JarDigiGoldTest extends Baseclass
{
	
	@Test
	void getDigiGoldInformationOnTanishqPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.myjar.app/",driver);
		JarDigiGold ob=JarDigiGold.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=JarDigiGold.class.getDeclaredMethod("getDigiGoldInformation");
		m.setAccessible(true);
		String JarDigiGoldText=(String) m.invoke(ob);
		Assert.assertTrue(JarDigiGoldText.contains("With the Jar app, you can participate in the tradition of saving in"));
		test.log(LogStatus.PASS, "Validation Successful");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
	}

}
