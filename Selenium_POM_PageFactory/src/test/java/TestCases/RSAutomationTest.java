package TestCases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.RSAutomation;
import utilities.seleniumUtilities;

public class RSAutomationTest extends Baseclass
{
	@Test
	void navigateToJavaInterviewQuestionsRsSite() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://rahulshettyacademy.com/blog/index.php/automation-testing-interview-questions/", driver);
		RSAutomation ob=RSAutomation.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=RSAutomation.class.getDeclaredMethod("navigateToJavaInterviewQuestionsSite");
		m.setAccessible(true);
		String pageTitle=(String) m.invoke(ob);
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains("Java Interview Questions"),"Not navigated to Java Interview Questions site");
		test.log(LogStatus.PASS, "Navigated successfully to Java Interview Site");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
