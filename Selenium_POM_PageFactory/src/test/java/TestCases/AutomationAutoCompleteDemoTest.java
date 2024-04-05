package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationAutoCompleteDemo;
import utilities.seleniumUtilities;

public class AutomationAutoCompleteDemoTest extends Baseclass
{
	
	
	@Test
	void getAutoCompletedValue() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://demo.automationtesting.in/AutoComplete.html", driver);
		AutomationAutoCompleteDemo ob=AutomationAutoCompleteDemo.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		String textToBeSelected=seleniumUtilities.getDataForKey("AUTOCOMPLETION_TEXT");
		Method m=AutomationAutoCompleteDemo.class.getDeclaredMethod("getAutoCompletedText",String.class);
		m.setAccessible(true);
		String selectedText= (String) m.invoke(ob,textToBeSelected);
		if(selectedText.contains(textToBeSelected))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		test.log(LogStatus.PASS, "Test autocompleted and selected");
		test.log(LogStatus.PASS, "Test Ended");
	}


}
