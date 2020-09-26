package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.postman;
import utilities.seleniumUtilities;

public class postmanAutomation extends Baseclass {
	
	
	@Test
	public void getDetails()
	{

	seleniumUtilities.LaunchBrowser("https://www.postman.com/",driver);
	postman ob=new postman(driver,test);
    ob.getAutomationDetails();

	}

}
