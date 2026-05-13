package TestCases;

import java.lang.reflect.Method;
import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationTestingDatePicker;
import utilities.seleniumUtilities;

public class AutomationTestingDatePickerTest extends Baseclass
{
	@Test
	void validateDatePicker() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.automationtesting.co.uk/datepicker.html", driver);
		AutomationTestingDatePicker ob=AutomationTestingDatePicker.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AutomationTestingDatePicker.class.getDeclaredMethod("selectDate", String.class);
		m.setAccessible(true);
		m.invoke(ob, String.valueOf(LocalDate.now().getDayOfMonth()));
		test.log(LogStatus.PASS, "Date successfully selected");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
