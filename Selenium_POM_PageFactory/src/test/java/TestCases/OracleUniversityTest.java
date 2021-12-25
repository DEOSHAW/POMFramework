package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.OracleUniversity;
import utilities.seleniumUtilities;

public class OracleUniversityTest extends Baseclass {
	
	@Test
	void getOCICertificationsList() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://learn.oracle.com/ols/course-list/35644", driver);
		OracleUniversity ob=OracleUniversity.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=ob.getClass().getDeclaredMethod("getTheListOfOCICertifications");
		m.setAccessible(true);
		m.invoke(ob);
	}

}
