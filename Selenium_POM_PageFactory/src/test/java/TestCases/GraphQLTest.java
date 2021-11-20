package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import Base.Baseclass;
import Pages.GraphQL;
import utilities.seleniumUtilities;

public class GraphQLTest extends Baseclass {
	
	@Test
	void testGraphQL() throws Exception
	{
		
		seleniumUtilities.LaunchBrowser("https://graphql.org/", driver);
		GraphQL ob=GraphQL.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		Method m=GraphQL.class.getDeclaredMethod("searchInfo");
		m.setAccessible(true);
		m.invoke(ob);
		
		
		
	}

}
