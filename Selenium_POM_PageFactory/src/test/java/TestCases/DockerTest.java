package TestCases;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.Docker;
import utilities.seleniumUtilities;

public class DockerTest extends Baseclass {
	
	
	@Test
	void testDocker() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://www.docker.com/", driver);
		Docker.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test).getDockerInformation();
		
	}
	
}
