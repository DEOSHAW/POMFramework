package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.LetCode;
import utilities.seleniumUtilities;

public class LetCodeTest extends Baseclass
{
	@Test
	void selectFruitsFromDropdownOnLetCode() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://letcode.in/dropdowns", driver);
		LetCode ob=LetCode.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		String fruitName=seleniumUtilities.getDataForKey("FRUIT_NAME");
		Method m=LetCode.class.getDeclaredMethod("selectFruitFromDropdown",String.class);
		m.setAccessible(true);
		String successMessage=(String) m.invoke(ob,fruitName);
		Assert.assertEquals(successMessage, "You have selected "+fruitName);
		test.log(LogStatus.PASS, "Fruit Selected");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
