package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationTesting_FileUpload;
import utilities.seleniumUtilities;

public class AutomationTesting_FileUploadTest extends Baseclass
{
	@Test
	void validateUploadFile() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.automationtesting.co.uk/fileupload.html", driver);
		AutomationTesting_FileUpload ob=AutomationTesting_FileUpload.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=AutomationTesting_FileUpload.class.getDeclaredMethod("uploadFile");
		m.setAccessible(true);
		boolean fileUploaded=(boolean) m.invoke(ob);
		Assert.assertTrue(fileUploaded, "File uploaded successfully");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
