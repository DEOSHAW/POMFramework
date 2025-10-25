package TestCases;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Base.Baseclass;
import Pages.JioPaymentsBank;
import utilities.seleniumUtilities;

public class JioPaymentsBankTest extends Baseclass
{
	@Test
	void getJioBankAccountTypes() throws Exception
	{
		test.log(LogStatus.PASS, "Test Started");
		seleniumUtilities.LaunchBrowser("https://www.jiopayments.bank.in/", driver);
		JioPaymentsBank ob=JioPaymentsBank.class.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		Method m=JioPaymentsBank.class.getDeclaredMethod("getAccountTypes");
		m.setAccessible(true);
		List<String> accountTypes=(List<String>) m.invoke(ob);
		System.out.println(accountTypes);
		Assert.assertEquals(accountTypes.get(3), "Wallet");
		test.log(LogStatus.PASS, "Account type validated");
		test.log(LogStatus.PASS, "Test Ended");
	}

}
