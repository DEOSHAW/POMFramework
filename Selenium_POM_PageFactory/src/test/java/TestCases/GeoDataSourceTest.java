package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.GeoDataSource;
import utilities.seleniumUtilities;

public class GeoDataSourceTest extends Baseclass
{
	@Test
	void selectRegionFromGeoDataSource()throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.geodatasource.com/software/country-region-dropdown-menu-demo", driver);
		GeoDataSource ob=GeoDataSource.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		String selectedCountry=ob.selectRegionFromGeoDataSource(seleniumUtilities.getDataForKey("COUNTRY"));
		System.out.println("Selected Country is: "+selectedCountry);
		Assert.assertEquals(selectedCountry, seleniumUtilities.getDataForKey("COUNTRY"));
		test.log(LogStatus.PASS, "Dropdown Selection Validations successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	 }

}
;