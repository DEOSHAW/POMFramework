package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Infosys;
import utilities.seleniumUtilities;

public class InfosysTest extends Baseclass 
{
	
	
	@Test
	void navigateToInfosysKnowledgeInstitute() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.infosys.com/", driver);
		Infosys ob=Infosys.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=Infosys.class.getDeclaredMethod("navigateToKnowledgeInstitute");
		m.setAccessible(true);
		boolean navigated=(boolean) m.invoke(ob);
		if(navigated)
		{
			Assert.assertTrue(true);
		    test.log(LogStatus.PASS, "Navigated to Infosys Institute Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Not navigated to Infosys Institute Page");
			Assert.assertTrue(false);
		}
		
	}

}
