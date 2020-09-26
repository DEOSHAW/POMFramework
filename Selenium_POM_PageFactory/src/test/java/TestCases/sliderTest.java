package TestCases;

import org.testng.annotations.Test;

import Base.Baseclass;
import Pages.SliderPage;
import utilities.seleniumUtilities;

public class sliderTest extends Baseclass {
	
	
	@Test
	public void testSlider() throws InterruptedException
	{
		

		seleniumUtilities.LaunchBrowser("https://jqueryui.com/resources/demos/slider/default.html",driver);
		SliderPage slider=new SliderPage(driver,test);
		slider.handleSlider();
        Thread.sleep(5000);

	}
	
	

}
