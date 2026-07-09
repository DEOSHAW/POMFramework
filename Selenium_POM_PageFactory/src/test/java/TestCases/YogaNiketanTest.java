package TestCases;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.YogaNiketan;
import utilities.seleniumUtilities;

public class YogaNiketanTest extends Baseclass
{
	@Test
	void validateNamesOfAshramTeachers() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.yoganiketanashram.org/index.php", driver);
		YogaNiketan ob=YogaNiketan.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=YogaNiketan.class.getDeclaredMethod("getNamesOfAshramTeachers");
		m.setAccessible(true);
		List<String> allTeachers=(List<String>) m.invoke(ob);
		Assert.assertTrue(allTeachers.get(4).contains("Milan"),"Name mismatch!");
		test.log(LogStatus.PASS, "Validation successful");
		test.log(LogStatus.PASS, "Test Ended");
	}
}
