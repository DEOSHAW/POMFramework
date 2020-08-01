package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.Flipkart;
import utilities.seleniumUtilities;

public class CarouselTest extends Baseclass {
	
	
	@Test
	public void testCarousel() throws InterruptedException
	{
		seleniumUtilities ob=new seleniumUtilities(driver);
		ob.LaunchBrowser("https://www.flipkart.com/");
		Flipkart flip=new Flipkart(driver,test);
		flip.ValidateAppliances();
		ob.closeBrowser();
		
	}

}
