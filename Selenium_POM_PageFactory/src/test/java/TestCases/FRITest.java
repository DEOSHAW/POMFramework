package TestCases;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.FRI;
import utilities.seleniumUtilities;

public class FRITest extends Baseclass
{
	@Test
	void ValidateMastersProgrammes() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("http://fridu.edu.in/", driver);
		FRI ob=FRI.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=FRI.class.getDeclaredMethod("getMastersProgrammes");
		m.setAccessible(true);
		Set<String> mastersProgrammes=(Set<String>) m.invoke(ob);
		int count=0;
		for(String programme:mastersProgrammes)
		{
			if(count==0)
			{
				Assert.assertEquals(programme, "M.Sc. Forestry");
			}
			System.out.println(programme);
			count++;
		}	
		Assert.assertTrue(mastersProgrammes.contains("M.Sc. Environment Management"),"Programme is not present");
		test.log(LogStatus.PASS, "Validation Successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
