package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Twitter;
import utilities.seleniumUtilities;

public class twitterTest extends Baseclass {
	
	
	@Test(dataProvider="DataSupplierWithPoi")
	public void signuUp(String name,String phone) throws InterruptedException
	{
		seleniumUtilities ob=new seleniumUtilities(driver);
		ob.LaunchBrowser("https://twitter.com/");
		Twitter tweet=new Twitter(driver,test);
		tweet.signUpOnTwitter(name,phone);
		ob.closeBrowser();
		
	}

}
