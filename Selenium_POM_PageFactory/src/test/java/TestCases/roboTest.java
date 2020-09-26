package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.RobotFramework;
import utilities.seleniumUtilities;

public class roboTest extends Baseclass {
	
	
	@Test
	public void robotest()
	{
		

		seleniumUtilities.LaunchBrowser("https://robotframework.org/",driver);
		RobotFramework robot=new RobotFramework(driver, test);
		robot.getDetails();

		
		
	}

}
