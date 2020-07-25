package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Heroku;
import utilities.seleniumUtilities;

public class HerokuFileUpload extends Baseclass {
	
	@Test
	public void doFileUpload()
	{
		seleniumUtilities ob=new seleniumUtilities(driver);
		ob.LaunchBrowser("https://the-internet.herokuapp.com/upload");
		Heroku heroku=new Heroku(driver,test);
		heroku.uploadFile();
		ob.closeBrowser();
		
	}

}
