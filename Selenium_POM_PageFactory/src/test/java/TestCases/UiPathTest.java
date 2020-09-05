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
		
		seleniumUtilities ob=new seleniumUtilities(driver);
		ob.LaunchBrowser("https://www.uipath.com/");
		UIPath path=new UIPath(driver,test);
		path.printMenuBarList();
		ob.closeBrowser();
		
	}

}
