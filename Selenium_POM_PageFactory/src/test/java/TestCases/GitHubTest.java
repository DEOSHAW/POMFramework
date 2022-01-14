package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.GitHub;
import utilities.seleniumUtilities;

public class GitHubTest extends Baseclass {
	
	@Test
	public void GitHubRepositoryTest() throws InterruptedException
	{
		
		
		seleniumUtilities.LaunchBrowser("https://github.com/",driver);
		GitHub profile=new GitHub(driver,test);
		profile.getRepositoryCount();
		
		
	}
	
	@Test(priority=-1)
	void uploadImage() throws Exception
	{
		seleniumUtilities.LaunchBrowser("https://github.com/settings/profile", driver);
		GitHub ob=GitHub.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=GitHub.class.getDeclaredMethod("uploadProfileImage",String.class);
		m.setAccessible(true);
		m.invoke(ob,seleniumUtilities.getDataForKey("UPLOAD_MESSAGE"));
		
		
	}

}
