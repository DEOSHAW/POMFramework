package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.RobotFramework;
import utilities.seleniumUtilities;

public class roboTest extends Baseclass {
	
	
	@Test
	public void robotest()
	{
		
		seleniumUtilities util=new seleniumUtilities(driver);
		util.LaunchBrowser("https://robotframework.org/");
		RobotFramework robot=new RobotFramework(driver, test);
		robot.getDetails();
		util.closeBrowser();
		
		
	}

}
