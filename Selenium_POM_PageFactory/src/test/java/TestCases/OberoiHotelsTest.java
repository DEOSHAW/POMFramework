package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.OberoiHotels;
import utilities.seleniumUtilities;

public class OberoiHotelsTest extends Baseclass {
	
	
	@Test
	void oberoiHotelsTest() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://www.oberoihotels.com/", driver);
		Class[] clazz=new Class[2];
		clazz[0]=WebDriver.class;
		clazz[1]=ExtentTest.class;
		OberoiHotels ob=OberoiHotels.class.getConstructor(clazz).newInstance(driver,test);
		//System.out.println(OberoiHotels.class.getDeclaredMethod("getHotelLocations"));
		OberoiHotels.class.getDeclaredMethod("getHotelLocations").invoke(ob);
	}

}
