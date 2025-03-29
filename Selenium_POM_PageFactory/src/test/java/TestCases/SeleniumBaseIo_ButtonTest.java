package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.SeleniumBaseIo_Button;
import utilities.seleniumUtilities;

public class SeleniumBaseIo_ButtonTest extends Baseclass
{
	
	@Test
	void ValidateButtonColourChangeOnSeleniumBasePortal() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://seleniumbase.io/demo_page/", driver);
		SeleniumBaseIo_Button ob=SeleniumBaseIo_Button.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=SeleniumBaseIo_Button.class.getDeclaredMethod("ValidateButtonColourChange");
		m.setAccessible(true);
		m.invoke(ob);			
	}

}
