package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.SeleniumEasy;
import utilities.seleniumUtilities;

public class HandlingJQueryList extends Baseclass {
	
	@Test
	public void jQueryTest() throws InterruptedException
	{

	seleniumUtilities.LaunchBrowser("https://www.seleniumeasy.com/test/jquery-dual-list-box-demo.html",driver);
	SeleniumEasy ob=new SeleniumEasy(driver,test);
	ob.HandlejQueryList();

	}

}
