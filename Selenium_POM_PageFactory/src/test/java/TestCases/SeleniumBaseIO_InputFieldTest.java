package TestCases;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.SeleniumBaseIO_InputField;
import utilities.seleniumUtilities;

public class SeleniumBaseIO_InputFieldTest extends Baseclass
{
	
	@Test
	void copyPasteInTextFieldOnSeleniumBaseIOField()throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://seleniumbase.io/demo_page", driver);
		Constructor<SeleniumBaseIO_InputField> construct=SeleniumBaseIO_InputField.class.getDeclaredConstructor(WebDriver.class);
		construct.setAccessible(true);
		SeleniumBaseIO_InputField ob=construct.newInstance(driver);
		Method m=SeleniumBaseIO_InputField.class.getDeclaredMethod("copyPasteInTextFieldOnSeleniumBaseIOField");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Text copied to input field");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
