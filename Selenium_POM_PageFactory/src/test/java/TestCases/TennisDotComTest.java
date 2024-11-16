package TestCases;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.TennisDotCom;
import utilities.seleniumUtilities;

public class TennisDotComTest extends Baseclass
{
	
	@Test
	void getTennisTop10Ranking() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.tennis.com/", driver);
		TennisDotCom ob=TennisDotCom.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=TennisDotCom.class.getDeclaredMethod("getTop10Ranking");
		m.setAccessible(true);
		HashMap<Integer,String> tennisRanking=(HashMap<Integer, String>) m.invoke(ob);
		for(Map.Entry<Integer, String> entry:tennisRanking.entrySet())
		{
			System.out.println(entry.getKey()+"==>"+entry.getValue());
		}
		Assert.assertEquals(tennisRanking.get(1), "Jannik");
		test.log(LogStatus.PASS, "Assertion successful");
		test.log(LogStatus.PASS, "Test Ended");
		
	}

}
