package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Aon;
import utilities.seleniumUtilities;

public class AonTest extends Baseclass
{
	@Test
	void getAonISUs() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.aon.com/en/", driver);
		Aon ob=Aon.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Aon.class.getDeclaredMethod("getISUs");
		m.setAccessible(true);
		List<String> ISUs=(List<String>) m.invoke(ob);
		System.out.println(ISUs);
		Assert.assertEquals(ISUs.size(), 16);
		Assert.assertEquals(ISUs.get(1), "Financial Institutions");
		
	}

}
