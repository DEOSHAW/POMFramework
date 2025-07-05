package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.HerokuDragAndDrop;
import utilities.seleniumUtilities;

public class HerokuDragAndDropTest extends Baseclass
{
	@Test
	void dragAndDropOnHerokuPortal() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://the-internet.herokuapp.com/drag_and_drop", driver);
		HerokuDragAndDrop ob=HerokuDragAndDrop.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=HerokuDragAndDrop.class.getDeclaredMethod("dragAndDropObject");
		m.setAccessible(true);
		m.invoke(ob);
		test.log(LogStatus.PASS, "Drag and Drop completed");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
