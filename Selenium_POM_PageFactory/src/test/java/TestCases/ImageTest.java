package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.MyThoughts;
import utilities.seleniumUtilities;

public class ImageTest extends Baseclass {
	
	
	@Test
	public void OpenImageURL() throws IOException, InterruptedException
	{
		
	
		seleniumUtilities.LaunchBrowser("http://www.mythoughts.co.in/2013/10/extract-and-verify-text-from-image.html",driver);
		MyThoughts object=new MyThoughts(driver,test);
		object.LaunchImageURL();
		seleniumUtilities.closeBrowser();
		
	}

}
