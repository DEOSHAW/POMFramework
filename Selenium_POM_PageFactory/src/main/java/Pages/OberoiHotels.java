package Pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.seleniumUtilities;

public class OberoiHotels {
	WebDriver driver;
	ExtentTest test;
	JavascriptExecutor js;
	WebDriverWait wait;
	
	
	
	
	public OberoiHotels(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Destinations')]")
	WebElement Destinations;
	@FindBy(xpath="//*[@class='desk']")
	List<WebElement> Locations;
	
	public void getHotelLocations() throws InterruptedException
	{
		test.log(LogStatus.PASS, "Test started");
		seleniumUtilities.jsClick(driver, Destinations);
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Navigated to destinations page");
		StringBuilder hotelLocations=new StringBuilder();
		Iterator<WebElement> itr=Locations.iterator();
		hotelLocations.append("Number of locations in India: ");
		hotelLocations.append("\n");
		while(itr.hasNext())
		{
			hotelLocations.append(itr.next().getText());
			hotelLocations.append("\n");
		}
		
		js=(JavascriptExecutor)driver;
		js.executeScript("alert(arguments[0])", hotelLocations.toString());
		test.log(LogStatus.PASS, "Displayed hotel locations");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		test.log(LogStatus.PASS, "Test ended");
		System.out.println( hotelLocations.toString());
	}

}
