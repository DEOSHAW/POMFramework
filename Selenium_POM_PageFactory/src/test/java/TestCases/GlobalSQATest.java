package TestCases;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.GlobalSQA;
import utilities.seleniumUtilities;

public class GlobalSQATest extends Baseclass {
	
	
	
	@Test
	void testDragAndDropFeature() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.globalsqa.com/demo-site/draganddrop/", driver);
		GlobalSQA ob=GlobalSQA.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		GlobalSQA.class.getDeclaredMethod("dragAndDropImagesIntoTrash").invoke(ob);
		
		
		
	}

}
