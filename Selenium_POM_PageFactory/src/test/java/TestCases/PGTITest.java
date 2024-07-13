package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.PGTI;
import utilities.seleniumUtilities;

public class PGTITest extends Baseclass
{
	@Test
	void getPGTITournaments()throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.pgtofindia.com/", driver);
		PGTI ob=PGTI.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=PGTI.class.getDeclaredMethod("getTournaments");
		m.setAccessible(true);
		List<String> pgtiTournaments=(List<String>) m.invoke(ob);
		Assert.assertTrue(pgtiTournaments.get(9).contains("Hero Indian Open 2024* (PGTI & DPWT Joint-Sanctioned)"),"Tournament name did not match");
		test.log(LogStatus.PASS, "Assertion passed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
