package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.postman;
import utilities.seleniumUtilities;

public class postmanAutomation extends Baseclass {
	
	
	@Test
	public void getDetails()
	{
	seleniumUtilities ob1=new seleniumUtilities(driver);
	ob1.LaunchBrowser("https://www.postman.com/");
	postman ob=new postman(driver,test);
    ob.getAutomationDetails();
    ob1.closeBrowser();
	}

}
