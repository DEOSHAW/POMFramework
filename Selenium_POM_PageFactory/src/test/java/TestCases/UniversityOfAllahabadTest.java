package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.UniversityOfAllahabad;

public class UniversityOfAllahabadTest extends Baseclass
{
	@Test
	void ValidateClickOnMenuOption() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		driver.get("https://www.allduniv.ac.in/");
		UniversityOfAllahabad ob=UniversityOfAllahabad.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=UniversityOfAllahabad.class.getDeclaredMethod("clickByText", String.class);
		m.setAccessible(true);
		String linkName="Academics";
		String pageTitle=(String)m.invoke(ob, linkName);
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains(linkName.toLowerCase()));
		test.log(LogStatus.PASS, "Clicked Successfully");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
