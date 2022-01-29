package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Grafana;
import utilities.seleniumUtilities;

public class GrafanaTest extends Baseclass {
	
	@Test
	void testGrafana() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://grafana.com/", driver);
		Class<Grafana> clazz=Grafana.class;
		Grafana ob=clazz.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=clazz.getDeclaredMethod("getTheListOfGrafanaContributors");
		m.setAccessible(true);
		m.invoke(ob);
		
		
	}

}
