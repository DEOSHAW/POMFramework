package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.DemoQADragAndDrop;
import utilities.seleniumUtilities;

public class DemoQADragAndDropTest extends Baseclass
{
	
	@Test
	void dragAndDropInDroppableBox() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://demoqa.com/droppable", driver);
		DemoQADragAndDrop ob=DemoQADragAndDrop.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=DemoQADragAndDrop.class.getDeclaredMethod("dragAndDropInBox");
		m.setAccessible(true);
		String droppedMessage=(String) m.invoke(ob);
		Assert.assertEquals(droppedMessage, "Dropped!");
		test.log(LogStatus.PASS, "Dragged and dropped to box");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

	
}
