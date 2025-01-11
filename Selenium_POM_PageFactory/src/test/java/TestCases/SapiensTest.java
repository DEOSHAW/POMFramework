package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Sapiens;
import utilities.seleniumUtilities;

public class SapiensTest extends Baseclass
{
	@Test
	void getSapiensSolutions() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://sapiens.com/", driver);
		Sapiens ob=Sapiens.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Sapiens.class.getDeclaredMethod("getSolutions");
		m.setAccessible(true);
		List<String> solutionsList=(List<String>) m.invoke(ob);
		System.out.println(solutionsList);
		Assert.assertTrue(solutionsList.get(1).contains("Annuities"),"Text does not match");
		test.log(LogStatus.PASS, "List of solutions displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
