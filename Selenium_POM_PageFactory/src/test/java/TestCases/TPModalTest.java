package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.TPModal;
import utilities.seleniumUtilities;

public class TPModalTest extends Baseclass
{
	@Test
	void handleTPModal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.tutorialspoint.com/selenium/practice/modal-dialogs.php", driver);
		TPModal ob=TPModal.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=TPModal.class.getDeclaredMethod("handleModal");
		m.setAccessible(true);
		String modalText=(String) m.invoke(ob);
		System.out.println(modalText);
		Assert.assertEquals(modalText, "Show a second modal and hide this one with the button below.");
		test.log(LogStatus.PASS, "Modal handled");
		test.log(LogStatus.PASS, "Test Ended");
		
		
	}

}
