package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.GitHub;
import Pages.UIPath;
import utilities.seleniumUtilities;

public class UiPathTest extends Baseclass {
	
	@Test
	public void TestForUIPath()
	{
		

		seleniumUtilities.LaunchBrowser("https://www.uipath.com/",driver);
		UIPath path=new UIPath(driver,test);
		path.printMenuBarList();

		
	}

}
