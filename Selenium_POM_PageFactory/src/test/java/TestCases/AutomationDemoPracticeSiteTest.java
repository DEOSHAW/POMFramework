package TestCases;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.AutomationDemoPracticeSite;
import utilities.seleniumUtilities;

public class AutomationDemoPracticeSiteTest extends Baseclass
{
	
	
	@Test
	void addBookToBasketonPracticeSite() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://practice.automationtesting.in/shop/", driver);
		AutomationDemoPracticeSite ob=AutomationDemoPracticeSite.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		List<String> books=new ArrayList<String>();
		books.add(seleniumUtilities.getDataForKey("BOOK_NAME_1"));
		books.add(seleniumUtilities.getDataForKey("BOOK_NAME_2"));
		ob.addBookToBasket(books);
		test.log(LogStatus.PASS, "Added book to basket");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
