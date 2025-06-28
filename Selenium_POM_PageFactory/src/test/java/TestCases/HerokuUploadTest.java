package TestCases;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.HerokuUpload;
import utilities.seleniumUtilities;

public class HerokuUploadTest extends Baseclass
{
	@Test
	void uploadFileOnHeroku() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://the-internet.herokuapp.com/upload", driver);
		HerokuUpload ob=HerokuUpload.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=HerokuUpload.class.getDeclaredMethod("uploadFile",String.class);
		m.setAccessible(true);
		String filePath=System.getProperty("user.dir")+File.separator+"Screenshots/AIR_Test.png";
		String successMessage=(String) m.invoke(ob,filePath);
		Assert.assertEquals(successMessage, "File Uploaded!");
		test.log(LogStatus.PASS, "File upload successful");
		test.log(LogStatus.PASS, "Test Ended");		
	}

}