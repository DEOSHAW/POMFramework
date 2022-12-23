package TestCases;

import java.lang.reflect.Method;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.RSPracticePage;
import utilities.seleniumUtilities;

public class RSPracticePageTableTest extends Baseclass {
	
	@Test
	void getPriceOfParticularCourse() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://rahulshettyacademy.com/AutomationPractice/", driver);
		
		RSPracticePage ob=RSPracticePage.class.getDeclaredConstructor(WebDriver.class,ExtentTest.class).newInstance(driver,test);
		
		Method m=RSPracticePage.class.getDeclaredMethod("getCoursePrice", String.class);
		m.setAccessible(true);
		String courseName=seleniumUtilities.getDataForKey("COURSE_NAME");
		String coursePrice=(String) m.invoke(ob,courseName);
		
		System.out.println("Price of the course "+"\""+courseName+"\""+" is Rs."+coursePrice);
		test.log(LogStatus.PASS, "Price of the course displayed");
		test.log(LogStatus.PASS, "Test Ended");
		
		
		
		
		
		
		
	}

}
