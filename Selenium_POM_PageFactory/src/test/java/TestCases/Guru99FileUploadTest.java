package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.Guru99FileUpload;
import utilities.seleniumUtilities;

public class Guru99FileUploadTest extends Baseclass
{
	
	@Test
	void uploadFileOnGuru99() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://demo.guru99.com/test/upload/", driver);
		Guru99FileUpload ob=Guru99FileUpload.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=Guru99FileUpload.class.getDeclaredMethod("uploadFile", String.class);
		m.setAccessible(true);
		String successMsg=(String) m.invoke(ob,seleniumUtilities.getDataForKey("FILE_NAME"));
		Assert.assertTrue(successMsg.contains("successfully uploaded"));
		test.log(LogStatus.PASS, "File uploaded successfully");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
