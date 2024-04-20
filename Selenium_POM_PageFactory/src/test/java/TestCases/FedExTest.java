package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.FedEx;
import utilities.seleniumUtilities;

public class FedExTest extends Baseclass
{
	
	@Test
	void getFedExCourierStatusViaChatBot() throws Exception
	{
		test.log(LogStatus.PASS,"Test Started");
		seleniumUtilities.LaunchBrowser("https://www.fedex.com/en-in/home.html", driver);
		FedEx ob=FedEx.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=FedEx.class.getDeclaredMethod("getStatusViaChatBot");
		m.setAccessible(true);
		String response=(String) m.invoke(ob);
		if(response.contains("need your tracking number"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		test.log(LogStatus.PASS,"Got response from chat bot");
		test.log(LogStatus.PASS,"Test Ended");
		
	}


}
