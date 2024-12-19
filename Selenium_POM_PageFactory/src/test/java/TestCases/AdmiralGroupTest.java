package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AdmiralGroup;
import utilities.seleniumUtilities;

public class AdmiralGroupTest extends Baseclass
{
	
	@Test
	void AdmiralGroupIndiaOfficesLocation() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://admiralgroup.co.uk/who-we-are/our-offices", driver);
		AdmiralGroup ob=AdmiralGroup.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AdmiralGroup.class.getDeclaredMethod("getIndiaOfficesLocation");
		m.setAccessible(true);
		List<String> indiaOffices=(List<String>) m.invoke(ob);
		for(String office:indiaOffices)
		{
			System.out.println(office);
			System.out.println("=====================");
		}
		test.log(LogStatus.PASS, "Location of India offices displayed");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
