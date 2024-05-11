package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Deloitte;
import utilities.seleniumUtilities;

public class DeloitteTest extends Baseclass 
{
	@Test
	void getListOfDeloitteServices() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www2.deloitte.com/us/en.html", driver);
		Deloitte ob=Deloitte.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Deloitte.class.getDeclaredMethod("getListOfServices");
		m.setAccessible(true);
		List<String> servicesList=(List<String>) m.invoke(ob);
		test.log(LogStatus.PASS, "List of Deloitte Services displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		SoftAssert softAssert=new SoftAssert();
	    softAssert.assertEquals(servicesList.get(0), "Tax");
	    softAssert.assertEquals(servicesList.get(1), "Consulting");
	    softAssert.assertEquals(servicesList.get(2), "Audit & Assurance");
	    softAssert.assertEquals(servicesList.get(3), "Deloitte Private");
	    softAssert.assertEquals(servicesList.get(4), "M&A and Restructuring");
	    softAssert.assertEquals(servicesList.get(5), "Risk & Financial Advisory");
	    softAssert.assertEquals(servicesList.get(6), "AI & Analytics");
	    softAssert.assertEquals(servicesList.get(7), "Cloud");
	    softAssert.assertEquals(servicesList.get(8), "Diversity, Equity & Inclusion");	
	    softAssert.assertAll();
		
	}

}
